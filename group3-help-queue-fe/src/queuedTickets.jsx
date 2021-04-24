import React, {useState} from 'react';
import { CardModal } from './cardModal';

import CardStructure from './cardStructure';
import './Tickets.css';
const QueuedTickets = ({tickets}) => {

    const [showTicketModal, setShowTicketModal] = useState(false);
    // const [allTickets, setAllTickets] = useState([]);

    const openTicketModal = (id) => {
        setShowTicketModal(prev => !prev);
        console.log(id);
    }


    // const [tickets, setTickets] = useState([
    // {

    //     id:1,
    //     usersName: "Luke Foster",
    //     time: "17:14",
    //     ticketDescription: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Error perferendis porro consequuntur illum omnis quas ex incidunt eius eos sed magni earum iusto maiores laboriosam numquam maxime, quidem nobis sint.",
    //     ticketTitle: "Docker Problem"

    // },
    // {
    //     id:2,
    //     usersName: "Jack Smith",
    //     time: "17:36",
    //     ticketDescription: "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Error perferendis porro consequuntur illum omnis quas ex incidunt eius eos sed magni earum iusto maiores laboriosam numquam maxime, quidem nobis sint.",
    //     ticketTitle: "Terraform Problem"
    // }]
    // )

    return (
        <div className="queuedHeading">
            <h2 className="header" id="create-ticket">Queued Tickets</h2>
            <button className="btnCreate" id="create-ticket">
                Create Ticket
			</button>
            {
                tickets.map((cardStuff) => (
                    // <div className="column" key={cardStuff.id}>
                    // <div className="card">
                    //     <div className="ticket-user-time"><h3 className="inline">{cardStuff.usersName}</h3>      <p className="inline">{cardStuff.time}</p></div>
                    //     <div className="ticket-description" onClick={() => openTicketModal(tickets.id)}><h3>{cardStuff.ticketTitle}</h3><p>{cardStuff.ticketDescription}</p></div>
                    //     <div className="complete-button">
                    //     <button className="btn" id="ticket-complete">Completed</button>
                    //     <button className="btn" id="ticket-edit">Edit</button>
                    //     <button className="btn" id="ticket-delete">Delete</button>
                    //     </div>
                    // </div>
                    // </div>
                    <CardStructure key={cardStuff.id} cardStuff={cardStuff} openTicketModal={openTicketModal}/>
                ))
                
            }
            <CardModal showTicketModal={showTicketModal} setShowTicketModal={setShowTicketModal}/>
        </div>

    )

}

export default QueuedTickets;