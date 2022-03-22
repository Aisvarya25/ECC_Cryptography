import React from 'react';
import UserHeader from './UserHeader'
import Header from './Header'
import FileListServices from './services/FileListServices'
class SharedFiles extends React.Component {

    constructor(props) {
        super(props)

        this.state = {
                files: []
        }
        this.addFiles = this.addFiles.bind(this);
        this.editFiles = this.editFiles.bind(this);
        this.deleteFiles = this.deleteFiles.bind(this);
    }

    deleteFiles(id){
        FileListServices.deleteFiles(id).then( res => {
            this.setState({files: this.state.files.filter(file => file.id !== id)});
        });
    }
    viewFiles(id){
        this.props.history.push(`/view-files/${id}`);
    }
    editFiles(id){
        this.props.history.push(`/add-files/${id}`);
    }

    componentDidMount(){
        FileListServices.getFiles().then((res) => {
            this.setState({ files: res.data});
        });
    }

    addFiles(){
        this.props.history.push('/add-files/_add');
    }
   
    render (){
        return (
           
            <div>
                
        <UserHeader />
        <div>
        <br></br><br></br>
                 <h2 className="text-center">Shared Files List</h2>
                 
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Id </th>
                                    <th> EMail Id</th>
                                    <th> Description</th>
                                    <th> File Name</th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.files.map(
                                        file => 
                                        <tr key = {file.id}>
                                            <td> { file.id} </td> 
                                             <td> { file.emailId} </td>   
                                             <td> {file.desct}</td>
                                             <td> {file.fileName}</td>
                                             <td>
                                                 <button onClick={ () => this.editFiles(file.id)} className="btn btn-info">Download </button>
                                               
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewFiles(file.id)} className="btn btn-info">Edit </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
            </div>
        )
    }
}

export default SharedFiles

