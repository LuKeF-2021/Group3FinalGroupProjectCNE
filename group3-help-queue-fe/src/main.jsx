import QueuedTickets from "./queuedTickets";
import CompletedTickets from './completedTickets';
import { useState } from 'react';
import './App.css';

const Main = ({ tickets, setTickets }) => {

    const [filterDropdown, setFilterDropdown] = useState('Show All Tickets');
    
    const filteredAllQueuedTickets = tickets.filter(ticket => ticket.complete === false);
    const filteredAllCompletedTickets = tickets.filter(ticket => ticket.complete === true);
    const filteredAllQueuedTickets2 = tickets.filter(ticket => ticket.complete === false);
    const filteredAllCompletedTickets2 = tickets.filter(ticket => ticket.complete === true);
    const filteredQueuedLowTickets = filteredAllQueuedTickets.filter(ticket => ticket.urgency === "Low");
    const filteredQueuedMediumTickets = filteredAllQueuedTickets.filter(ticket => ticket.urgency === "Medium");
    const filteredQueuedHighTickets = filteredAllQueuedTickets.filter(ticket => ticket.urgency === "High");
    const filteredCompletedLowTickets = filteredAllCompletedTickets.filter(ticket => ticket.urgency === "Low");
    const filteredCompletedMediumTickets = filteredAllCompletedTickets.filter(ticket => ticket.urgency === "Medium");
    const filteredCompletedHighTickets = filteredAllCompletedTickets.filter(ticket => ticket.urgency === "High");
    // const sortAllQueuedNew2Old = filteredAllQueuedTickets.sort((a,b) => a.id < b.id);
    // const sortAllCompletedNew2Old = filteredAllCompletedTickets.sort((a,b) => a.id < b.id);
    const sortAllQueuedNew2Old = filteredAllQueuedTickets2.reverse();
    const sortAllCompletedNew2Old = filteredAllCompletedTickets2.reverse();

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
            {(filterDropdown === "Show All Tickets") && (
                <>
                <div className="queue"><QueuedTickets tickets={filteredAllQueuedTickets} setTickets={setTickets} /></div>
                <div className="completed"><CompletedTickets tickets={filteredAllCompletedTickets} setTickets={setTickets} /></div>
                </>
            )}
            {(filterDropdown === "urgencyLow") && (
                <>
                <div className="queue"><QueuedTickets tickets={filteredQueuedLowTickets} setTickets={setTickets} /></div>
                <div className="completed"><CompletedTickets tickets={filteredCompletedLowTickets} setTickets={setTickets} /></div>
                </>
            )}
            {(filterDropdown === "urgencyMedium") && (
                <>
                <div className="queue"><QueuedTickets tickets={filteredQueuedMediumTickets} setTickets={setTickets} /></div>
                <div className="completed"><CompletedTickets tickets={filteredCompletedMediumTickets} setTickets={setTickets} /></div>
                </>
            )}
            {(filterDropdown === "urgencyHigh") && (
                <>
                <div className="queue"><QueuedTickets tickets={filteredQueuedHighTickets} setTickets={setTickets} /></div>
                <div className="completed"><CompletedTickets tickets={filteredCompletedHighTickets} setTickets={setTickets} /></div>
                </>
            )}
            {(filterDropdown === "newToOld") && (
                <>
                <div className="queue"><QueuedTickets tickets={sortAllQueuedNew2Old} setTickets={setTickets} /></div>
                <div className="completed"><CompletedTickets tickets={sortAllCompletedNew2Old} setTickets={setTickets} /></div>
                </>
            )}
            {/* <div className="queue">
                {(filterDropdown === "Show All Tickets") && (
                    <QueuedTickets tickets={filteredAllQueuedTickets} setTickets={setTickets} />
                )}
                {(filterDropdown === "urgencyLow") && (
                    <QueuedTickets tickets={filteredQueuedLowTickets} setTickets={setTickets} />
                )}
                {(filterDropdown === "urgencyMedium") && (
                    <QueuedTickets tickets={filteredQueuedMediumTickets} setTickets={setTickets} />
                )}
                {(filterDropdown === "urgencyHigh") && (
                    <QueuedTickets tickets={filteredQueuedHighTickets} setTickets={setTickets} />
                )}
            </div> */}
            {/* <div className="completed">
                {(filterDropdown === "Show All Tickets") && (
                    <CompletedTickets tickets={filteredAllCompletedTickets} setTickets={setTickets} />
                )}
                {(filterDropdown === "urgencyLow") && (
                    <CompletedTickets tickets={filteredCompletedLowTickets} setTickets={setTickets} />
                )}
                {(filterDropdown === "urgencyMedium") && (
                    <CompletedTickets tickets={filteredCompletedMediumTickets} setTickets={setTickets} />
                )}
                {(filterDropdown === "urgencyHigh") && (
                    <CompletedTickets tickets={filteredCompletedHighTickets} setTickets={setTickets} />
                )}
            </div> */}
        </>
    )
}


export default Main;