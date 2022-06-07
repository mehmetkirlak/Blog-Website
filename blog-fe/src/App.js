import React, {Component} from "react";
import logo from './logo.svg';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

class App extends Component {
    state = {
        blog: {}
      };

    async componentDidMount() {
        const response = await fetch('/api/blogs/getall');
        const body = await response.json();
        this.setState({blog: body});
      }
    render() {
        const {blog} = this.state;
        return (
            <div className="App">
              <header className="App-header">
                <img src={logo} className="App-logo" alt="logo" />
                <div className="App-intro">
                  <h2>blogs</h2>
                  <div key={blog.id}>
                    {blog.title}
                  </div>
                </div>
              </header>
            </div>
        );
      }
}

export default App;
