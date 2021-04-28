import './App.css';
import axios from 'axios';
import { useEffect, useState } from 'react';
import Main from './main';
import './Tickets.css';

function App() {

  const [tickets, setTickets] = useState([])
  // const [queueTest, setQueueTest] = useState([])
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
          // setQueueTest(response.data)
          // {
          //   (response.data).filter(ticket => ticket.complete === false).map((cardStuff) => (
          //   setQueueTest([...queueTest, cardStuff])              
          // ))
          // }
          // console.log('get data received:', tickets)
        })
        .catch((error) => {
          setIsLoaded(true);
          setError(error);
        })
    }, 2000)


  }, [tickets])
  // console.log('tickets outside of use effect: ', tickets)
  // const [queueTest, setQueueTest] = useState([]);
  // setQueueTest(tickets)

  // console.log('queued list updated: ', queueTest)



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
      <h1>Welcome Group 3!</h1>
      <Main tickets={tickets} setTickets={setTickets} />
      </div>
    );
  }
}
export default App;
