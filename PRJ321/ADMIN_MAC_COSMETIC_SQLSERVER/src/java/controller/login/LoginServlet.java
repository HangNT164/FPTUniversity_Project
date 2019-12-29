/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.login;

import dao.AccountDao;
import dao.CardDao;
import dao.ImageAvataDao;
import dao.OrderDao;
import entity.Account;
import entity.AccountDetail;
import entity.Card;
import entity.ImageAvata;
import entity.Order;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.AccountDetailService;
import service.AccountService;
import service.OrderService;
import service.ProductService;

/**
 *
 * @author TuanNA
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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

            String username = request.getParameter("txtEmail");
            String password = request.getParameter("txtPassword");

            // xac nhan tai khoan
            HttpSession session = request.getSession();
            Account account = new AccountDao().login(username.trim(), password.trim());
//            System.out.println(account);
            // khi account ton tai va quyen la admin
            if (account != null) {
                if (account.getRole_id() == 2) {
                    // duoc phep dang nhap
                    // lay anh
                    int accountDetailID = account.getAccountDetalId();
                    ImageAvata imageAvata = new ImageAvataDao().getOneByAccountDetail(accountDetailID);
                    AccountDetail accountDetail = new AccountDetailService().getOne(accountDetailID);
                    session.setAttribute("user", accountDetail);
                    session.setAttribute("avataAccount", imageAvata);
                    session.setAttribute("account", account);

                    // day list qua index.jsp
                    List<Product> listProduct = new ProductService().getAll();
                    List<Account> listAccount = new AccountService().getAll();
                    List<Order> listOrder = new OrderService().getAll();
                    List<Card> listOrderProcess = new CardDao().getAll();

                    List<Order> listO = new OrderDao().getAll();
                    int t1 = new OrderDao().getSumTienLai("01", listO);
                    int t2 = new OrderDao().getSumTienLai("02", listO);
                    int t3 = new OrderDao().getSumTienLai("03", listO);
                    int t4 = new OrderDao().getSumTienLai("04", listO);
                    int t5 = new OrderDao().getSumTienLai("05", listO);
                    int t6 = new OrderDao().getSumTienLai("06", listO);
                    int t7 = new OrderDao().getSumTienLai("07", listO);
                    int t8 = new OrderDao().getSumTienLai("08", listO);
                    int t9 = new OrderDao().getSumTienLai("09", listO);
                    int t10 = new OrderDao().getSumTienLai("10", listO);
                    int t11 = new OrderDao().getSumTienLai("11", listO);
                    int t12 = new OrderDao().getSumTienLai("12", listO);

                    request.setAttribute("t1", t1);
                    request.setAttribute("t2", t2);
                    request.setAttribute("t3", t3);
                    request.setAttribute("t4", t4);
                    request.setAttribute("t5", t5);
                    request.setAttribute("t6", t6);
                    request.setAttribute("t7", t7);
                    request.setAttribute("t8", t8);
                    request.setAttribute("t9", t9);
                    request.setAttribute("t10", t10);
                    request.setAttribute("t11", t11);
                    request.setAttribute("t2", t12);

                    // truyen sang index.jsp
                    session.setAttribute("product", listProduct);
                    session.setAttribute("account", listAccount);
                    session.setAttribute("order", listOrder);
                    session.setAttribute("card", listOrderProcess);

                    response.sendRedirect("index.jsp");
                } // tai khoan hop le nhung ko co quyen truy cap
                else {
                    // ban mess va chuyen sang quay lai trang login
                    session.setAttribute("mess", "Account don't have admin!! ");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } // neu account ko ton tai 
            else {
                session.setAttribute("mess", "Email or password not right ");
                request.getRequestDispatcher("login.jsp").forward(request, response);
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
