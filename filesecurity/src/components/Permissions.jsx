import React from 'react';
import UserHeader from './UserHeader'
import Header from './Header'
import FileListServices from './services/FileListServices'
class Permissions extends React.Component {

    constructor(props) {
        super(props)

       
    }

    render (){
        return (
           
            <div >
                
        <UserHeader />
        <div align="center">
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> Permissions</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Id: </label>
                            <div> 2</div>
                        </div>
                        <div className = "row">
                            <label> Data Owner: </label>
                            <div> bala12@gmail.com</div>
                        </div>
                        <div className = "row">
                            <label> File Name: </label>
                            <div> datasecurity.txt</div>
                        </div>
                        <div className = "row">
                            <label> Permissions: </label>
                            <input type="checkbox" id="edit" name="edit" value="Edit" />Edit
                            <input type="checkbox" id="view" name="view" value="View" />View
                        </div>
                        <button style={{marginLeft: "10px"}} className="btn btn-info">Submit </button>
                    </div>

                </div>
            </div>
            </div>
        )
    }
}

export default Permissions

