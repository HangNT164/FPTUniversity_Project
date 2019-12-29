/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.order;

import dao.CustomerInfoDao;
import dao.OrderDao;
import entity.AccountDetail;
import entity.CustomerInfo;
import entity.ViewOrderDetail;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Validate;

/**
 *
 * @author TuanNA
 */
@WebServlet(name = "DetailOrder", urlPatterns = {"/view-detail-order"})
public class DetailOrder extends HttpServlet {

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
            // list order detail
            List<ViewOrderDetail> lists = new OrderDao().getAllOrderDetailByOrderID(orderID);

            // list account detail
            AccountDetail accountDetail = new OrderDao().getOneAccountDetailByOrderID(orderID);

            // list customer 
            CustomerInfo customerInfo=new CustomerInfoDao().getOneByOrderID(orderID);
            request.setAttribute("lists", lists);
            request.setAttribute("accoutDetail", accountDetail);
            request.setAttribute("customerInfo", customerInfo);

            // chuyen sang trang customer infor
            request.getRequestDispatcher("customerInfo.jsp").forward(request, response);

        } catch (Exception e) {
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
