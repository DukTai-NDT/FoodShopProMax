<%-- 
    Document   : insertAdmin
    Created on : Oct 31, 2024, 11:11:41 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Insert Admin</title>
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
            input[type="password"] {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 5px;
                box-sizing: border-box;
            }
            .btn-submit {
                width: 100%;
                padding: 10px;
                background-color: #4CAF50;
                color: #fff;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
                margin-top: 10px;
            }
            .btn-submit:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <%
        String InsertFailer = (String) request.getAttribute("InsertFailer");
    %>
    <body>

        <div class="container">
            <h2>Insert New Admin</h2>
            <form action="CustomerURL" method="post">
                <input type="hidden" name="service" value="insertAdmin">   
                <div class="form-group">
                    <label for="adminName">Admin Name</label>
                    <input type="text" id="adminName" name="AdminName" required>
                </div>
                <div class="form-group">
                    <label for="sex">Sex</label>
                    <select id="sex" name="Sex" required>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="Email" required>
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text" id="phone" name="Phone" required>
                </div>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" id="address" name="Address" required>
                </div>
                <div class="form-group">
                    <label for="country">Country</label>
                    <input type="text" id="country" name="Country" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="Password" required>
                </div>
                <div style="color: red">
                    ${InsertFailer}
                </div>
                <button type="submit" class="btn-submit">Insert Admin</button>
            </form>
        </div>

    </body>
</html>

