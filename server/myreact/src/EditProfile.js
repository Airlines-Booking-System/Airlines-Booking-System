import { useState, useEffect } from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../src/Home.css"
import axios from "axios";
import DatePicker from "react-datepicker";
import "../node_modules/react-datepicker/dist/react-datepicker.css"
// import {Link, Switch, Route} from 'react-router-dom';


function EditProfile(props) {
        const [passenger,setpassenger]=useState([]);
        const serverUrl="";

        const getDetails = ()=>{
            axios.get(serverUrl + "/profile").then((response)=>{
                setpassenger(response.data);
            })
        }

        useEffect(()=>{
            const temp={"no":123,"name":"sneha","email":"sneha@123","mobile":"1234567890","password":"123","birth":"31-01-2001","gender":"f","address":"pune","aadhar":"1234"}
            setpassenger(temp);
            //getDetails();
        },[]);
    return (  
        <>
        <div className="container" style={{"textAlign":"left","position":"relative"}}>
            <div className="restDiv growDiv ">
                <div className ="image">
                    <img className="profileImage " src="Delhi.jpg" alt="" />   
                </div> 
                <div  className="editDiv">
                    <input type="text" value={passenger.name} className="profileBox myfont  greyText" />
                    <input type="text" value={passenger.mobile} className="profileBox myfont greyText" />
                    <input type="text" value={passenger.email} className="profileBox myfont greyText" />
                </div>
            </div> 
        </div>
        <div className="container"  style={{"textAlign":"center" ,"marginTop":"10px"}}>
    
          
            <div className="restDiv" style={{"textAlign":"left"}}>
            <div style={{"marginBottom":"5px"}} >
                <p  className="myfont">  Password : </p>
                <input type="password" value={passenger.password} className="profileBox myfont greyText" />
            </div>
            <div style={{"marginBottom":"5px"}}>
                <p className="myfont"> DateOfBirth : </p>
                <input type="text" value={passenger.birth} className="profileBox myfont  greyText" />
              
            </div>
            <div style={{"marginBottom":"5px"}}>
                <p className="myfont">Gender :</p>
                <input type="text" value={passenger.gender} className="profileBox myfont greyText" />
            </div>
            <div style={{"marginBottom":"5px"}}>
                <p className="myfont">Address :</p>
                <input type="text" value={passenger.address} className="profileBox myfont greyText" />
            </div>
            <div style={{"marginBottom":"5px"}}>
                <p className="myfont">AadharNo :</p>
                <input type="number" value={passenger.aadhar} className="profileBox myfont greyText" />
            </div>

            <div style={{"marginBottom":"5px"}}>
                <button className="tweet" style={{"marginTop":"10px" }}>Update Profile </button>
            </div>
            </div>

        </div>

        </>
    );
}

export default EditProfile;