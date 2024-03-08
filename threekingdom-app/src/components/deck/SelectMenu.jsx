import TextButton from "@components/button/TextButton";
import styled from "@emotion/styled";
import { useNavigate } from "react-router-dom";

function SelectMenu() {
  const navi = useNavigate();
  return (
    <MainContainer>
      <ButtonDiv>
        <TextButton onClick={() => navi("/deck/create-user")}>
          유저 등록
        </TextButton>
      </ButtonDiv>
      <ButtonDiv>
        <TextButton onClick={() => navi("/deck/create-deck")}>
          덱 생성
        </TextButton>
      </ButtonDiv>
      <ButtonDiv>
        <TextButton onClick={() => navi("/deck/show-deck")}>덱 검색</TextButton>
      </ButtonDiv>
    </MainContainer>
  );
}

const ButtonDiv = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  width: 25%;
`;

const MainContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  height: 5rem;
  width: 100%;
`;

export default SelectMenu;
