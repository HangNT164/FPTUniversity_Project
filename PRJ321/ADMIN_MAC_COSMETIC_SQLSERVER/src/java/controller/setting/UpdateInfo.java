package controller.setting;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.ImageAvataDao;
import entity.Account;
import entity.AccountDetail;
import entity.ImageAvata;
import java.io.File;

import service.AccountService;
import service.AccountDetailService;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import util.CopyImage;

/**
 *
 * @author HangNT
 */
@WebServlet(name = "UpdateUser", urlPatterns = {"/update-info"})
public class UpdateInfo extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            // update infor
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String mobile = request.getParameter("mobile");
            String address = request.getParameter("address");
            String genderStr = request.getParameter("gender");
            int gender;
            if (genderStr.equalsIgnoreCase("female")) {
                gender = 0;
            } else if (genderStr.equalsIgnoreCase("male")) {
                gender = 1;
            } else {
                gender = 2;
            }
            AccountDetail user = (AccountDetail) session.getAttribute("user");
            user.setAddress(address);
            user.setGender(gender);
            user.setMobile(mobile);
            user.setName(username);
            Account account = new AccountService().getOneByAccountDetailID(user.getId());
            account.setEmail(email);
            boolean testUpdate = new AccountDetailService().update(user.getId(), user);
            boolean testUpdateAccount = new AccountService().update(account.getId(), account);

            // update image
            String imageLink = request.getParameter("pic");
            //System.out.println(imageLink);
            // sourceFolder: thu muc nguon duoc copy
            File sourceFolder = new File("C:\\Users\\HangNT\\Downloads");
            // targetFolder: thu muc dich duoc copy den
            File targetFolder = new File("E:\\Form 4-Fall 2019\\Web-Based Java Applications(PRJ321)\\JavaWebOfDuy\\2.Assignment\\Project1_SellProduct\\MAC_COSMETIC_F\\ADMIN_MAC_COSMETIC_SQLSERVER\\web\\img\\img_avata");
            // goi phuong thuc copy
            CopyImage.copyFolder(sourceFolder, targetFolder);
            ImageAvata imageAvata = (ImageAvata) session.getAttribute("avataAccount");

            // chen link vao DB
            // check xem co update anh ko
            //  update
            if (!imageLink.isEmpty()) {
                String newImageLink = "img/img_avata/"+ imageLink;
                //System.out.println(newImageLink);
                // update
//                System.out.println(newImageLink);
                session.removeAttribute("avataAccount");
                boolean update = new ImageAvataDao().updateImageLink(user.getId(), newImageLink);
                ImageAvata imageAvata2 = new ImageAvataDao().getOneByAccountDetail(user.getId());
                session.setAttribute("avataAccount", imageAvata2);
            }// user not update image=> old image
            else {
                session.setAttribute("avataAccount", imageAvata);
            }

            if (testUpdate) {
                if (testUpdateAccount) {
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("setting.jsp").forward(request, response);
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
