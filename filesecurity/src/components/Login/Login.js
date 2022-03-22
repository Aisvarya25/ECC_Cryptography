import React, {useState} from 'react';
import '../../../public/style.css';
import classes from '../../../public/style.css'
const Logindetails = (props) =>{
    const[email,setEmail] = useState("")
    const[uPassword,setPassword] = useState("")
    
    const Details = {
        Username : "admin",
        Password : "admin"
    }
    const EmailHandler = event =>{
        setEmail(event.target.value);
       
    }
    const PasswordHandler = event =>{
        setPassword(event.target.value);

    }
    const submitHandler = (event) => {
        event.preventDefault();
        if (email.trim().length === 0 && uPassword.trim().length === 0) {
            alert("Please Enter the Email/Password")
            return;
        }
        if (Details.Username === email && Details.Password === uPassword) {
            console.log("Login Suceed...")
        }
        else {
            alert("Login Faild")
            return;
        }
        props.onLogin(email, uPassword);
      };
    return(
        <form className={classes.input} onSubmit={submitHandler}>
                <h1 className={classes.Head}>Sign In</h1>
                <label htmlFor="email" className={classes.label}>Email</label>
                <input type="text" name="email" id="email" 
                value={email}
                onChange={EmailHandler}
                className={classes.inputs}
                placeholder="Enter email"
                ></input>
                <label htmlFor="password" className={classes.label}>Password</label>
                <input type="password" name="password" id="password" 
                value={uPassword}
                onChange={PasswordHandler}
                className={classes.inputs}
                placeholder="Enter password"
                ></input><br></br><br></br>
                <button className={classes.button}>Login</button><br></br><br></br>
                <small  className={classes.small}> Forgot Password <a href="#">Click Here...?</a></small>
        </form>
    );
}

export default Logindetails;