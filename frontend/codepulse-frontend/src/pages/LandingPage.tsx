import React, { useState } from "react";
import codepulseLogo from "../images/codepulseLogo.svg";
import aiImage from "../images/aiImage.svg";
import axios from "axios"
import { Link } from "react-router-dom";

export default function LandingPage() {
const [username, setUsername] = useState("")
const [role, setRole] = useState("")



const handleStart =()=>{
  const obj={
    interviewType: role,
    username: username
  }
  
  axios.post("https://codepulse.up.railway.app/users",obj)
  .then((res)=>{
    console.log(res.data)
  })
  .catch((err)=>{
    console.log(err)
  })
  localStorage.setItem("username", username);
}

  return (
    <div style={{ width: "100%" }}>
      <img
        src={codepulseLogo}
        alt="logo"
        style={{
          width: "350px",
          margin: "auto",
          display: "block",
          marginTop: "30px",
        }}
      />

      <div
        style={{
          padding: "30px 9% 0% 9%",
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
        }}
      >
        <img
          src={aiImage}
          alt="logo"
          style={{
            width: "30%",
            margin: "auto",
            display: "block",
            marginTop: "30px",
          }}
        />
        <div style={{ width: "60%" }}>
          <h1 style={{ fontSize: "45px", marginBottom: "0px" }}>
            Welcome to codePulse
          </h1>
          <h2 style={{ fontWeight: "normal", fontSize: "18px" }}>
            Your AI Interview Platform. Practice the
            latest interview questions tailored to your skills and domain. Get
            real-time scorecards to excel in every interview.
          </h2>
          <h3
            style={{ marginTop: "50px", fontSize: "18px", fontWeight: "500" }}
          >
            Ready to ace interviews? Share details to start AI-powered practice
            and excel with confidence.
          </h3>

          <div className="landingInputDiv">
            <label style={{ width: "45%" }}>
              Enter Username
              <br />
              <input
                type="text"
                placeholder="ex : codePulse"
                className="landinginputs"
                onChange={(e)=> {setUsername(e.target.value)}}
              />
            </label>
            <label style={{ width: "45%" }}>
              Select your Role
              <br />
              <select
                name=""
                id=""
                style={{
                  width: "100%",
                  fontSize: "16px",
                  borderRadius: "4px",
                  height:"38px",
                  background:"transparent",
                  padding:"0px 12px 0px 12px",
                  marginTop:"4px",
                  border:" 1px solid #0B6947"
                }}
                onChange={(e)=> {setRole(e.target.value)}}
              >
                <option value="Select Roles">Select Your Role</option>
                <option value="mern">MERN</option>
                <option value="java">JAVA</option>
                <option value="node">NODE</option>
              </select>
            </label>
          </div>
          <div style={{width:"155px",marginTop:"30px"}}>
            <Link to="/interview_Master" style={{textDecoration:"none"}}>
            <button className="landingBtn" disabled = {!username && !role} onClick={()=>{handleStart()}}>Start Interview</button>
            </Link>
          
          </div>
          
        </div>
        <div></div>
      </div>
    </div>
  );
}
