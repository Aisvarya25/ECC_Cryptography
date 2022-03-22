import React, { Component } from 'react'
import RegisterService from './services/RegisterService';
import './Login.module.css';
import classes from './Login.module.css'
class Registration extends Component {

    constructor(props) {
        super(props)
        this.state = {
            // step 2
            id: 'Registration',
            emailId: '',
            pwd: '',
            firstName: '',
            lastName: '',
            phone:''
        }
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePwdHandler = this.changePwdHandler.bind(this);
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.changePhoneHandler = this.changePhoneHandler.bind(this);
        this.saveOrUpdateUser = this.saveOrUpdateUser.bind(this);
    }
  
     // step 3
     componentDidMount(){ 

        // step 4
        if(this.state.id === 'Registration'){
            return
        } 
        else{
            RegisterService.getUserById(this.state.id).then( (res) =>{
                let employee = res.data;
                this.setState({firstName: employee.firstName,
                    lastName: employee.lastName,
                    emailId : employee.emailId
                });
            });
        }        
    }

    saveOrUpdateUser = (e) => {
        e.preventDefault();
        let users = {emailId: this.state.emailId, pwd: this.state.pwd, firstName: this.state.firstName, lastName: this.state.lastName, phone:this.state.phone};
        console.log('users => ' + JSON.stringify(users)); //'users => ' +

        // step 5
        if(this.state.id === 'Registration'){
            RegisterService.createUsers(users).then(res =>{
                this.props.history.push('/Login');
          
            });            
        }
    }
   
    changeFirstNameHandler= (event) => {
        this.setState({firstName: event.target.value});
    }

    changeLastNameHandler= (event) => {
        this.setState({lastName: event.target.value});
    }

    changeEmailHandler= (event) => {
        this.setState({emailId: event.target.value});
    }

    changePwdHandler= (event) => {
        this.setState({pwd: event.target.value});
    }

    changePhoneHandler= (event) => {
        this.setState({phone: event.target.value});
    }


    cancel(){
        this.props.history.push('/');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Register User</h3>
        }else{
            return <h3 className="text-center">Update User</h3>
        }
    }

    render() {
    return(
        <div >
             <form className={classes.input} >
                <h1 className={classes.Head}>New user Registration</h1>
                <label htmlFor="emailId" className={classes.label}>Email</label>
                <input type="text" name="emailId" id="emailId" 
                value={this.state.emailId}
                onChange={this.changeEmailHandler}
                className={classes.inputs}
                placeholder="Enter email"
                ></input>
                <label htmlFor="pwd" className={classes.label}>Password</label>
                <input type="password" name="pwd" id="pwd" 
                value={this.state.pwd}
                onChange={this.changePwdHandler}
                className={classes.inputs}
                placeholder="Enter password"
                ></input>
                
                <label htmlFor="firstName" className={classes.label}>First Name</label>
                <input placeholder="First Name" name="firstName" className={classes.inputs} 
                value={this.state.firstName} onChange={this.changeFirstNameHandler}/>

                <label htmlFor="lastName" className={classes.label}>Last Name</label>
                <input type="text" name="lastName" id="lastName" 
                value={this.state.lastName}             
                onChange={this.changeLastNameHandler}     
                className={classes.inputs}
                placeholder="Enter Last Name"
                ></input>

                <label htmlFor="phone" className={classes.label}>Phone</label>
                <input type="text" name="phone" id="phone" 
                value={this.state.phone}
                onChange={this.changePhoneHandler}                    
                className={classes.inputs}
                placeholder="Enter Phone Number"
                ></input>
                
                
               <br></br><br></br>
                <button className={classes.button} onClick={this.saveOrUpdateUser}>Register</button>
                <button className={classes.button}  onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>

                </form>
        </div>
    );
}
}
export default Registration;