/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Account;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import jdbc.SQLServerConnection;
import util.BCrypt;

/**
 *
 * @author HangNT
 */
public class AccountDao implements ICommonDao<Account>, AccountCommonDao {

    private Account getValueAccount(ResultSet rs) {
        try {
            return Account.builder()
                    .id(rs.getInt(1))
                    .accountDetalId(rs.getInt(2))
                    .role_id(rs.getInt(3))
                    .email(rs.getString(4))
                    .password(rs.getString(5))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    private boolean setValueAccount(Account account, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.setObject(1, account.getAccountDetalId());
                ps.setObject(2, account.getEmail());
                ps.setObject(3, BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()));
                return true;
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return false;
    }

    @Override
    public List<Account> getAll() {
        String query = "SELECT * FROM account WHERE deleted = 0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ResultSet rs = ps.executeQuery();
                List<Account> list = new ArrayList<>();
                while (rs != null && rs.next()) {
                    list.add(getValueAccount(rs));
                }
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Account getOne(int id) {
        String query = "SELECT * FROM account where id = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs != null && rs.next()) {
                    return getValueAccount(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Account getOneByAccountDetailID(int id) {
        String query = "SELECT * FROM account where account_detail_id = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs != null && rs.next()) {
                    return getValueAccount(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean add(Account user) {
        int check = 0;
        String query = "INSERT INTO account(account_detail_id,email,password )"
                + "VALUES(?,?,?)";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            check = setValueAccount(user, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public int addAccountReturnId(Account account) {
        String query = "INSERT INTO account(account_detail_id,email,password )"
                + "VALUES(?,?,?)";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS) : null;) {
            if (ps != null) {
                ps.setObject(1, account.getAccountDetalId());
                ps.setObject(2, account.getEmail());
                ps.setObject(3, BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()));
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

    @Override
    public boolean update(int id, Account user) {
        int check = 0;
        String query = "UPDATE account SET account_detail_id = ?,"
                + "email =? ,password=? WHERE id = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            setValueAccount(user, ps);
            if (ps != null) {
                ps.setObject(4, id);
            }
            check = setValueAccount(user, ps) ? ps.executeUpdate() : 0;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updatePassword(int id, Account account) {
        int check = 0;
        String query = "UPDATE account SET password = ? WHERE id = ?";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, BCrypt.hashpw(account.getPassword(), BCrypt.gensalt()));
                ps.setObject(2, id);
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
        String query = "UPDATE account SET deleted = 1 WHERE id = ?";

        try (Connection con = SQLServerConnection.getConnection();
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

    // ham check login
    @Override
    public Account login(String email, String password) {
        String query = "SELECT * FROM account where email = ? AND deleted = 0 ";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, email);
                ResultSet rs = ps.executeQuery();
                if (rs != null && rs.next()) {
                    Account account = getValueAccount(rs);
                    // System.out.println(account.getPassword());
                    if (BCrypt.checkpw(password, account.getPassword())) {
                        return account;
                    }
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean isDulicapte(String email) {
        String sql = "SELECT * FROM account WHERE email = ? ";

        try (Connection con = SQLServerConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            if (ps != null) {
                ps.setObject(1, email);
            }
            ResultSet rs = ps != null ? ps.executeQuery() : null;

            if (rs != null) {
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out); //gom 2 viec la : no se print ra loi , va bao ra dong loi
        }
        return false;
    }

    public Account getOneByEmail(String email) {
        String query = "SELECT * FROM account where email = ? AND deleted =0";

        try (Connection con = SQLServerConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                ps.setObject(1, email);
                ResultSet rs = ps.executeQuery();
                while (rs != null && rs.next()) {
                    return getValueAccount(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        String s = BCrypt.hashpw("hangHANG88@", BCrypt.gensalt());
        boolean test = BCrypt.checkpw("hangHANG88@", s);
        System.out.println(test);
    }
}
