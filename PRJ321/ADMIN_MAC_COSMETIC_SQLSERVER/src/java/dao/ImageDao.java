/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Image;
import entity.Product;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.SQLServerConnection;

/**
 *
 * @author HangNT
 */
public class ImageDao implements ICommonDao<Image>, ImageCommonDao {

    private Image getValueImage(ResultSet rs) {
        try {
            return Image.builder()
                    .id(rs.getInt(1))
                    .productId(rs.getInt(2))
                    .imageLink(rs.getString(3))
                    .cover(rs.getBoolean(4))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private boolean setValueImage(Image image, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.setObject(1, image.getProductId());
                ps.setObject(2, image.getImageLink());
                ps.setObject(3, image.isCover());
                return true;
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return false;
    }

    @Override
    public List<Image> getAll() {
        String query = "SELECT * FROM images WHERE deleted =0 ";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<Image> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(getValueImage(rs));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Image getOne(int id) {
        String query = "SELECT * FROM images WHERE id = ? AND deleted = 0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    return getValueImage(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(Image image) {
        int check = 0;
        String query = "INSERT INTO images(product_id, image_link, cover)"
                + "VALUES(?, ?, ?, ?)";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            check = setValueImage(image, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean update(int id, Image image) {
        int check = 0;
        String query = "UPDATE images SET product_id = ?, image_link = ?, cover = ? WHERE id = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            setValueImage(image, ps);
            if (ps != null) {
                ps.setObject(4, id);
            }
            check = setValueImage(image, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean delete(int id) {
        int check = 0;
        String query = "UPDATE images SET deleted =1 WHERE id = ?";

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
    
        public boolean deleteKHAC(int id) {
        int check = 0;
        String query = "UPDATE images SET deleted = 1 ,cover =0 WHERE id = ?";

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

    public boolean deleteIdProduct(int id) {
        int check = 0;
        String query = "UPDATE images SET deleted = 1 WHERE product_id = ?";

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
    public List<String> getAllImageTrue(List<Product> lists) {
        String query = new ImageDao().getQueryCoverTrue(lists);

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<String> listImage = new ArrayList<>();
                if (rs != null) {
                    if (rs.next()) {
                        for (int i = 1; i <= lists.size(); i++) {
                            listImage.add(rs.getString(i));
                        }
                    }
                    return listImage;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<String> getAllImageFalse(List<Product> lists) {
        String query = new ImageDao().getQueryCoverFalse(lists);

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<String> listImage = new ArrayList<>();
                if (rs != null) {
                    if (rs.next()) {
                        for (int i = 1; i <= lists.size(); i++) {
                            listImage.add(rs.getString(i));
                        }
                    }
                    return listImage;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public List<Image> listAllImageByProductId(int productID) {
        String query = " SELECT images.* \n"
                + " FROM product,images\n"
                + " WHERE images.product_id=product.id\n"
                + " AND product.id=? AND product.deleted =0 AND images.deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setInt(1, productID);
                ResultSet rs = ps.executeQuery();
                List<Image> listImage = new ArrayList<>();
                while (rs != null && rs.next()) {
                    listImage.add(getValueImage(rs));
                }
                return listImage;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Image getImageCover(int id) {
        String query = "SELECT * FROM images where product_id = ? AND cover =1 AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    return getValueImage(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private String getQueryCoverTrue(List<Product> lists) {
        String result = "SELECT ";
        for (int i = 0; i < lists.size(); i++) {
            result += "t" + (i + 1) + ".c,";
        }
        result = result.substring(0, result.length() - 1) + " from ";
        for (int i = 0; i < lists.size(); i++) {
            result += "(SELECT image_link AS c FROM images WHERE product_id = "
                    + lists.get(i).getId() + " AND cover = 1 AND images.deleted = 0) as t" + (i + 1) + ",";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }

    private String getQueryCoverFalse(List<Product> lists) {
        String result = "SELECT ";
        for (int i = 0; i < lists.size(); i++) {
            result += "t" + (i + 1) + ".c,";
        }
        result = result.substring(0, result.length() - 1) + " from";
        for (int i = 0; i < lists.size(); i++) {
            result += "(SELECT image_link AS c FROM images WHERE product_id = "
                    + lists.get(i).getId() + " AND cover = 0 AND deleted =0) as t" + (i + 1) + ",";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }

    public boolean addlistImg(List<Image> images) {
        int[] arr = {};

        String query = "INSERT INTO images(product_id, image_link, cover) VALUES(?, ?, ?)";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = (con != null) ? con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS) : null;) {

            if (ps != null) {
                for (Image i : images) {
                    ps.setInt(1, i.getProductId());
                    ps.setString(2, i.getImageLink());
                    ps.setBoolean(3, i.isCover());

                    ps.addBatch();
                }
                arr = ps.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return arr.length > 0;
    }

    public static void main(String[] args) {
        Image im1 = Image.builder()
                .productId(27)
                .imageLink( "D:\\bla\\MAC_COSMETIC_SQLServer\\web\\img\\img_chi_tiet_san_pham\\img_do_trang_diem\\img_son\\sanpham1\\a.jpg")
                .cover(true)
                .build();
        Image im2 = Image.builder()
                .productId(27)
                .imageLink("D:\\bla\\MAC_COSMETIC_SQLServer\\web\\img\\img_chi_tiet_san_pham\\img_do_trang_diem\\img_son\\sanpham1\\nen.jpg")
                .cover(false)
                .build();

        List<Image> list = new ArrayList<>();
        list.add(im1);
        list.add(im2);

        System.out.println(new ImageDao().addlistImg(list));

      
        
    }
}
