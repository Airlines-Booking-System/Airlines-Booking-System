import { useState, useEffect } from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../src/Home.css"
import axios from "axios";
import DatePicker from "react-datepicker";
import "../node_modules/react-datepicker/dist/react-datepicker.css"
// import {Link, Switch, Route} from 'react-router-dom';

function Home() {
    const serverUrl = 'http://localhost:6969';
    const [flights, setFilghts] = useState([]);
    const getFlights = ()=>{
        axios.get(serverUrl + "/flightDtls").then((response)=>{
            setFilghts(response.data);
        })
    }

    useEffect(()=>{
        getFlights();
    }, []);


    return ( 
        <>
            <nav className="navbar navbar-expand-lg" style={{"backgroundColor":"rgb(205, 141, 122)"}}>
                <div className="container-fluid">
                    <a className="navbar-brand myfont" href="#" style={{"color":"white"}}>Fly High</a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item">
                        <a className="nav-link active myfont" aria-current="page" href="#" style={{"color":"white"}}>Home</a>
                        </li>
                        <li className="nav-item">
                        <a className="nav-link myfont" href="" style={{"color":"white"}}>About</a>
                        </li>
                        <li className="nav-item">
                        <a className="nav-link myfont" href="" style={{"color":"white"}}>Services</a>
                        </li>
                        <li className="nav-item">
                        <a className="nav-link myfont" href="" style={{"color":"white"}}>Contact</a>
                        </li>
                    </ul>
                    </div>
                </div>
            </nav>
            {/* <div className="jumbo">
                <img src="favicon.png" className="logoImg" alt="" />
                <p className="myfont logoText">
                    FlyHigh 
                    Explore Flights 
                    Login
                    Contact Us
                </p>
            </div> */}
            <div style={{"textAlign":"center"}}>
                <div className="searchDiv restDiv">
                    <div style={{"textAlign":"center"}}>
                        <span className="myfont">
                            From:
                        </span>
                        <input type="text" placeholder="Enter a city" className="searchBox myfont" />
                        <span className="myfont">
                            To:
                        </span>
                        <input type="text" placeholder="Enter a city" className="searchBox myfont" />
                        <span className="myfont">
                            Date:
                        </span>
                        <DatePicker className="searchBox myfont" placeholderText="Select Departure Date"></DatePicker>
                        <br />
                        <button className="LinkedInFreeTrail">SEARCH</button>

                    </div>
                </div>
            </div>
            <div className="table-responsive restDiv">
                <table className="table table-bordered myfont" style={{"textAlign":"center"}}>
                    <thead>
                        <td>Name</td>
                        <td>Class</td>
                        <td>Destination</td>
                        <td>Source</td>
                        <td>Departure</td>
                        <td>Arrival</td>
                    </thead>
                    <tbody>
                        {
                            flights.map((flight)=>{
                                return(
                                    <>
                                        <tr key={flight.id}>
                                            <td>{flight.name}</td>
                                            <td>{flight.class}</td>
                                            <td>{flight.destination}</td>
                                            <td>{flight.source}</td>
                                            <td>{flight.departure}</td>
                                            <td>{flight.arrival}</td>
                                        </tr>
                                    </>
                                );
                            })
                        }
                    </tbody>
                </table>
            </div>
        </>

        
     );
}

export default Home;

{/* <div className="gridDiv" key={flight}>
<div>{flight.name}</div>
<div>{flight.class}</div>
<div>{flight.destination}</div>
<div>{flight.source}</div>
<div>{flight.departure}</div>
<div>{flight.arrival}</div>
</div> */}