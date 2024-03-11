import BattleInitialPage from "@components/battle/BattleInitialPage";
import CreateBattle from "@components/battle/CreateBattle";
import ShowBattle from "@components/battle/ShowBattle";
import CreateDeck from "@components/deck/CreateDeck";
import CreateUser from "@components/deck/CreateUser";
import DeckInitialPage from "@components/deck/DeckInitialPage";
import ShowDeckList from "@components/deck/ShowDeckList";
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
        children: [
          {
            id: 5,
            path: "create-user",
            label: "CreateUser",
            element: <CreateUser />,
          },
          {
            id: 6,
            path: "create-deck",
            label: "CreateDeck",
            element: <CreateDeck />,
          },
          {
            id: 7,
            path: "show-deck",
            label: "ShowDeck",
            element: <ShowDeckList />,
          },
          {
            id: 7,
            path: "",
            label: "Initail",
            element: <DeckInitialPage />,
          },
        ],
      },
      {
        id: 4,
        path: "battle",
        label: "Battle",
        element: <BattlePage />,
        children: [
          {
            id: 8,
            path: "create-battle",
            label: "CreateBattle",
            element: <CreateBattle />,
          },
          {
            id: 9,
            path: "show-battle",
            label: "ShowBattle",
            element: <ShowBattle />,
          },
          {
            id: 10,
            path: "",
            label: "Initail",
            element: <BattleInitialPage />,
          },
        ],
      },
    ],
  },
];

const routers = createBrowserRouter(routePaths);

export default routers;
