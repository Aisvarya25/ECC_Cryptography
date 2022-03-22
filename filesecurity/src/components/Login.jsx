import React, { Component } from 'react'
import './Login.module.css';
import RegisterService from './services/RegisterService';
import UserHome from './UserHome';
import classes from './Login.module.css'
class Login extends Component {

    constructor(props) {
        super(props)
        this.state = {
            // step 2
            id: this.props.match.params.id,
            emailId: '',
            pwd: ''           
        }
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePwdHandler = this.changePwdHandler.bind(this);      
        this.saveOrUpdateUser = this.saveOrUpdateUser.bind(this);
    }

    
     // step 3
     componentDidMount(){

        // step 4
        if(this.state.id === 'Login'){
            return
        }
        else if(this.state.id === 'Logout')
        {
            localStorage.setItem('token', '')
            this.props.history.push('/Login');
        }
        else{
            RegisterService.getUserById(this.state.id).then( (res) =>{
                let employee = res.data;
                this.setState({
                    emailId : employee.emailId,
                    pwd : employee.pwd
                });
            });
        } 
    }
    saveOrUpdateUser = (e) => {
        e.preventDefault();
        let users = {emailId: this.state.emailId, pwd: this.state.pwd};
        console.log('users =>' + JSON.stringify(users)); //'users => ' +

        // step 5
       // if(this.state.id === 'Login'){
            
            if (users.emailId === "admin" && users.pwd === "admin") {
                alert("Login Suceed...");
                localStorage.setItem('token', users.emailId)
                this.props.history.push({pathname: '/UserHome',state: { some: users.emailId }});
            }
            else
            {
                alert("Invalid Login ...");
                localStorage.setItem('token', '')
            }
               

            this.onLogin(this.state.emailId, this.state.pwd);
            // RegisterService.createUsers(users).then(res =>{
            //     this.props.history.push('/UserHome');
          
            // });            
      //  }
        
    }  
    changeEmailHandler= (event) => {
        this.setState({emailId: event.target.value});
    }

    changePwdHandler= (event) => {
        this.setState({pwd: event.target.value});
    }

    
    cancel(){
        this.props.history.push('/');
    }

    getTitle(){
        if(this.state.id === 'Login'){
            return <h3 className="text-center">Register User</h3>
        }else{
            return <h3 className="text-center">Update User</h3>
        }
    } 

    render() {
    return(
        <form className={classes.input} >
                <h1 className={classes.Head}>Sign In</h1>
                <label htmlFor="emailId" className={classes.label}>Email</label>
                <input type="text" name="emailId" id="emailId" 
                value={this.state.emailId}
                onChange={this.changeEmailHandler}
                className={classes.inputs}
                placeholder="Enter email"
                ></input>
                <label htmlFor="password" className={classes.label}>Password</label>
                <input type="password" name="password" id="password" 
                value={this.state.pwd}
                onChange={this.changePwdHandler}
                className={classes.inputs}
                placeholder="Enter password"
                ></input><br></br><br></br>
                <button className={classes.button} onClick={this.saveOrUpdateUser}>Login</button><br></br><br></br>
               
        </form>
    );
}
}
export default Login;