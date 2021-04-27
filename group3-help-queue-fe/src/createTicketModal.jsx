import React, { useState } from 'react';
import './Tickets.css';
import { HiX } from "react-icons/hi";



export const CreateTicketModal = ({ showCreateTicketModal, setShowCreateTicketModal, tickets, createNewTicket}) => {

    const [id, setId] = useState(0);
    const [name, setName] = useState('');
    const [time, setTime] = useState('15:12');
    const [ticketDescription, setTicketDescription] = useState('');
    const [ticketTitle, setTicketTitle] = useState('');
    const [isCompleted, setIsCompleted] = useState(false);


    const onSubmit = (e) => {
        e.preventDefault();

        if(!name) {
            alert('Please enter a name')
            return
        }else if(!ticketTitle){
            alert('Please enter a ticket title')
            return
        }else if(!ticketDescription){
            alert('Please enter a ticket description')
            return
        }

        setId(tickets.length + 1);
        setIsCompleted(false);
        createNewTicket({ id, name, time, ticketDescription, ticketTitle, isCompleted })
        setShowCreateTicketModal(prev => !prev);

        setName('');
        setTicketTitle('');
        setTicketDescription('');

    }

    return (
        <>
            {showCreateTicketModal ? (
                <form onSubmit={onSubmit}>
                <div className="modalPopup">
                    <div className="createCardModal">
                        <div className="ticket-user-time">
                            <h3 className="inline">Name: </h3>
                            <input
                                id="name"
                                type="text"
                                name="name"
                                value={name}
                                onChange={(e) => setName(e.target.value)}
                            />
                            <HiX style={{ verticalAlign: 'middle' }} size={28} className="crossModal" onClick={() => setShowCreateTicketModal(prev => !prev)} />
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