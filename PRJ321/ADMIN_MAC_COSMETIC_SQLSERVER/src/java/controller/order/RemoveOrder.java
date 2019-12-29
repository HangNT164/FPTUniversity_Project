/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.order;

import dao.CardDao;
import dao.StatusOrderDetailDao;
import entity.Card;
import entity.Order;
import entity.StatusOrderDetail;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.OrderDetailService;
import service.OrderService;
import util.Validate;

/**
 *
 * @author HangNT
 */
@WebServlet(name = "RemoveOrder", urlPatterns = {"/remove-order"})
public class RemoveOrder extends HttpServlet {

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
        try {
            int orderID = Validate.getValidateID(request.getParameter("idOrder"));
            if (orderID > 0) {
                Order order = new OrderService().getOne(orderID);
                // remove customer, order,orderDetail
                int customerID = order.getCustomerInfoId();
                boolean remove = new OrderService().delete(orderID);
                boolean removeCustomer = new OrderService().delete(customerID);
                boolean removeOrderDetail = new OrderDetailService().delete(orderID);
                if (!remove || !removeCustomer || !removeOrderDetail) {
                    request.setAttribute("mess", "Can't remove");
                } else if (remove && removeCustomer && removeOrderDetail) {
                    List<Card> getAll = new CardDao().getAll();
                    List<StatusOrderDetail> listStatus = new StatusOrderDetailDao().getAll();
                    request.setAttribute("listStatus", listStatus);
                    request.setAttribute("listOrders", getAll);
                    request.getRequestDispatcher("order.jsp").forward(request, response);
                }
            } else {
                response.sendRedirect("notfoundproduct.jsp");
            }
        } catch (IOException | ServletException e) {
            response.sendRedirect("notfoundproduct.jsp");
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
