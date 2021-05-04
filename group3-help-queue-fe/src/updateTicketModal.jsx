import React from 'react';
import './Headings.css';
import './Tickets.css';
import './Buttons.css';
import './Pagnation.css';
import './Inputs.css';
import { HiX } from "react-icons/hi";



export const UpdateTicketModal = ({ showUpdateTicketModal, setShowUpdateTicketModal, currentTicketModal, updateTicketContents , ticketDescription, setTicketDescription, ticketTitle, setTicketTitle}) => {

    // console.log('in edit modal: ', currentTicketModal.description);
    // console.log('in edit modal2: ', currentTicketModal.title);
    // const [id, setId] = useState(0);
    // const [name, setName] = useState('');
    // const [time, setTime] = useState();
    // const [ticketDescription, setTicketDescription] = useState(currentTicketModal.description);
    // const [ticketTitle, setTicketTitle] = useState(currentTicketModal.title);
    // console.log('ticket description use state: ', ticketDescription);
    // console.log('ticket ticket title :', ticketTitle);
    // const [isCompleted, setIsCompleted] = useState(false);


    const onSubmit = (e) => {
        e.preventDefault();

        
        // if(!ticketTitle){
        //     alert('Please enter a ticket title')
        //     return
        // }else if(!ticketDescription){
        //     alert('Please enter a ticket description')
        //     return
        // }

        updateTicketContents({ ticketDescription, ticketTitle, currentTicketModal})
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
                            <h3 className="inline">{currentTicketModal.name}</h3><HiX style={{ verticalAlign: 'middle' }} size={28} className="crossModal" onClick={() => setShowUpdateTicketModal(prev => !prev)} />
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