import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import axios from 'axios';

function App() {

    const [name,setname]=useState();
    const [contact,setContact]=useState();
    const [address,setAddress] =useState();


    function saveEmp() {
        let data = {
          empId: "",
          name: name,
          contactNo: contact,
          acNo: address,
        };
        alert(name);
      
        // Send the data using Axios
        axios.post('http://localhost:8080/api/v1/employee/saveEmployee', data, {
          headers: {
            'Content-Type': 'application/json',
          },
          withCredentials: true, // To include cookies and authentication headers if needed
        })
          .then((response) => {
            alert('Saved');
            // Handle the response data here if needed
          })
          .catch((error) => {
            alert('Something went wrong. Please try again later.');
            console.error('Error:', error);
          });
      }
     
      
      
      
      
      

  return (
    <div className="App">
      <head>
        <title>Title</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous"/>
        
    </head>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <body>
    <div class="container mt-5 col-6">
        <div class="mb-3 ">
            <label for="exampleFormControlInput1" class="form-label">Employ ID: </label>
            <input disabled type="text" class="form-control" id="exampleFormControlInput1" placeholder=""/>
        </div>

        <div class="mb-3 ">
            <label for="exampleFormControlInput1" class="form-label">Employ Name: </label>
            <input type="text" class="form-control" id="name" placeholder="Ex : John" onChange={setname}/>
        </div>

        <div class="mb-3 ">
            <label for="exampleFormControlInput1" class="form-label">Contact no: </label>
            <input type="text" class="form-control" id="contact" placeholder="0XX -XXXXXXX" onChange={setContact}/>
        </div>

        <div class="mb-3 ">
            <label for="exampleFormControlInput1" class="form-label">Account No</label>
            <input type="text" class="form-control" id="address" placeholder="" onChange={setAddress}/>
        </div>

        <div>
            <button type="button" class="btn btn-primary" onClick={saveEmp}>Save</button>
            <button type="button" class="btn btn-secondary" >Update</button>
            <button type="button" class="btn btn-success" >Delete</button>
        </div>

        <div class="mt-4">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Name</th>
                    <th scope="col">Address</th>
                    <th scope="col">Contact no</th>
                </tr>
                </thead>
                <tbody id="tableEmp">

                </tbody>
            </table>

        </div>


    </div>


    </body>
    </div>
  );
}

export default App;
