import React from "react";
import ReactDOM from "react-dom/client";
import { Provider } from "react-redux";
import { Global } from "@emotion/react";
import globalStyle from "@assets/styles/globalStyle";
import App from "./App";
import store from "./store";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <Provider store={store}>
      <Global styles={globalStyle} />
      <App />
    </Provider>
  </React.StrictMode>,
);
