import './App.css';
import CompletedTickets from './completedTickets';
import QueuedTickets from './queuedTickets';
import WelcomeUser from './welcomeUser';
import { useState } from 'react';

function App() {

  const [tickets, setTickets] = useState([
    {

        id:1,
        usersName: "Luke Foster",
        time: "17:14",
        ticketDescription: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Error perferendis porro consequuntur illum omnis quas ex incidunt eius eos sed magni earum iusto maiores laboriosam numquam maxime, quidem nobis sint.",
        ticketTitle: "Docker Problem"

    },
    {
        id:2,
        usersName: "Jack Smith",
        time: "17:36",
        ticketDescription: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Error perferendis porro consequuntur illum omnis quas ex incidunt eius eos sed magni earum iusto maiores laboriosam numquam maxime, quidem nobis sint.",
        ticketTitle: "Terraform Problem"
    }]
    )

  return (
    <div className="screenDiv">
      <WelcomeUser/>
    <div className="queue">
      <QueuedTickets tickets={tickets}/>
    </div>
    <div className="completed">
      <CompletedTickets/>
    </div>
    </div>
  );
}

export default App;
