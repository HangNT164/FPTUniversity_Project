/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.chart;

import dao.OrderDao;
import dao.ProductDao;
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

/**
 *
 * @author HangNT
 */
@WebServlet(name = "ChartController", urlPatterns = {"/chart"})
public class ChartController extends HttpServlet {

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

            int tt1 = new OrderDao().getSum("01", listO);
            int tt2 = new OrderDao().getSum("02", listO);
            int tt3 = new OrderDao().getSum("03", listO);
            int tt4 = new OrderDao().getSum("04", listO);
            int tt5 = new OrderDao().getSum("05", listO);
            int tt6 = new OrderDao().getSum("06", listO);
            int tt7 = new OrderDao().getSum("07", listO);
            int tt8 = new OrderDao().getSum("08", listO);
            int tt9 = new OrderDao().getSum("09", listO);
            int tt10 = new OrderDao().getSum("10", listO);
            int tt11 = new OrderDao().getSum("11", listO);
            int tt12 = new OrderDao().getSum("12", listO);

            List<Product> list = new ProductDao().getAll();
            int count1 = 0, count2 = 0, count3 = 0;
            for (Product p : list) {
                if (p.getSellPrice() <= 300000) {
                    count1++;
                } else if (p.getSellPrice() > 300000 && p.getSellPrice() < 600000) {
                    count2++;
                } else {
                    count3++;
                }
            }

            request.setAttribute("c1", count1);
            request.setAttribute("c2", count2);
            request.setAttribute("c3", count3);

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

            request.setAttribute("tt1", tt1);
            request.setAttribute("tt2", tt2);
            request.setAttribute("tt3", tt3);
            request.setAttribute("tt4", tt4);
            request.setAttribute("tt5", tt5);
            request.setAttribute("tt6", tt6);
            request.setAttribute("tt7", tt7);
            request.setAttribute("tt8", tt8);
            request.setAttribute("tt9", tt9);
            request.setAttribute("tt10", tt10);
            request.setAttribute("tt11", tt11);
            request.setAttribute("tt2", tt12);

            request.getRequestDispatcher("chart.jsp").forward(request, response);
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
