import theme from "@assets/styles/theme";
import styled from "@emotion/styled";

function CreateUser() {
  return (
    <MainContainer>
      <TextDiv>
        <TextBox>시즌 선택</TextBox>
        <TextBox>유저 이름</TextBox>
      </TextDiv>
      <InputDiv>
        <InputBox />
        <InputBox />
      </InputDiv>
    </MainContainer>
  );
}

const MainContainer = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
`;

const TextDiv = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  width: 30%;
  height: 100%;
`;

const InputDiv = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;
  width: 70%;
  height: 100%;
`;

const TextBox = styled.div`
  margin: 15px;
  font-size: 15px;
  display: flex;
  border-radius: 7px;
  justify-content: center;
  align-items: center;
  text-align: center;
  width: 80%;
  height: 2.5rem;
  background-color: ${theme.primary1};
  user-select: none;
  &:hover {
    cursor: default;
  }
`;

const InputBox = styled.input`
  margin: 15px;
  font-size: 15px;
  border: none;
  outline: none;
  border-radius: 7px;
  width: 90%;
  height: 2.5rem;
  cursor: text;
  box-sizing: border-box;
`;

export default CreateUser;
