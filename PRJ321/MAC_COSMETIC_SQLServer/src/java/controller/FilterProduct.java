/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Category;
import entity.Product;
import entity.SubCate;

import service.CategoryService;
import service.ImageService;
import service.ProductService;
import service.SubCateService;

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
@WebServlet(name = "FilterProduct", urlPatterns = {"/filter-product"})
public class FilterProduct extends HttpServlet {

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
            List<SubCate> listSub = new SubCateService().getAll();
            List<Category> listCate = new CategoryService().getAll();
            List<Product> listProduct = new ProductService().getAll();

            List<Product> listProductInAPage
                    = new ProductService().listProductInOnePageInAll(1, 6);
            List<Integer> listPage = new ProductService().getListPage(listProduct, 6);

            List<String> listImageTrue = new ImageService().getAllImageTrue(listProductInAPage);

            int pageID = Validate.getValidateID(request.getParameter("pageId"));
            if (pageID == -1) {
                request.getRequestDispatcher("notfoundproduct.jsp").forward(request, response);
            } else {
                if (pageID >= 1) {
                    listProductInAPage
                            = new ProductService().listProductInOnePageInAll(pageID, 6);
                    listImageTrue = new ImageService().getAllImageTrue(listProductInAPage);
                }
                if (listProductInAPage.isEmpty()) {
                    response.sendRedirect("notfoundproduct.jsp");
                } else {
                    int linkTempNext = pageID + 1;
                    String linkPageNext = String.valueOf(linkTempNext);
                    request.setAttribute("linkPage1", linkPageNext);
                    int linkTempPrevious = pageID - 1;
                    String linkPagePrevious = String.valueOf(linkTempPrevious);
                    request.setAttribute("linkPage", linkPagePrevious);
                    request.setAttribute("listProduct", listProductInAPage);
                    request.setAttribute("listImageTrue", listImageTrue);
                    request.setAttribute("listPage", listPage);
                    request.setAttribute("listSub", listSub);
                    request.setAttribute("listCate", listCate);
                    request.getRequestDispatcher("phanloaisanpham.jsp").forward(request, response);
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
