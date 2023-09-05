import React, { useState, useEffect } from 'react';

import styled from 'styled-components';

const Timer: React.FC = () => {
  const initialTime: number = 10 * 60; // 10 minutes in seconds
  const [timeLeft, setTimeLeft] = useState<number>(initialTime);
  const [isTimerRunning, setIsTimerRunning] = useState<boolean>(false);

  useEffect(() => {
    let interval: NodeJS.Timeout;

    setIsTimerRunning(true);

    if (isTimerRunning && timeLeft > 0) {
      interval = setInterval(() => {
        setTimeLeft((prevTime) => prevTime - 1);
      }, 1000);
    } else if (timeLeft === 0) {
      setIsTimerRunning(false);
    }

    // Clean up the interval when the component is unmounted or timer is paused
    return () => clearInterval(interval);
  }, [isTimerRunning, timeLeft]);

  useEffect(() => {
    if (timeLeft === 0) {
      // Enable the "End Session" button when the timer reaches zero
      // You can add any additional logic here for handling session end
      // For now, we'll just log a message to the console.
      console.log("Session ended!");
      setIsTimerRunning(true);
    }
  }, [timeLeft]);

  const formatTime = (timeInSeconds: number): string => {
    const hours: number = Math.floor(timeInSeconds / 3600);
    const minutes: number = Math.floor((timeInSeconds % 3600) / 60);
    const seconds: number = timeInSeconds % 60;

    return `${hours.toString().padStart(2, "0")}:${minutes
      .toString()
      .padStart(2, "0")}:${seconds.toString().padStart(2, "0")}`;
  };

  const handleEndSession = (): void => {
    // You can add any additional logic here for handling session end
    // For now, we'll just reset the timer to the initial time and pause it.
    setTimeLeft(initialTime);
    setIsTimerRunning(false);
  };

  return (
    <DIV>
      <h1>{formatTime(timeLeft)}</h1>

      <button
        // className='endbtn'
        className="landingBtn"
        onClick={handleEndSession}
        disabled={!isTimerRunning || timeLeft > 0}
      >
        End Session
      </button>
    </DIV>
  );
};

export default Timer;



const DIV = styled.div`

h1 {
  // border : 1px solid;
}
.endbtn {
    font-size : 18px;
    padding : 8px 15px;
    border-radius : 10px;
    border: none;
    background-color : #0B6947;
    color : white;
}

.endbtn:hover {
    cursor : pointer;
    background-color : #26A69A;
    transform : scale(1.1);
    transition : 500ms;
}
`



// import { useEffect, useState } from "react"

// export const Timer =()=>{

//   const [count,setCount] = useState(600);

//   const convert =(time)=>{
//     const min = Math.floor(time/60);
//     const sec =  time % 60;
//     const final_time = `${min}:${sec}`
//     return final_time
//   }

//   useEffect(()=>{
//     const id = setInterval(()=>{
//      setCount((prev)=> (
//        prev > 0 ? prev - 1 : 0
//      ))
//     },1000)

//     return ()=>{
//       clearInterval(id)
//     }
//   },[])

//   return (
//   <div>
//     <h2>Timer</h2>
//     <h3>{convert(count)}</h3>
//     <button disabled={count > 0}>End Session</button>
//   </div>
//     )
// }
