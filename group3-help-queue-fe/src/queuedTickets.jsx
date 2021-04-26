import React, {useState} from 'react';
import { CardModal } from './cardModal';
import ReactPaginate from 'react-paginate';

import CardStructure from './cardStructure';
import './Tickets.css';


const QueuedTickets = ({tickets, setTickets , QueuedTickets2, setQueuedTickets2, CompletedTickets2, setCompletedTickets2}) => {

    
    const [showTicketModal, setShowTicketModal] = useState(false);
    const [currentTicketModal, setCurrentTicketModal] = useState([]);
    const [pageNum, setPageNum] = useState(1);

    // const [QueuedTickets, setQueuedTickets] = useState(tickets.filter((ticket) => ticket.isCompleted === "false"));
    console.log('number of queued tickets', QueuedTickets2);

    // const numOfTickets = tickets.length;
    const numOfTickets = QueuedTickets2.length;
    console.log(numOfTickets);
    const ticketsPerPage = 4;
    const firstTicketToDisplay = ((pageNum-1) * ticketsPerPage) + 1;
   
    // eg. user clicks page 2 button, we want tickets 5-8 to display.
    // const displayTickets = tickets.slice((firstTicketToDisplay - 1), (firstTicketToDisplay + (ticketsPerPage - 1)));
    const displayTickets = QueuedTickets2.slice((firstTicketToDisplay - 1), (firstTicketToDisplay + (ticketsPerPage - 1)));
    console.log('first ticket', firstTicketToDisplay);
    console.log('tickets range', displayTickets);
    const numOfPages = Math.ceil(numOfTickets/ticketsPerPage);
    console.log('Number of pages:', numOfPages);

    const openTicketModal = (ticketDetails) => {
        setShowTicketModal(prev => !prev);
        // console.log('opened', ticketDetails);
        setCurrentTicketModal(ticketDetails);
        // console.log('currentTicketModal', currentTicketModal);
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
        setQueuedTickets2(tickets.filter((ticket) => ticket.isCompleted === "false"));
        setCompletedTickets2(tickets.filter((ticket) => ticket.isCompleted === "true"));

        console.log('output of updateTicket:', tickets);
        console.log('new queued ticket list:', QueuedTickets2);
        console.log('new completed ticket list:', CompletedTickets2);
        
    }

    const deleteTicket = (id) => {
        setQueuedTickets2(QueuedTickets2.filter((ticket) => ticket.id !== id));
        // console.log(tickets)
        }

    const changePage = ({selected}) => {
        setPageNum(selected + 1);
    }
    

    return (
        <>
        <div className="queuedHeading">
            <h2 className="header" id="create-ticket">Queued Tickets</h2>
            <button className="btnCreate" id="create-ticket">
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