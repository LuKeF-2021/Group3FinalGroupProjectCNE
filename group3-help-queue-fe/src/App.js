import './App.css';
import CompletedTickets from './completedTickets';
import QueuedTickets from './queuedTickets';
import axios from 'axios';
import WelcomeUser from './welcomeUser';
import { useEffect, useState } from 'react';

function App() {

  const [tickets, setTickets] = useState([])

  // setting out error obj
  const [error, setError] = useState(null);
  // loading...
  const [isLoaded, setIsLoaded] = useState(false);

  useEffect(() => {
    setTimeout(() => {
      const header = { "Access-Control-Allow-Origin": "*" };
      axios
        .get(`http://localhost:8901/tickets/readAll`, { header })
        .then((response) => {
          console.log(response);
          console.log('response.data', response.data);
          setIsLoaded(true);
          setTickets(response.data)
          // console.log('get data received:', tickets)
        })
        .catch((error) => {
          setIsLoaded(true);
          setError(error);
        })
    }, 2000)
  }, [])

  console.log('contents of tickets state:', tickets);
  const [QueuedTicketsList, setQueuedTicketsList] = useState(tickets.filter((ticket) => ticket.complete === false));
  console.log('Queued tickets: ', QueuedTicketsList);
  const [CompletedTicketsList, setCompletedTicketsList] = useState([]);
  const filteredComplete = tickets.filter((ticket) => ticket.complete === true);

  if (error) {
    return <h1>Something went wrong. Error: {error.message}</h1>
  } else if (!isLoaded) {
    return (
      <>
        <p>Please wait.... we are getting your request</p>
      </>
    )
  } else {

    return (
      <div className="screenDiv">
        <WelcomeUser />
        <div className="queue">
          <QueuedTickets tickets={tickets} setTickets={setTickets} QueuedTicketsList={QueuedTicketsList} setQueuedTicketsList={setQueuedTicketsList} CompletedTicketsList={CompletedTicketsList} setCompletedTicketsList={setCompletedTicketsList} />
        </div>
        <div className="completed">
          <CompletedTickets tickets={tickets} setTickets={setTickets} CompletedTicketsList={CompletedTicketsList} setCompletedTicketsList={setCompletedTicketsList} />
        </div>
      </div>
    );
  }
}
export default App;
