/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Order {

    private int OrderID;
    private int CustomerID;
    private String DeliveryAddress;
    private String PaymentForm;
    private String OrderDate;
    private String DeliveryDate;
    private int ShipVia;
    private String Status;

    public Order(int OrderID, int CustomerID, String DeliveryAddress, String PaymentForm, String OrderDate, String DeliveryDate, int ShipVia, String Status) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.DeliveryAddress = DeliveryAddress;
        this.PaymentForm = PaymentForm;
        this.OrderDate = OrderDate;
        this.DeliveryDate = DeliveryDate;
        this.ShipVia = ShipVia;
        this.Status = Status;
    }

    public Order(int CustomerID, String DeliveryAddress, String PaymentForm, String OrderDate, String DeliveryDate, int ShipVia, String Status) {
        this.CustomerID = CustomerID;
        this.DeliveryAddress = DeliveryAddress;
        this.PaymentForm = PaymentForm;
        this.OrderDate = OrderDate;
        this.DeliveryDate = DeliveryDate;
        this.ShipVia = ShipVia;
        this.Status = Status;
    }

    public Order(int CustomerID, String DeliveryAddress, String PaymentForm, String OrderDate, String DeliveryDate, int ShipVia) {
        this.CustomerID = CustomerID;
        this.DeliveryAddress = DeliveryAddress;
        this.PaymentForm = PaymentForm;
        this.OrderDate = OrderDate;
        this.DeliveryDate = DeliveryDate;
        this.ShipVia = ShipVia;
    }

   

    

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" + "OrderID=" + OrderID + ", CustomerID=" + CustomerID + ", DeliveryAddress=" + DeliveryAddress + ", PaymentForm=" + PaymentForm + ", OrderDate=" + OrderDate + ", DeliveryDate=" + DeliveryDate + ", ShipVia=" + ShipVia + ", Status=" + Status + '}';
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

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getDeliveryAddress() {
        return DeliveryAddress;
    }

    public void setDeliveryAddress(String DeliveryAddress) {
        this.DeliveryAddress = DeliveryAddress;
    }

    public String getPaymentForm() {
        return PaymentForm;
    }

    public void setPaymentForm(String PaymentForm) {
        this.PaymentForm = PaymentForm;
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

    public int getShipVia() {
        return ShipVia;
    }

    public void setShipVia(int ShipVia) {
        this.ShipVia = ShipVia;
    }
}
