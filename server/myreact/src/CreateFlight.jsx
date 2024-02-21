/*
{
    "name": "string",
    "flight_class": "string",
    "destination": "string",
    "source": "string",
    "departure": "2024-02-21T08:07:03.109Z",
    "arrival": "2024-02-21T08:07:03.109Z",
    "farePrice": 0
}
*/

import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
const port = process.env.REACT_APP_PORT_NO;
const serverIp = process.env.REACT_APP_SERVER_IP;
function CreateFlight(){
    const navigate = useNavigate();
    const serverUrl = `http://${serverIp}:${port}`
    const [name, setName] = useState("Akasa");
    const [flightClass, setFlightClass] = useState("Business");
    const [destination, setDestination] = useState("Pune");
    const [source, setSource] = useState("Mumbai");
    const [departure, setDeparture] = useState("2024-02-21T08:07:03.109Z");
    const [arrival, setArrival] = useState("2024-02-21T08:07:03.109Z");
    const [farePrice, setFarePrice] = useState(5567);

    const onNameChange =(e)=>{
        setName(e.target.value);
    }

    const onFlightClassChange =(e)=>{
        setFlightClass(e.target.value);
    }

    const onDestinationChange =(e)=>{
        setDestination(e.target.value);
    }

    const onSourceChange =(e)=>{
        setSource(e.target.value);
    }

    const onDepartureChange =(e)=>{
        setDeparture(e.target.value);
    }

    const onArrivalChange =(e)=>{
        setArrival(e.target.value);
    }

    const onFarePriceChange =(e)=>{
        setFarePrice(e.target.value);
    }

    const sendFlightPayload = async()=>{
        const payload = {
            "name": name,
            "flight_class": flightClass,
            "destination": destination,
            "source": source,
            "departure": departure,
            "arrival": arrival,
            "farePrice": farePrice
            };
        try{
            console.log("sending req to: ");
            console.log(`${serverUrl}/admin/createflight`);
            const resp = await axios.post(`${serverUrl}/admin/createflight`, payload);
            if(resp.status === 200){
                toast.success("Flight Created!");
            }
        }
        catch{
            navigate("/Error")
        }

    }

    return (
        <>
            <div className="container centerText">
                <p className="logoFont centerText">Create a Flight</p>

                            
                <p className="myfont">Enter Flight Name:</p>
                <input type="text" value={name} onChange={onNameChange} className="searchBox" />

                <p className="myfont">Enter Flight Class:</p>
                <input type="text" value={flightClass} onChange={onFlightClassChange} className="searchBox" />

                <p className="myfont">Enter Destination:</p>
                <input type="text" value={destination} onChange={onDestinationChange} className="searchBox" />

                <p className="myfont">Enter Source:</p>
                <input type="text" value={source} onChange={onSourceChange} className="searchBox" />

                <p className="myfont">Enter Departure Time:</p>
                <input type="text" value={departure} onChange={onDepartureChange} className="searchBox" />

                <p className="myfont">Enter Arrival Time:</p>
                <input type="text" value={arrival} onChange={onArrivalChange} className="searchBox" />

                <p className="myfont">Enter Fare Price:</p>
                <input type="number" value={farePrice} onChange={onFarePriceChange} className="searchBox" />
                <br />
                <button className="LinkedInFreeTrail" onClick={sendFlightPayload}>
                    Create Now
                </button>
            </div>
            <ToastContainer></ToastContainer>
        </>
    )
}

export default CreateFlight;