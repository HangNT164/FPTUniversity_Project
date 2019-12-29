/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.account;

import dao.AccountAndDetailDao;
import dao.AccountDao;
import dao.RoleDao;
import entity.Account;
import entity.AccountAndDetail;
import entity.Role;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AccountService;
import util.Validate;

/**
 *
 * @author HangNT
 */
@WebServlet(name = "UpdateAccoutUser", urlPatterns = {"/update-user"})
public class UpdateAccoutUser extends HttpServlet {

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
            int accountID = Validate.getValidateID(request.getParameter("idUpdate"));
            if (accountID > 0) {
                int roleID = Validate.getValidateID(request.getParameter("listRole"));
                if (roleID > 0) {
                    boolean updateRole = new AccountDao().updateRole(accountID, roleID);
                    if (!updateRole) {
                        request.setAttribute("mess", "Can't update");
                    }
                    List<AccountAndDetail> getAllAdmin = new AccountAndDetailDao().getAllAdmin();
                    List<AccountAndDetail> getAllUser = new AccountAndDetailDao().getAllUser();
                    List<Role> getAllRole = new RoleDao().getAll();
                    request.setAttribute("listRole", getAllRole);
                    request.setAttribute("listAdmin", getAllAdmin);
                    request.setAttribute("listUser", getAllUser);
                    request.getRequestDispatcher("account.jsp").forward(request, response);
//                int accountDetailID = account.getAccountDetalId();
                } else {
                    response.sendRedirect("notfoundproduct.jsp");
                }
            } else {
                response.sendRedirect("notfoundproduct.jsp");
            }
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
