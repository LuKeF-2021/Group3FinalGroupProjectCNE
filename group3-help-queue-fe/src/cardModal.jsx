import React from 'react';
import './Tickets.css';
import { HiX } from "react-icons/hi";



export const CardModal = ({ showTicketModal, setShowTicketModal, currentTicketModal}) => {


    return (
        <>
            {showTicketModal ? (
                <div className="modalPopup">
                    <div className="cardModal">
                        <div className="ticket-user-time"><h3 className="inline">{currentTicketModal.usersName}</h3>      <p className="inline">{currentTicketModal.time}</p> <HiX style={{ verticalAlign: 'middle' }} size={28} className="crossModal" onClick={() => setShowTicketModal(prev => !prev)}/></div>
                        <div className="ticket-description"><h3>{currentTicketModal.ticketTitle}</h3><p>{currentTicketModal.ticketDescription}</p></div>
                    </div>
                </div>
            ) : null}
        </>
    )
}