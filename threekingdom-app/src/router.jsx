import ErrorPage from "@pages/ErrorPage";
import BattlePage from "@pages/battle/BattlePage";
import DeckPage from "@pages/deck/DeckPage";
import LoginPage from "@pages/main/LoginPage";
import MainPage from "@pages/main/MainPage";
import { createBrowserRouter } from "react-router-dom";

const routePaths = [
  {
    id: 0,
    path: "/login",
    label: "Login",
    element: <LoginPage />,
  },
  {
    id: 1,
    path: "*",
    label: "Error",
    element: <ErrorPage />,
  },
  {
    id: 2,
    path: "/",
    label: "View",
    element: <MainPage />,
    children: [
      {
        id: 3,
        path: "deck",
        label: "Deck",
        element: <DeckPage />,
      },
      {
        id: 4,
        path: "battle",
        label: "Battle",
        element: <BattlePage />,
      },
    ],
  },
];

const routers = createBrowserRouter(routePaths);

export default routers;
