import styled from "@emotion/styled";

function DeckInitialPage() {
  return <MainContainer>메뉴를 선택하세요</MainContainer>;
}

const MainContainer = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  font-size: 20px;
`;

export default DeckInitialPage;
