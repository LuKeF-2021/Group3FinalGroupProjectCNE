import QueuedTickets from "./queuedTickets";
import CompletedTickets from './completedTickets';
import { useEffect, useState } from 'react';
import './App.css';

const Main = ({ tickets, setTickets, queueTest, setQueueTest }) => {

    const [queuedTicketsList, setQueuedTicketsList] = useState([]);
    // const [CompletedTicketsList, setCompletedTicketsList] = useState([]);

    console.log('tickets:', tickets);
    console.log('queue tickets:', queuedTicketsList);

    // useEffect(() => {
    // setQueueTest(tickets.filter((ticket) => ticket.complete === false))
    // console.log('queue list on load: ', queueTest)
    // }, [])

    return (
        <>
            <div className="queue">
                <QueuedTickets tickets={tickets} setTickets={setTickets} queueTest={queueTest} setQueueTest={setQueueTest}/>
            </div>
            <div className="completed">
                <CompletedTickets tickets={tickets} setTickets={setTickets} />
            </div>
        </>
    )
}


export default Main;