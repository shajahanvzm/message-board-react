import logo from './logo.svg';
import './App.css';
import MessageComponent from './components/message/MessageComponent'
import FormikComponent from './components/message/FormikComponent'

function App() {
  return (
    <div >
      <h3>React Message Board </h3>
      {/* <FormikComponent /> */}
       <MessageComponent /> 
    </div>
  );
}

export default App;
