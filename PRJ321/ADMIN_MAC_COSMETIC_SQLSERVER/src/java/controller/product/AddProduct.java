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
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import service.ProductService;
import service.SubCateService;

/**
 *
 * @author TuanNA
 */
@WebServlet(name = "AddProduct", urlPatterns = {"/add-product"})
public class AddProduct extends HttpServlet {

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
            boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
            if (!isMultiPart) {
                System.out.println("Error");
            } else {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List items = null;
                List<String> lsFileName = new ArrayList<>();

                try {
                    items = upload.parseRequest(request);
                } catch (FileUploadException e) {
                    System.err.println(e.getMessage());
                }

                Iterator iter = items.iterator();
                Hashtable params = new Hashtable();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    if (item.isFormField()) {
                        // convert to UTF-8
                        params.put(new String(item.getFieldName().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8),
                                new String(item.getString().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
                    } else {
                        try {
                            // get file name
                            String itemName = item.getName();
                            String fileName = itemName.substring(itemName.lastIndexOf("\\") + 1);
                            lsFileName.add(fileName);

//                            String readPart = getServletContext().getRe?alPath("/");
                            String partUpload = "D:\\bla\\MAC_COSMETIC_SQLServer\\web\\img\\img_chi_tiet_san_pham\\img_do_trang_diem\\img_son\\sanpham1\\" + fileName;

                            File saveFile = new File(partUpload);
                            item.write(saveFile);
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }
                }

                String code = (String) params.get("code");
                String name = (String) params.get("name");
                int intSubCate = Integer.parseInt((String) params.get("intSubCate"));
                System.out.println(intSubCate);
                String color = (String) params.get("color");
                System.out.println(color);
                int quantity = Integer.parseInt((String) params.get("quantity"));
                System.out.println(quantity);
                int orginP = Integer.valueOf((String) params.get("orginPrice"));
                System.out.println(orginP);
                int sellP = Integer.valueOf((String) params.get("sellPrice"));
                System.out.println(sellP);
                String des = (String) params.get("txtDescriptionProduct");

                Product p = Product.builder()
                        .subCateID(intSubCate)
                        .productName(name)
                        .productCode(code)
                        .color(color)
                        .quantity(quantity)
                        .description(des)
                        .sellPrice(sellP)
                        .orginPrice(orginP)
                        .build();

                List<Image> images = new ArrayList<>();

                int idProduct = new ProductDao().addProductReturnId(p);

                for (int i = 0; i < lsFileName.size(); i++) {
                    Image image = null;
                    if (i == 0) {
                        image = Image.builder()
                                .productId(idProduct)
                                .imageLink(lsFileName.get(i))
                                .cover(true)
                                .deleted(false)
                                .build();

                    } else {
                        image = Image.builder()
                                .productId(idProduct)
                                .imageLink(lsFileName.get(i))
                                .cover(false)
                                .deleted(false)
                                .build();
                    }
                    images.add(image);

                }

                for (Image image : images) {
                    image.setImageLink("img/img_chi_tiet_san_pham/img_do_trang_diem/img_son/sanpham1/" + image.getImageLink());
                }

                boolean a = new ImageDao().addlistImg(images);

                Status st = Status.builder()
                        .productId(idProduct)
                        .descriptionStatus(0)
                        .statusName("Sale")
                        .build();

                new StatusDao().add(st);

                List<Product> list = new ProductService().getAll();
                List<SubCate> listSubCategory = new SubCateService().getAll();

                request.setAttribute("listSubCategory", listSubCategory);
                request.setAttribute("listProduct", list);
                request.getRequestDispatcher("addProduct.jsp").forward(request, response);
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
