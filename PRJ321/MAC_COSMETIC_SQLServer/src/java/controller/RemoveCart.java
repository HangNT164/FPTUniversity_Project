/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Card;

import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import util.Validate;

/**
 *
 * @author Minh
 */
@WebServlet(name = "RemoveCart", urlPatterns = {"/remove-cart"})
public class RemoveCart extends HttpServlet {

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
            int id = Validate.getValidateID(request.getParameter("id"));
            HttpSession session = request.getSession();
            if (id > 0) {
                List<Card> listCart = (List<Card>) session.getAttribute("listCard");
                for (int i = listCart.size() - 1; i >= 0; i--) {
                    if (listCart.get(i).getId() == id) {
                        listCart.remove(i);
                    }
                }
                session.setAttribute("listCard", listCart);
                if (listCart.isEmpty()) {
                    response.sendRedirect("themgiohangnull.jsp");
                } else {
                    response.sendRedirect("themgiohang.jsp");
                }
            } else if (id == 0) {
                session.removeAttribute("listCard");
                response.sendRedirect("themgiohangnull.jsp");
            } else {
                response.sendRedirect("notfoundproduct.jsp");
            }
        }
    }

    // new servlet - xử lý số lượng trong giỏ hàng. 
    // c1 : nút cộng nút trừ
    // c2 : input text (check) - form - bên cạnh là nút OK ( thẻ a . truyền id đi ) -
    // không được truyền quá số lượng trong kho. 
    // giảm về 0 coi như xóa.
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
