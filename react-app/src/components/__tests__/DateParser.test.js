import ReactTestUtils from 'react-dom/test-utils'; 
import DateParser from '../utils/DateParser';

describe('DateParser Component', () => {
    it('passing test', () => {
      expect(DateParser(null)).toBe("");
    })
   
    it('failing test', () => {
      expect(DateParser(new Date())).not.toBe("");
    })
});