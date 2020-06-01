import AccountActionTypes from './account.types';

const INITIAL_STATE = {
    account: null
};

const AccountReducer = (state = INITIAL_STATE, action) => {
    switch(action.type){
        case AccountActionTypes.ADD_ACCOUNT:
            return {
                ...state,
                account: action.payload
            };
        default:
            return state;
    }
}

export default AccountReducer;