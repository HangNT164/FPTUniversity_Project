/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDao;
import entity.Account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import util.BCrypt;

/**
 *
 * @author HangNT
 */
@WebServlet(name = "ChangePassword", urlPatterns = {"/change-password"})
public class ChangePassword extends HttpServlet {

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
            String oldPassword = request.getParameter("oldpass");
            Account user = (Account) session.getAttribute("account");
            // check oldpassword must equal password of user 
//            System.out.println(BCrypt.checkpw(user.getPassword(), BCrypt.gensalt()) + "  - " + oldPassword);
            boolean test = BCrypt.checkpw(oldPassword, user.getPassword());
//            System.out.println(oldPassword);
//            System.out.println(test);
            if (test) {
                String newpass = request.getParameter("newpass");
                // new pass not duilicate with old pass
                if (user.getPassword() != newpass) {
                    user.setPassword(newpass);
                    boolean testUpdate = new AccountDao().updatePassword(user.getId(), user);
                    if (testUpdate) {
                        session.setAttribute("account", user);
                        request.getRequestDispatcher("thongtincanhan.jsp").forward(request, response);
                    }
                } else {
                    response.sendRedirect("thongtincanhan_1.jsp");
                }
            } else {
                response.sendRedirect("thongtincanhan_2.jsp");
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