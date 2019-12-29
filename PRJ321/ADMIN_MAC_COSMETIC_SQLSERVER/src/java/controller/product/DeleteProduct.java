/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

import dao.ImageDao;
import dao.ProductDao;
import dao.StatusDao;
import entity.Image;
import entity.Product;
import entity.Status;
import entity.SubCate;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ProductService;
import service.SubCateService;

/**
 *
 * @author TuanNA
 */
@WebServlet(name = "DeleteProduct", urlPatterns = {"/delete"})
public class DeleteProduct extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */

            int id = Integer.parseInt(request.getParameter("id"));

            List<Status> listS = new StatusDao().getAll();

            for (Status status : listS) {
                if (status.getProductId() == id) {
                    new StatusDao().delete(status.getId());
                }
            }

            List<Image> list2 = new ImageDao().getAll();
            for (Image image : list2) {
                if (image.getProductId() == id) {
                    new ImageDao().delete(image.getId());
                }
            }
            new ProductDao().delete(id);

            List<Product> list = new ProductService().getAll();
            List<SubCate> listSubCategory = new SubCateService().getAll();

            request.setAttribute("listSubCategory", listSubCategory);
            request.setAttribute("listProduct", list);
            request.getRequestDispatcher("addProduct.jsp").forward(request, response);

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