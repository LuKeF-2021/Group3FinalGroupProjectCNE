import './App.css';
import CompletedTickets from './completedTickets';
import QueuedTickets from './queuedTickets';
import WelcomeUser from './welcomeUser';

function App() {
  return (
    <div className="screenDiv">
      <WelcomeUser/>
    <div className="queue">
      <QueuedTickets/>
    </div>
    <div className="completed">
      <CompletedTickets/>
    </div>
    </div>
  );
}

export default App;
