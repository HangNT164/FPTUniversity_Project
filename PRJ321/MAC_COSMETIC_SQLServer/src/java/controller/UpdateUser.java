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
import java.io.File;

import service.AccountService;
import service.AccountDetailService;

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
public class UpdateUser extends HttpServlet {

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
        try {
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
            // System.out.println(user);
            user.setAddress(address);
            user.setGender(gender);
            user.setMobile(mobile);
            user.setName(username);
            Account account = new AccountService().getOneByAccountDetailID(user.getId());
            account.setEmail(email);
            boolean testUpdate = new AccountDetailService().update(user.getId(), user);
            boolean testUpdateAccount = new AccountService().update(account.getId(), account);
            ImageAvata imageAvata = (ImageAvata) session.getAttribute("avataAccount");

            // update image
            String imageLink = request.getParameter("pic");
//            System.out.println("dm\n"+imageLink);
            if (imageLink.isEmpty()&&(imageAvata.getImageLink().equals("img/img_avata/female.jpg")||imageAvata.getImageLink().equals("img/img_avata/male.jpg"))) {
                // neu pic ko co anh 
                if (user.getGender() == 0) {
                    imageAvata.setImageLink("img/img_avata/female.jpg");
                } else {
                    imageAvata.setImageLink("img/img_avata/male.jpg");
                }
                session.setAttribute("avataAccount", imageAvata);
            } // neu pic la anh bt
            else {
                File sourceFolder = new File("C:\\Users\\HangNT\\Downloads");
                // targetFolder: thu muc dich duoc copy den
                File targetFolder = new File("E:\\Form 4-Fall 2019\\Web-Based Java Applications(PRJ321)\\JavaWebOfDuy\\2.Assignment\\Project1_SellProduct\\MAC_COSMETIC_F\\MAC_COSMETIC_SQLServer\\web\\img\\img_avata");
                // copy vao project admin
                //  File targetFolderAdmin = new File("E:\\Form 4-Fall 2019\\Web-Based Java Applications(PRJ321)\\JavaWebOfDuy\\2.Assignment\\Project1_SellProduct\\MAC_COSMETIC_F\\ADMIN_MAC_COSMETIC_SQLSERVER\\web\\img\\img_avata");

                // goi phuong thuc copy
                CopyImage.copyFolder(sourceFolder, targetFolder);
                //   CopyImage.copyFolder(sourceFolder, targetFolderAdmin);

                // chen link vao DB
                // check xem co update anh ko
                //  update
                if (!imageLink.isEmpty()) {
                    String newImageLink = "img/img_avata/" + imageLink;
                    //  System.out.println(newImageLink);

                    // update
                    session.removeAttribute("avataAccount");
                    boolean update = new ImageAvataDao().updateImageLink(user.getId(), newImageLink);
                    // System.out.println(update);
                    ImageAvata imageAvata2 = new ImageAvataDao().getOneByAccountDetail(user.getId());
                    //System.out.println(imageAvata2);
                    session.setAttribute("avataAccount", imageAvata2);
                }// user not update image=> old image
                else {
                    session.setAttribute("avataAccount", imageAvata);
                }
            }
            if (testUpdate) {
                if (testUpdateAccount) {
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("thongtincanhan.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
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
