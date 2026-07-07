import logo from './logo.svg';
import './App.css';

import {BrowserRouter, Routes, Route} from "react-router-dom";

import Home from "./pages/home/Home.jsx";
import Listagem from './pages/listagem/Listagem.jsx';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/listagem' element={<Listagem />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
