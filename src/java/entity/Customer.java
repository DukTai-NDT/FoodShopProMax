/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Customer {

    private int CustomerID;
    private String CustomerName;
    private String Sex;
    private String Address;
    private String Email;
    private String Phone;
    private String Country;
    private String Password;
    private int RoleID;

    public Customer(int CustomerID, String CustomerName, String Sex, String Address, String Email, String Phone, String Country, String Password, int RoleID) {
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.Sex = Sex;
        this.Address = Address;
        this.Email = Email;
        this.Phone = Phone;
        this.Country = Country;
        this.Password = Password;
        this.RoleID = RoleID;
    }

    public Customer(String CustomerName, String Sex, String Address, String Email, String Phone, String Country, String Password, int RoleID) {
        this.CustomerName = CustomerName;
        this.Sex = Sex;
        this.Address = Address;
        this.Email = Email;
        this.Phone = Phone;
        this.Country = Country;
        this.Password = Password;
        this.RoleID = RoleID;
    }
    
    
    

    public Customer() {
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    @Override
    public String toString() {
        return "Customer{" + "CustomerID=" + CustomerID + ", CustomerName=" + CustomerName + ", Sex=" + Sex + ", Address=" + Address + ", Email=" + Email + ", Phone=" + Phone + ", Country=" + Country + ", Password=" + Password + ", RoleID=" + RoleID + '}';
    }

    

}
