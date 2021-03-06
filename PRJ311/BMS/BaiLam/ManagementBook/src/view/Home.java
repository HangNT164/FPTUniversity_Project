/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bo.AuBoPuTiAuBo;
import bo.UsersBo;
import dao.AuBoPuTiAuDao;
import dao.UsersDao;
import entity.AuBoPuTiAu;
import entity.Users;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import util.FormController;
import view.dialog.AddBook;
import view.dialog.Drashboard;
import view.dialog.ViewDetaiAccount;
import view.dialog.ViewDetailBook;


/**
 *
 * @author HangNT
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    private final Locale locale;
    private String drashboard, showAccount, showBook, addBook, search, exit;

    private void updateGui(Locale loc) {
        String url = "resource/languages";
        ResourceBundle rb = ResourceBundle.getBundle(url, loc);
        // de doc
        String home = rb.getString("home.home");
        exit = rb.getString("home.exit");
        drashboard = rb.getString("home.Drashboard");
        showAccount = rb.getString("home.ShowAccount");
        showBook = rb.getString("home.ShowBook");
        addBook = rb.getString("home.AddBook");
        search = rb.getString("home.Search");
        String title = rb.getString("home");
        // update
        txtTitle.setText(home);
        txtExit.setText(exit);
        btnDrashboard.setText(drashboard);
        btnShowAccount.setText(showAccount);
        btnShowBook.setText(showBook);
        btnAdd.setText(addBook);
        btnSearch.setText(search);
        this.setTitle(title);

    }
    private final AuBoPuTiAuBo auBoPuTiAuBo = new AuBoPuTiAuBo();
    private final List<AuBoPuTiAu> listAu = new AuBoPuTiAuDao().getAll();
    private final List<Users> listUser = new UsersDao().getAll();
    private final UsersBo usersBo = new UsersBo();

  
    public JTable getTbViewBooks() {
        return tbViewBooks;
    }

    public Home(String username, Locale locale) {
        initComponents();
        txtHiName.setText(username);
        jPanel4.setVisible(false);
        this.locale = locale;
        updateGui(locale);
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("E:\\Form 3-Summer 2019\\Desktop Java Applications(PRJ311)\\JavaSwingOfDuy\\02-Assigment\\ManagementStudent\\img\\bann.jpg");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jPanel2 = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        txtHiName = new javax.swing.JLabel();
        txtExit = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnDrashboard = new javax.swing.JLabel();
        btnShowAccount = new javax.swing.JLabel();
        btnShowBook = new javax.swing.JLabel();
        btnAdd = new javax.swing.JLabel();
        btnSearch = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnAsc = new javax.swing.JLabel();
        btnDesc = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbViewAccount = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbViewBooks = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home ");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        txtTitle.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(255, 255, 255));
        txtTitle.setText("Home");
        txtTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtHiName.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        txtHiName.setForeground(new java.awt.Color(255, 255, 255));
        txtHiName.setText("-------------");

        txtExit.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        txtExit.setForeground(new java.awt.Color(255, 255, 255));
        txtExit.setText("Exit");
        txtExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtHiName)
                .addGap(50, 50, 50)
                .addComponent(txtExit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txtTitle)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExit)
                    .addComponent(txtHiName))
                .addGap(23, 23, 23))
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        btnDrashboard.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        btnDrashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDrashboard.setText("Drashboard");
        btnDrashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDrashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDrashboardMouseClicked(evt);
            }
        });

        btnShowAccount.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        btnShowAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnShowAccount.setText("Show Account");
        btnShowAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShowAccountMouseClicked(evt);
            }
        });

        btnShowBook.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        btnShowBook.setForeground(new java.awt.Color(255, 255, 255));
        btnShowBook.setText("Show Book");
        btnShowBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShowBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShowBookMouseClicked(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add Book");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnDrashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnShowAccount)
                .addGap(91, 91, 91)
                .addComponent(btnShowBook)
                .addGap(128, 128, 128)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(84, 84, 84))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDrashboard)
                    .addComponent(btnShowAccount)
                    .addComponent(btnShowBook)
                    .addComponent(btnAdd)
                    .addComponent(btnSearch))
                .addGap(37, 37, 37))
        );

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));

        btnAsc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAsc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAscMouseClicked(evt);
            }
        });

        btnDesc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDesc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDescMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnAsc, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDesc)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDesc)
                    .addComponent(btnAsc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setPreferredSize(new java.awt.Dimension(960, 400));

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(930, 300));
        jScrollPane2.setVerifyInputWhenFocusTarget(false);

        tbViewAccount.setBackground(new java.awt.Color(51, 51, 51));
        tbViewAccount.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        tbViewAccount.setForeground(new java.awt.Color(153, 153, 153));
        tbViewAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Username", "DisplayName", "Description"
            }
        ));
        tbViewAccount.setToolTipText("");
        tbViewAccount.setGridColor(new java.awt.Color(102, 102, 102));
        tbViewAccount.setPreferredSize(new java.awt.Dimension(930, 270));
        tbViewAccount.setRowHeight(28);
        tbViewAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbViewAccountMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbViewAccount);
        if (tbViewAccount.getColumnModel().getColumnCount() > 0) {
            tbViewAccount.getColumnModel().getColumn(0).setMinWidth(80);
            tbViewAccount.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbViewAccount.getColumnModel().getColumn(0).setMaxWidth(80);
            tbViewAccount.getColumnModel().getColumn(1).setMinWidth(150);
            tbViewAccount.getColumnModel().getColumn(1).setPreferredWidth(150);
            tbViewAccount.getColumnModel().getColumn(1).setMaxWidth(150);
            tbViewAccount.getColumnModel().getColumn(2).setMinWidth(200);
            tbViewAccount.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbViewAccount.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(930, 300));
        jScrollPane1.setVerifyInputWhenFocusTarget(false);

        tbViewBooks.setBackground(new java.awt.Color(51, 51, 51));
        tbViewBooks.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        tbViewBooks.setForeground(new java.awt.Color(153, 153, 153));
        tbViewBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "BookID", "Book Title", "Publisher", "Authors", "Notes"
            }
        ));
        tbViewBooks.setToolTipText("");
        tbViewBooks.setGridColor(new java.awt.Color(102, 102, 102));
        tbViewBooks.setPreferredSize(new java.awt.Dimension(930, 270));
        tbViewBooks.setRowHeight(28);
        tbViewBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbViewBooksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbViewBooks);
        if (tbViewBooks.getColumnModel().getColumnCount() > 0) {
            tbViewBooks.getColumnModel().getColumn(0).setMinWidth(100);
            tbViewBooks.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbViewBooks.getColumnModel().getColumn(0).setMaxWidth(100);
            tbViewBooks.getColumnModel().getColumn(1).setMinWidth(100);
            tbViewBooks.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbViewBooks.getColumnModel().getColumn(1).setMaxWidth(100);
            tbViewBooks.getColumnModel().getColumn(2).setMinWidth(150);
            tbViewBooks.getColumnModel().getColumn(2).setPreferredWidth(150);
            tbViewBooks.getColumnModel().getColumn(2).setMaxWidth(150);
            tbViewBooks.getColumnModel().getColumn(3).setMinWidth(150);
            tbViewBooks.getColumnModel().getColumn(3).setPreferredWidth(150);
            tbViewBooks.getColumnModel().getColumn(3).setMaxWidth(50);
            tbViewBooks.getColumnModel().getColumn(4).setMinWidth(250);
            tbViewBooks.getColumnModel().getColumn(4).setPreferredWidth(250);
            tbViewBooks.getColumnModel().getColumn(4).setMaxWidth(250);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(70, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1006, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(38, 38, 38)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(28, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(83, 83, 83)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1114, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDrashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDrashboardMouseClicked
        // TODO add your handling code here:
        txtTitle.setText(drashboard);
        jPanel4.setVisible(false);
        FormController.show(new Drashboard(this, true));
    }//GEN-LAST:event_btnDrashboardMouseClicked

    private void btnShowAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowAccountMouseClicked
        // TODO add your handling code here:
        txtTitle.setText(showAccount);
        jPanel4.setVisible(true);
        jScrollPane1.setVisible(false);
        jScrollPane2.setVisible(true);
        usersBo.displayTable(tbViewAccount, listUser);
    }//GEN-LAST:event_btnShowAccountMouseClicked

    private void btnShowBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowBookMouseClicked
        // TODO add your handling code here:
        txtTitle.setText(showBook);
        jPanel4.setVisible(true);
        jScrollPane2.setVisible(false);
        jScrollPane1.setVisible(true);
        List<AuBoPuTiAu> lists = new AuBoPuTiAuDao().getAll();
        auBoPuTiAuBo.displayTable(tbViewBooks, lists);
    }//GEN-LAST:event_btnShowBookMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        txtTitle.setText(addBook);
        jPanel4.setVisible(false);
        AddBook addBooks = new AddBook(this, true, txtHiName.getText(), locale);
        addBooks.addWindowListener(getAction);
        FormController.show(addBooks);
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // TODO add your handling code here:
        txtTitle.setText(search);
        jPanel4.setVisible(false);
        FormController.show(new Search(txtHiName.getText(), locale));
        this.dispose();
    }//GEN-LAST:event_btnSearchMouseClicked

    private void txtExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtExitMouseClicked
        // TODO add your handling code here:
        txtTitle.setText(exit);
        int number = new AuBoPuTiAuBo().choiceFunction("Question ",
                "Do you want to close program?", "Yes", "No", "Cancel");
        new AuBoPuTiAuBo().processFunction(this, number);
    }//GEN-LAST:event_txtExitMouseClicked
    WindowAdapter getAction = new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            new AuBoPuTiAuBo().displayTable(tbViewBooks, listAu);
        }

    };
    private void btnDescMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescMouseClicked
        // TODO add your handling code here:
        if (txtTitle.getText().equals("Show Account")) {
            listUser.sort(Comparator.comparing(Users::getUserName).reversed());
            usersBo.displayTable(tbViewAccount, listUser);
        } else {
            listAu.sort(Comparator.comparing(AuBoPuTiAu::getAu_id).reversed());
            auBoPuTiAuBo.displayTable(tbViewBooks, listAu);
        }
    }//GEN-LAST:event_btnDescMouseClicked

    private void btnAscMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAscMouseClicked
        // TODO add your handling code here:
        if (txtTitle.getText().equals("Show Account")) {
            listUser.sort(Comparator.comparing(Users::getUserName));
            usersBo.displayTable(tbViewAccount, listUser);
        } else {
            listAu.sort(Comparator.comparing(AuBoPuTiAu::getAu_id));
            auBoPuTiAuBo.displayTable(tbViewBooks, listAu);
        }
    }//GEN-LAST:event_btnAscMouseClicked

    private void tbViewBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbViewBooksMouseClicked
        int index = tbViewBooks.getSelectedRow();
        List<AuBoPuTiAu>listAuBo=new AuBoPuTiAuDao().getAll();
        FormController.show(new ViewDetailBook(this, true, txtHiName.getText(), listAuBo.get(index), locale));
    }//GEN-LAST:event_tbViewBooksMouseClicked

    private void tbViewAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbViewAccountMouseClicked
        // TODO add your handling code here:
        int index = tbViewAccount.getSelectedRow();
        TableModel model = tbViewAccount.getModel();
        String rollNumber = model.getValueAt(index, 1).toString().trim();
        Users users=new UsersDao().getOne(rollNumber);
        FormController.show(new ViewDetaiAccount(this, true, txtHiName.getText(), users, locale));
    }//GEN-LAST:event_tbViewAccountMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAdd;
    private javax.swing.JLabel btnAsc;
    private javax.swing.JLabel btnDesc;
    private javax.swing.JLabel btnDrashboard;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel btnShowAccount;
    private javax.swing.JLabel btnShowBook;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbViewAccount;
    private javax.swing.JTable tbViewBooks;
    private javax.swing.JLabel txtExit;
    private javax.swing.JLabel txtHiName;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
