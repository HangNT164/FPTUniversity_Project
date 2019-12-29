
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Order;
import entity.Product;
import entity.SubCate;

import java.util.ArrayList;
import java.util.List;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.SQLServerConnection;
import service.ProductService;

/**
 *
 * @author HangNT
 */
public class ProductDao implements ICommonDao<Product>, ProductCommonDao {

    private Product getValueProduct(ResultSet rs) {
        try {
            return Product.builder()
                    .id(rs.getInt(1))
                    .subCateID(rs.getInt(2))
                    .productName(rs.getString(3))
                    .color(rs.getString(4))
                    .quantity(rs.getInt(5))
                    .sellPrice(rs.getInt(6))
                    .orginPrice(rs.getInt(7))
                    .description(rs.getString(8))
                    .productCode(rs.getString(9))
                    .createDate(rs.getString(10))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private boolean setValueProduct(Product product, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.setObject(1, product.getSubCateID());
                ps.setObject(2, product.getProductName());
                ps.setObject(3, product.getColor());
                ps.setObject(4, product.getQuantity());
                ps.setObject(5, product.getSellPrice());
                ps.setObject(6, product.getOrginPrice());
                ps.setObject(7, product.getDescription());
                ps.setObject(8, product.getProductCode());
                return true;
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return false;
    }

    @Override
    public List<Product> getAll() {
        String query = "SELECT * FROM product WHERE deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<Product> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(getValueProduct(rs));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Product getOne(int id) {
        String query = "SELECT * FROM product WHERE id = ? AND deleted =0 ";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    return getValueProduct(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(Product product) {
        int check = 0;
        String query = "INSERT INTO product(subcate_id ,product_name ,"
                + "color ,quantity ,sell_price,orgin_price ,description,product_code)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            check = setValueProduct(product, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(int id, Product product) {
        int check = 0;
        String query = "UPDATE product SET subcate_id = ?, product_name = ?,"
                + " color = ?, quantity = ?, sell_price = ?,orgin_price=?, description= ?, "
                + "product_code= ?,create_date = ? WHERE id = ? AND deleted =0 ";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            setValueProduct(product, ps);
            if (ps != null) {
                ps.setObject(9, product.getCreateDate());
                ps.setObject(10, id);
            }
            check = setValueProduct(product, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean updateQuantity(int id, int newQuantity) {
        int check = 0;
        String query = "UPDATE product SET quantity = ? WHERE id = ? AND deleted = 0 ";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, newQuantity);
                ps.setObject(2, id);
                check = ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean updateTypeProduct(int id) {
        int check = 0;
        String query = "UPDATE product SET status_id = 3 WHERE id = ? AND deleted = 0 ";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, id);
                check = ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(int id) {
        int check = 0;
        String query = "UPDATE  product  SET deleted =1 WHERE id = ?";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, id);
                check = ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public List<Product> listProductBySubId(List<SubCate> listSubCates,
            List<Product> listProduct, int subID) {
        List<Product> lists = new ArrayList<>();
        for (SubCate subCate : listSubCates) {
            if (subCate.getId() == subID) {
                for (Product p : listProduct) {
                    if (p.getSubCateID() == subCate.getId()) {
                        lists.add(p);
                    }
                }
            }
        }
        return lists;
    }

    // chuyen trang get all
    @Override
    public List<Product> listProductInOnePageInAll(int page, int numberInAPage) {
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                CallableStatement cal = con.prepareCall("{call pagination(?,?)}")) {
            if (cal != null) {
                cal.setInt(1, page);
                cal.setInt(2, numberInAPage);
                ResultSet rs = cal.executeQuery();
                List<Product> newListProduct = new ArrayList<>();
                while (rs != null && rs.next()) {
                    newListProduct.add(getValueProduct(rs));
                }
                return newListProduct;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    // chuyen trang get by subCategory
    @Override
    public List<Product> listProductInOnePageInSubCategory(int page, int numberInAPage, int subCateID) {
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                CallableStatement cal = con.prepareCall("{call paginationCategory(?,?,?)}")) {
            if (cal != null) {
                cal.setInt(1, page);
                cal.setInt(2, numberInAPage);
                cal.setInt(3, subCateID);
                ResultSet rs = cal.executeQuery();
                List<Product> newListProduct = new ArrayList<>();
                while (rs != null && rs.next()) {
                    newListProduct.add(getValueProduct(rs));
                }
                return newListProduct;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Integer> getListPage(List<Product> listProduct, int number) {
        List<Integer> listPage = new ArrayList<>();
        double size = (double) listProduct.size() / (double) number;
        for (int i = 1; i <= Math.ceil(size); i++) {
            listPage.add(i);
        }
        return listPage;
    }

    // top 15 san pham moi
    @Override
    public List<Product> getAllNewProduct() {
        String query = "SELECT TOP 15* FROM product WHERE deleted =0  ORDER BY id DESC ";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<Product> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(getValueProduct(rs));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    // chuyen trang cua san pham moi
    @Override
    public List<Product> getListProductNew(int page, int numberInAPage) {
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                CallableStatement cal = con.prepareCall("{call paginationNew(?,?)}")) {
            if (cal != null) {
                cal.setInt(1, page);
                cal.setInt(2, numberInAPage);
                ResultSet rs = cal.executeQuery();
                List<Product> newListProduct = new ArrayList<>();
                while (rs != null && rs.next()) {
                    newListProduct.add(getValueProduct(rs));
                }
                return newListProduct;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Product> search(String text) {
        String query = "SELECT * FROM product WHERE product_name LIKE ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            ps.setObject(1, "%" + text + "%");
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<Product> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(getValueProduct(rs));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Product> getListProductSearch(int page, int numberInAPage, String text) {
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                CallableStatement cal = con.prepareCall("{call paginationSearch(?,?,?)}")) {
            if (cal != null) {
                cal.setInt(1, page);
                cal.setInt(2, numberInAPage);
                cal.setString(3, text);
                ResultSet rs = cal.executeQuery();
                List<Product> newListProduct = new ArrayList<>();
                while (rs != null && rs.next()) {
                    newListProduct.add(getValueProduct(rs));
                }
                return newListProduct;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Product> getListBuyMuch(int page, int numberInAPage) {
        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                CallableStatement cal = con.prepareCall("{call paginationBuyProductMax(?,?)}")) {
            if (cal != null) {
                cal.setInt(1, page);
                cal.setInt(2, numberInAPage);
                ResultSet rs = cal.executeQuery();
                List<Product> newListProduct = new ArrayList<>();
                while (rs != null && rs.next()) {
                    newListProduct.add(getValueProduct(rs));
                }
                return newListProduct;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Product> getAllBuyMax() {
        String query = "SELECT DISTINCT product.*\n"
                + "		FROM product,order_detail\n"
                + "		WHERE product.id=order_detail.product_id\n"
                + "		AND product.deleted=0\n"
                + "		AND order_detail.deleted=0\n"
                + "		AND order_detail.quantity>=3";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<Product> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(getValueProduct(rs));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public int addProductReturnId(Product p) {
        String query = "INSERT INTO [dbo].[product]\n"
                + "           ([subcate_id]\n"
                + "           ,[product_name]\n"
                + "           ,[color]\n"
                + "           ,[quantity]\n"
                + "           ,[sell_price]\n"
                + "           ,[orgin_price]\n"
                + "           ,[description]\n"
                + "           ,[product_code])\n"
              

                + "VALUES(?,?,?,?,?,?,?,?)";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS) : null;) {
            if (ps != null) {
                ps.setObject(1, p.getSubCateID());
                ps.setObject(2, p.getProductName());
                ps.setObject(3, p.getColor());
                ps.setObject(4, p.getQuantity());
                ps.setObject(5, p.getSellPrice());
                ps.setObject(6, p.getOrginPrice());
                ps.setObject(7, p.getDescription());
                ps.setObject(8, p.getProductCode());
          
          
                int isCheck = ps.executeUpdate();
                if (isCheck > 0) {
                    ResultSet rs = ps.getGeneratedKeys();
                    rs.next();
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    public static void main(String[] args) {
        Product p = Product.builder()
                .subCateID(10)
                .productName("2")
                .productCode("2")
                .color("4")
                .quantity(2)
                .description("6")
                .sellPrice(1000)
                .orginPrice(444)
                .build();

        boolean check = new ProductDao().update(29,p);
        System.out.println(check);

    }
}
