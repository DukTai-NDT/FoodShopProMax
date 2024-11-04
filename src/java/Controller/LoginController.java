/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DAOCustomer;
import jakarta.servlet.RequestDispatcher;
/**
 *
 * @author Admin
 */
@WebServlet(name="LoginController", urlPatterns={"/LoginURL"})
public class LoginController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(true);
        DAOCustomer daoCustomer = new DAOCustomer();
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("service");
            
            if(request.getParameter("service") == null || service == null){
                service = "login";
            }
            if(service.equals("login")){
                 
                 String submit = request.getParameter("submit");
                 if(submit == null){
                 request.getRequestDispatcher("login.jsp").forward(request, response);
             }else{
                     Customer cus = daoCustomer.getLogin(request.getParameter("userName"),request.getParameter("password") );
                     if(cus == null){
                         //login fail
                         request.setAttribute("message", "Login fail");
                         request.getRequestDispatcher("login.jsp").forward(request, response);

                     }else{
                         if(cus.getRoleID() == 1){
                         //login success --> insert to the session
                         session.setAttribute("customer", cus);
                         request.getRequestDispatcher("homePage.jsp").forward(request, response);
                         }else if(cus.getRoleID() == 0){
                             session.setAttribute("customer", cus);
                             request.getRequestDispatcher("homePageAdmin.jsp").forward(request, response);
                         }
                     }
                     
                 }
            }
            
            if(service.equals("SignUp")){
                String CustomerName = request.getParameter("CustomerName");
                String Sex = request.getParameter("Sex");
                String Address = request.getParameter("Address");
                String Email = request.getParameter("Email");
                String Phone = request.getParameter("Phone");
                String Country = request.getParameter("Country");
                String Password = request.getParameter("Password");
                
                Customer customer = new Customer(CustomerName, Sex, Address, Email, Phone, Country, Password,1);
                int n = daoCustomer.addCustomer(customer);
                
                if(n != 0){
                    response.sendRedirect("LoginURL");
                }else{
                    request.setAttribute("SignUpFail", "Sign up for failure,Plead try again");
                    RequestDispatcher requestDis = request.getRequestDispatcher("SignUp.jsp");
                    requestDis.forward(request, response);
                }
            }
           
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
