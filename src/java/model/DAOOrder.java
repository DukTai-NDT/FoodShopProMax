/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Order;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class DAOOrder extends DBConnection{
    public int insertOrder(Order  other){
        int n = 0;
        String sql = "INSERT INTO [dbo].[Orders] ([CustomerID], [DeliveryAddress], [PaymentForm], [OrderDate], [DeliveryDate], [ShipVia]) " +
             "VALUES (" + other.getCustomerID() + ", '" + other.getDeliveryAddress() + "', '" + other.getPaymentForm() + 
             "', '" + other.getOrderDate() + "', '" + other.getDeliveryDate() + "', " + other.getShipVia() + ")";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int addOrder(Order other){
        int n = 0;
        String sql = "INSERT INTO [dbo].[Orders] ( [CustomerID] ,[DeliveryAddress] ,[PaymentForm] ,[OrderDate] ,[DeliveryDate] ,[ShipVia],[Status])\n" +
" VALUES (? ,? ,? ,? ,? ,?,?)";
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setInt(1, other.getCustomerID());
            preState.setString(2, other.getDeliveryAddress());
            preState.setString(3, other.getPaymentForm());
            preState.setString(4, other.getOrderDate());
            preState.setString(5,other.getDeliveryDate());
            preState.setInt(6, other.getShipVia());
            preState.setString(7,other.getStatus());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    public int deleteOrder(int oid){
        int n = 0;
        String sql = "DELETE FROM [dbo].[Orders] WHERE OrderID = "+oid;
        
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    public int updateOrder(Order other){
        int n =0;
        String sql = """
                     UPDATE [dbo].[Orders]  SET [CustomerID] =?
                           ,[DeliveryAddress] = ?
                           ,[PaymentForm] = ?
                           ,[OrderDate] = ?
                           ,[DeliveryDate] = ?
                           ,[ShipVia] = ?
                      WHERE OrderID = ?""";
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setInt(1, other.getCustomerID());
            preState.setString(2, other.getDeliveryAddress());
            preState.setString(3, other.getPaymentForm());
            preState.setString(4, other.getOrderDate());
            preState.setString(5, other.getDeliveryDate());
            preState.setInt(6, other.getShipVia());
            preState.setInt(7, other.getOrderID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    public Vector<Order> getOrder(String sql){
        Vector<Order> vector = new Vector<>();
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {                
                int OrderID = rs.getInt("OrderID");
                int CustomerID = rs.getInt("CustomerID");
                String DeliveryAddress = rs.getString("DeliveryAddress");
                String PaymentForm = rs.getString("PaymentForm");
                String OrderDate = rs.getString("OrderDate");
                String DeliveryDate = rs.getString("DeliveryDate");
                int ShipVia = rs.getInt("ShipVia");
                String Status = rs.getString("Status");
                Order order = new Order(OrderID, CustomerID, DeliveryAddress, PaymentForm, OrderDate, DeliveryDate, ShipVia,Status);
                vector.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    public int getLastOrderID(){
        int n = 0;
        String sql = "SELECT top(1) * FROM Orders ORDER BY OrderID DESC ";
         try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {                
                n = rs.getInt("OrderID");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public void changeBillStatus(int oid) {
    String sql = "SELECT * FROM Orders WHERE OrderID = ?";
    String sqlChange = null;
    Order order = new Order();

    try {
        // Sử dụng PreparedStatement để truy vấn
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, oid);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) { // Đảm bảo có dữ liệu trong ResultSet
            order.setOrderID(rs.getInt("OrderID"));
            order.setCustomerID(rs.getInt("CustomerID"));
            order.setDeliveryAddress(rs.getString("DeliveryAddress"));
            order.setPaymentForm(rs.getString("PaymentForm"));
            order.setOrderDate(rs.getString("OrderDate"));
            order.setDeliveryDate(rs.getString("DeliveryDate")); // Đã sửa từ DeliveryAddress thành DeliveryDate
            order.setShipVia(rs.getInt("ShipVia"));
            order.setStatus(rs.getString("Status"));

            // Xác định trạng thái mới và chuẩn bị câu lệnh cập nhật
            if (order.getStatus().equals("wait      ")) {
                sqlChange = "UPDATE [dbo].[Orders] SET [Status] = 'process' WHERE OrderID = ?";
            } else if (order.getStatus().equals("process   ")) {
                sqlChange = "UPDATE [dbo].[Orders] SET [Status] = 'done' WHERE OrderID = ?";
            }

            // Nếu sqlChange không phải là null, thực hiện câu lệnh cập nhật
            if (sqlChange != null) {
                PreparedStatement updateStmt = conn.prepareStatement(sqlChange);
                updateStmt.setInt(1, oid);
                updateStmt.executeUpdate();
            } else {
                System.out.println("Bill is done" );
            }
        } else {
            System.out.println("Not found bill with OrderID: " + oid);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
    }
}

        
         
    public static void main(String[] args) {
        DAOOrder dao = new DAOOrder();
        
//        int n = dao.insertOrder(new Order(1002, "Hung Yen", "cash payment", "2024-10-16", "2024-10-20", 5));
//        if(n != 0 ){
//            System.out.println("Success");
//        }else{
//            System.out.println("Failer");
//        }


        System.out.println(dao.getLastOrderID());
    }
}
