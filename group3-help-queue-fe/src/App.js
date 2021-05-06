import './App.css';
import axios from 'axios';
import { useEffect, useState } from 'react';
import Main from './main';
import './Headings.css';
import './Tickets.css';
import './Buttons.css';
import './Pagnation.css';
import './Inputs.css';

function App() {

  const [tickets, setTickets] = useState([])
  // setting out error obj
  const [error, setError] = useState(null);
  // loading...
  const [isLoaded, setIsLoaded] = useState(false);
  const [refresh, setRefresh] = useState(true);

  useEffect(() => {
      const header = { "Access-Control-Allow-Origin": "*" };
      axios
        .get(`http://localhost:8899/tickets/readAll`, { header })
        .then((response) => {
          console.log(response);
          console.log('response.data', response.data);
          setIsLoaded(true);
          setTickets(response.data);
          setRefresh(false);
        })
        .catch((error) => {
          setIsLoaded(true);
          setError(error);
          console.log(error.response.data.error);
        
    })


  }, [refresh])
  console.log('tickets outside of use effect: ', tickets)


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
      <h1>QA Help Ticket System</h1>
      <Main tickets={tickets} setTickets={setTickets} refresh={refresh} setRefresh={setRefresh}/>
      </div>
    );
  }
}
export default App;
