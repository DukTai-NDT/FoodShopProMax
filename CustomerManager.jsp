<%-- 
    Document   : CustomerManager
    Created on : Oct 31, 2024, 10:49:36 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector,entity.Customer" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Customer Manager</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f9;
                margin: 0;
                padding: 20px;
            }
            h2 {
                text-align: center;
                color: #333;
            }
            .add-admin {
                display: block;
                text-align: center;
                width: 120px;
                margin: 20px auto;
                padding: 10px 20px;
                background-color: #4CAF50;
                color: #fff;
                text-decoration: none;
                font-size: 16px;
                border-radius: 5px;
            }
            .add-admin:hover {
                background-color: #45a049;
            }
            .search-form {
                margin-bottom: 20px;
                text-align: center;
            }
            .search-form input[type="text"] {
                padding: 10px;
                width: 200px;
                border: 1px solid #ddd;
                border-radius: 5px;
            }
            .search-form button {
                padding: 10px 15px;
                background-color: #3498db;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-left: 10px;
            }
            .search-form button:hover {
                background-color: #2980b9;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }
            th, td {
                padding: 12px;
                text-align: center;
                border: 1px solid #ddd;
            }
            th {
                background-color: #4CAF50;
                color: white;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            .btn {
                padding: 8px 12px;
                color: #fff;
                text-decoration: none;
                border-radius: 5px;
            }
            .btn-delete {
                background-color: #e74c3c;
            }
            .btn-update {
                background-color: #3498db;
            }
            .btn-delete:hover {
                background-color: #c0392b;
            }
            .btn-update:hover {
                background-color: #2980b9;
            }
        </style>
    </head>
    <%
         Vector<Customer> vectorCustomer = (Vector<Customer>)session.getAttribute("dataCustomer");
    %>
    <body>

        <h2>Customer Manager</h2>
        <a href="CustomerURL?service=insertAdmin" class="add-admin">Add Admin</a>
        <a href="homePageAdmin.jsp" class="add-admin">Return Home</a>
        <!-- Form tìm kiếm khách hàng -->
        <div class="search-form">
            <form action="CustomerURL" method="post">
                <input type="hidden" value="service" name="listAllCustomer">
                <input type="text" name="CustomerName" placeholder="Search by Customer Name" >
                <button type="submit" name="submit">Search</button>
            </form>
        </div>

        <table>
            <tr>
                <th>CustomerID</th>
                <th>CustomerName</th>
                <th>Sex</th>
                <th>Address</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Country</th>
                <th>Password</th>
                <th>RoleID</th>
                <th>Actions</th>
            </tr>
            <% for (Customer customer : vectorCustomer) { %>
            <tr>
                <td><%= customer.getCustomerID() %></td>
                <td><%= customer.getCustomerName() %></td>
                <td><%= customer.getSex() %></td>
                <td><%= customer.getAddress() %></td>
                <td><%= customer.getEmail() %></td>
                <td><%= customer.getPhone() %></td>
                <td><%= customer.getCountry() %></td>
                <td><%= customer.getPassword() %></td>
                <% if (customer.getRoleID() == 1) { %>
                <td>User</td>
                <% } else { %>
                <td>Admin</td>
                <% } %>
                <td>
                    <a href="CustomerURL?service=updateCustomer&cid=<%= customer.getCustomerID() %>" class="btn btn-update">Update</a>
                    <a href="CustomerURL?service=deleteCustomer&cid=<%= customer.getCustomerID() %>" class="btn btn-delete">Delete</a>
                </td>
            </tr>
            <% } %>
        </table>

    </body>
</html>
