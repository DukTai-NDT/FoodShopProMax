/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import entity.Cart;
import entity.Customer;
import entity.Order;
import entity.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Vector;
import model.DAOOrder;
import model.DAOOrderDetail;

/**
 *
 * @author Admin
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderURL"})
public class OrderController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(true);
            DAOOrder daoOrder = new DAOOrder();
            DAOOrderDetail daoODetail = new DAOOrderDetail();
           Customer customer = (Customer) session.getAttribute("customer");
            
            Vector<Cart> vectorCart = (Vector<Cart>) session.getAttribute("dataCart");
            String service = request.getParameter("service");
            if (service.equals("checkout")) {
                String CustomerName = request.getParameter("CustomerName");
                String Country = request.getParameter("Country");
                String Address = request.getParameter("Address");
                String Phone = request.getParameter("Phone");
                String Email = request.getParameter("Email");
                String PaymentForm = request.getParameter("PaymentForm");
                LocalDate currentDate = LocalDate.now();

                // Định dạng ngày dưới dạng chuỗi (dd-MM-yyyy)
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String formattedDate = currentDate.format(formatter);
                Random random = new Random();

                // Lấy một số ngẫu nhiên từ 1 đến 10
                int ShipVia = random.nextInt(10) + 1;
               
               
                int n = daoOrder.addOrder(new Order(customer.getCustomerID(), Address, PaymentForm, formattedDate, formattedDate, ShipVia, "wait"));
                int x = 0;
                for (Cart cart : vectorCart) {
                    x = daoODetail.addOrderDetail(new OrderDetail(daoOrder.getLastOrderID(), cart.getProductID(), cart.getUnitPrice(), cart.getQuantity(), cart.getDiscount(), 0, 0));

                }
                   System.out.println(n);
                
                response.sendRedirect("homePage.jsp");
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
