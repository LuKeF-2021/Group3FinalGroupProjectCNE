import React from 'react';
import './Tickets.css';



export const CardModal = ({ showTicketModal, setShowTicketModal}) => {


    return (
        <>
            {showTicketModal ? (
                <div className="modalPopup">
                    <div className="cardModal">
                        <div className="ticket-user-time"><h3 className="inline">Luke Foster</h3>      <p className="inline">17:56</p></div>
                        <div className="ticket-description"><h3>Docker Problem</h3><p>Test Description</p></div>
                        <button className="btn" onClick={() => setShowTicketModal(prev => !prev)}>Close</button>
                    </div>
                </div>
            ) : null}
        </>
    )
}