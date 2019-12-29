/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrderDao;
import entity.Account;
import entity.AccountDetail;
import entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.AccountDetailService;
import service.AccountService;
import service.CustomerInfoService;
import service.OrderDetailService;
import service.OrderService;

/**
 *
 * @author HangNT
 */
@WebServlet(name = "DeleteAccount", urlPatterns = {"/remove-account"})
public class DeleteAccount extends HttpServlet {

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
            HttpSession session = request.getSession();
            AccountDetail accountDetail = (AccountDetail) session.getAttribute("user");
            // xoa accoutn detail
            boolean updateAccountDetail = new AccountDetailService().delete(accountDetail.getId());

            // xoa account
            Account account = (Account) session.getAttribute("account");
            boolean updateAccount = new AccountService().delete(account.getId());
            
            // xoa order
            List<Order> lists = new OrderDao().getAllByAccountDetail(accountDetail.getId());
            System.out.println(lists);
            lists.forEach((o) -> {
                boolean updateOrder = new OrderService().delete(o.getId());
            });
            
            // xoa customer
            List<Integer> getALlCustomerID = new ArrayList<>();
            lists.forEach((o) -> {
                getALlCustomerID.add(o.getCustomerInfoId());
            });

            getALlCustomerID.forEach((o) -> {
                boolean updateCustomer = new CustomerInfoService().delete(o);
            });
            
            // xoa order detail
            lists.forEach((o) -> {
            boolean updateOrderDetail = new OrderDetailService().delete(o.getId());
            });
            
            
            session.invalidate();
            response.sendRedirect("index.jsp");
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
