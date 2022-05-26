import "./newProduct.css";
import { useState, useEffect } from "react";
import axios from 'axios';

export default function NewProduct() {

  const [state, setState] = useState({
    id: "",
    movie_title: "",
    movie_pic: "",
    genre: ""
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
    const movieData = {
        Movie: {
        id: state.id,
        movie_title: state.movie_title,
        movie_pic: state.movie_pic,
        genre: state.genre
        }
    };
    axios.post("http://localhost:5000/movie", movieData).then((response) => {
        console.log(response.status);
        console.log(response.data);
    });
  };  

  return (
    <div className="newProduct">
      <h1 className="addProductTitle">New Movie</h1>
      <form className="addProductForm" onSubmit={handleSubmit}>
        <div className="addProductItem">
          <label>ID</label>
          <input type="id" name="id" value={state.id} onChange={handleChange}/>
        </div>
        <div className="addProductItem">
          <label>Movie Title</label>
          <input type="movie_title" name="movie_title" value={state.movie_title} onChange={handleChange}/>
        </div>
        <div className="addProductItem">
          <label>Movie Picture</label>
          <input type="movie_pic" name="movie_pic" value={state.movie_pic} onChange={handleChange}/>
        </div>
        <div className="addProductItem">
          <label>Movie Genre</label>
          <input type="genre" name="genre" value={state.genre} onChange={handleChange}/>
        </div>
        <button type="submit" className="addProductButton">Create</button>
      </form>
    </div>
  );
}
