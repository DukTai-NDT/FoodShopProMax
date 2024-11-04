/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Customer;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.util.Vector;
import javax.xml.transform.Result;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class DAOCustomer extends DBConnection {

    public int insertCustomer(Customer other) {
        int n = 0;
        String sql = "INSERT INTO Customers ([CustomerName], [Sex], [Address], [Email], [Phone]) "
                + "VALUES('" + other.getCustomerName() + "', '" + other.getSex() + "', '" + other.getAddress() + "', '"
                + other.getEmail() + "', '" + other.getPhone() + "',1)";
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    
    public int addCustomer(Customer other) {

        int n = 0;
        String sql = """
                     INSERT INTO [dbo].[Customers]([CustomerName],[Sex],[Address],[Email],[Phone],[Country],[Password],[RoleID])
                          VALUES
                                (?,?,?,?,?,?,?,?)
                     """;
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getCustomerName());
            preState.setString(2, other.getSex());
            preState.setString(3, other.getAddress());
            preState.setString(4, other.getEmail());
            preState.setString(5, other.getPhone());
            preState.setString(6, other.getCountry());
            preState.setString(7, other.getPassword());
            preState.setInt(8, other.getRoleID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;

    }

    public int deleteCustomer(int cid) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Customers]\n"
                + "      WHERE CustomerID = " + cid;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int updateCustomer(Customer other) {
        int n = 0;
        String sql = "UPDATE [dbo].[Customers] SET [CustomerName] =? ,[Sex] = ? ,[Address] = ? ,[Email] = ? ,[Phone] = ?,[Country] = ? ,[Password] = ?,[RoleID] = ?\n"
                + " WHERE CustomerID = ?";
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, other.getCustomerName());
            preState.setString(2, other.getSex());
            preState.setString(3, other.getAddress());
            preState.setString(4, other.getEmail());
            preState.setString(5, other.getPhone());
            preState.setString(6, other.getCountry());
            preState.setString(7, other.getPassword());
            preState.setInt(8, other.getRoleID());
            preState.setInt(9, other.getCustomerID());
            n = preState.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Customer> getCustomer(String sql) {
        Vector<Customer> vector = new Vector<>();
        Statement state;
        try {
            state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int CustomerID = rs.getInt("CustomerID");
                String CustomerName = rs.getString("CustomerName");
                String Sex = rs.getString("Sex");
                String Address = rs.getString("Address");
                String Email = rs.getString("Email");
                String Phone = rs.getString("Phone");
                String Country = rs.getString("Country");
                String Password = rs.getString("Password");
                int RoleID = rs.getInt("RoleID");
                Customer customer = new Customer(CustomerID, CustomerName, Sex, Address, Email, Phone, Country, Password, RoleID);
                vector.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }
    public Customer getLogin(String userName, String password){
        Customer customer = null;
        String sql = "select * from Customers where CustomerName = ? and Password = ?";
        try {
            PreparedStatement preState = conn.prepareStatement(sql);
            preState.setString(1, userName);
            preState.setString(2, password);
            ResultSet rs = preState.executeQuery();
            while (rs.next()) {
            customer = new Customer(rs.getInt(1), rs.getString(2)
                    , rs.getString(3), rs.getString(4), rs.getString(5)
                    , rs.getString(6), rs.getString(7), rs.getString(8),rs.getInt(9));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    public static void main(String[] args) {
        DAOCustomer dao = new DAOCustomer();
        int n = dao.updateCustomer(new Customer(2,"Nguyen Ba Minh", "Male", "BacNinh", "quang@gmail.com"
                , "0999999999", "Viet Nam", "123", 1));
        if(n != 0){
            System.out.println("success");
        }else{
            System.out.println("failer");
        }
    }
}
