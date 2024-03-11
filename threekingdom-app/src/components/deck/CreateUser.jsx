import theme from "@assets/styles/theme";
import styled from "@emotion/styled";
import { useEffect, useRef, useState } from "react";
import seasonList from "data/seasonList";
import axios from "axios";

function CreateUser() {
  const [isOpen, setIsOpen] = useState(false);
  const [selectedItem, setSelectedItem] = useState(null);
  const [username, setUsername] = useState("");
  const [modalContent, setModalContent] = useState("");
  const [showSuccessModal, setShowSuccessModal] = useState(false);
  const dropdownRef = useRef(null);

  useEffect(() => {
    const handleClickOutside = (event) => {
      if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
        setIsOpen(false);
      }
    };

    document.addEventListener("mousedown", handleClickOutside);
    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, []);

  const toggleDropdown = () => {
    setIsOpen(!isOpen);
  };

  const handleContentClick = (item) => {
    setSelectedItem(item);
    setIsOpen(false);
  };

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  // 유저 이름을 저장해서 백에 보내기
  const saveUser = () => {
    const trimmedUsername = username.trim();
    if (selectedItem === null) {
      setModalContent("시즌이 없습니다.");
    } else if (trimmedUsername === null || trimmedUsername === "") {
      setModalContent("이름이 없습니다.");
    } else {
      axios
        .post("http://localhost:8081/api/v1/seasons", {
          nickname: trimmedUsername,
          season_num: selectedItem.season_num,
        })
        .then(() => {
          setModalContent(`${username} 유저가 \n 저장되었습니다.`);
          setSelectedItem(null);
          setUsername("");
        })
        .catch((error) => {
          console.log("시즌 저장 에러", error);
          setModalContent("시즌 저장 실패");
        });
    }

    setShowSuccessModal(true);
    setTimeout(() => {
      setShowSuccessModal(false);
    }, 2000); // 2초 뒤 자동으로 사라짐
  };

  // 유저 이름 입력에 스페이스바를 사용 못하게
  const preventSpace = (event) => {
    if (event.keyCode === 32) {
      event.preventDefault();
    }
  };

  return (
    <MainContainer>
      <ViewDiv>
        {showSuccessModal && <ModalContent>{modalContent}</ModalContent>}
        <TextDiv>
          <TextBox>시즌 선택</TextBox>
          <TextBox>유저 이름</TextBox>
        </TextDiv>
        <InputDiv>
          <DropdownContainer>
            <ButtonBox type="button" onClick={toggleDropdown}>
              {selectedItem
                ? `${selectedItem.season_name}`
                : "시즌을 선택하세요"}
            </ButtonBox>
            <DropdownContentContainer isOpen={isOpen} ref={dropdownRef}>
              <DropdownContent>
                {seasonList.map((item) => (
                  <Content
                    key={item.id}
                    onClick={() => handleContentClick(item)}
                  >
                    {item.season_num}. {item.season_name}
                  </Content>
                ))}
              </DropdownContent>
            </DropdownContentContainer>
          </DropdownContainer>
          <InputBox
            placeholder="닉네임을 입력하세요"
            value={username}
            onChange={handleUsernameChange}
            onKeyDown={preventSpace}
          />
        </InputDiv>
      </ViewDiv>
      <ButtonDiv>
        <SubmitButton onClick={saveUser}>등록</SubmitButton>
      </ButtonDiv>
    </MainContainer>
  );
}

const MainContainer = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
`;

const ModalContent = styled.div`
  display: flex;
  white-space: pre-line;
  text-align: center;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: calc(300px);
  left: 50%;
  width: 10rem;
  height: 5rem;
  transform: translateX(-50%);
  z-index: 1000;
  color: white;
  background-color: ${theme.primary3};
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
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
  text-align: center;
`;

const ButtonBox = styled.button`
  margin: 15px;
  font-size: 15px;
  border: none;
  outline: none;
  border-radius: 7px;
  width: 90%;
  height: 2.5rem;
  text-align: center;
`;

const ViewDiv = styled.div`
  display: flex;
  width: 100%;
  height: 60%;
`;

const ButtonDiv = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 20%;
`;

const SubmitButton = styled.button`
  padding: 0.5rem;
  width: 6rem;
  height: 2.5rem;
  margin: 5px;
  border: none;
  border-radius: 4px;
  background-color: ${theme.primary1};
  color: black;
  font-size: 13px;
  cursor: pointer;
  &:hover {
    background-color: ${theme.primary1};
    color: white;
    width: 7.5rem;
    height: 3.5rem;
    font-size: 15px;
  }
`;

const DropdownContainer = styled.div`
  width: 100%;
  position: relative;
  display: flex;
  justify-content: center;
`;

const DropdownContentContainer = styled.div`
  display: ${(props) => (props.isOpen ? "block" : "none")};
  position: absolute;
  top: calc(100% - 15px); /* 버튼 아래에 나타나도록 조절 */
  width: 90%;
`;

const DropdownContent = styled.div`
  background-color: white;
  border-radius: 7px;
  box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
  z-index: 1;
  max-height: 150px;
  overflow-y: auto;
`;

const Content = styled.div`
  display: flex;
  padding: 10px;
  justify-content: center;
  text-align: center;
  cursor: pointer;
`;

export default CreateUser;
