Trần Đức Hải
<%-- 
    Document   : Login
    Created on : Oct 18, 2024, 11:45:44 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Coding By CodingNepal - codingnepalweb.com -->
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Login Form</title>
        <% String message = (String)request.getAttribute("message"); 
    %>
        <!---Custom CSS File--->

        <style>
            /* Import Google font - Poppins */
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif;
            }
            body{
                min-height: 100vh;
                width: 100%;
                background: #000000;
            }
            .container{
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%,-50%);
                max-width: 430px;
                width: 100%;
                background: #fff;
                border-radius: 7px;
                box-shadow: 0 5px 10px rgba(0,0,0,0.3);
            }
            .container .form{
                padding: 2rem;
            }
            .form header{
                font-size: 2rem;
                font-weight: 500;
                text-align: center;
                margin-bottom: 1.5rem;
            }
            .form input{
                height: 60px;
                width: 100%;
                padding: 0 15px;
                font-size: 17px;
                margin-bottom: 1.3rem;
                border: 1px solid #ddd;
                border-radius: 6px;
                outline: none;
            }
            .form input:focus{
                box-shadow: 0 1px 0 rgba(0,0,0,0.2);
            }
            .form a{
                font-size: 16px;
                color: #009579;
                text-decoration: none;
            }
            .form a:hover{
                text-decoration: underline;
            }
            .form input.button{
                color: #fff;
                background: #000000;
                font-size: 1.2rem;
                font-weight: 500;
                letter-spacing: 1px;
                margin-top: 1.7rem;
                cursor: pointer;
                transition: 0.4s;
            }
            .form input.button:hover{
                background: #808080;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="login form">
                <header>Login</header>
                <form action="LoginURL">
                    <input type="hidden" name="service" value="login">
<input type="text" placeholder="Enter your username" name="userName">
                    <input type="password" placeholder="Enter your password" name="password">
                    <p style="color: red;"><%=(message!=null?message:"")%></p>
                   
                    <a href="#">Forgot password?</a>
                    <input type="submit" class="button" name="submit" value="login">
                </form>
                
                <div class="signup">
                    <span class="signup">Don't have an account?
                        <a href="SignUp.jsp">Sign up</a>
                    </span>
                </div>
            </div>
        </div>
    </body>
</html>