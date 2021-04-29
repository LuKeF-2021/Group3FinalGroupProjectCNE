import QueuedTickets from "./queuedTickets";
import CompletedTickets from './completedTickets';
// import { useState } from 'react';
import './App.css';

const Main = ({ tickets, setTickets }) => {

    
    
    return (
        <>
            <div className="queue">
                <QueuedTickets tickets={tickets} setTickets={setTickets} />
            </div>
            <div className="completed">
                <CompletedTickets tickets={tickets} setTickets={setTickets} />
            </div>
        </>
    )
}


export default Main;