import axios from "axios";
import { useEffect, useState } from "react";
import { Navigate, useNavigate, useParams } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";



// PAYLOAD:
// {
//     "cid": 0,
//     "flightID": 0,
//     "paymentId": 0,
//     "seatNo": [
//       "string"
//     ],
//     "passengerId": [
//       0
//     ],
//     "passengerNames": [
//       "string"
//     ]
// }


// PAYLOAD 1:
// {
//     "flightId": 1,
//     "status": "Successful",
//     "customerId": 1,
//     "totalAmount": 12000
// }

const port = process.env.REACT_APP_PORT_NO;
const serverIp = process.env.REACT_APP_SERVER_IP;
function BookFlight(){
    const [paymentDetails, setPaymentDetails] = useState({});
    const [paymentId, setPaymentId] = useState("");
    const [availabeSeats, setAvailableSeats] = useState([]);
    const flightId = useParams();
    const serverUrl = `${serverIp}:${port}`;
    const getAvailableSeats = ()=>{
        console.log("SENDING GET REQ")
        console.log(`http://${serverUrl}/user/getAvailabeSeats/${flightId["flightId"]}`);
        axios.get(`http://${serverUrl}/user/getAvailabeSeats/${flightId["flightId"]}`).then((resp)=>{
            setAvailableSeats(resp.data);
        });
    }

    const getFlightToBook = async ()=>{
        const resp = await axios.get(`http://${serverUrl}/flights/findFlightById/${flightId["flightId"]}`);
        setFilghtToBook(resp.data);
        console.log(resp.data.farePrice);
        console.log(flightToBook);
        let temp = {
            flightId: `${flightId.flightId}`,
            status: "Successful",
            customerId: `${currentUser.cid}`,
            totalAmount: `${flightToBook.farePrice}`
        }
        setPaymentDetails(temp);
        console.log("temp: " + temp);
        console.log(paymentDetails);
    }

    useEffect(()=>{
        getAvailableSeats();
        getFlightToBook();
    }, []);

    const currentUser = {
        "cid": 1
    }

    // const makePayment = ()=>{
    //     axios.post(`${serverIp}//user/makePayment`, paymentDetails).then().catch();
    // }

    
    const navigate = useNavigate();
    const [flightToBook, setFilghtToBook] = useState({});
    // const getFlight = ()=>{
    //     console.log("SENDGING FLIGHT REQ")
    //     console.log(`http://${serverUrl}/flights/findFlightById/${flightId["flightId"]}`);
    //     axios.get(`http://${serverUrl}/flights/findFlightById/${flightId["flightId"]}`).then((resp)=>{
    //         console.log("hello");
    //     });
    // }



    const makePayment = async ()=>{
        // console.log("\n\n PAYMENT: " + paymentDetails.totalAmount);
        console.log(paymentDetails);
        await console.log("\n\n PAYMENT: " + paymentDetails.totalAmount);
        await axios.post(`http://${serverUrl}/user/makePayment`, paymentDetails).then((resp)=>{
            console.log(resp.data);
            console.log(typeof(resp.data));
            console.log("setting paymentid")
            setPaymentId(resp.data);
            toast.success("Payment is successful!");
        })
        
        await console.log("\n\n PAYMENT: " + paymentDetails);
    }


    // const [selectedSeats, setSelectedSeats] = useState([]); // for array
    const [selectedSeats, setSelectedSeats] = useState(""); //for single seat
    const [selectedPassengers, setSelectedPassengers] = useState([]);
    const [numberOfSeats, setNumberOfSeats] = useState();

    // for array of seats:

    // const seatSelectAction =(seatNo)=>{
    //     // let num = numberOfSeats+1;
    //     // setNumberOfSeats(num);
    //     setSelectedSeats(selectedSeats => [...selectedSeats, seatNo]);
    // }


    // for single seat function:

    const seatSelectAction = (seatNo)=>{
        setSelectedSeats(seatNo);
    }


    console.log(flightId);




    const bookFlight = async ()=>{
        // <Navigate to="/paymentGateway" state={paymentDetails}></Navigate>
        // {
        //     "cid": 0,
        //     "flightID": 0,
        //     "paymentId": 0,
        //     "seatNo": [
        //       "string"
        //     ]
        // }
        await axios.post(`http://${serverUrl}/user/bookFlight`,         {
            "cid": currentUser.cid,
            "flightID": flightId.flightId,
            "paymentId": paymentId,
            "seatNo": [
              selectedSeats
            ]
        }).then((resp)=>{
            toast.success("Flight Booked Successfully!");
        }).catch((err)=>{
            toast.error("something went wrong );");
        })

    }

    return (
        <>
            <div className="container">
                {
                    availabeSeats.map((seat)=>{
                        return(
                            <>
                                <button className="tweet" onClick={()=>{seatSelectAction(seat["seatNo"])}}>{seat["seatNo"]}</button>
                            </>
                        )
                    })
                }
            </div>
            <div className="container">
                <p style={{"marginTop":"10px"}} className="myfont textVertical">Selected Seat:{" "}{selectedSeats}</p>
              
                {/* for multiple seats: */}
                {/* {
                    selectedSeats.map((seat)=>{
                        return(
                            <>
                                {seat}{" "}
                            </>
                        )
                    })
                }</p> */}
                
                {/* <input type="text" disabled defaultValue={selectedSeats} className="searchBox myfont" /> */}

                <div className="restDiv">
                    <h3 className="logoFont centerText" >Make Payment</h3>
                    <p className="myfont textVertical">
                        Total Amount to be paid: {flightToBook.farePrice}
                    </p>
                    <button className="tweet" onClick={makePayment}>Pay now</button>
                    <div className="centerText">
                        <button className="LinkedInFreeTrail" onClick={bookFlight}>
                            Book Flight Now!
                        </button>
                    </div>
                </div>
            </div>
            <ToastContainer></ToastContainer>
        </>
    );
}

export default BookFlight;