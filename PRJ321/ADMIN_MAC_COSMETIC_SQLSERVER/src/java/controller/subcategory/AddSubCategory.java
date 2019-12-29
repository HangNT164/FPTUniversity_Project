/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.subcategory;

import dao.SubAndCateDao;
import dao.SubCateDao;
import entity.Category;
import entity.SubAndCate;
import entity.SubCate;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CategoryService;
import service.SubCateService;

/**
 *
 * @author HangNT
 */
@WebServlet(name = "AddSubCategory", urlPatterns = {"/add-sub-category"})
public class AddSubCategory extends HttpServlet {

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
            String subCode = request.getParameter("txtSubCode");
            String subName = request.getParameter("txtSubName");
            int categoryID=Integer.valueOf(request.getParameter("categoryName"));
            boolean isUpdate = new SubCateDao().isDulicate(new SubCateService().getAll(), subCode);
            // not dulicate
            if (isUpdate) {
                SubCate newCate = SubCate.builder().id(1).subCateName(subName).build();
                newCate.setSubCategoryCode(subCode);
                newCate.setCategoryId(categoryID);
                new SubCateService().add(newCate);
                List<Category> getAll = new CategoryService().getAll();
                List<SubAndCate> listSub = new SubAndCateDao().getAll();
                request.setAttribute("listSub", listSub);
                request.setAttribute("listCate", getAll);
                request.getRequestDispatcher("addSubCategory.jsp").forward(request, response);
            } else {
                request.setAttribute("mess", "SubCategory dulicate!!\nCan't add");
                List<Category> getAll = new CategoryService().getAll();
                List<SubAndCate> listSub = new SubAndCateDao().getAll();
                request.setAttribute("listSub", listSub);
                request.setAttribute("listCate", getAll);
                request.getRequestDispatcher("addSubCategory.jsp").forward(request, response);
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
