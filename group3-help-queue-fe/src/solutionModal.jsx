import React, { useState } from 'react';
import './Tickets.css';
import { HiX } from "react-icons/hi";

export const SolutionModal = ({ showSolutionModal, setShowSolutionModal, currentTicketModal, updateTicketWithSolution }) => {

    
    
    const [solution, setSolution] = useState('N/A');


    const onSubmit = (e) => {
        e.preventDefault();

        

        updateTicketWithSolution({ solution, currentTicketModal})
        setShowSolutionModal(prev => !prev);

        setSolution('N/A');


    }

    return (
        <>
            {showSolutionModal ? (
                <form onSubmit={onSubmit}>
                <div className="modalPopup">
                    <div className="createCardModal">
                        <div className="ticket-user-time">
                            <h3 className="inline">{currentTicketModal.name}</h3><HiX style={{ verticalAlign: 'middle' }} size={28} className="crossModal" onClick={() => setShowSolutionModal(prev => !prev)} />
                        </div>
                        <div className="ticket-description">
                            <h3>{currentTicketModal.title}</h3>
                            <h3>Ticket Solution (Optional): </h3>
                            <textarea
                                id="ticketSolution"
                                name="ticketSolution"
                                value={solution}
                                onChange={(e) => setSolution(e.target.value)}
                            ></textarea>
                        </div>
                        <button className="btn">Submit</button>
                    </div>
                </div>
                </form>
            ) : null}
        </>
    )
}