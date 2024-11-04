<%-- 
    Document   : BillManager
    Created on : Nov 4, 2024, 1:47:46 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Bill,java.util.Vector" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bill Manager</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .table-container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .view-btn a {
            text-decoration: none;
            color: white;
            background-color: #007BFF;
            padding: 8px 12px;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        .view-btn a:hover {
            background-color: #0056b3;
        }
        .buttons {
            margin-top: 20px;
            display: flex;
            gap: 10px;
            justify-content: center;
        }
        .button {
            text-decoration: none;
            color: white;
            background-color: #007BFF;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<%
    Vector<Bill> vectorBill = (Vector<Bill>)session.getAttribute("dataBill");
    Vector<Bill> vectorEachBill = (Vector<Bill>)session.getAttribute("dataEachBill");
    %>
<body>

    <div class="table-container">
        <h1>Bill Manager</h1>
        <div class="buttons">
            
            <a href="homePageAdmin.jsp" class="button">Back to Home</a>
        </div>
        <table>
            <thead>
                <tr>
                    <th>Bill ID</th>
                    <th>Order ID</th>
                    <th>Customer Name</th>
                    <th>Order Date</th>
                     <th>Delivery Date</th>
                    <th>Status</th>
                    <th>View</th>
                </tr>
            </thead>
            <tbody>
                <%
                 int billID = 1;
                 for (Bill bill : vectorEachBill) {
                %>
                
                <tr>
                    <td><%=billID++%></td>
                    <td><%=bill.getOrderID()%></td>
                    <td><%=bill.getCustomerName()%></td>
                    <td><%=bill.getOrderDate()%></td>
                    <td><%=bill.getDeliveryDate()%></td>
                    <td><%=bill.getStatus()%></td>
                   <td class="view-btn"><a href="BillURL?service=BillOrder&bid=<%=bill.getOrderID()%>">Detail</a></td>

                </tr>
             <%}%>
                <!-- Add more rows as needed -->
            </tbody>
        </table>
    </div>

</body>
</html>
