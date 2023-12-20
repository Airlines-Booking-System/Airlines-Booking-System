import { useState, useEffect } from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../src/Home.css"
import axios from "axios";
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
                            <div className="gridDiv" key={flight}>
                                <div>{flight.name}</div>
                                <div>{flight.class}</div>
                                <div>{flight.destination}</div>
                                <div>{flight.source}</div>
                                <div>{flight.departure}</div>
                                <div>{flight.arrival}</div>
                            </div> 
                        </>
                    );
                })
            }

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
</div>  */}