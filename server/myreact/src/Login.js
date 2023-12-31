import React from "react";
import { Switch, Link, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

function Login() {
  return (
    <>
      <div style={{"textAlign": "center"}} className="container">
        <div className=" borderStyle" style={{"marginTop":"8%"}} >
          <p className="logoFont" style={{ "fontSize": "50px"}}>Login to FlyHigh</p>
          <input className="searchBox" type="text" name="email" placeholder="Email" />
          <br></br>
          <input className="searchBox" type="password" name="password" placeholder="Password" />
          <br></br>
          <button className="LinkedInFreeTrail"> Login</button>
          <br></br>
          <p className="myfont greyText"> Haven't registered with us yet?{" "}
            <Link to="/Register">
              <br></br>
              Register now
            </Link></p>
        </div>
      </div>


    </>
  );
}

export default Login;
