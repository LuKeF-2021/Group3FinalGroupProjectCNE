import React, { useState } from 'react';
import { CardModal } from './cardModal';
import { CreateTicketModal } from './createTicketModal';
import ReactPaginate from 'react-paginate';
import axios from 'axios';

import CardStructure from './cardStructure';
import './Tickets.css';
import { UpdateTicketModal } from './updateTicketModal';


const QueuedTickets = ({ tickets, setTickets }) => {

    const [showCreateTicketModal, setShowCreateTicketModal] = useState(false);
    const [showUpdateTicketModal, setShowUpdateTicketModal] = useState(false);
    const [showTicketModal, setShowTicketModal] = useState(false);
    const [currentTicketModal, setCurrentTicketModal] = useState([]);
    const [ticketDescription, setTicketDescription] = useState('');
    const [ticketTitle, setTicketTitle] = useState('');
    const [pageNum, setPageNum] = useState(1);
    const [createdTicket, setCreatedTicket] = useState("");


    const QueuedTicketsList = [];
    tickets.map((ticket) => {
        if (ticket.complete === false) {
            QueuedTicketsList.push(ticket);
            console.log('queued tickets: ', QueuedTicketsList);
        }
    })

    const numOfTickets = QueuedTicketsList.length;
    const ticketsPerPage = 4;
    const firstTicketToDisplay = ((pageNum - 1) * ticketsPerPage) + 1;

    // eg. user clicks page 2 button, we want tickets 5-8 to display.
    // const displayTickets = tickets.slice((firstTicketToDisplay - 1), (firstTicketToDisplay + (ticketsPerPage - 1)));
    const displayTickets = QueuedTicketsList.slice((firstTicketToDisplay - 1), (firstTicketToDisplay + (ticketsPerPage - 1)));
    const numOfPages = Math.ceil(numOfTickets / ticketsPerPage);


    const openTicketModal = (ticketDetails) => {
        setShowTicketModal(prev => !prev);
        setCurrentTicketModal(ticketDetails);
        // console.log('object in current ticket modal: ', currentTicketModal);
    }

    const openCreateTicketModal = () => {
        setShowCreateTicketModal(prev => !prev);
    }

    const openUpdateTicketModal = (ticketDetails) => {
        // console.log('ticket being passed back: ', ticketDetails);
        setShowUpdateTicketModal(prev => !prev);
        setCurrentTicketModal(ticketDetails);
        setTicketDescription(ticketDetails.description);
        setTicketTitle(ticketDetails.title);
        // console.log('ticket description use state: ', ticketDescription);
        // console.log('ticket ticket title :', ticketTitle);
        // console.log('object in current ticket modal: ', currentTicketModal);
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

    }

    const updateTicketContents = ({ ticketDescription, ticketTitle, currentTicketModal }) => {
        // openUpdateTicketModal();
        const ticketToChange = tickets.filter((ticket) => ticket.id === currentTicketModal.id);
        console.log('ticket you clicked edit on:', ticketToChange);

        const newTickets = tickets.map((ticket) => {
            if (ticket.id === currentTicketModal.id) {
                const updatedTicket = {
                    ...ticket,
                    complete: ticket.complete,
                    name: ticket.name,
                    description: ticketDescription,
                    title: ticketTitle,
                    createdAt: ticket.createdAt
                };
                axios.put(`http://localhost:8901/tickets/update/${currentTicketModal.id}`, {
                    complete: ticket.complete,
                    name: ticket.name,
                    description: ticketDescription,
                    title: ticketTitle,
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

    }

    // const handleFormUpdate = (e) => {
    //     e.preventDefault();
    //     updateTicketToCompleted();
    //     //this handleform thing needs to go into the submit form button
    // }

    const createNewTicket = ({ name, ticketDescription, ticketTitle }) => {

        // const newTicket =
        // {
        //     name: name,
        //     description: ticketDescription,
        //     title: ticketTitle,
        //     completed: false
        // };

        // console.log('new ticket is: ', newTicket);
        // setCreatedTicket(newTicket);
        // console.log('updated list with new ticket: ', tickets);

        axios.post(`http://localhost:8901/tickets/create`, {
            complete: false,
            name: name,
            description: ticketDescription,
            title: ticketTitle,
        })
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            })

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
                    // tickets.filter(ticket => ticket.complete === false)
                    displayTickets.map((cardStuff) => (
                        <CardStructure key={cardStuff.id} cardStuff={cardStuff} openTicketModal={openTicketModal} deleteTicket={deleteTicket} updateTicketToCompleted={updateTicketToCompleted} openUpdateTicketModal={openUpdateTicketModal} />
                    ))

                }
                <CardModal showTicketModal={showTicketModal} setShowTicketModal={setShowTicketModal} currentTicketModal={currentTicketModal} />
                <CreateTicketModal showCreateTicketModal={showCreateTicketModal} setShowCreateTicketModal={setShowCreateTicketModal} createNewTicket={createNewTicket} tickets={tickets} />
                <UpdateTicketModal showUpdateTicketModal={showUpdateTicketModal} setShowUpdateTicketModal={setShowUpdateTicketModal} updateTicketContents={updateTicketContents} currentTicketModal={currentTicketModal} setCurrentTicketModal={setCurrentTicketModal} ticketDescription={ticketDescription} setTicketDescription={setTicketDescription} ticketTitle={ticketTitle} setTicketTitle={setTicketTitle} />
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