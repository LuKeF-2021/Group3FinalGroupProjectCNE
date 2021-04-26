import React from 'react';
import './Tickets.css';
import { HiX } from "react-icons/hi";



export const CreateTicketModal = ({ showCreateTicketModal, setShowCreateTicketModal }) => {


    return (
        <>
            {showCreateTicketModal ? (
                <div className="modalPopup">
                    <div className="createCardModal">
                        <div className="ticket-user-time"><h3 className="inline">Name: </h3><HiX style={{ verticalAlign: 'middle' }} size={28} className="crossModal" onClick={() => setShowCreateTicketModal(prev => !prev)} /></div>
                        <div className="ticket-description"></div>
                    </div>
                </div>
            ) : null}
        </>
    )
}