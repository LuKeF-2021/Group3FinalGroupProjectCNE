import { HiCheck } from "react-icons/hi";
import { HiPencil } from "react-icons/hi";
import { HiX } from "react-icons/hi";
import { HiOutlineArrowsExpand } from "react-icons/hi";


const CardStructure = ({cardStuff , openTicketModal, deleteTicket, updateTicketToCompleted}) => {
    return (
        <div className="column" key={cardStuff.id}>
            <div className="card">
                <div className="ticket-user-time"><h3 className="inline">{cardStuff.usersName}</h3>      <p className="inline">{cardStuff.time}</p> <HiOutlineArrowsExpand style={{ verticalAlign: 'middle' }} size={28} className="expand" onClick={() => openTicketModal(cardStuff)}/></div>
                <div className="ticket-description"><h3>{cardStuff.ticketTitle}</h3><p>{cardStuff.ticketDescription}</p></div>
                <div className="card-actions">
                    <HiCheck style={{ verticalAlign: 'middle' }} size={28} className="check"  onClick={() => updateTicketToCompleted(cardStuff.id)}/>
                    <HiPencil style={{ verticalAlign: 'middle' }} size={28}/>
                    <HiX style={{ verticalAlign: 'middle' }} size={28} className="cross" onClick={() => deleteTicket(cardStuff.id)}/>
                </div>
            </div>
        </div>
    );
};

export default CardStructure;