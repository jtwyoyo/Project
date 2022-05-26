import { Link } from "react-router-dom";
import "./user.css";
import { useState, useEffect } from "react";
import axios from 'axios';

export default function User() {

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
    axios.put("http://localhost:5000/user", userData).then((response) => {
      console.log(response.status);
      console.log(response.data);
    });
  }; 

  return (
    <div className="user">
      <div className="userTitleContainer">
        <h1 className="userTitle">Edit User</h1>
      </div>
      <div className="userContainer">
        <div className="userUpdate">
          <span className="userUpdateTitle">Edit</span>
          <form className="userUpdateForm" onSubmit={handleSubmit}>
            <div className="userUpdateLeft">
              <div className="userUpdateItem">
                <label>ID</label>
                <input
                  type="id"
                  className="userUpdateInput"
                  name="id"
                  value={state.id}
                  onChange={handleChange}
                />
              </div>
              <div className="userUpdateItem">
                <label>Username</label>
                <input
                  type="username"
                  className="userUpdateInput"
                  name="username"
                  value={state.username}
                  onChange={handleChange}
                />
              </div>
              <div className="userUpdateItem">
                <label>Password</label>
                <input
                  type="password"
                  className="userUpdateInput" 
                  name="password"
                  value={state.password}
                  onChange={handleChange}
                />
              </div>
              <div className="userUpdateItem">
                <label>Admin Status</label>
                <input
                  type="admin_flag"
                  className="userUpdateInput" 
                  name="admin_flag"
                  value={state.admin_flag}
                  onChange={handleChange}
                />
              </div>
            </div>
            <button className="userUpdateButton">Update</button>
          </form>
        </div>
        <div className="userUpdateRight">
          <Link to="/newUser">
          <button className="userAddButton">Create</button>
        </Link>
        </div>
      </div>
    </div>
  );
}
