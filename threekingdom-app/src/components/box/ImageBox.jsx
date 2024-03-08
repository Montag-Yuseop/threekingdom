import PropTypes from "prop-types";

const { default: styled } = require("@emotion/styled");

const ImageBoxStyle = styled.div`
  display: flex;
  margin: 10px;
  width: 3.5rem;
  height: 3.5rem;
  border-radius: 100px;
  overflow: hidden;
  align-items: center;
  flex-shrink: 0;
`;

const Image = styled.img`
  width: 100%;
  height: 100%;
  object-fit: cover;
`;

function ImageBox({ src, alt }) {
  return (
    <ImageBoxStyle>
      <Image src={src} alt={alt} />
    </ImageBoxStyle>
  );
}

ImageBox.propTypes = {
  src: PropTypes.string.isRequired,
  alt: PropTypes.string.isRequired,
};

export default ImageBox;
