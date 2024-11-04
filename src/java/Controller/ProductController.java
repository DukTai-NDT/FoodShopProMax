package Controller;

import entity.Category;
import entity.Product;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.util.Vector;
import model.DAOCategory;
import model.DAOProduct;

@WebServlet(name = "ProductController", urlPatterns = {"/ProductURL"})
public class ProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOProduct dao = new DAOProduct();
        DAOCategory daocat = new DAOCategory();
        HttpSession session = request.getSession(true);
        // Lấy danh mục sản phẩm
        String sqlCategory = "SELECT * FROM Categories";
        Vector<Category> vectorCategory = daocat.getCategory(sqlCategory);
        request.setAttribute("dataCategory", vectorCategory);

        System.out.println("xgf");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAllProduct";
            }

            if (service.equals("updateProduct")) {
                String submit = request.getParameter("submit");
//                String pidabc = request.getParameter("pid");
//                if(pidabc.isEmpty()){
//                    System.out.println("abc");
//                }else{
//                    System.out.println("xyz");
//                }
                if (submit == null) {
                    int pid = Integer.parseInt(request.getParameter("pid"));
                    Vector<Product> vector = dao.getProduct("Select * from Products where ProductID=" + pid);
                    Product product = vector.get(0);
                    request.setAttribute("data", product);
                    //Show form
                    ResultSet rsSup = dao.getData("SELECT [SupplierID],[SupplierName] FROM [dbo].[Suppliers]");
                    ResultSet rsCate = dao.getData("SELECT [CategoryID],[CategoryName] FROM [dbo].[Categories]");
                    request.setAttribute("rsSup", rsSup);
                    request.setAttribute("rsCate", rsCate);
                    request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
                } else {
                    //getdata
                    int pid = Integer.parseInt(request.getParameter("pid"));
                    String ProductName = request.getParameter("ProductName");
                    int SupplierID = Integer.parseInt(request.getParameter("SupplierID"));
                    int CategoryID = Integer.parseInt(request.getParameter("CategoryID"));
                    String MfgDate = request.getParameter("MfgDate");
                    String ExpDate = request.getParameter("ExpDate");
                    int Quantity = Integer.parseInt(request.getParameter("Quantity"));
                    double UnitPrice = Double.parseDouble(request.getParameter("UnitPrice"));
                    String ImgURL = request.getParameter("ImgURL");
                    String Description = request.getParameter("Description");
                    //check data

                    if (ProductName.equals(
                            "")) {
                        out.print("Product name is not empty");
                    }
                    //convert

                    Product pro = new Product(pid,ProductName, SupplierID, CategoryID, MfgDate, ExpDate, Quantity, UnitPrice, ImgURL, Description);
                    int n = dao.updateProduct(pro);
                    response.sendRedirect("ProductURL?service=listAllProduct");
                }

            }
            if (service.equals("deleteProduct")) {
                dao.deleteProduct(Integer.parseInt(request.getParameter("pid")));
                response.sendRedirect("ProductURL?service=listAllProduct");

            }
            if (service.equals("insertProduct")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    //Show form
                    ResultSet rsSup = dao.getData("SELECT [SupplierID],[SupplierName] FROM [dbo].[Suppliers]");
                    ResultSet rsCate = dao.getData("SELECT [CategoryID],[CategoryName] FROM [dbo].[Categories]");
                    request.setAttribute("rsSup", rsSup);
                    request.setAttribute("rsCate", rsCate);
                    request.getRequestDispatcher("insertProduct.jsp").forward(request, response);
                } else {
                    //getdata
                    String ProductName = request.getParameter("ProductName");
                    int SupplierID = Integer.parseInt(request.getParameter("SupplierID"));
                    int CategoryID = Integer.parseInt(request.getParameter("CategoryID"));
                    String MfgDate = request.getParameter("MfgDate");
                    String ExpDate = request.getParameter("ExpDate");
                    int Quantity = Integer.parseInt(request.getParameter("Quantity"));
                    double UnitPrice = Double.parseDouble(request.getParameter("UnitPrice"));
                    String ImgURL = request.getParameter("ImgURL");
                    String Description = request.getParameter("Description");
                    //check data

                    if (ProductName.equals(
                            "")) {
                        out.print("Product name is not empty");
                    }
                    //convert

                    Product pro = new Product(ProductName, SupplierID, CategoryID, MfgDate, ExpDate, Quantity, UnitPrice, ImgURL, Description);
                    int n = dao.addProduct(pro);

                    response.sendRedirect("ProductURL?service=listAllProduct");
                }
            }

            if (service.equals("listAllProduct")) {

                String sql = "select * from Products";
                String submit = request.getParameter("submit");
                if (submit != null) {

                    String pname = request.getParameter("pname");
                    sql = "select *\n"
                            + "from Products\n"
                            + "where ProductName like '%" + pname + "%'";
                }
                Vector<Product> vector = dao.getProduct(sql);
                
                //select view
                RequestDispatcher dispath = request.getRequestDispatcher("ProductManager.jsp");
                //set data
                session.setAttribute("dataProduct", vector);

                // Run - view
                dispath.forward(request, response);
            }

            if (service.equals("productDetails")) {
                String pname = request.getParameter("pname");

                if (pname != null) {
                    String sql = "SELECT * FROM Products WHERE ProductName LIKE '%" + pname + "%'";
                    Vector<Product> vector = dao.getProduct(sql);

                    if (!vector.isEmpty()) {
                        Product product = vector.get(0);
                        request.setAttribute("dataProductDetail", vector.get(0));
                        RequestDispatcher dispath = request.getRequestDispatcher("shop-details.jsp");
                        dispath.forward(request, response);
                    } else {
                        out.println("No product found with the given name.");
                    }
                } else {
                    out.println("Product name is required.");
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
