import { createSelector } from 'reselect';

const selectAuth = state => state.auth;

export const selectAccount = createSelector(
    [selectAuth],
    auth => {
        if(auth != null && auth.account != null) return auth.account;
        return null;
    }
);