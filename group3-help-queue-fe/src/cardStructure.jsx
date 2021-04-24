
const CardStructure = ({cardStuff , openTicketModal}) => {
    return (
        <div className="column" key={cardStuff.id}>
            <div className="card">
                <div className="ticket-user-time"><h3 className="inline">{cardStuff.usersName}</h3>      <p className="inline">{cardStuff.time}</p></div>
                <div className="ticket-description" onClick={openTicketModal}><h3>{cardStuff.ticketTitle}</h3><p>{cardStuff.ticketDescription}</p></div>
                <div className="complete-button">
                    <button className="btn" id="ticket-complete">Completed</button>
                    <button className="btn" id="ticket-edit">Edit</button>
                    <button className="btn" id="ticket-delete">Delete</button>
                </div>
            </div>
        </div>
    );
};

export default CardStructure;