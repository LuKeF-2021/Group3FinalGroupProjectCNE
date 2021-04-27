import React, {useState} from 'react';
import { CardModal } from './cardModal';
import { CreateTicketModal} from './createTicketModal';
import ReactPaginate from 'react-paginate';

import CardStructure from './cardStructure';
import './Tickets.css';


const QueuedTickets = ({tickets, setTickets}) => {

    const [showCreateTicketModal, setShowCreateTicketModal] = useState(false);
    const [showTicketModal, setShowTicketModal] = useState(false);
    const [currentTicketModal, setCurrentTicketModal] = useState([]);
    const [pageNum, setPageNum] = useState(1);
    const [createdTicket, setCreatedTicket] = useState("");

   

    const openTicketModal = (ticketDetails) => {
        setShowTicketModal(prev => !prev);
        setCurrentTicketModal(ticketDetails);
    }

    const openCreateTicketModal = () => {
        setShowCreateTicketModal(prev => !prev);
    }

    const updateTicketToCompleted = (id) => {
        const ticketToComplete = tickets.filter((ticket) => ticket.id === id);
        console.log('ticket you clicked complete on:', ticketToComplete);
        
        const newTickets = tickets.map((ticket) => {
            if (ticket.id === id) {
                const updatedTicket = {
                    ...ticket,
                    isCompleted: ticket.isCompleted = "true"
                };

                return updatedTicket;
            }
            return ticket;
            
        });
        
        setTickets(newTickets);

        
    }

    const createNewTicket = ({ name, ticketDescription, ticketTitle, isCompleted }) => {

        const newTicket = 
            {
                name: name,
                description: ticketDescription,
                title: ticketTitle,
                completed: isCompleted
            };  

        console.log('new ticket is: ', newTicket);
        setCreatedTicket(newTicket);
        console.log('updated list with new ticket: ', tickets);
    }

    const deleteTicket = (id) => {
        setTickets(tickets.filter((ticket) => ticket.id !== id));
        }

    const changePage = ({selected}) => {
        setPageNum(selected + 1);
        console.log('updated list with new ticket: ', tickets);
    }
    

    return (
        <>
        <div className="queuedHeading">
            <h2 className="header" id="create-ticket">Queued Tickets</h2>
            <button className="btnCreate" id="create-ticket" onClick={openCreateTicketModal}>
                Create Ticket
			</button>
    
        </div>
        <div className="cardGrid">
            {
                tickets.filter(ticket => ticket.complete === false)
                .map((cardStuff) => (
                    <CardStructure key={cardStuff.id} cardStuff={cardStuff} openTicketModal={openTicketModal} deleteTicket={deleteTicket} updateTicketToCompleted={updateTicketToCompleted}/>
                ))
                
            }
            <CardModal showTicketModal={showTicketModal} setShowTicketModal={setShowTicketModal} currentTicketModal={currentTicketModal}/>
            <CreateTicketModal showCreateTicketModal={showCreateTicketModal} setShowCreateTicketModal={setShowCreateTicketModal} createNewTicket={createNewTicket} tickets={tickets}/>
        </div>
        <div className="pageArea">
            {/* <ReactPaginate
                previousLabel={"Previous"}
                nextLabel={"Next"}
                pageCount={numOfPages}
                onPageChange={changePage}
                containerClassName={"pageButtons"}
                previousLinkClassName={"previousButton"}
                nextLinkClassName={"nextButton"}
                activeClassName={"activePage"}
                disabledClassName={"disabled"}
            /> */}
        </div>
        </>

    )

}

export default QueuedTickets;