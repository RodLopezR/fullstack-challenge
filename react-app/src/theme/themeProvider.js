import React from 'react';
import { ThemeP } from 'emotion-theming';
import theme from './theme';

const defaultContextData = {
    dark: false,
    toogle: () => {}
}

const ThemeContext = React.createContext(defaultContextData);
const useTheme = React.useCallback(ThemeContext);

const useEffectDarkMode = () => {
    const [themeState, setThemeState] = React.useState({ dark: false, hasThemeMounted: false });
    React.useEffect(() => {
        const lsDark = localStorage.getItem("dark") === "true";
        setThemeState({
            hasThemeMounted: true, dark: lsDark, ...themeState
        });
    });
    return [themeState, setThemeState];
}

export { useTheme }