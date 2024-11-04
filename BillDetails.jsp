<%-- 
    Document   : BillDetails
    Created on : Nov 4, 2024, 2:28:06 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entity.Bill,java.util.Vector" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bill Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            padding-top: 30px;
        }

        .details-container {
            width: 80%;
            max-width: 800px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            padding: 20px;
            margin-bottom: 20px;
            text-align: center;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        .info {
            font-size: 16px;
            margin: 5px 0;
            text-align: left;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
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

        .grand-total {
            font-size: 18px;
            font-weight: bold;
            margin-top: 10px;
            text-align: right;
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
    Bill bill = vectorBill.get(0); // Lấy thông tin chung từ hóa đơn đầu tiên
%>
<body>

    <div class="details-container">
        <h1>Bill Details</h1>
        <!-- Display basic details -->
        <div class="info"><strong>Order ID:</strong> <%=bill.getOrderID()%></div>
        <div class="info"><strong>Order Date:</strong> <%=bill.getOrderDate()%></div>
        <div class="info"><strong>Delivery Date:</strong> <%=bill.getDeliveryDate()%></div>
        <div class="info"><strong>Customer Name:</strong> <%=bill.getCustomerName()%></div>
        <div class="info"><strong>Status:</strong> <%=bill.getStatus()%></div>

        <!-- Display product details in a table -->
        <table>
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Discount</th>
                    <th>Total</th>
                </tr>
            </thead>
           
            <tbody>
                <%
                double grandTotal = 0;

                for (Bill bill1 : vectorBill) {
                    double total = bill1.getUnitPrice() * bill1.getQuantity() * (1 - bill1.getDiscount() / 100);
                    grandTotal += total;
                %>
                <tr>
                    <td><%=bill1.getProductID()%></td>
                    <td><%=bill1.getProductName()%></td>
                    <td><%=bill1.getUnitPrice()%></td>
                    <td><%=bill1.getQuantity()%></td>
                    <td><%=bill1.getDiscount()%></td>
                    <td><%=total%></td> <!-- Calculated as (UnitPrice * Quantity) - Discount -->
                </tr>
                <% } %>
            </tbody>
        </table>

        <!-- Display Grand Total -->
        <div class="grand-total">Grand Total: <%=grandTotal%></div>

        <!-- Action buttons -->
        <div class="buttons">
            <a href="BillURL?service=changeStatusBill&oid=<%=bill.getOrderID()%>" class="button">Change Status</a>
            <a href="BillURL?service=BillManager" class="button">Back to Bill Manager</a>
        </div>
    </div>

</body>
</html>
