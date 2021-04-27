import React, {useState} from 'react';
import { CardModal } from './cardModal';
import { CreateTicketModal} from './createTicketModal';
import ReactPaginate from 'react-paginate';

import CardStructure from './cardStructure';
import './Tickets.css';


const QueuedTickets = ({tickets, setTickets , QueuedTicketsList, setQueuedTicketsList, CompletedTicketsList, setCompletedTicketsList}) => {

    const [showCreateTicketModal, setShowCreateTicketModal] = useState(false);
    const [showTicketModal, setShowTicketModal] = useState(false);
    const [currentTicketModal, setCurrentTicketModal] = useState([]);
    const [pageNum, setPageNum] = useState(1);
    const [createdTicket, setCreatedTicket] = useState("");
    
    console.log('tickets: ', tickets)
    console.log('Queued tickets: ', QueuedTicketsList);
    // const [QueuedTickets, setQueuedTickets] = useState(tickets.filter((ticket) => ticket.isCompleted === "false"));
    // console.log('number of queued tickets', QueuedTicketsList);

    // const numOfTickets = tickets.length;
    const numOfTickets = QueuedTicketsList.length;
    // console.log(numOfTickets);
    const ticketsPerPage = 4;
    const firstTicketToDisplay = ((pageNum-1) * ticketsPerPage) + 1;
   
    // eg. user clicks page 2 button, we want tickets 5-8 to display.
    // const displayTickets = tickets.slice((firstTicketToDisplay - 1), (firstTicketToDisplay + (ticketsPerPage - 1)));
    const displayTickets = QueuedTicketsList.slice((firstTicketToDisplay - 1), (firstTicketToDisplay + (ticketsPerPage - 1)));
    // console.log('first ticket', firstTicketToDisplay);
    // console.log('tickets range', displayTickets);
    const numOfPages = Math.ceil(numOfTickets/ticketsPerPage);
    // console.log('Number of pages:', numOfPages);

    const openTicketModal = (ticketDetails) => {
        setShowTicketModal(prev => !prev);
        // console.log('opened', ticketDetails);
        setCurrentTicketModal(ticketDetails);
        // console.log('currentTicketModal', currentTicketModal);
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
        setQueuedTicketsList(tickets.filter((ticket) => ticket.isCompleted === "false"));
        setCompletedTicketsList(tickets.filter((ticket) => ticket.isCompleted === "true"));

        console.log('output of updateTicket:', tickets);
        console.log('new queued ticket list:', QueuedTicketsList);
        console.log('new completed ticket list:', CompletedTicketsList);
        
    }

    const createNewTicket = ({ id, name, time, ticketDescription, ticketTitle, isCompleted }) => {
        // setShowCreateTicketModal(prev => !prev);

        // console.log('new ticket: ', ticketItem)

        const newTicket = 
            {
                id: id,
                usersName: name,
                time: time,
                ticketDescription: ticketDescription,
                ticketTitle: ticketTitle,
                isCompleted: isCompleted
            };  

        console.log('new ticket is: ', newTicket);
        setCreatedTicket(newTicket);
        // setTickets(tickets => [...tickets, newTicket]);
        setQueuedTicketsList(QueuedTicketsList => [...QueuedTicketsList, newTicket]);
        console.log('updated list with new ticket: ', tickets);
    }

    const deleteTicket = (id) => {
        setQueuedTicketsList(QueuedTicketsList.filter((ticket) => ticket.id !== id));
        // console.log(tickets)
        }

    const changePage = ({selected}) => {
        setPageNum(selected + 1);
        console.log('updated list with new ticket: ', tickets);
        console.log('updated queued list: ', QueuedTicketsList);
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
                displayTickets.map((cardStuff) => (
                    <CardStructure key={cardStuff.id} cardStuff={cardStuff} openTicketModal={openTicketModal} deleteTicket={deleteTicket} updateTicketToCompleted={updateTicketToCompleted}/>
                ))
                
            }
            <CardModal showTicketModal={showTicketModal} setShowTicketModal={setShowTicketModal} currentTicketModal={currentTicketModal}/>
            <CreateTicketModal showCreateTicketModal={showCreateTicketModal} setShowCreateTicketModal={setShowCreateTicketModal} createNewTicket={createNewTicket} tickets={tickets}/>
        </div>
        <div className="pageArea">
            <ReactPaginate
                previousLabel={"Previous"}
                nextLabel={"Next"}
                pageCount={numOfPages}
                onPageChange={changePage}
                containerClassName={"pageButtons"}
                previousLinkClassName={"previousButton"}
                nextLinkClassName={"nextButton"}
                activeClassName={"activePage"}
                disabledClassName={"disabled"}
            />
        </div>
        </>

    )

}

export default QueuedTickets;