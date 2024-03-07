import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { Provider } from 'react-redux';
import store from './store';
import { Global } from '@emotion/react';
import globalStyle from './assets/styles/globalStyle';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Provider store = { store }>
      <Global styles = { globalStyle } />
      <App />
    </Provider>
  </React.StrictMode>
);