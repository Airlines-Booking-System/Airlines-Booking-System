import { useState, useEffect } from "react";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import "../src/Home.css"
import axios from "axios";
import DatePicker from "react-datepicker";
import "../node_modules/react-datepicker/dist/react-datepicker.css"
// import {Link, Switch, Route} from 'react-router-dom';

const port = process.env.REACT_APP_PORT_NO;
const serverIp = process.env.REACT_APP_SERVER_IP;
function Home() {
    const [searchResult, setSearchResult] = useState(false);
    const serverUrl = `http://${serverIp}:${port}`;
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
            <div style={{"textAlign":"center"}}>
                <div className="searchDiv restDiv">
                    <div style={{"textAlign":"center"}}>
                        <div style={{"display":"inline-block"}}>
                        <span className="myfont">
                            From:
                        </span>
                        <input type="text" placeholder="Enter a city" className="searchBox myfont" />
                        </div>
                        <div style={{"display":"inline-block"}}>
                        <span className="myfont">
                            To:
                        </span>
                        <input type="text" placeholder="Enter a city" className="searchBox myfont" />
                        </div>
                       <div style={{"display":"inline-block"}}>
                       <span className="myfont">
                            Date:
                        </span>
                        <DatePicker className="searchBox myfont" placeholderText="Select Departure Date"></DatePicker>
                       </div>
                        <br />
                        <button className="LinkedInFreeTrail" onClick={setSearchResult}>SEARCH</button>
                    </div>
                </div>
            </div>
            {
                searchResult &&
                <>
                    {flights.map((flight)=>{
                        return (
                            <>
                                <div className="container">
                                    <div className="row restDiv growDiv" key={flight}>
                                        <div className="col"> <p className="myfont textVertical">{flight.name}</p></div> {" "}
                                        <div className="col"> <p className="myfont textVertical">{flight.class}</p></div> {" "}
                                        <div className="col"> <p className="myfont textVertical">{flight.destination}</p></div> {" "}
                                        <div className="col"> <p className="myfont textVertical">{flight.source}</p></div> {" "}
                                        <div className="col"> <p className="myfont textVertical">{flight.departure}</p></div> {" "}
                                        <div className="col"> <p className="myfont textVertical">{flight.arrival}</p></div> {" "}
                                        <div className="col"><button className="tweet">View</button></div>
                                    </div> 
                                </div>
                            </>
                        );
                    })}
                </>
            }
            {
                !searchResult &&
                <>
                    <div className="gridDiv">
                        <div className="growCity">
                            <img className="cityImage" src="Bangalore.webp" alt="" />
                            <img className="cityImage" src="Delhi.jpg" alt="" />
                            <img className="cityImage" src="Indore.jpg" alt="" />
                            <img className="cityImage" src="Pune.jpg" alt="" />
                            <img className="cityImage" src="Jaipur.jpg" alt="" />
                            <img className="cityImage" src="Mumbai.webp" alt="" />
                        </div>
                    </div>
                </>
            }
        </>
     );
}

export default Home;