import React from 'react';
import UserHeader from './UserHeader'
import FileListServices from './services/FileListServices'

let API_BASE_URL = "http://localhost:8080/api/v1/incoming-files";
class FileDownload extends React.Component {

   

    constructor(props) {
        super(props)

        this.state = {
                files: []
        }
        this.addFiles = this.addFiles.bind(this);
        this.editFiles = this.editFiles.bind(this);
        this.deleteFiles = this.deleteFiles.bind(this);
        this.downloadFile = this.downloadFile.bind(this);
    }
    
    downloadFile(filename) {
		fetch('http://localhost:8080/api/v1/downloadfiles')
    .then(response => {
      const filename =  response.headers.get('Content-Disposition').split('filename=')[1];
      response.blob().then(blob => {
        let url = window.URL.createObjectURL(blob);
        let a = document.createElement('a');
        a.href = url;
        a.download = filename;
        a.click();
    });
 });
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
                 <h2 className="text-center">Files List</h2>
                 
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
                                                <a href={API_BASE_URL+"/"+file.fileName}>{file.fileName}</a>
                                                 <button onClick={ () => this.downloadFile(file.fileName)} className="btn btn-info">Download </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteFiles(file.id)} className="btn btn-danger">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewFiles(file.id)} className="btn btn-info">Permission </button>
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

export default FileDownload

