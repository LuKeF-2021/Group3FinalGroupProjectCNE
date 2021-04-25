import './App.css';
import CompletedTickets from './completedTickets';
import QueuedTickets from './queuedTickets';
import WelcomeUser from './welcomeUser';
import { useState } from 'react';

function App() {

  const [tickets, setTickets] = useState([
    {

      id: 1,
      usersName: "Luke Foster",
      time: "17:14",
      ticketDescription: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Error perferendis porro consequuntur illum omnis quas ex incidunt eius eos sed magni earum iusto maiores laboriosam numquam maxime, quidem nobis sint.",
      ticketTitle: "Docker Problem",
      isCompleted: "false"
    },
    {
      id: 2,
      usersName: "Jack Smith",
      time: "17:36",
      ticketDescription: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Error perferendis porro consequuntur illum omnis quas ex incidunt eius eos sed magni earum iusto maiores laboriosam numquam maxime, quidem nobis sint.",
      ticketTitle: "Terraform Problem",
      isCompleted: "false"
    },
    {
      id: 3,
      usersName: "Ben Wellens",
      time: "11:25",
      ticketDescription: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Error perferendis porro consequuntur illum omnis quas ex incidunt eius eos sed magni earum iusto maiores laboriosam numquam maxime, quidem nobis sint.Lorem ipsum dolor sit, amet consectetur adipisicing elit. Error perferendis porro consequuntur illum omnis quas ex incidunt eius eos sed magni earum iusto maiores laboriosam numquam maxime, quidem nobis sint",
      ticketTitle: "Login Problem",
      isCompleted: "false"
    },
    {
      id: 4,
      usersName: "Sam Matterson",
      time: "14:52",
      ticketDescription: "Lorem ipsum dolor sit",
      ticketTitle: "500 Server error",
      isCompleted: "false"
    },
    {

      id: 5,
      usersName: "Amy Lawson",
      time: "17:18",
      ticketDescription: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Error perferendis porro consequuntur illum omnis quas ex incidunt eius eos sed magni earum iusto maiores laboriosam numquam maxime, quidem nobis sint.",
      ticketTitle: "Docker Problem 2",
      isCompleted: "false"

    },
    {
      id: 6,
      usersName: "Jack Wellens",
      time: "17:38",
      ticketDescription: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Error perferendis porro consequuntur illum omnis quas ex incidunt eius eos sed magni earum iusto maiores laboriosam numquam maxime, quidem nobis sint.",
      ticketTitle: "Terraform Problem 2",
      isCompleted: "true"
    },
    {
      id: 7,
      usersName: "Lee Richards",
      time: "11:30",
      ticketDescription: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Error perferendis porro consequuntur illum omnis quas ex incidunt eius eos sed magni earum iusto maiores laboriosam numquam maxime, quidem nobis sint.Lorem ipsum dolor sit, amet consectetur adipisicing elit. Error perferendis porro consequuntur illum omnis quas ex incidunt eius eos sed magni earum iusto maiores laboriosam numquam maxime, quidem nobis sint",
      ticketTitle: "Login Problem 2",
      isCompleted: "false"
    },
    {
      id: 8,
      usersName: "Peter Matterson",
      time: "18:52",
      ticketDescription: "Lorem ipsum dolor sit",
      ticketTitle: "500 Server error 2",
      isCompleted: "true"
    }
  ])

  return (
    <div className="screenDiv">
      <WelcomeUser />
      <div className="queue">
        <QueuedTickets tickets={tickets} setTickets={setTickets} />
      </div>
      <div className="completed">
        <CompletedTickets tickets={tickets} setTickets={setTickets} />
      </div>
    </div>
  );
}

export default App;
