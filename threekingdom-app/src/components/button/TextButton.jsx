import theme from "@assets/styles/theme";
import { PropTypes } from "prop-types";

const { default: styled } = require("@emotion/styled");

// 버튼 스타일 정의
const StyledButton = styled.button`
  padding: 0.5rem;
  width: 8rem;
  height: 3rem;
  margin: 5px;
  border: none;
  border-radius: 4px;
  background-color: ${theme.primary2};
  color: black;
  font-size: 13px;
  cursor: pointer;
  &:hover {
    background-color: ${theme.primary1};
    color: white;
    width: 8.5rem;
    height: 3.5rem;
    font-size: 15px;
  }
`;

// 버튼 컴포넌트
function TextButton({ children, onClick }) {
  return <StyledButton onClick={onClick}>{children}</StyledButton>;
}

TextButton.propTypes = {
  children: PropTypes.node.isRequired,
  onClick: PropTypes.func.isRequired,
};

export default TextButton;
