import logo from './logo.svg';
import React, {useState} from 'react';
import './App.css';
import Header from './components/Header';
import UserHeader from './components/UserHeader';
import FileUpload from './components/FileUpload';
import FileDownload from './components/FileDownload';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import ListEmployeeComponent from './components/ListEmployeeComponent';
import FooterComponent from './components/FooterComponent';
import CreateEmployeeComponent from './components/CreateEmployeeComponent';
import UpdateEmployeeComponent from './components/UpdateEmployeeComponent';
import ViewEmployeeComponent from './components/ViewEmployeeComponent';
import Registration from './components/Registration';
import Login from './components/Login';
import UserHome from './components/UserHome';
function App() {
  //alert('Logged in : ' + localStorage.getItem('token'));

  const [isLoggedIn, setIsLoggedIn] = useState("");
  const loginHandler = (email, password) => {    
    setIsLoggedIn(email);

  };
  return (
    <div>

    <Router> 
    

    {!localStorage.getItem('token') && <Header ></Header> }
            <div className="container">
                <Switch> 
                     
                      
                      <Route path = "/Registration" component = {Registration}></Route>
                      <Route path = "/Login" component = {Login}></Route>
                      <Route path = "/FileUpload" component = {FileUpload}></Route>
                      <Route path = "/FileDownload" component = {FileDownload}></Route>
                      <Route path = "/UserHome" component = {UserHome}></Route>
                      <Route path = "/Logout" component = {Login}></Route>
                       <Route path = "/add-employee/:id" component = {CreateEmployeeComponent}></Route>
                      
                </Switch>
            </div>
            <br></br><br></br><br></br><br></br><br></br>
          <FooterComponent />
    </Router>

   
    
</div>
  );
}

export default App;
