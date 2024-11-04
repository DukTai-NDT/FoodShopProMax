/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import entity.Category;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import model.DAOCategory;
import model.DAOProduct;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ShopController", urlPatterns = {"/ShopURL"})
public class ShopController extends HttpServlet {

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
        HttpSession session = request.getSession(true); 
        DAOProduct daoProduct = new DAOProduct();
        DAOCategory daoCategory = new DAOCategory();
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String pidParam = request.getParameter("pid");
            String cidParam = request.getParameter("cid");
            String sqlCategory = "SELECT * FROM Categories";
            Vector<Category> vectorCategory = daoCategory.getCategory(sqlCategory);
            session.setAttribute("dataCategory", vectorCategory);
            String service = request.getParameter("service");
            if (service.equals("pagination")) {
                if (cidParam == null) {

                    int paginID = Integer.parseInt(request.getParameter("paginID"));
                    int numProductDisplay = 9;
                    int offset = (paginID - 1) * numProductDisplay;
                    String sql;

                    sql = "SELECT * FROM Products ORDER BY ProductID OFFSET " + offset + " ROWS FETCH NEXT " + numProductDisplay + " ROWS ONLY;";
                    int totalProduct = daoProduct.getTotalProduct("select count(*) from Products");
                    int numPagin = (int) Math.ceil((double) totalProduct / numProductDisplay);
                    Vector<Product> vectorProduct = daoProduct.getProduct(sql);

                    RequestDispatcher dispath = request.getRequestDispatcher("shop-grid.jsp");
                    //set data
                    session.setAttribute("numPagin", numPagin);
                    session.setAttribute("dataProduct", vectorProduct);

                    // Run - view
                    dispath.forward(request, response);
                    return;
                }else{
                    int cid = Integer.parseInt(cidParam);
                int paginID = Integer.parseInt(request.getParameter("paginID"));
                int numProductDisplay = 9;
                int offset = (paginID - 1) * numProductDisplay;
                String sql;

                sql = "SELECT * FROM Products where CategoryID = "+cid+" ORDER BY ProductID OFFSET " + offset + " ROWS FETCH NEXT " + numProductDisplay + " ROWS ONLY;";
                int totalProduct = daoProduct.getTotalProduct("select count(*) from Products where CategoryID = "+cid );
                int numPagin = (int) Math.ceil((double) totalProduct / numProductDisplay);
                Vector<Product> vectorProduct = daoProduct.getProduct(sql);

                RequestDispatcher dispath = request.getRequestDispatcher("shop-grid.jsp");
                //set data
                session.setAttribute("numPagin", numPagin);
                session.setAttribute("dataProduct", vectorProduct);
                
                // Run - view
                dispath.forward(request, response);
                return;
                }
            }
                if (service.equals("listAllProductWithCID")) {

                    int cid = Integer.parseInt(cidParam);
                    int paginID = Integer.parseInt(request.getParameter("paginID"));
                    int numProductDisplay = 9;
                    int offset = (paginID - 1) * numProductDisplay;
                    String sql;

                    sql = "SELECT * FROM Products where CategoryID = " + cid + " ORDER BY ProductID OFFSET " + offset + " ROWS FETCH NEXT " + numProductDisplay + " ROWS ONLY;";
                    int totalProduct = daoProduct.getTotalProduct("select count(*) from Products");
                    int numPagin = (int) Math.ceil((double) totalProduct / numProductDisplay);
                    Vector<Product> vectorProduct = daoProduct.getProduct(sql);

                    RequestDispatcher dispath = request.getRequestDispatcher("shop-grid.jsp");
                    //set data
                    request.setAttribute("numPagin", numPagin);
                    request.setAttribute("dataProduct", vectorProduct);
                    
                    // Run - view
                    dispath.forward(request, response);

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
