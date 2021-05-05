import React from 'react';
import renderer from 'react-test-renderer';
import deleteTicket from  '../cardStructure';
import App from '../App';

it('renders correctly', () => {
    const id = 2;
    const tree = renderer.create(<deleteTicket id={id} />).toJSON();
    expect(tree).toMatchSnapshot();
});

it('renders correctly', () => {
    const tree = renderer.create(<App />).toJSON();
    expect(tree).toMatchSnapshot();
});