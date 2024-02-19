import axios from "axios";
import { useState } from "react";
import { Navigate, useNavigate, useParams, useResolvedPath } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";

const port = process.env.RREACT_APP_PORT_NO;
const ip = process.env.REACT_APP_SERVER_IP;

function BookFlight(){
    const serverIp = `${ip}:${port}`;
    const flightId = useParams();
    const navigate = useNavigate();
    const [flightToBook, setFilghtToBook] = useState({});
    const getFlight = ()=>{
        axios.get(`${serverIp}/flights/findFlightById/${flightId}`).then((resp)=>{
            setFilghtToBook(resp.data);
        }).catch(navigate("/Error"));
    }

    const [paymentDetails, setPaymentDetails] = useState({});

    console.log(flightId);
    const currentUser = {
        "cid": 2,
        "flightId":flightId,

    }

    return (
        <>
            <h1>BOOK</h1>
        </>
    );
}

export default BookFlight;