<%-- 
    Document   : updateCustomer
    Created on : Nov 1, 2024, 12:00:05 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Customer" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Update Admin</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f9;
      margin: 0;
      padding: 20px;
    }
    .container {
      max-width: 500px;
      margin: 0 auto;
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }
    h2 {
      text-align: center;
      color: #333;
    }
    .form-group {
      margin-bottom: 15px;
    }
    label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }
    input[type="text"],
    input[type="email"],
    input[type="password"],
    select {
      width: 100%;
      padding: 10px;
      border: 1px solid #ddd;
      border-radius: 5px;
      box-sizing: border-box;
    }
    .btn-submit {
      width: 100%;
      padding: 10px;
      background-color: #3498db;
      color: #fff;
      border: none;
      border-radius: 5px;
      font-size: 16px;
      cursor: pointer;
      margin-top: 10px;
    }
    .btn-submit:hover {
      background-color: #2980b9;
    }
  </style>
</head>
<% Customer customer = (Customer) request.getAttribute("customer"); %>
<body>

  <div class="container">
    <h2>Update Admin</h2>
    <form action="CustomerURL" method="post">
      <!-- Hidden fields to store Admin ID and service type -->
      <input type="hidden" name="service" value="updateCustomer">
      

      <div class="form-group">
        <label for="adminName"> Name</label>
        <input type="text" id="adminName" name="CustomerName" value="<%= customer.getCustomerName() %>" required>
      </div>
      
      <div class="form-group">
        <label for="sex">Sex</label>
        <select id="sex" name="Sex" required>
          <option value="Male" <%= customer.getSex().equals("Male") ? "selected" : "" %>>Male</option>
          <option value="Female" <%= customer.getSex().equals("Female") ? "selected" : "" %>>Female</option>
        </select>
      </div>

      <div class="form-group">
        <label for="address">Address</label>
        <input type="text" id="address" name="Address" value="<%= customer.getAddress() %>" required>
      </div>

      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" id="email" name="Email" value="<%= customer.getEmail() %>" required>
      </div>

      <div class="form-group">
        <label for="phone">Phone</label>
        <input type="text" id="phone" name="Phone" value="<%= customer.getPhone() %>" required>
      </div>

      <div class="form-group">
        <label for="country">Country</label>
        <input type="text" id="country" name="Country" value="<%= customer.getCountry() %>" required>
      </div>

      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="Password" value="<%= customer.getPassword() %>" required>
      </div>

      <div class="form-group">
        <label for="role">Role</label>
        <select id="role" name="RoleID" required>
          <% if (customer.getRoleID() == 1) { %>
            <option value="1" selected>User</option>
            <option value="0">Admin</option>
          <% } else { %>
            <option value="1">User</option>
            <option value="0" selected>Admin</option>
          <% } %>
        </select>
      </div>

        <input name="submit" type="submit" value="Update" class="site-btn">
    </form>
  </div>

</body>
</html>
