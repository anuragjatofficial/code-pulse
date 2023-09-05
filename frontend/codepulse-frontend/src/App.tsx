import React from "react";
import "./App.css";
import { Routes, Route } from "react-router-dom";
import LandingPage from "./pages/LandingPage";
import InterviewMaster from "./pages/InterviewMaster/InterviewMaster";

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<LandingPage/>}/>
        <Route path="/interview_Master" element = {<InterviewMaster/>}/>
      </Routes>
    </div>
  );
}

export default App;
