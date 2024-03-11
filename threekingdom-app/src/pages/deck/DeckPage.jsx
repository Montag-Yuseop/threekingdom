import theme from "@assets/styles/theme";
import SelectMenu from "@components/deck/SelectMenu";
import styled from "@emotion/styled";
import { Outlet } from "react-router-dom";

function DeckPage() {
  return (
    <MainContainer>
      <SelectMenu />
      <OutletContainer>
        <Outlet />
      </OutletContainer>
    </MainContainer>
  );
}

const MainContainer = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  flex-direction: column;
`;

const OutletContainer = styled.div`
  width: 90%;
  height: 84%;
  border-radius: 5px;
  background-color: ${theme.primary2};
`;

export default DeckPage;
