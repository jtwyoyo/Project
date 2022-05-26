import "./newUser.css";
import { useState, useEffect } from "react";
import axios from 'axios';

export default function NewUser() {
    const [state, setState] = useState({
      id: "",
      username: "",
      password: "",
      admin_flag: ""
    });
  
    const handleChange = (e) => {
      const value = e.target.value;
      setState({
        ...state,
        [e.target.name]: value
      });
    };
  
    const handleSubmit = (e) => {
      e.preventDefault();
      const userData = {
        user: {
        id: state.id,
        username: state.username,
        password: state.password,
        admin_flag: state.admin_flag
        }
      };
      axios.post("http://localhost:5000/user", userData).then((response) => {
        console.log(response.status);
        console.log(response.data);
      });
    }; 
  
  return (
    <div className="newUser">
      <h1 className="newUserTitle">New User</h1>
      <form className="newUserForm" onSubmit={handleSubmit}>
        <div className="newUserItem">
          <label>ID</label>
          <input type="id" name="id" value={state.id} onChange={handleChange}/>
        </div>
        <div className="newUserItem">
          <label>Username</label>
          <input type="username" name="username" value={state.username} onChange={handleChange}/>
        </div>
        <div className="newUserItem">
          <label>Password</label>
          <input type="password" name="password" value={state.password} onChange={handleChange} />
        </div>
        <div className="newUserItem">
          <label>Adming Status</label>
          <input type="admin_flag" name="admin_flag" value={state.admin_flag} onChange={handleChange} />
        </div>
        <button type="submit" className="newUserButton">Create</button>
      </form>
    </div>
  );
}
