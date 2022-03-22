import React, {useState} from 'react';

//import '../../public/style.css';
//import classes from './Login.module.css'
import './Login.module.css';
import UserHeader from './UserHeader'
import { useLocation } from "react-router-dom";
import ViewEmployeeComponent from './ViewEmployeeComponent'


import classes from './Login.module.css'
const UserHome = (props) => {

  const location = useLocation();
  //state: { some: location.state.some }

    return (
      <div>
        <UserHeader />
        
        <br></br><br></br>
        <h1 align="center"> Welcome :  {location.state.some} </h1>
        <br></br><br></br><br></br><br></br><br></br>
      </div>
      
  );
  };

export default UserHome;