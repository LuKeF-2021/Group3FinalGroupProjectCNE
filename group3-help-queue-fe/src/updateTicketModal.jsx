import React, { useState } from 'react';
import './Tickets.css';
import { HiX } from "react-icons/hi";



export const UpdateTicketModal = ({ showUpdateTicketModal, setShowUpdateTicketModal, tickets, updateTicketContents}) => {

    console.log('in edit modal: ', tickets.description);
    console.log('in edit modal2: ', tickets.title);
    // const [id, setId] = useState(0);
    // const [name, setName] = useState('');
    // const [time, setTime] = useState();
    const [ticketDescription, setTicketDescription] = useState(tickets.description);
    const [ticketTitle, setTicketTitle] = useState(tickets.title);
    // const [isCompleted, setIsCompleted] = useState(false);


    const onSubmit = (e) => {
        e.preventDefault();

        
        if(!ticketTitle){
            alert('Please enter a ticket title')
            return
        }else if(!ticketDescription){
            alert('Please enter a ticket description')
            return
        }

        updateTicketContents({ ticketDescription, ticketTitle })
        setShowUpdateTicketModal(prev => !prev);

        setTicketTitle('');
        setTicketDescription('');

    }

    return (
        <>
            {showUpdateTicketModal ? (
                <form onSubmit={onSubmit}>
                <div className="modalPopup">
                    <div className="createCardModal">
                        <div className="ticket-user-time">
                            <h3 className="inline">{tickets.name}</h3>
                            <HiX style={{ verticalAlign: 'middle' }} size={28} className="crossModal" onClick={() => setShowUpdateTicketModal(prev => !prev)} />
                        </div>
                        <div className="ticket-description">
                            <h3>Ticket Title: </h3>
                            <input
                                id="ticketTitle"
                                type="text"
                                name="ticketTitle"
                                value={ticketTitle}
                                onChange={(e) => setTicketTitle(e.target.value)}
                            />
                            <h3>Ticket Description: </h3>
                            <textarea
                                id="ticketDescription"
                                name="ticketDescription"
                                value={ticketDescription}
                                onChange={(e) => setTicketDescription(e.target.value)}
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