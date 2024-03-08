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
  background-color: #3498db;
  color: white;
  cursor: pointer;
  &:hover {
    background-color: #2980b9;
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
