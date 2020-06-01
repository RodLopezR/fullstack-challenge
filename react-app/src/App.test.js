import React from 'react';
import { render } from '@testing-library/react';
import App from './App';

test('renders Hola react link', () => {
    const { getByText } = render(<App />);
    const linkElement = getByText(/Hola/i);
    expect(linkElement).toBeInTheDocument();
});

