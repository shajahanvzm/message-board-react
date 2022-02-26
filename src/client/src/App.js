import {
  BrowserRouter as Router,
  Switch,
  Route,
  Routes,
} from "react-router-dom";
import './App.css';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import MessageComponent from './components/message/MessageComponent'


function App() {
  return (
    <Router>
      <HeaderComponent />
      <Routes>
        <Route path="/" element={<MessageComponent />} />
      </Routes>
      <FooterComponent />
    </Router>

  );
}

export default App;
