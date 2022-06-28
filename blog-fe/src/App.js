import logo from './logo.svg';
import './App.css';
import BlogList from "./pages/BlogList";
import {Container} from "reactstrap";
import Navi from "./layouts/Navi";
import Dashboard from "./layouts/Dashboard";
import Footer from "./layouts/Footer";
import React from "react";

function App() {
  return (
    <div className="App">
        <Navi/>
        <Container>
            <Dashboard/>
            <Footer/>
        </Container>
    </div>
  );
}

export default App;
