
import theme from "@assets/styles/theme";
import styled from "@emotion/styled";


function Header() {

    return(
        <MainContainer>
            헤더바
        </MainContainer>
    )
}

export default Header;

const MainContainer = styled.div`
  background-color: ${theme.primary2};
  width: 100%;
  min-width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
`