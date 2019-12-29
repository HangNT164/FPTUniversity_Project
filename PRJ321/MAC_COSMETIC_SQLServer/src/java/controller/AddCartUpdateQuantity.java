/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Card;
import entity.Image;
import entity.Product;

import service.ImageService;
import service.ProductService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import util.Validate;

/**
 *
 * @author HangNT
 */
@WebServlet(name = "AddCartUpdateQuantity", urlPatterns = {"/add-cart"})
public class AddCartUpdateQuantity extends HttpServlet {

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
            String action = request.getParameter("action");
            // neu ko update gio hang
            List<Card> listCard = null;
            int id = Integer.valueOf(request.getParameter("id"));
            int quantity = 0;
            if (action != null && action.equalsIgnoreCase("update")) {
                HttpSession session = request.getSession();
                quantity = Integer.valueOf(request.getParameter("quantity"));
                listCard = (List<Card>) session.getAttribute("listCard");
                Validate.update(id, quantity, listCard);
                session.setAttribute("listCard", listCard);
            }
            if (id > 0) {
                Product product = new ProductService().getOne(id);
                if (!product.getStatusName().equalsIgnoreCase("Sold off") && quantity <= product.getQuantity()) {
                    if (product != null) {
                        Image image = new ImageService().getImageCover(id);
                       Card card = Card.builder()
                                .id(id)
                                .productName(product.getProductName())
                                .imageLink(image.getImageLink())
                                .sellPrice(product.getPriceNew())
                                .orginPrice(product.getOrginPrice())
                                .productQuantity(product.getQuantity())
                                .quantity(quantity)
                                .totalPrice(quantity * product.getPriceNew())
                                .build();
                        // kiem tra gio hang xem co san pham hay chua
                        HttpSession sessionCard = request.getSession();
                        listCard = (List<Card>) sessionCard.getAttribute("listCard");
                        // flag
                        if (listCard == null) {
                            listCard = new ArrayList<>();
                            listCard.add(card);
                            sessionCard.setAttribute("listCard", listCard);
                        } else {
                            boolean flag = true;
                            // flag san pham vua chon da ton tai trong gio hang hay chua
                            for (Card c : listCard) {
                                if (c.getId() == id) {
                                    flag = false;
                                    c.setQuantity(c.getQuantity());
                                    c.setTotalPrice(c.getQuantity() * c.getSellPrice());
                                }
                            }
                            if (flag) {
                                listCard.add(card);
                            }
                            sessionCard.setAttribute("listCard", listCard);
                        }
                    } else {
                        response.sendRedirect("error.jsp");
                    }
                } else {
                    response.sendRedirect("notadd.jsp");
                }
            } else {
                response.sendRedirect("error.jsp");
            }
            response.sendRedirect("themgiohang.jsp");
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
