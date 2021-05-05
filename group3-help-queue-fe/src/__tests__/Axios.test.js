import React from 'react';
import renderer from 'react-test-renderer';
import createNewTicket from  '../queuedTickets';
import deleteTicket from  '../queuedTickets';
import updateTicketContents from  '../queuedTickets';
import updateTicketToCompleted from '../queuedTickets';




it('renders correctly', () => {
    const name = "Jest Test";
    const ticketDescription = "Jest Test description";
    const ticketTitle = "Jest Test Title";
    const complete = false;
    const tree = renderer.create(<createNewTicket name={name} ticketDescription={ticketDescription} ticketTitle={ticketTitle} complete={complete}/>).toJSON();
    expect(tree).toMatchSnapshot();
});

it('renders correctly', () => {
    const name = "Jest Test";
    const ticketDescription = "Jest Test description";
    const ticketTitle = "Jest Test Title";
    const tree = renderer.create(<updateTicketContents name={name} ticketDescription={ticketDescription} ticketTitle={ticketTitle}/>).toJSON();
    expect(tree).toMatchSnapshot(
    //     {
    //     name: "Jest Test",
    //     ticketDescription: "Jest Test description",
    //     ticketTitle: "Jest Test Title"
    // }
    );
});

it('renders correctly', () => {
    const id = 2;
    const tree = renderer.create(<deleteTicket id={id} />).toJSON();
    expect(tree).toMatchSnapshot();
});

it('updated to complete correctly', () => {
    const complete = true;
    const tree = renderer.create(<updateTicketToCompleted complete={complete} />).toJSON();
    expect(tree).toMatchSnapshot();
})