<%-- 
    Document   : insertProduct
    Created on : Nov 1, 2024, 9:10:29 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Insert Product</title>
        <style>
            /* CSS cải tiến cho form insertProduct */
            body {
                font-family: Arial, sans-serif;
                background-color: #e9ecef;
                color: #333;
                margin: 0;
                padding: 0;
            }

            h2 {
                text-align: center;
                color: #333;
                margin-top: 30px;
                font-size: 24px;
            }

            form {
                max-width: 600px;
                margin: 20px auto;
                padding: 30px;
                background-color: #ffffff;
                border-radius: 10px;
                box-shadow: 0 6px 10px rgba(0, 0, 0, 0.15);
            }

            label {
                display: block;
                font-weight: bold;
                color: #495057;
                margin-top: 10px;
                font-size: 14px;
            }

            input[type="text"],
            input[type="number"],
            input[type="date"],
            input[type="file"],
            select,
            textarea {
                width: 100%;
                padding: 10px;
                margin-top: 5px;
                border: 1px solid #ced4da;
                border-radius: 5px;
                font-size: 16px;
                color: #495057;
                background-color: #f8f9fa;
                transition: all 0.3s ease;
                box-sizing: border-box;
            }

            input[type="text"]:focus,
            input[type="number"]:focus,
            input[type="date"]:focus,
            input[type="file"]:focus,
            select:focus,
            textarea:focus {
                border-color: #80bdff;
                background-color: #ffffff;
                outline: none;
            }

            textarea {
                resize: vertical;
            }

            button {
                width: 100%;
                padding: 12px;
                margin-top: 20px;
                background-color: #28a745;
                border: none;
                border-radius: 5px;
                color: #ffffff;
                font-size: 18px;
                font-weight: bold;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            button:hover {
                background-color: #218838;
            }

            .form-group {
                margin-bottom: 15px;
            }

            select {
                appearance: none;
                -webkit-appearance: none;
                -moz-appearance: none;
                padding-right: 20px;
                background: url('data:image/svg+xml;charset=US-ASCII,%3csvg xmlns%3d%27http%3a//www.w3.org/2000/svg%27 viewBox%3d%270 0 4 5%27%3e%3cpath fill%3d%27%23495057%27 d%3d%27M2 0L0 2h4zM2 5L0 3h4z%27/%3e%3c/svg%3e') no-repeat right 10px center;
                background-size: 10px;
            }

            @media (max-width: 600px) {
                form {
                    padding: 20px;
                    margin: 15px;
                }

                button {
                    font-size: 16px;
                }
            }
        </style>
    </head>
    <%
        ResultSet rsSup = (ResultSet)request.getAttribute("rsSup");
        ResultSet rsCate = (ResultSet)request.getAttribute("rsCate");
        %>
    <body>

        <h2>Insert New Product</h2>
        <form action="ProductURL" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="service" value="insertProduct">

            <div class="form-group">
                <label for="productName">Product Name:</label>
                <input type="text" id="productName" name="ProductName" required>
            </div>

            <div class="form-group">
                <label for="SupplierID">Supplier ID:</label>
                <select name="SupplierID" id="SupplierID">
                    <% while(rsSup.next()){ %>
                        <option value="<%= rsSup.getInt(1)%>"><%= rsSup.getString(2) %></option>
                    <% } %>
                </select>
            </div>

            <div class="form-group">
                <label for="CategoryID">Category ID:</label>
                <select name="CategoryID" id="CategoryID">
                    <% while(rsCate.next()){ %>
                        <option value="<%= rsCate.getInt(1)%>"><%= rsCate.getString(2) %></option>
                    <% } %>
                </select>
            </div>

            <div class="form-group">
                <label for="MfgDate">Manufacture Date:</label>
                <input type="date" id="MfgDate" name="MfgDate" required>
            </div>

            <div class="form-group">
                <label for="ExpDate">Expiration Date:</label>
                <input type="date" id="ExpDate" name="ExpDate" required>
            </div>

            <div class="form-group">
                <label for="quantity">Quantity:</label>
                <input type="number" id="quantity" name="Quantity" required>
            </div>

            <div class="form-group">
                <label for="unitPrice">Unit Price:</label>
                <input type="number" step="0.1" id="unitPrice" name="UnitPrice" required>
            </div>

            <div class="form-group">
                <label for="image">Image:</label>
                <input type="file" id="image" name="Image" accept="image/*" required>
            </div>

            <div class="form-group">
                <label for="description">Description:</label>
                <textarea id="description" name="Description" rows="4" required></textarea>
            </div>

            <button type="submit" value="insertProduct" name="submit">Insert Product</button>
        </form>

    </body>
</html>

