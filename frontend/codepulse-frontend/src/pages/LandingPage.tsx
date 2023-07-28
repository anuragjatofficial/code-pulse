import React from 'react'
import codepulseLogo from "../images/codepulseLogo.svg"

export default function LandingPage() {
  return (
    <div style={{width:"100%"}}>
         <img src={codepulseLogo} alt="logo" style={{width:"350px", margin:"auto",display:"block",marginTop:"30px", }}/>
         <h1>Interview Master v-1.0.0</h1>

<div>
  <label>Type of Interview </label>
  <select className="typeofinterview">
    <option>Select a type</option>
    <option>MERN</option>
    <option>NODE</option>
    <option>JAVA</option>
  </select>
</div>

<div>
  <br />
  <label>Username : </label>
  <input
    type="text"
    placeholder="Enter Username"
    required
    spellCheck="true"
  />
  <div></div>
</div>

<br />
<button>Start</button>
    </div>
  )
}
