/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.MyMail;
import entity.MailMessage;
import entity.SMTPServer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HangNT
 */
@WebServlet(name = "ForgotPassword", urlPatterns = {"/forgot"})
public class ForgotPassword extends HttpServlet {

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
            String email = request.getParameter("email");
            SMTPServer sMTPServer = new SMTPServer("smtp.gmail.com", "TLS", "587");
            String from = "thaitnfx01652@funix.edu.vn";
            String password = "35740112";
            Session session = new MyMail().getMailSession(sMTPServer, from, password);

            // tao mang random gui code
            String mess = "";
            HttpSession s = request.getSession();
            Random rand = new Random();
            // mang chu hoa
            List<Character> listHoa = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                listHoa.add((char) (65 + rand.nextInt(3)));
            }
            mess = String.valueOf(listHoa.get(0));
            mess += String.valueOf(listHoa.get(1));
            // mang chu thuong
            List<Character> listsChar = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                listsChar.add((char) (97 + rand.nextInt(3)));
            }
            mess += String.valueOf(listsChar.get(0));
            mess += String.valueOf(listsChar.get(1));
            mess += String.valueOf(listsChar.get(2));

            // mang so
            List<Integer> lists = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                lists.add(rand.nextInt(10));
            }
            // mess
            mess += String.valueOf(lists.get(0));
            mess += String.valueOf(lists.get(1));
            mess += String.valueOf(lists.get(2));
            mess += String.valueOf(lists.get(3));
            mess += String.valueOf(lists.get(4));
            //System.out.println(mess);
            
            s.setAttribute("mailcode", mess);
            s.setAttribute("mail", email);
            MailMessage mm = new MailMessage(from, email, "Send code", mess);
            boolean sendMail;
            try {
                sendMail = new MyMail().sendMail(mm, session);
                if (sendMail) {
                    request.getRequestDispatcher("quenmatkhaunhapso.jsp").forward(request, response);
                } else {
                    request.setAttribute("mess", "Can't send code!!");
                    request.getRequestDispatcher("quenmatkhaun.jsp").forward(request, response);
                }
            } catch (Exception ex) {
                ex.printStackTrace(System.out);
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
