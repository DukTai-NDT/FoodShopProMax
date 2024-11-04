/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import entity.Customer;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Vector;
import model.DAOCustomer;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CustomerController", urlPatterns = {"/CustomerURL"})
public class CustomerController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAOCustomer daoCustomer = new DAOCustomer();
        HttpSession session = request.getSession(true);
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAllCustomer";
            }
            if (service.equals("listAllCustomer")) {
                 
                

                String sql = "SELECT * FROM Customers ORDER BY RoleID DESC";
                String submit = request.getParameter("submit");
                if (submit != null) {

                    String cname = request.getParameter("CustomerName");
                    sql = "select *\n"
                            + "from Customers\n"
                            + "where CustomerName like '%" + cname + "%'";
                }
                Vector<Customer> vector = daoCustomer.getCustomer(sql);
//                if(vector.isEmpty()){
//                    System.out.println("abc");
//                }else{
//                    System.out.println("xyz");
//                }
                //select view
                RequestDispatcher dispath = request.getRequestDispatcher("CustomerManager.jsp");
                //set data
                session.setAttribute("dataCustomer", vector);
                
                // Run - view
                dispath.forward(request, response);            }

            if (service.equals("insertAdmin")) {
                String AdminName = request.getParameter("AdminName");
                String Sex = request.getParameter("Sex");
                String Address = request.getParameter("Address");
                String Email = request.getParameter("Email");
                String Phone = request.getParameter("Phone");
                String Country = request.getParameter("Country");
                String Password = request.getParameter("Password");

                Customer customer = new Customer(AdminName, Sex, Address, Email, Phone, Country, Password, 0);
                System.out.println(customer);
                int n = daoCustomer.addCustomer(customer);

                if (n != 0) {
                    response.sendRedirect("CustomerURL?service=listAllCustomer");
                } else {
                    request.setAttribute("InsertFailer", "Insert for failure,Plead try again");
                    RequestDispatcher requestDis = request.getRequestDispatcher("insertAdmin.jsp");
                    requestDis.forward(request, response);
                }
            }
            if (service.equals("updateCustomet")) {
                String submit = request.getParameter("submit");
                if (submit == null) {
                    //System.out.println("Hello ");
                    int cid = Integer.parseInt(request.getParameter("cid"));
                    RequestDispatcher rd = request.getRequestDispatcher("UpdateUsers.jsp");
                    Vector<Customer> vector = daoCustomer.getCustomer("select * from Customers where CustomerID=" + cid);
                    Customer customer = vector.get(0);
                    request.setAttribute("user", customer);
                    rd.forward(request, response);

                } else {
                    //System.out.println("Hello world");
                    int cid = Integer.parseInt(request.getParameter("cid"));
                    String CustomerName = request.getParameter("CustomerName");
                    String Sex = request.getParameter("Sex");
                    String Address = request.getParameter("Address");
                    String Email = request.getParameter("Email");
                    String Phone = request.getParameter("Phone");
                    String Country = request.getParameter("Country");
                    String Password = request.getParameter("Password");
                    int RoleId = Integer.parseInt(request.getParameter("RoleId"));
                    //System.out.println(UserId + " " + Username + " " + Password + " " + RoleId);
                    int n = daoCustomer.updateCustomer(new Customer(cid, CustomerName, Sex, Address, Email, Phone, Country, Password, RoleId));
                    response.sendRedirect("CustomerController?service=listAllCustomer");
                }
            }

            if (service.equals("deleteCustomer")) {
                int cid = Integer.parseInt(request.getParameter("cid"));
                int n = daoCustomer.deleteCustomer(cid);
                response.sendRedirect("CustomerURL?service=listAllCustomer");
            }

        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
//if (service.equals("updateCustomer")) {
//                String cidParam = request.getParameter("cid");
//                System.out.println("abc"+cidParam);
//                if (cidParam == null || cidParam.isEmpty()) {
//                    request.setAttribute("UpdateFailer", "Customer ID is missing.");
//                    request.getRequestDispatcher("updateCustomer.jsp").forward(request, response);
//                    return;
//                }
//
//                int cid = Integer.parseInt(cidParam); // Chuyển đổi sau khi đảm bảo cid không null hoặc rỗng
//                Vector<Customer> vectorCustomer = daoCustomer.getCustomer("SELECT * FROM Customers WHERE CustomerID=" + cid);
//
//                if (vectorCustomer.isEmpty()) {
//                    request.setAttribute("UpdateFailer", "Customer not found.");
//                    request.getRequestDispatcher("updateCustomer.jsp").forward(request, response);
//                    return;
//                }
//
//                Customer customer = vectorCustomer.get(0);
//                request.setAttribute("customer", customer);
//
//                String AdminName = request.getParameter("AdminName");
//                String Sex = request.getParameter("Sex");
//                String Address = request.getParameter("Address");
//                String Email = request.getParameter("Email");
//                String Phone = request.getParameter("Phone");
//                String Country = request.getParameter("Country");
//                String Password = request.getParameter("Password");
//                int RoleID = Integer.parseInt(request.getParameter("RoleID"));
//                System.out.println(AdminName+Sex+Address+Email+Phone+Country+Password+RoleID);
//                Customer customerUpdate = new Customer(cid, AdminName, Sex, Address, Email, Phone, Country, Password, RoleID);
//                int n = daoCustomer.updateCustomer(customerUpdate);
//
//                if (n != 0) {
//                    response.sendRedirect("CustomerURL?service=listAllCustomer");
//                } else {
//                    request.setAttribute("UpdateFailer", "Update failed. Please try again.");
//                    request.getRequestDispatcher("updateCustomer.jsp").forward(request, response);
//                }
//            
//        }
