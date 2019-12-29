/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.AccountDetail;
import entity.Card;
import entity.CustomerInfo;
import entity.Order;

import service.CustomerInfoService;
import service.OrderDetailService;
import service.OrderService;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

/**
 *
 * @author HangNT
 */
@WebServlet(name = "CheckOut", urlPatterns = {"/check-out"})
public class CheckOut extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("Name");
            String phone = request.getParameter("Mobile");
            String payment = request.getParameter("Payment");
            String address = request.getParameter("Address");
            HttpSession session = request.getSession();
            AccountDetail accountDetail = (AccountDetail) session.getAttribute("user");
            CustomerInfo cf = CustomerInfo.builder()
                    .name(name)
                    .address(address)
                    .mobile(phone)
                    .build();
            int customerId = new CustomerInfoService().addCustomerReturnId(cf);
            // System.out.println(customerId);
            if (customerId > 0) {
                String note = request.getParameter("Note");
                List<Card> listCart = (List<Card>) session.getAttribute("listCard");

                int totalPrice = 0;
                totalPrice = listCart.stream().map((c) -> c.getTotalPrice()).reduce(totalPrice, Integer::sum);
                Order o = Order.builder()
                        .accountDetailId(accountDetail.getId())
                        .customerInfoId(customerId)
                        .totalPrice(totalPrice)
                        .note(note)
                        .payment(payment)
                        .build();
                // System.out.println(o);
                int orderId = new OrderService().addOrderReturnId(o);

                //  System.out.println(orderId);
                if (orderId > 0) {
                    boolean isCheck = new OrderDetailService().addListCard(listCart, orderId);
                    
                    session.setAttribute("orderDetailID", orderId);

//                    System.out.println(isCheck);
//                    System.out.println(isCheck);
//                    OrderDetail orderDetail = new OrderDetailService().getOrderDetailByOrder(orderId);
//                    int productID = orderDetail.getProductId();
//                    Product product = new ProductService().getOne(productID);
//                    product.setQuantity(product.getQuantity() - orderDetail.getQuantity());
//                    boolean testSubQuantity = new ProductService().updateQuantity(productID, product.getQuantity());
                    // add success               
//                    if (testSubQuantity) {
//                        if (product.getQuantity() == 0) {
//                            boolean testType = new ProductService().updateTypeProduct(productID);
//                            
//                        }
                    if (isCheck) {
                        // xoa session
                        session.removeAttribute("listCard");
                        response.sendRedirect("thankyou.jsp");
                    } else {
                        // xoa order vua add va customer info
                        boolean testRemove = new OrderService().remove(orderId);
                        boolean removeCustomer = new CustomerInfoService().remove(customerId);
                        response.sendRedirect("error.jsp");
                    }
                }
//                } else {
//                    response.sendRedirect("error.jsp");
//                }
            } else {
                //xoa customer info khi add fail
                boolean removeCustomer = new CustomerInfoService().remove(customerId);
                response.sendRedirect("error.jsp");
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
