import React from 'react';
import ReactTestUtils from 'react-dom/test-utils'; 
import { Message, StarsRender } from '../stats/Stats.Component';

describe('Starts.Component', () => {
 
    it('has an span tag', () => {
        expect(Message(2)).not.toBeNull();
        expect(Message(3)).not.toBeUndefined();
    });
    
});