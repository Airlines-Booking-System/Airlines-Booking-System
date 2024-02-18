import { useState, useEffect } from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../src/Home.css"
import axios from "axios";
import DatePicker from "react-datepicker";
import "../node_modules/react-datepicker/dist/react-datepicker.css"
import { Navigate, useNavigate } from "react-router-dom";


function Profile(props) {
    const navigate = useNavigate();
        const [passenger,setpassenger]=useState([]);
        const serverUrl="";

        const getDetails = ()=>{
            axios.get(serverUrl + "/profile").then((response)=>{
                setpassenger(response.data);
            })
        }

        useEffect(()=>{
            const temp={"no":123,"name":"sneha rakshe","email":"sneha@123","mobile":"1234567890","password":"123","birth":"31-01-2001","gender":"f","address":"pune","aadhar":"1234"}
            setpassenger(temp);
            //getDetails();
        },[]);
    return (  
        <>
        <div className="container" style={{"textAlign":"left","position":"relative"}}>
            <div className="restDiv growDiv ">
                <div className="image">
                    <img className="profileImage " src="Delhi.jpg" alt="" />   
                </div> 
                <div  style={{"display":"inline-block" ,"width":"60%","marginLeft":"200px", "textAlign":""}}>
                    <p className="myfont">Name : <span className="greyText">{passenger.name}</span></p>
                    <p className="myfont">Mobile : <span className="greyText">{passenger.mobile}</span></p>
                    <p className="myfont">Email : <span className="greyText">{passenger.email}</span></p>
                </div>
            </div> 
        </div>
        <div className="container"  style={{"textAlign":"center" ,"marginTop":"10px"}}>
            
          
            <div className="restDiv" style={{"textAlign":"left"}}>
            <div>
                <p  className="myfont">  Password : </p>
                <p className=" myfont greyText" >{passenger.password}</p>
            </div>
            <hr />
            <div>
                <p className="myfont"> DateOfBirth : </p>
                <p className=" myfont greyText" >{passenger.birth}</p>
            </div>
            <hr />
            <div>
                <p className="myfont">Gender :</p>
                <p className=" myfont greyText" >{passenger.gender}</p>
            </div>
            <hr />
            <div>
                <p className="myfont">Address :</p>
                <p className=" myfont greyText" >{passenger.address}</p>
            </div>
            <hr />
            <div>
                <p className="myfont">AadharNo :</p>
                <p className=" myfont greyText" >{passenger.aadhar}</p>
            </div>
            <hr />
            <div>
                <button className="tweet" style={{"marginTop":"10px" }} onClick={()=>{navigate("/editprofile")}}>Edit Profile </button>

            </div>
            </div>

        </div>

        </>
    );
}

export default Profile;