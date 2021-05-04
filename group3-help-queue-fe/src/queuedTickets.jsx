import React, { useState } from 'react';
import CardModal from './cardModal';
import { CreateTicketModal } from './createTicketModal';
import ReactPaginate from 'react-paginate';
import axios from 'axios';

import CardStructure from './cardStructure';
import './Headings.css';
import './Tickets.css';
import './Buttons.css';
import './Pagnation.css';
import './Inputs.css';
import { UpdateTicketModal } from './updateTicketModal';
import { SolutionModal } from './solutionModal';


const QueuedTickets = ({ tickets, setTickets, refresh, setRefresh }) => {

    const [showCreateTicketModal, setShowCreateTicketModal] = useState(false);
    const [showUpdateTicketModal, setShowUpdateTicketModal] = useState(false);
    const [showTicketModal, setShowTicketModal] = useState(false);
    const [showSolutionModal, setShowSolutionModal] = useState(false);
    const [currentTicketModal, setCurrentTicketModal] = useState([]);
    const [ticketDescription, setTicketDescription] = useState('');
    const [ticketTitle, setTicketTitle] = useState('');
    const [pageNum, setPageNum] = useState(1);


    const numOfTickets = tickets.length;
    const ticketsPerPage = 4;
    const firstTicketToDisplay = ((pageNum - 1) * ticketsPerPage) + 1;

    // eg. user clicks page 2 button, we want tickets 5-8 to display.
    const displayTickets = tickets.slice((firstTicketToDisplay - 1), (firstTicketToDisplay + (ticketsPerPage - 1)));
    const numOfPages = Math.ceil(numOfTickets / ticketsPerPage);

    const openTicketModal = (ticketDetails) => {
        setShowTicketModal(prev => !prev);
        setCurrentTicketModal(ticketDetails);
    }

    const openCreateTicketModal = () => {
        setShowCreateTicketModal(prev => !prev);
    }

    const openUpdateTicketModal = (ticketDetails) => {
        setShowUpdateTicketModal(prev => !prev);
        setCurrentTicketModal(ticketDetails);
        setTicketDescription(ticketDetails.description);
        setTicketTitle(ticketDetails.title);
    }

    const openSolutionModal = (ticketDetails) => {
        setShowSolutionModal(prev => !prev);
        setCurrentTicketModal(ticketDetails);
    }

    const updateTicketContents = ({ ticketDescription, ticketTitle, currentTicketModal }) => {
       
        axios.put(`http://localhost:8899/tickets/update/${currentTicketModal.id}`, {
            complete: currentTicketModal.complete,
            name: currentTicketModal.name,
            description: ticketDescription,
            title: ticketTitle,
            urgency: currentTicketModal.urgency
        })
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            })
        setRefresh(true);
    }

    const updateTicketWithSolution = ({ solution, currentTicketModal }) => {
       
        axios.put(`http://localhost:8899/tickets/update/${currentTicketModal.id}`, {
            complete: true,
            name: currentTicketModal.name,
            description: currentTicketModal.description,
            title: currentTicketModal.title,
            solution: solution,
            urgency: currentTicketModal.urgency
        })
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            })
            setRefresh(true);
}


    const createNewTicket = ({ name, ticketDescription, ticketTitle, urgency }) => {
        axios.post(`http://localhost:8899/tickets/create`, {
            complete: false,
            name: name,
            description: ticketDescription,
            title: ticketTitle,
            urgency: urgency
        })
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            })
            setRefresh(true);
    }

   
    const deleteTicket = (id) => {
        axios.delete(`http://localhost:8899/tickets/delete/${id}`)
            .then(function (response) {
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            })

            setRefresh(true);

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
                    displayTickets.map((cardStuff) => (
                        <CardStructure key={cardStuff.id} cardStuff={cardStuff} openTicketModal={openTicketModal} deleteTicket={deleteTicket} openUpdateTicketModal={openUpdateTicketModal} openSolutionModal={openSolutionModal}/>
                    ))

                }
                <CardModal showTicketModal={showTicketModal} setShowTicketModal={setShowTicketModal} currentTicketModal={currentTicketModal} />
                <CreateTicketModal showCreateTicketModal={showCreateTicketModal} setShowCreateTicketModal={setShowCreateTicketModal} createNewTicket={createNewTicket} />
                <UpdateTicketModal showUpdateTicketModal={showUpdateTicketModal} setShowUpdateTicketModal={setShowUpdateTicketModal} updateTicketContents={updateTicketContents} currentTicketModal={currentTicketModal} setCurrentTicketModal={setCurrentTicketModal} ticketDescription={ticketDescription} setTicketDescription={setTicketDescription} ticketTitle={ticketTitle} setTicketTitle={setTicketTitle} />
                <SolutionModal showSolutionModal={showSolutionModal} setShowSolutionModal={setShowSolutionModal} currentTicketModal={currentTicketModal} updateTicketWithSolution={updateTicketWithSolution}/>
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