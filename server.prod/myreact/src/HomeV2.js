import { useState, useEffect } from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../src/Home.css"
import axios from "axios";
// import {Link, Switch, Route} from 'react-router-dom';

function Home() {
    const serverUrl = 'http://43.204.37.78:6969';
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
            <nav className="navbar navbar-expand-lg" style={{"backgroundColor":"rgb(223, 130, 108)"}}>
                <div className="container-fluid">
                    <a className="navbar-brand" href="#">Fly High</a>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item">
                        <a className="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li className="nav-item">
                        <a className="nav-link" href="">About</a>
                        </li>
                        <li className="nav-item">
                        <a className="nav-link" href="">Services</a>
                        </li>
                        <li className="nav-item">
                        <a className="nav-link" href="">Contact</a>
                        </li>
                    </ul>
                    </div>
                </div>
            </nav>
            {
                flights.map((flight)=>{
                    return (
                        <>
                            <div className="container">
                                <div className="row restDiv" key={flight}>
                                    <div className="col"> <p className="myfont textVertical">{flight.name}</p></div> {" "}
                                    <div className="col"> <p className="myfont textVertical">{flight.class}</p></div> {" "}
                                    <div className="col"> <p className="myfont textVertical">{flight.destination}</p></div> {" "}
                                    <div className="col"> <p className="myfont textVertical">{flight.source}</p></div> {" "}
                                    <div className="col"> <p className="myfont textVertical">{flight.departure}</p></div> {" "}
                                    <div className="col"> <p className="myfont textVertical">{flight.arrival}</p></div> {" "}
                                </div> 
                            </div>
                        </>
                    );
                })
            }

        </>

        
     );
}

export default Home;