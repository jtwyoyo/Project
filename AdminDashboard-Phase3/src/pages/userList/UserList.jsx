import "./userList.css";
import { DataGrid } from "@material-ui/data-grid";
import { DeleteOutline } from "@material-ui/icons";
import { Link } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from 'axios';

export default function UserList() {

  const [data, setData] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:5000/user').then((response) => {
      console.log(response.data.data)
      setData(response.data.data)
    })
  },[])

  const handleDelete = (id) => {
    setData(data.filter((item) => item.id !== id));
    axios.delete('http://localhost:5000/user', {
      data: {
        "user": { 
                  "user_ID": id
                }
      }
    }).then((response) => {
      console.log('Deleted User')
    })
  };
  
  const columns = [
    { field: "id", headerName: "ID", width: 120 },
    { field: "username", headerName: "Username", width: 200 },
    { field: "password", headerName: "Password", width: 200 },
    { field: "admin_flag", headerName: "Admin Status", width: 200 },
    {
      field: "action",
      headerName: "Action",
      width: 150,
      renderCell: (params) => {
        return (
          <>
            <Link to={"/user/" + params.row.id}>
              <button className="userListEdit">Edit</button>
            </Link>
            <DeleteOutline
              className="userListDelete"
              onClick={() => handleDelete(params.row.id)}
            />
          </>
        );
      },
    },
  ];

  return (
    <div className="userList">
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
