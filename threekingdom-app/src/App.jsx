import styled from "@emotion/styled";
import Header from "@components/navigation/Header";
import Navigation from "@components/navigation/Navigation";

const ContainerStyle = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0px;
  padding: 0px;
  width: 100%;
  height: 100vh;
  min-width: 375px;
`;

const Main = styled.div`
  background-color: white;
  width: 100%;
  height: 812px;
  max-width: 720px;
`;

// @media (max-width: 720px) {
//   min-width: 720px;
// }

function App() {
  return (
    <ContainerStyle>
      <Main>
        <Header />
        메인화면
        <Navigation />
      </Main>
    </ContainerStyle>
  );
}

export default App;
