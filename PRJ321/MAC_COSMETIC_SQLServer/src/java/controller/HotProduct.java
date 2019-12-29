/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Product;

import service.ImageService;
import service.ProductService;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import util.Validate;

/**
 *
 * @author HangNT
 */
@WebServlet(name = "HotProduct", urlPatterns = {"/hot-product"})
public class HotProduct extends HttpServlet {

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
            List<Product> listProduct = new ProductService().getAllBuyMax();
            List<Integer> listPage = new ProductService().getListPage(listProduct, 12);
            List<Product> listProductInAPage;
            List<String> listImageTrue;
            List<String> listImageFalse;
            //Status statusByProduct;
            int pageID = Validate.getValidateID(request.getParameter("pageId"));
            if (pageID <= 0) {
                    response.sendRedirect("notfoundproduct.jsp");
            } else {
                listProductInAPage
                        = new ProductService().getListBuyMuch(pageID, 12);
                if (listProductInAPage.isEmpty()) {
                    response.sendRedirect("notfoundproduct.jsp");
                } else {
                    listImageTrue = new ImageService().getAllImageTrue(listProductInAPage);
                    listImageFalse = new ImageService().getAllImageFalse(listProductInAPage);
                    int linkTempNext = pageID + 1;
                    String linkPageNext = String.valueOf(linkTempNext);
                    int linkTempPrevious = pageID - 1;
                    String linkPagePrevious = String.valueOf(linkTempPrevious);
                    
                    request.setAttribute("linkPage1", linkPageNext);
                    request.setAttribute("linkPage", linkPagePrevious);
                    request.setAttribute("listProductInAPage", listProductInAPage);
                    request.setAttribute("listImageTrue", listImageTrue);
                    request.setAttribute("listPage", listPage);
                    request.setAttribute("listImageFalse", listImageFalse);
                    request.getRequestDispatcher("sanphambanchay.jsp").forward(request, response);
                }
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
