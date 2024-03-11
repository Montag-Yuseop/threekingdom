import theme from "@assets/styles/theme";
import ImageBox from "@components/box/ImageBox";
import styled from "@emotion/styled";
import wolf from "@assets/images/wolf.jpg";

function Header() {
  return (
    <MainContainer>
      <ImageBox src={wolf} alt="이리단 마크" />
      <HeaderTitle>이리단 덱 검색기</HeaderTitle>
    </MainContainer>
  );
}

export default Header;

const MainContainer = styled.div`
  background-color: ${theme.primary2};
  height: 10%;
  display: flex;
  align-items: center;
  user-select: none;
`;

const HeaderTitle = styled.div`
  display: flex;
  width: 80%;
  flex-wrap: wrap;
  word-break: break-all;
  height: 100%;
  align-items: center;
  font-size: 1.5rem;
`;
