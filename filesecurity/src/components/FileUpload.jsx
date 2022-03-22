import React, { useState } from 'react';
import classes from './Login.module.css'
import UserHeader from './UserHeader';
import { useLocation } from "react-router-dom";
import UploadFileService from './services/UploadFilesService'
const UploadFile = () => {
    const location = useLocation();

    const [files, setFiles] = useState('');
    //state for checking file size
    const [fileSize, setFileSize] = useState(true);
    // for file upload progress message
    const [fileUploadProgress, setFileUploadProgress] = useState(false);
    //for displaying response message
    const [fileUploadResponse, setFileUploadResponse] = useState(null);
    //base end point url
    const FILE_UPLOAD_BASE_ENDPOINT = "http://localhost:8080";
    const[email,setEmail] = useState("")
    const[descr,setDesct] = useState("")
    const[filename,setFileName] = useState("")
   
    const uploadFileHandler = (event) => {
        setFiles(event.target.files);
        setFileName(event.target.value);
       };

       const EmailHandler = (event) =>{
        setEmail(event.target.value);
       
    }
  
    const descrHandler = event =>{
        setDesct(event.target.value);

    }

    
      const fileSubmitHandler = (event) => {
       event.preventDefault();
       setFileSize(true);
       setFileUploadProgress(true);
       setFileUploadResponse(null);
      
        const formData = new FormData();

        for (let i = 0; i < files.length; i++) {
            // if (files[i].size > 1024){
            //     setFileSize(false);
            //     setFileUploadProgress(false);
            //     setFileUploadResponse(null);
            //     return;
            // }

            formData.append(`files`, files[i])
        }
      
        const requestOptions = {
            method: 'POST',           
            body: formData
        };
        console.log(email);
        console.log(descr);

        let filesDetails = {emailId: email, descr: descr, fileName: filename};
        console.log('filedetails =>' + JSON.stringify(filesDetails)); //'users => ' +

        UploadFileService.createFile(filesDetails).then(res =>{
            this.props.history.push('/');          
        });     

        fetch(FILE_UPLOAD_BASE_ENDPOINT+'/upload', requestOptions)
            .then(async response => {
                const isJson = response.headers.get('content-type')?.includes('application/json');
                const data = isJson && await response.json();
    
                // check for error response
                if (!response.ok) {
                    // get error message
                    const error = (data && data.message) || response.status;
                    setFileUploadResponse(data.message);
                    return Promise.reject(error);
                }
    
               console.log(data.message);
               
             setFileUploadResponse(data.message);

            })
            .catch(error => {               
                console.error('Error while uploading file!', error);
            });
        setFileUploadProgress(false);
      };           
        
    return(  
        <div>
      <UserHeader />

      <h1 align="center">  </h1>

      <form onSubmit={fileSubmitHandler} className={classes.input}>     
      <label htmlFor="emailId" >Email</label>
                <input type="email" name="emailId" id="emailId" 
                value= {email}
                onChange={EmailHandler}
                className={classes.inputs}
                placeholder="Enter email"
                ></input> 

<label htmlFor="descr" >Description</label>
                <input type="text" name="descr" id="descr" 
                value={descr}
                onChange={descrHandler}
                className={classes.inputs}
                placeholder="Enter Description"
                ></input> 
    <label htmlFor="descr" >Select File </label>
         <input type="file"  multiple onChange={uploadFileHandler} className={classes.inputs}/>    <br></br> <br></br> 
         <button type='submit' className={classes.button}>Upload</button>
         {!fileSize && <p style={{color:'red'}}>File size exceeded!!</p>}
         {fileUploadProgress && <p style={{color:'red'}}>Uploading File(s)</p>}
        {fileUploadResponse!=null && <p style={{color:'green'}}>{fileUploadResponse}</p>}
      </form>  
      </div>
    );
}
export default UploadFile;