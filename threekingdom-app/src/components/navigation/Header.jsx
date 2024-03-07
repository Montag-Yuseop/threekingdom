import theme from "@assets/styles/theme";
import ImageBox from "@components/box/ImageBox";
import styled from "@emotion/styled";
import wolf from "@assets/images/wolf.jpg";

function Header() {
  return (
    <MainContainer>
      <ImageBox src={wolf} alt="이리단 마크" />
    </MainContainer>
  );
}

export default Header;

const MainContainer = styled.div`
  background-color: ${theme.primary2};
  width: 100%;
  min-width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
`;

// const HeaderTitle = styled.div``;
