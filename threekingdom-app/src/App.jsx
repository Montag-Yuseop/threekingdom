import styled from "@emotion/styled";
import { RouterProvider } from "react-router-dom";
import routers from "router";

function App() {
  return (
    // <BrowserRouter>
    //   <Routes>
    //     <Route path="/login" element={<LoginPage />} />
    //     <Route path="/" element={<MainPage />} />
    //     <Route path="/deck" element={<DeckPage />} />
    //     <Route path="/battle" element={<BattlePage />} />
    //   </Routes>
    // </BrowserRouter>
    <MainContainer>
      <RouterProvider router={routers} />
    </MainContainer>
  );
}

const MainContainer = styled.div`
  width: 100%;
  height: 100%;
`;

export default App;
