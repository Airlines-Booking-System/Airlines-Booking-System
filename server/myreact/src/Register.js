import { useState, useEffect } from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../src/Home.css"
import axios from "axios";
import DatePicker from "react-datepicker";
import "../node_modules/react-datepicker/dist/react-datepicker.css"
// import {Link, Switch, Route} from 'react-router-dom';


function UserProfile(props) {
        // const [passenger,setpassenger]=useState([]);
        // const serverUrl="";

        // const getDetails = ()=>{
        //     axios.get(serverUrl + "/profile").then((response)=>{
        //         setpassenger(response.data);
        //     })
        // }

        // useEffect(()=>{
        //     const temp={"no":123,"name":"sneha","email":"sneha@123","mobile":"1234567890","password":"123","birth":"31-01-2001","gender":"f","address":"pune","aadhar":"1234"}
        //     setpassenger(temp);
        //     //getDetails();
        // },[]);
    return (  
        <>
        
        <div className="container"  style={{"textAlign":"center" ,"marginTop":"10px"}}>
            
          <div className="restDiv" style={{"textAlign":"left", "backgroundImage":"planepic.jpeg"}} >
                <div>
                    <p  className="myfont"> Full Name : </p>
                    <input type="text" className="searchBox myfont greyText" />
                </div>

                <div>
                    <p className="myfont"> Email : </p>
                    <input type="text"  className="searchBox myfont  greyText" />
                
                </div>
                <div>
                    <p className="myfont"> Mobile:</p>
                    <input type="number"  className="searchBox myfont greyText" />
                </div>
                <div>
                    <p className="myfont">Date of birth :</p>
                    <input type="text"  className="searchBox myfont greyText" />
                </div>
                <div>
                    <p className="myfont">Gender :</p>
                    <input type="text"  className="searchBox myfont greyText" />
                </div>

                <div>
                    <p className="myfont">Adhar Card Number :</p>
                    <input type="number" className="searchBox myfont greyText" />
                </div>

                <div>
                    <p className="myfont">Password :</p>
                    <input type="password"  className="searchBox myfont greyText" />
                </div>

                <div>
                    <button className="tweet" style={{"marginTop":"10px" }}>Update Profile </button>
                </div>
         </div>
            

        </div>

        </>
    );
}

export default UserProfile;