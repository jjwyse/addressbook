<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE HTML>
<html>
<head>
<title>Address Book</title>     
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/addressbook/resources/css/addressbook.css"/>
</head>
<body>
   <div id="container">
      <h1>Address Book Page</h1>
      <p>This page demonstrates Spring MVC's AJAX functionality. Retrieve a person by ID, or save a new person</p>
      <h2>Get By ID</h2>
      <form id="idForm">
         <div class="error hide" id="idError">Please enter an ID greater than 0</div>
         <label for="personId">ID (0-3): </label>
         <input name="id" id="personId" value="0" type="number" />       
         <input type="submit" value="Get Person By ID" /> 
         <br /> 
         <br />       
         <div id="personIdResponse"></div>
      </form>
      <hr />
      <h2>Submit New Address Book Entry</h2>
      <form id="newPersonForm">
         <label for="name">Name: </label>
         <input type="text" name="name" id="nameInput" />
         <br />
         <label for="addressInput">Address: </label>
         <input type="text" name="address" id="addressInput" />
         <br />
         <label for="cityInput">City: </label>
         <input type="text" name="city" id="cityInput" />
         <br />
         <label for="stateInput">State: </label>
         <input type="text" name="state" id="stateInput" />
         <br />
         <label for="phoneNumberInput">Phone Number: </label>
         <input type="text" name="phoneNumber" id="phoneNumberInput" />
         <br />
         <input type="submit" value="Save Person" />
         <br />
         <br />
         <div id="personFormResponse" class="green"></div>
      </form>
   </div>
   <script type="text/javascript">
   
    $(document).ready(function() 
    {
      // Request Person by ID AJAX
      $('#idForm').submit(function(e) 
      {
        var personId = +$('#personId').val();
        $.get('${pageContext.request.contextPath}/api/' + personId, function(person) 
        {
          $('#personIdResponse').text(person.name + 
             ', address: ' + person.address + ', city: ' + person.city + ', state: ' + person.state + ', phoneNumber: ' + person.phoneNumber);
        });
        e.preventDefault(); // prevent actual form submit
      });
              
      $('#newPersonForm').submit(function(e) 
      {
        // will pass the form date using the jQuery serialize function
        $.post('${pageContext.request.contextPath}/api/person', $(this).serialize(), function(response) 
        {
          $('#personFormResponse').text(response);
        });
         
        e.preventDefault(); // prevent actual form submit and page reload
      });
       
    });
  </script>
</body>
</html>