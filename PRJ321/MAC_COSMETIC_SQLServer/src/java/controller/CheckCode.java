/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ImageAvataDao;
import entity.Account;
import entity.AccountDetail;
import entity.ImageAvata;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.AccountDetailService;
import service.AccountService;

/**
 *
 * @author HangNT
 */
@WebServlet(name = "CheckCode", urlPatterns = {"/check-code"})
public class CheckCode extends HttpServlet {

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
            String codeSend = (String) session.getAttribute("mailcode1");
            //System.out.println(codeSend);
            String code = request.getParameter("code");
            AccountDetail accountDetail = (AccountDetail) session.getAttribute("user");
            Account account = (Account) session.getAttribute("account");
            if (codeSend.equals(code)) {
                // xoa session 
                session.removeAttribute("codeRegister");
                // them vao DB
                int accountDetailId = new AccountDetailService().addAccountDetailReturnId(accountDetail);
                accountDetail.setId(accountDetailId);
                account.setAccountDetalId(accountDetailId);
                boolean addAccount = new AccountService().add(account);
                // them avata
                if (accountDetail.getGender() == 0) {
                    ImageAvata image = ImageAvata.builder()
                            .accountDetailID(accountDetailId)
                            .imageLink("img/img_avata/female.jpg")
                            .build();
                    boolean addAvata = new ImageAvataDao().add(image);
                } else {
                    ImageAvata image = ImageAvata.builder()
                            .accountDetailID(accountDetailId)
                            .imageLink("img/img_avata/male.jpg")
                            .build();
                    boolean addAvata = new ImageAvataDao().add(image);
                }

                // chuyen toi trang dang nhap
                response.sendRedirect("dangnhap.jsp");
            } else {
                request.setAttribute("mess", "Code not right");
                request.getRequestDispatcher("checkcode.jsp").forward(request, response);
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
