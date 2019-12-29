/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.order;

import dao.CustomerInfoDao;
import dao.OrderDao;
import dao.StatusOrderDetailDao;
import entity.CustomerInfo;
import entity.Order;
import entity.OrderDetail;
import entity.Product;
import entity.StatusOrderDetail;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.OrderDetailService;
import service.ProductService;
import util.Validate;

/**
 *
 * @author HangNT
 */
@WebServlet(name = "UpdateOrder", urlPatterns = {"/update-order"})
public class UpdateOrder extends HttpServlet {

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
            int orderID = Validate.getValidateID(request.getParameter("idUpdate"));
            if (orderID > 0) {
                int statusID = Validate.getValidateID(request.getParameter("listStatus"));
                if (statusID > 0) {
                    // update status
                    boolean update = new OrderDao().updateStatusByOrderID(orderID, statusID);

                    if (statusID == 3) {
                        OrderDetail orderDetail = new OrderDetailService().getOrderDetailByOrder(orderID);
                        int productID = orderDetail.getProductId();
                        Product product = new ProductService().getOne(productID);
                        product.setQuantity(product.getQuantity() - orderDetail.getQuantity());
                        boolean testSubQuantity = new ProductService().updateQuantity(productID, product.getQuantity());

//                        add success               
                        if (testSubQuantity) {
                            if (product.getQuantity() == 0) {
                                boolean testType = new ProductService().updateTypeProduct(productID);
                            }
                        }
                        List<Order> getAll = new OrderDao().getAll();
                        List<StatusOrderDetail> listStatus = new StatusOrderDetailDao().getAll();
                        List<CustomerInfo> list = new CustomerInfoDao().getAll();
                        request.setAttribute("listC", list);
                        request.setAttribute("listStatus", listStatus);
                        request.setAttribute("listOrders", getAll);
                        request.getRequestDispatcher("order.jsp").forward(request, response);

                    } else {
                        List<Order> getAll = new OrderDao().getAll();
                        List<StatusOrderDetail> listStatus = new StatusOrderDetailDao().getAll();
                        List<CustomerInfo> list = new CustomerInfoDao().getAll();
                        request.setAttribute("listC", list);
                        request.setAttribute("listStatus", listStatus);
                        request.setAttribute("listOrders", getAll);
                        request.getRequestDispatcher("order.jsp").forward(request, response);
                    }
                } else {
                    response.sendRedirect("notfoundproduct.jsp");
                }
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
