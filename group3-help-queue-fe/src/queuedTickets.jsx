import React, {useState} from 'react';
import { CardModal } from './cardModal';

import CardStructure from './cardStructure';
import './Tickets.css';
const QueuedTickets = ({tickets}) => {

    const [showTicketModal, setShowTicketModal] = useState(false);

    const openTicketModal = (id) => {
        setShowTicketModal(prev => !prev);
        console.log('opened', id);
    }


    

    return (
        <div className="queuedHeading">
            <h2 className="header" id="create-ticket">Queued Tickets</h2>
            <button className="btnCreate" id="create-ticket">
                Create Ticket
			</button>
            {
                tickets.map((cardStuff) => (
                    <CardStructure key={cardStuff.id} cardStuff={cardStuff} openTicketModal={openTicketModal}/>
                ))
                
            }
            <CardModal showTicketModal={showTicketModal} setShowTicketModal={setShowTicketModal}/>
        </div>

    )

}

export default QueuedTickets;