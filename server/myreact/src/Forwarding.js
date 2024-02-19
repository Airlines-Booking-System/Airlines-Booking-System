import Home from "./HomeV3.1";
import "./Home.css"
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import Profile from "./Profile";
import EditProfile from "./EditProfile"
import Login from "./Login"
import Register from "./Register"
import About from "./About"
import {Link, Routes, Route} from 'react-router-dom'


function Forwarding(){

    return(
        <>
            <nav className="navbar navbar-expand-lg" style={{"backgroundColor":"white"}}>
                <div className="container-fluid">
                    <Link to="/home" className="navbar-brand logoFont" style={{"color":"black"}}>FlyHigh</Link>
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">                    <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item">
                        {/* <a className="nav-link active myfont" aria-current="page" href="/login" style={{"color":"black"}}>Login</a> */}
                        <Link to="/login" className="nav-link myfont" style={{"color":"black"}}>Login</Link>
                        </li>
                        <li className="nav-item">
                        <Link to="/about" className="nav-link myfont" style={{"color":"black"}}>About</Link>
                        </li>
                        <li className="nav-item">
                        <Link to="/contact" className="nav-link myfont" style={{"color":"black"}}>Contact</Link>  
                        </li>
                        <li className="nav-item">
                        <Link to="/profile" className="nav-link myfont" style={{"color":"black"}}>My Profile</Link>  
                        </li>
                        <li className="nav-item">
                        <Link to="/editprofile" className="nav-link myfont" style={{"color":"black"}}>Edit Profile</Link>  
                        </li>
                    </ul>
                    </div>
                </div>
            </nav>
            <Routes>
                <Route path="/"  element={<Home/>}/>
                <Route path="/home" element={<Home/>}/>
                <Route path="/profile" element={<Profile/>}/>
                <Route path="/editprofile" element={<EditProfile/>}/>
                <Route path="/register" element={<Register/>}/> 
                <Route path="/login" element={<Login/>}/>
                <Route path="/about" element={<About/>}/>

            </Routes>
        </>
    );
}

export default Forwarding;