import React, { useState } from 'react';
import CardModal from './cardModal';
import ReactPaginate from 'react-paginate';
import axios from 'axios';

import CardStructure from './cardStructure';
import './Tickets.css';


const CompletedTickets = ({ tickets, setTickets }) => {

    const [showCreateTicketModal, setShowCreateTicketModal] = useState(false);
    const [showTicketModal, setShowTicketModal] = useState(false);
    const [currentTicketModal, setCurrentTicketModal] = useState([]);
    const [pageNum, setPageNum] = useState(1);
    const [createdTicket, setCreatedTicket] = useState("");


    const CompletedTicketsList = [];
    tickets.map((ticket) => {
        if (ticket.complete === true) {
            CompletedTicketsList.push(ticket);
            // console.log('completed tickets: ', completedTicketsList);
        }
    })

    const numOfTickets = CompletedTicketsList.length;
    const ticketsPerPage = 4;
    const firstTicketToDisplay = ((pageNum-1) * ticketsPerPage) + 1;
   
    // eg. user clicks page 2 button, we want tickets 5-8 to display.
    // const displayTickets = tickets.slice((firstTicketToDisplay - 1), (firstTicketToDisplay + (ticketsPerPage - 1)));
    const displayTickets = CompletedTicketsList.slice((firstTicketToDisplay - 1), (firstTicketToDisplay + (ticketsPerPage - 1)));
    const numOfPages = Math.ceil(numOfTickets/ticketsPerPage);

    const openTicketModal = (ticketDetails) => {
        setShowTicketModal(prev => !prev);
        setCurrentTicketModal(ticketDetails);
    }


    const [deleteTheTicket, setDeleteTheTicket] = useState(false);
    const deleteTicket = (id) => {
        // setCompletedTicketsList(CompletedTicketsList.filter((ticket) => ticket.id !== id))
        // console.log(tickets)
        setTickets(tickets.filter((ticket) => ticket.id !== id));
        axios.delete(`http://localhost:8901/tickets/delete/${id}`)
            .then(function (response) {
                console.log(response);
                setDeleteTheTicket(true);
            })
            .catch(function (error) {
                console.log(error);
            })



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

    const changePage = ({selected}) => {
        setPageNum(selected + 1);
    }

    return (
        <>
            <div className="completedHeading">
                <h2 className="header">Completed Tickets</h2>
            </div>
            <div className="cardGrid">
                {
                    // tickets.filter(ticket => ticket.complete === true)
                        displayTickets.map((cardStuff) => (
                            <CardStructure key={cardStuff.id} cardStuff={cardStuff} openTicketModal={openTicketModal} deleteTicket={deleteTicket} updateTicketToCompleted={updateTicketToCompleted} />
                        ))

                }
                <CardModal showTicketModal={showTicketModal} setShowTicketModal={setShowTicketModal} currentTicketModal={currentTicketModal} />
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

export default CompletedTickets;