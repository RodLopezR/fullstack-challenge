import { combineReducers } from 'redux';
import { persistReducer } from 'redux-persist'; 
import storage from 'redux-persist/lib/storage';

import AccountReducer from './account/account.reducer';
import NotificationReducer from './notification/notification.reducer';

const persistConfig = {
    key: 'root',
    storage,
    whitelist: [ 'auth' ]
}

const rootReducer =  combineReducers({
    auth: AccountReducer,
    notification: NotificationReducer
});

export default persistReducer(persistConfig, rootReducer);