import AccountActionTypes from './account.types';

export const addAccount = (account) => ({
    type: AccountActionTypes.ADD_ACCOUNT,
    payload: account
});