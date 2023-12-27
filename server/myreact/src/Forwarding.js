import Home from "./HomeV3.1";
import "./Home.css"
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import Profile from "./Profile";
import EditProfile from "./EditProfile"
import {Link, Switch, Route} from 'react-router-dom'


function Forwarding(){
    return(
        <>
            <nav className="navbar navbar-expand-lg" style={{"backgroundColor":"white"}}>
                <div className="container-fluid">
                    <Link to="/home" className="navbar-brand logoFont" style={{"color":"black"}}>FlyHigh</Link>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item">
                        {/* <a className="nav-link active myfont" aria-current="page" href="" style={{"color":"black"}}>Login</a> */}
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
            <Switch>
                <Route path="/" exact component={Home}/>
                <Route path="/home" exact component={Home}/>
                <Route path="/profile" exact component={Profile}/>
                <Route path="/editprofile" exact component={EditProfile}/>
            </Switch>
        </>
    );
}

export default Forwarding;