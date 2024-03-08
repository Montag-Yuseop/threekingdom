import styled from "@emotion/styled";
import { Outlet } from "react-router-dom";

function ViewPage() {
  return (
    <MainContainer>
      <Outlet />
    </MainContainer>
  );
}

const MainContainer = styled.div`
  height: 80%;
  width: 100%;
`;

export default ViewPage;
