import "./productList.css";
import { DataGrid } from "@material-ui/data-grid";
import { DeleteOutline } from "@material-ui/icons";
import { Link } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from 'axios';

export default function ProductList() {

  const [data, setData] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:5000/movie').then((response) => {
      console.log(response.data.data)
      setData(response.data.data)
    })
  },[])

  const handleDelete = (id) => {
    setData(data.filter((item) => item.id !== id));
    axios.delete('http://localhost:5000/movie', {
      data: {
        "Movieid" : id
      }
    }).then((response) => {
      console.log('Deleted Movie')
    })
  };

  const columns = [
    { field: "id", headerName: "ID", width: 90 },
    { field: "movie_title", headerName: "Title", width: 200 },
    { field: "movie_pic", headerName: "Picture", width: 400 },
    { field: "genre", headerName: "Genre", width: 200 },
    {
      field: "action",
      headerName: "Action",
      width: 150,
      renderCell: (params) => {
        return (
          <>
            <Link to={"/product/" + params.row.id}>
              <button className="productListEdit">Edit</button>
            </Link>
            <DeleteOutline
              className="productListDelete"
              onClick={() => handleDelete(params.row.id)}
            />
          </>
        );
      },
    },
  ];

  return (
    <div className="productList">
      <DataGrid
        rows={data}
        disableSelectionOnClick
        columns={columns}
        pageSize={8}
        checkboxSelection
      />
    </div>
  );
}
