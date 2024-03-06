import './App.css';
import './store'

const counter = 0;

function App() {
  return (
    <div>
      <h2>{counter}</h2>
      <div>
        <button>더하기</button>
        <button>빼기</button>
      </div>
    </div>
  );
}

export default App;
