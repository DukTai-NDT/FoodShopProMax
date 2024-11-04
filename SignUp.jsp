<%-- 
    Document   : SignUp
    Created on : Oct 31, 2024, 11:45:07 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In Form</title>
    <style>
        /* Định dạng nền và căn giữa form */
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #121212;
            color: #333;
        }

        /* Định dạng form */
        .signin-form {
            background-color: #ffffff; /* Nền màu trắng cho form */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.5);
            width: 400px; /* Tăng chiều rộng của form */
        }

        /* Định dạng tiêu đề form */
        .signin-form h2 {
            text-align: center;
            color: #333; /* Chữ Sign In màu đen */
            margin-bottom: 20px;
            font-weight: bold;
        }

        /* Định dạng các nhãn */
        .form-group label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            color: #555;
        }

        /* Định dạng các trường nhập liệu */
        .form-group input[type="text"],
        .form-group input[type="email"],
        .form-group input[type="tel"],
        .form-group input[type="password"],
        .form-group select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
            color: #333;
            box-sizing: border-box;
        }

        /* Định dạng nút submit */
        .submit-btn {
            width: 100%;
            padding: 12px;
            background-color: #333;
            border: none;
            color: #ffffff;
            font-size: 16px;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            text-transform: uppercase;
        }

        /* Hiệu ứng hover cho nút submit */
        .submit-btn:hover {
            background-color: #555;
        }

        /* Định dạng khi focus vào các trường nhập liệu */
        .form-group input:focus,
        .form-group select:focus {
            outline: none;
            border: 1px solid #e91e63;
            background-color: #f0f0f0;
        }
    </style>
</head>
<%
    String SignUpFail = (String) request.getAttribute("SignUpFail");
%>
<body>

<div class="signin-form">
    <h2>Sign Up</h2>
    <form action="LoginURL" method="post">
        <input type="hidden" name="service" value="SignUp">
        <div class="form-group">
            <label for="customerName">Customer Name</label>
            <input type="text" id="customerName" name="CustomerName" required>
        </div>
        
        <div class="form-group">
            <label for="sex">Sex</label>
            <select id="sex" name="Sex" required>
                <option value="">Select</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
            </select>
        </div>
        
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" id="address" name="Address" required>
        </div>
        
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" id="email" name="Email" required>
        </div>
        
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="tel" id="phone" name="Phone" required>
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
            ${SignUpFail}
        </div>
        <button type="submit" class="submit-btn">Sign Up</button>
        <div class="signup">
          <span class="signup"> Have an account?
              <a href="login.jsp">Login</a>
          </span>
      </div>
    </form>
</div>

</body>
</html>

