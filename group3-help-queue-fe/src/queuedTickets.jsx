import './Tickets.css';
const QueuedTickets = () => {

    return(
        <div className="queuedHeading">
            <h2 className="header" id="create-ticket">Queued Tickets</h2>
            <button className="btnCreate" id="create-ticket">
					Create Ticket
			</button>
            <div className="card">
                <div className="ticket-user-time"><h3 className="inline">Luke Foster</h3>      <p className="inline">10:53</p></div>
                <div className="ticket-description"><p>test description Lorem ipsum dolor sit, amet consectetur adipisicing elit. Error perferendis porro consequuntur illum omnis quas ex incidunt eius eos sed magni earum iusto maiores laboriosam numquam maxime, quidem nobis sint.</p></div>
                <div className="complete-button">
                    <button className="btn" id="ticket-complete">Completed</button>
                    <button className="btn" id="ticket-edit">Edit</button>
                    <button className="btn" id="ticket-delete">Delete</button>
                </div>
            </div>
        </div>

    )

}

export default QueuedTickets;