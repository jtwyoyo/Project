import { Link } from "react-router-dom";
import "./product.css";
import { useState, useEffect } from "react";
import axios from 'axios';

export default function Product() {

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
    axios.put("http://localhost:5000/movie", movieData).then((response) => {
        console.log(response.status);
        console.log(response.data);
    });
    }; 

    return (
        <div className="product">
        <div className="productTitleContainer">
            <h1 className="productTitle">Movie</h1>
            <Link to="/newproduct">
            <button className="productAddButton">Create</button>
            </Link>
        </div>
        <div className="productBottom">
            <form className="productForm" onSubmit={handleSubmit}>
                <div className="productFormLeft">
                    <label>ID</label>
                    <input type="id" name="id" value={state.id} onChange={handleChange} />
                    <label>Movie Title</label>
                    <input type="movie_title" name="movie_title" value={state.movie_title} onChange={handleChange}  />
                    <label>Movie Picture</label>
                    <input type="movie_pic" name="movie_pic" value={state.movie_pic} onChange={handleChange} />
                    <label>Movie Genre</label>
                    <input type="genre" name="genre" value={state.genre} onChange={handleChange} />
                </div>
                <div className="productFormRight">
                    <button type="submit" className="productButton">Update</button>
                </div>
            </form>
        </div>
        </div>
    );
}
