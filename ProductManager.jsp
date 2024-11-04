<%-- 
    Document   : ProductManager
    Created on : Nov 1, 2024, 1:32:03 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Vector, entity.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            width: 80%;
            margin: auto;
            padding: 20px;
            background: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
        }

        .btn {
            display: inline-block;
            padding: 10px 15px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin: 10px 0;
        }

        .btn:hover {
            background-color: #0056b3;
        }

        .search-form {
            display: flex;
            justify-content: center;
            margin: 20px 0;
        }

        .search-form input {
            padding: 10px;
            width: 250px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .search-form button {
            padding: 10px 15px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .search-form button:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table th, table td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        table th {
            background-color: #007bff;
            color: white;
        }

        .product-img {
            width: 50px;
            height: auto;
        }

        .btn-action-update {
            display: inline-block;
            padding: 5px 10px;
            background-color: #28a745; /* Green */
            color: white;
            text-decoration: none;
            border-radius: 3px;
            margin-right: 5px;
        }

        .btn-action-update:hover {
            background-color: #218838;
        }

        .btn-action-delete {
            display: inline-block;
            padding: 5px 10px;
            background-color: #dc3545; /* Red */
            color: white;
            text-decoration: none;
            border-radius: 3px;
        }

        .btn-action-delete:hover {
            background-color: #c82333;
        }
    </style>
</head>
<%
    Vector<Product> vectorProduct = (Vector<Product>) session.getAttribute("dataProduct");
%>
<body>
    <div class="container">
        <h1>Product Management</h1>
        <a href="ProductURL?service=insertProduct" class="btn">Add Product</a>
        <a href="homePageAdmin.jsp" class="btn">Return Home</a>
        <form class="search-form" action="ProductURL" method="post">
            <input type="hidden" value="service" name="listAllProducts">
            <input type="text" placeholder="Search for products..." name="pname">
            <button type="submit" name="submit">Search</button>
        </form>

        <table>
            <thead>
                <tr>
                    <th>ProductID</th>
                    <th>Product Name</th>
                    <th>SupplierID</th>
                    <th>CategoryID</th>
                    <th>Manufacture Date</th>
                    <th>Expiration Date</th>
                    <th>Quantity</th>
                    <th>Unit Price</th>
                    <th>Image</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <!-- Product data will be added here -->
                <% for (Product product : vectorProduct) { %>
                    <tr>
                        <td><%= product.getProductID() %></td>
                        <td><%= product.getProductName() %></td>
                        <td><%= product.getSupplierID() %></td>
                        <td><%= product.getCategoryID() %></td>
                        <td><%= product.getMfgDate() %></td>
                        <td><%= product.getExpDate() %></td>
                        <td><%= product.getQuantity() %></td>
                        <td><%= product.getUnitPrice() %></td>
                        <td><img src="img/Project_PRJ/<%= product.getImgURL() %>" alt="<%= product.getProductName() %>" class="product-img"></td>
                        <td><%= product.getDescription() %></td>
                        <td>
                            <a href="ProductURL?service=updateProduct&pid=<%= product.getProductID() %>" class="btn btn-action-update">Update</a>
                            <a href="ProductURL?service=deleteProduct&pid=<%= product.getProductID() %>" class="btn btn-action-delete">Delete</a>
                        </td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
