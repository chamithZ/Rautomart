function saveEmp() {
  let name = $('#name').val();
  let contact = $('#contact').val();
  let address = $('#address').val();

  // Create an object to hold the data
  let data = {
    empId: "",
    name: name,
    contactNo: contact,
    acNo: address
  };

  // Send the data using Ajax
  $.ajax({
    url: 'http://localhost:8080/api/v1/employee/saveEmployee',
    method: 'POST',
    contentType: 'application/json',
    crossDomain: true,
    xhrFields: {
      withCredentials: true
    },
    data: JSON.stringify(data),
    success: function(response) {
      alert('saved');
      getAllEmployees();
    },
    error: function(xhr, status, error) {
      alert('Error');
    }
  });
}
