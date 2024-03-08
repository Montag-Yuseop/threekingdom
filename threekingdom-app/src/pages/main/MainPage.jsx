import Header from "@components/navigation/Header";
import styled from "@emotion/styled";
import Navigation from "@components/navigation/Navigation";
import ViewPage from "./ViewPage";

function MainPage() {
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

  return (
    <ContainerStyle>
      <Main>
        <Header />
        <ViewPage />
        <Navigation />
      </Main>
    </ContainerStyle>
  );
}

export default MainPage;
