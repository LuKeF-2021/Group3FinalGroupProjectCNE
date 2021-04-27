import { HiCheck } from "react-icons/hi";
import { HiPencil } from "react-icons/hi";
import { HiX } from "react-icons/hi";
import { HiOutlineArrowsExpand } from "react-icons/hi";


const CardStructure = ({ cardStuff, openTicketModal, deleteTicket, updateTicketToCompleted }) => {
    if (cardStuff.complete === true) {
        return (
            <div className="column" key={cardStuff.id}>
                <div className="card">
                    <div className="ticket-user-time"><h3 className="inline">{cardStuff.name}</h3>      <p className="inline">{cardStuff.createdAt}</p><HiOutlineArrowsExpand style={{ verticalAlign: 'middle' }} size={28} className="expand" onClick={() => openTicketModal(cardStuff)} /></div>
                    <div className="ticket-description"><h3>{cardStuff.title}</h3><p>{cardStuff.description}</p></div>
                    <div className="card-actions">
                        <HiX style={{ verticalAlign: 'middle' }} size={28} className="crossCompleted" onClick={() => deleteTicket(cardStuff.id)} />
                    </div>
                </div>
            </div>
        );
    } else {
        return (
            <div className="column" key={cardStuff.id}>
                <div className="card">
                    <div className="ticket-user-time"><h3 className="inline">{cardStuff.name}</h3>      <p className="inline">{cardStuff.createdAt}</p><HiOutlineArrowsExpand style={{ verticalAlign: 'middle' }} size={28} className="expand" onClick={() => openTicketModal(cardStuff)} /></div>
                    <div className="ticket-description"><h3>{cardStuff.title}</h3><p>{cardStuff.description}</p></div>
                    <div className="card-actions">
                        <HiCheck style={{ verticalAlign: 'middle' }} size={28} className="check" onClick={() => updateTicketToCompleted(cardStuff.id)} />
                        <HiPencil style={{ verticalAlign: 'middle' }} size={28} className="editButton" />
                        <HiX style={{ verticalAlign: 'middle' }} size={28} className="cross" onClick={() => deleteTicket(cardStuff.id)} />
                    </div>
                </div>
            </div>
        );

    }
};

export default CardStructure;