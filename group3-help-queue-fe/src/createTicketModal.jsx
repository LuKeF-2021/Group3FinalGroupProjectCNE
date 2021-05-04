import React, { useState } from 'react';
import './Headings.css';
import './Tickets.css';
import './Buttons.css';
import './Pagnation.css';
import './Inputs.css';
import { HiX } from "react-icons/hi";



export const CreateTicketModal = ({ showCreateTicketModal, setShowCreateTicketModal, createNewTicket}) => {

    // const [id, setId] = useState(0);
    const [name, setName] = useState('');
    // const [time, setTime] = useState('15:12');
    const [ticketDescription, setTicketDescription] = useState('');
    const [ticketTitle, setTicketTitle] = useState('');
    const [urgency, setUrgency] = useState('Low');
    // const [isCompleted, setIsCompleted] = useState(false);


    const onSubmit = (e) => {
        e.preventDefault();

        // if(!name) {
        //     alert('Please enter a name')
        //     return
        // }else if(!ticketTitle){
        //     alert('Please enter a ticket title')
        //     return
        // }else if(!ticketDescription){
        //     alert('Please enter a ticket description')
        //     return
        // }

        // setId(tickets.length + 1);
        // setIsCompleted(false);
        createNewTicket({ name, ticketDescription, ticketTitle, urgency})
        setShowCreateTicketModal(prev => !prev);

        setName('');
        setTicketTitle('');
        setTicketDescription('');
        setUrgency('Low');

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
                                required
                            />
                            <h3 className="inline">Urgency: </h3>
                            <select id="urgency" name="urgency" value={urgency} onChange={e => setUrgency(e.currentTarget.value)}>
                                <option value="Low">Low</option>
                                <option value="Medium">Medium</option>
                                <option value="High">High</option>
                            </select>
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
                                required
                            />
                            <h3>Ticket Description: </h3>
                            <textarea
                                id="ticketDescription"
                                name="ticketDescription"
                                value={ticketDescription}
                                onChange={(e) => setTicketDescription(e.target.value)}
                                required
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