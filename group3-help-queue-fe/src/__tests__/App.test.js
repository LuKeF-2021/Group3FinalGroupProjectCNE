import {render, screen, cleanup, waitForElement} from '@testing-library/react';
import App from '../App';
import axiosMock from 'axios';
import Fetch from '../Fetch';
import axios from 'axios';
import { TestScheduler } from "@jest/core";

import '@testing-library/jest-dom';
import {expect, it } from '@jest/globals';
import {create} from 'react-test-renderer';

it(`Take a snapshot each time it is rendered`,()=>{
    const snapShot = create(<App/>).toJSON()
    console.log(snapShot);
    expect(snapShot).toMatchSnapshot();
})


afterEach(cleanup);

it('mocking axios request', async () => {

});