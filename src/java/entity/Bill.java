/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Bill {
    private int OrderID;
    private String OrderDate;
    private String DeliveryDate;
    private String CustomerName;
    private int ProductID;
    private String ProductName;
    private double UnitPrice;
    private int Quantity;
    private double Discount;
    private String Status;

    public Bill(int OrderID, String OrderDate, String DeliveryDate, String CustomerName, int ProductID, String ProductName, double UnitPrice, int Quantity, double Discount, String Status) {
        this.OrderID = OrderID;
        this.OrderDate = OrderDate;
        this.DeliveryDate = DeliveryDate;
        this.CustomerName = CustomerName;
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.UnitPrice = UnitPrice;
        this.Quantity = Quantity;
        this.Discount = Discount;
        this.Status = Status;
    }

    public Bill(int OrderID, String OrderDate, String DeliveryDate, String CustomerName, String Status) {
        this.OrderID = OrderID;
        this.OrderDate = OrderDate;
        this.DeliveryDate = DeliveryDate;
        this.CustomerName = CustomerName;
        this.Status = Status;
    }

    

    public Bill() {
    }

    @Override
    public String toString() {
        return "Bill{" + "OrderID=" + OrderID + ", OrderDate=" + OrderDate + ", DeliveryDate=" + DeliveryDate + ", CustomerName=" + CustomerName + ", ProductID=" + ProductID + ", ProductName=" + ProductName + ", UnitPrice=" + UnitPrice + ", Quantity=" + Quantity + ", Discount=" + Discount + ", Status=" + Status + '}';
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

   

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(String DeliveryDate) {
        this.DeliveryDate = DeliveryDate;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double Discount) {
        this.Discount = Discount;
    }

    
    
}
