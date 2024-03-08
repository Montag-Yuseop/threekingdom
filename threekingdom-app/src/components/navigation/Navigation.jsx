import theme from "@assets/styles/theme";
import styled from "@emotion/styled";
import gladiator from "@assets/icons/gladiator.png";
import swords from "@assets/icons/swords.png";
import { useNavigate } from "react-router-dom";

function Navigation() {
  const navi = useNavigate();

  return (
    <MainContainer>
      <ButtonDiv>
        <IconButton icon={gladiator} onClick={() => navi("/deck")} />
      </ButtonDiv>
      <ButtonDiv>
        <IconButton icon={swords} onClick={() => navi("/battle")} />
      </ButtonDiv>
    </MainContainer>
  );
}

const MainContainer = styled.div`
  bottom: 0;
  left: 0;
  right: 0;
  height: 10%;
  width: 100%;
  overflow: hidden;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: ${theme.primary2};
`;

const ButtonDiv = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  text-align: center;
  width: 30%;
`;

const IconButton = styled.button`
  border: none;
  border-radius: 4px;
  cursor: pointer;
  background-color: ${theme.primary2};
  color: white;
  width: 3rem;
  height: 3rem;

  &:hover {
    background-color: ${theme.primary1};
  }

  &:focus {
    outline: none;
  }

  background-image: url(${(props) => props.icon});
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
`;

export default Navigation;
