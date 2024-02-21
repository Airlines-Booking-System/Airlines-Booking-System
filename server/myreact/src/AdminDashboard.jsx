import { useNavigate } from "react-router-dom";

function AdminDashboard(){
    const navigate = useNavigate();
    return(
        <>
            <div className="container">
                <p className="logoFont centerText">
                    Admin Dashboard
                </p>
                <div className="centerText">
                    <p className="logoFont restDiv centerText cityImage" style={{"display":"inline-block"}} onClick={()=>{
                        navigate("/ViewUsers")
                    }}>View Users</p>
                    <p className="logoFont restDiv centerText cityImage" style={{"display":"inline-block"}} onClick={()=>{
                        navigate("/CreateFlight")
                    }}>Create Flight</p>
                    <p className="logoFont restDiv centerText cityImage" style={{"display":"inline-block"}} onClick={()=>{
                        navigate("/ViewFlights")
                    }}>View Flights</p>
                    <p className="logoFont restDiv centerText cityImage" style={{"display":"inline-block"}} onClick={()=>{
                        navigate("/ViewPayments")
                    }}>View Payments</p>
                </div>
            </div>
        </>
    )
}

export default AdminDashboard;