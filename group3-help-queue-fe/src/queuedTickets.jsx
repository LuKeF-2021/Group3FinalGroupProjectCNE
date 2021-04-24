import React, {useState} from 'react';
import { CardModal } from './cardModal';

import CardStructure from './cardStructure';
import './Tickets.css';
const QueuedTickets = ({tickets, setTickets}) => {

    const [showTicketModal, setShowTicketModal] = useState(false);
    const [currentTicketModal, setCurrentTicketModal] = useState([]);

    const openTicketModal = (ticketDetails) => {
        setShowTicketModal(prev => !prev);
        // console.log('opened', ticketDetails);
        setCurrentTicketModal(ticketDetails);
        // console.log('currentTicketModal', currentTicketModal);
    }


    const deleteTicket = (id) => {
        setTickets(tickets.filter((ticket) => ticket.id !== id))
        // console.log(tickets)
        }


    

    return (
        <>
        <div className="queuedHeading">
            <h2 className="header" id="create-ticket">Queued Tickets</h2>
            <button className="btnCreate" id="create-ticket">
                Create Ticket
			</button>
        </div>
        <div className="cardGrid">
            {
                tickets.map((cardStuff) => (
                    <CardStructure key={cardStuff.id} cardStuff={cardStuff} openTicketModal={openTicketModal} deleteTicket={deleteTicket}/>
                ))
                
            }
            <CardModal showTicketModal={showTicketModal} setShowTicketModal={setShowTicketModal} currentTicketModal={currentTicketModal}/>
        </div>
        </>

    )

}

export default QueuedTickets;