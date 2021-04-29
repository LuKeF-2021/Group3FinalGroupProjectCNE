import QueuedTickets from "./queuedTickets";
import CompletedTickets from './completedTickets';
import { useEffect, useState } from 'react';
import './App.css';

const Main = ({ tickets, setTickets }) => {

    // const [queuedTicketsList, setQueuedTicketsList] = useState([]);
    // const [CompletedTicketsList, setCompletedTicketsList] = useState([]);

    // console.log('tickets:', tickets);
    // console.log('queue tickets:', queuedTicketsList);

    // useEffect(() => {
    // setQueueTest(tickets.filter((ticket) => ticket.complete === false))
    // console.log('queue list on load: ', queueTest)
    // }, [])

    // const makeQueuedList = () => {
    // setQueuedTicketsList(tickets.filter((ticket) => ticket.complete === false))
    // console.log('queue list after function: ', queuedTicketsList)
    // }

    // makeQueuedList();
    
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