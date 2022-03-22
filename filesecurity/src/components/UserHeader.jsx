import React from 'react';
import { BrowserRouter as Router, NavLink,Route, Link } from "react-router-dom";
import FileUpload from './FileUpload';
import FileDownload from './FileDownload';
import UserHome from './UserHome';
import FooterComponent from './FooterComponent';
const UserHeader = () => {
  //  this.saveOrUpdateUser = this.saveOrUpdateUser.bind(this);
    // saveOrUpdateUser = (e) => {
    //     e.preventDefault();
    //     localStorage.setItem('token', '')
    //     this.props.history.push('/');           
    // }  


  return (
    <div>
       
      

    <header class="header header_style_01">
        <nav class="megamenu navbar navbar-default">
            <div class="container-fluid">
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><NavLink to="/UserHome">Home</NavLink></li>
                        <li><NavLink to="/FileUpload">File Upload</NavLink></li>
                        <li><NavLink to="/FileDownload">File Download</NavLink></li>
                        <li><NavLink to="/Logout" onClick={localStorage.setItem('token', '')}>Logout</NavLink></li>
					</ul>				
                </div>
            </div>
        </nav>
    </header>
	
   
    </div>
);
};


export default UserHeader;