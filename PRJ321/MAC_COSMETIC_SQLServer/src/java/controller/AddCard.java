/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Card;
import entity.Image;
import entity.Product;

import service.ProductService;
import service.ImageService;

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
@WebServlet(name = "AddCard", urlPatterns = {"/add-card"})
public class AddCard extends HttpServlet {

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
//            // cookies luu anh
//            Cookie[] imageCookies=request.getCookies();
//            
//            // cookies luu ten san pham
//            Cookie[]productCookies=request.getCookies();
//            
//            // cookies luu so luong
//            Cookie[]quantityCookies=request.getCookies();
//            
//            // cookies luu gia
//            Cookie[]priceCookies=request.getCookies();
            
            
            int id = Validate.getValidateID(request.getParameter("id"));
            int page = Validate.getValidateID(request.getParameter("flag"));
            int quantity = 1;
            List<Card> listCard = null;
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
                        listCard = (List<Card>) session.getAttribute("listCard");
                        // flag
                        if (listCard == null) {
                            listCard = new ArrayList<>();
                            listCard.add(card);
                            // cookies anh
//                           Cookie c=new Cookie("imageCookies", value)
                            session.setAttribute("listCard", listCard);
                        } else {
                            boolean flag = true;
                            // flag san pham vua chon da ton tai trong gio hang hay chua
                            for (Card c : listCard) {
                                if (c.getId() == id) {
                                    flag = false;
                                    c.setQuantity(c.getQuantity() + 1);
                                    c.setTotalPrice(c.getQuantity() * c.getSellPrice());
                                }
                            }
                            if (flag) {
                                listCard.add(card);
                            }
                            session.setAttribute("listCard", listCard);
                            //response.sendRedirect("/product-detail?id="+product);
                        }
                        //check nó dag ở trang chủ hay trang detail . 
                        //đang ở đâu thì nhảy đúng về đó.
                        if (page > 0) {
                            switch (page) {
                                case 1:
                                    response.sendRedirect("themgiohang.jsp");
                                    break;
                                case 2:
                                    response.sendRedirect("product-detail?id=" + id);
                                    break;
                                case 3:
                                    response.sendRedirect("get-all-product?id=" + id + "&pageId=1");
                                    break;
                                case 4:
                                    response.sendRedirect("filter-product?id=" + id + "&pageId=1");
                                    break;
                                case 5:
                                    response.sendRedirect("filter-product-detail?id=" + id + "&pageId=1");
                                    break;
                                case 6:
                                    response.sendRedirect("filter-product-detail-price?id=" + id + "&pageId=1");
                                    break;
                                default:
                                    response.sendRedirect("error.jsp");
                                    break;
                            }
                        } else {
                            response.sendRedirect("error.jsp");
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
