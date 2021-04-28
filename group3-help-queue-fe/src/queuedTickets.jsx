import React, { useState } from 'react';
import { CardModal } from './cardModal';
import { CreateTicketModal } from './createTicketModal';
import ReactPaginate from 'react-paginate';
import axios from 'axios';

import CardStructure from './cardStructure';
import './Tickets.css';


const QueuedTickets = ({ tickets, setTickets }) => {

    const [showCreateTicketModal, setShowCreateTicketModal] = useState(false);
    const [showTicketModal, setShowTicketModal] = useState(false);
    const [currentTicketModal, setCurrentTicketModal] = useState([]);
    const [pageNum, setPageNum] = useState(1);
    const [createdTicket, setCreatedTicket] = useState("");


    const numOfTickets = tickets.length;
    const ticketsPerPage = 4;
    const firstTicketToDisplay = ((pageNum-1) * ticketsPerPage) + 1;
    const displayTickets = tickets.slice((firstTicketToDisplay - 1), (firstTicketToDisplay + (ticketsPerPage - 1)));
    const numOfPages = Math.ceil(numOfTickets/ticketsPerPage);

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
                    complete: ticket.complete = true
                };
                axios.put(`http://localhost:8901/tickets/update/${id}`, {
                    // id: ticket.id,
                    complete: true,
                    name: ticket.name,
                    description: ticket.description,
                    title: ticket.title,
                    createdAt: ticket.createdAt
                })
                    .then(function (response) {
                        console.log(response);
                    })
                    .catch(function (error) {
                        console.log(error);
                    })
                return updatedTicket;


            }

            return ticket;

        });

        setTickets(newTickets);

        // axios.put(`http://localhost:8901/tickets/update/${id}`, {
        //     updatedTicket
        // })
        //     .then(function (response) {
        //         console.log(response);
        //     })
        //     .catch(function (error) {
        //         console.log(error);
        //     })
    }

    // const handleFormUpdate = (e) => {
    //     e.preventDefault();
    //     updateTicketToCompleted();
    //     //this handleform thing needs to go into the submit form button
    // }

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

    // const deleteTicket = (id) => {
    //     setTickets(tickets.filter((ticket) => ticket.id !== id));
    // }

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

    const changePage = ({ selected }) => {
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
                    displayTickets.filter(ticket => ticket.complete === false)
                        .map((cardStuff) => (
                            <CardStructure key={cardStuff.id} cardStuff={cardStuff} openTicketModal={openTicketModal} deleteTicket={deleteTicket} updateTicketToCompleted={updateTicketToCompleted} />
                        ))

                }
                <CardModal showTicketModal={showTicketModal} setShowTicketModal={setShowTicketModal} currentTicketModal={currentTicketModal} />
                <CreateTicketModal showCreateTicketModal={showCreateTicketModal} setShowCreateTicketModal={setShowCreateTicketModal} createNewTicket={createNewTicket} tickets={tickets} />
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