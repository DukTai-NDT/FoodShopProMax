/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Product {

    private int ProductID;
    private String ProductName;
    private int SupplierID;
    private int CategoryID;
    private String MfgDate;
    private String ExpDate;
    private int Quantity;
    private double UnitPrice;
    private String ImgURL;
    private String Description;

    public Product(int ProductID, String ProductName, int SupplierID, int CategoryID, String MfgDate, String ExpDate, int Quantity, double UnitPrice, String ImgURL, String Description) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.SupplierID = SupplierID;
        this.CategoryID = CategoryID;
        this.MfgDate = MfgDate;
        this.ExpDate = ExpDate;
        this.Quantity = Quantity;
        this.UnitPrice = UnitPrice;
        this.ImgURL = ImgURL;
        this.Description = Description;
    }

    public Product(String ProductName, int SupplierID, int CategoryID, String MfgDate, String ExpDate, int Quantity, double UnitPrice, String ImgURL, String Description) {
        this.ProductName = ProductName;
        this.SupplierID = SupplierID;
        this.CategoryID = CategoryID;
        this.MfgDate = MfgDate;
        this.ExpDate = ExpDate;
        this.Quantity = Quantity;
        this.UnitPrice = UnitPrice;
        this.ImgURL = ImgURL;
        this.Description = Description;
    }
    
    

    public Product() {
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

    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int SupplierID) {
        this.SupplierID = SupplierID;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getMfgDate() {
        return MfgDate;
    }

    public void setMfgDate(String MfgDate) {
        this.MfgDate = MfgDate;
    }

    public String getExpDate() {
        return ExpDate;
    }

    public void setExpDate(String ExpDate) {
        this.ExpDate = ExpDate;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public String getImgURL() {
        return ImgURL;
    }

    public void setImgURL(String ImgURL) {
        this.ImgURL = ImgURL;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Product{" + "ProductID=" + ProductID + ", ProductName=" + ProductName + ", SupplierID=" + SupplierID + ", CategoryID=" + CategoryID + ", MfgDate=" + MfgDate + ", ExpDate=" + ExpDate + ", Quantity=" + Quantity + ", UnitPrice=" + UnitPrice + ", ImgURL=" + ImgURL + ", Description=" + Description + '}';
    }
    
   
}
