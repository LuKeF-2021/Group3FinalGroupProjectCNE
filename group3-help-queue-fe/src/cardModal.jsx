import React from 'react';
import './Tickets.css';
import { HiX } from "react-icons/hi";



const CardModal = ({ showTicketModal, setShowTicketModal, currentTicketModal}) => {

    // const temp = currentTicketModal.createdAt;
    // const timeFormat = (temp.substring(8,10)) + '/' + (temp.substring(5,7)) + '  ' + (temp.substring(11,16));

    return (
        <>
            {showTicketModal ? (
                <div className="modalPopup">
                    <div className="cardModal">
                        <div className="ticket-user-time"><h3 className="inline">{currentTicketModal.name}</h3>      <h3 className="inline-right">Urgency: {currentTicketModal.urgency}</h3> <HiX style={{ verticalAlign: 'middle' }} size={28} className="crossModal" onClick={() => setShowTicketModal(prev => !prev)}/></div>
                        <div className="ticket-description">
                            <h3>{currentTicketModal.title}</h3>
                            <p>{currentTicketModal.description}</p>
                            <br></br>
                            <h3>Solution:</h3>
                            <p>{currentTicketModal.solution}</p></div>
                    </div>
                </div>
            ) : null}
        </>
    )
}

export default CardModal;