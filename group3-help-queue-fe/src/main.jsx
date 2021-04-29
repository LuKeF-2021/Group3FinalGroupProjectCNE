import QueuedTickets from "./queuedTickets";
import CompletedTickets from './completedTickets';
import { useState } from 'react';
import './App.css';

const Main = ({ tickets, setTickets }) => {

    const [filterDropdown, setFilterDropdown] = useState('Show All Tickets');
    
    return (
        <>
            <h3 id="filterText">Filters: </h3>
            <select className="filterDropdown" value={filterDropdown} onChange={e => setFilterDropdown(e.currentTarget.value)}>
                <option value="Show All Tickets">Show All Tickets</option>
                <option value="urgencyLow">Urgency - Low</option>
                <option value="urgencyMedium">Urgency - Medium</option>
                <option value="urgencyHigh">Urgency - High</option>
                <option value="newToOld">Order - Newest First</option>
            </select>
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