/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dialog.AboutNotePad;
import dialog.MyFont;
import dialog.MyReplace;
import dialog.MySearch;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author HangNT
 */
public class MyNotePad extends javax.swing.JFrame {

    /**
     * Creates new form MyNotePad
     */
    public MyNotePad() {
        initComponents();
    }

    public JTextArea getTextArea() {
        return txtView;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtView = new javax.swing.JTextArea();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jmnNew = new javax.swing.JCheckBoxMenuItem();
        jmnOpen = new javax.swing.JMenuItem();
        jmnSave = new javax.swing.JMenuItem();
        jmnSaveAs = new javax.swing.JMenuItem();
        jmnExit = new javax.swing.JMenuItem();
        jmnFind = new javax.swing.JMenu();
        jmnPaste = new javax.swing.JMenuItem();
        jmnCopy = new javax.swing.JMenuItem();
        jmnSearch = new javax.swing.JMenuItem();
        jmnReplace = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmnFont = new javax.swing.JMenuItem();
        jmnZoom = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        btnZoomOut = new javax.swing.JMenuItem();
        btnZoomIn = new javax.swing.JMenuItem();
        jmnWiewHelp = new javax.swing.JMenu();
        jmnHelp = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My NodePad");

        txtView.setColumns(20);
        txtView.setRows(5);
        jScrollPane2.setViewportView(txtView);

        jMenuBar2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jMenu3.setText("File");

        jmnNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jmnNew.setText("New");
        jmnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnNewActionPerformed(evt);
            }
        });
        jMenu3.add(jmnNew);

        jmnOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jmnOpen.setText("Open");
        jmnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnOpenActionPerformed(evt);
            }
        });
        jMenu3.add(jmnOpen);

        jmnSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jmnSave.setText("Save");
        jmnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnSaveActionPerformed(evt);
            }
        });
        jMenu3.add(jmnSave);

        jmnSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jmnSaveAs.setText("Save as");
        jmnSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnSaveAsActionPerformed(evt);
            }
        });
        jMenu3.add(jmnSaveAs);

        jmnExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jmnExit.setText("Exit");
        jmnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnExitActionPerformed(evt);
            }
        });
        jMenu3.add(jmnExit);

        jMenuBar2.add(jMenu3);

        jmnFind.setText("Edit");

        jmnPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jmnPaste.setText("Paste");
        jmnFind.add(jmnPaste);

        jmnCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jmnCopy.setText("Copy");
        jmnFind.add(jmnCopy);

        jmnSearch.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jmnSearch.setText("Search");
        jmnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnSearchActionPerformed(evt);
            }
        });
        jmnFind.add(jmnSearch);

        jmnReplace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jmnReplace.setText("Replace");
        jmnReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnReplaceActionPerformed(evt);
            }
        });
        jmnFind.add(jmnReplace);

        jMenuBar2.add(jmnFind);

        jMenu5.setText("Format");

        jmnFont.setText("Font");
        jmnFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnFontActionPerformed(evt);
            }
        });
        jMenu5.add(jmnFont);

        jMenuBar2.add(jMenu5);

        jmnZoom.setText("View");

        jMenu1.setText("Zoom");

        btnZoomOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_EQUALS, java.awt.event.InputEvent.CTRL_MASK));
        btnZoomOut.setText("Zoom out");
        btnZoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomOutActionPerformed(evt);
            }
        });
        jMenu1.add(btnZoomOut);

        btnZoomIn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_MINUS, java.awt.event.InputEvent.CTRL_MASK));
        btnZoomIn.setText("Zoom in");
        btnZoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomInActionPerformed(evt);
            }
        });
        jMenu1.add(btnZoomIn);

        jmnZoom.add(jMenu1);

        jMenuBar2.add(jmnZoom);

        jmnWiewHelp.setText("Help");

        jmnHelp.setText("About Notepad");
        jmnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnHelpActionPerformed(evt);
            }
        });
        jmnWiewHelp.add(jmnHelp);

        jMenuBar2.add(jmnWiewHelp);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnNewActionPerformed
        // TODO add your handling code here:
        if (!txtView.getText().isEmpty()) {
            Object[] options = {"Save",
                "Don't save", "Cancel"};
            int n = JOptionPane.showOptionDialog(null,
                    "Do you want to save change to Untiled?",
                    "Notepad",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, //do not use a custom Icon
                    options, //the titles of buttons
                    options[0]); //default button title
            switch (n) {
                case 0: {
                    new MyNotePad().jmnSaveAsActionPerformed(evt);
                    break;
                }
                case 1: {
                    txtView.setText("");
                    break;
                }
                case 2: {
                    break;
                }
            }
        }

    }//GEN-LAST:event_jmnNewActionPerformed

    private void jmnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnOpenActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser();
            jfc.setMultiSelectionEnabled(false);
            // cau lenh cho nguoi dung nhap : mieu ta +nhung duoi file co the chon
            jfc.setFileFilter(new FileNameExtensionFilter("Text File", "txt", "java", "html","sql"));
            if (jfc.showOpenDialog(MyNotePad.this) == JFileChooser.APPROVE_OPTION) {
                File f = jfc.getSelectedFile();
                RandomAccessFile raf = new RandomAccessFile(f, "r");
                String s;
                // doc file 
                while (true) {
                    s = raf.readLine(); // doc tung dong 1 
                    if (s == null) {
                        break;
                    }
                    txtView.append(s + "\n");
                }
            }
        } catch (HeadlessException | IOException ex) {
        }
    }//GEN-LAST:event_jmnOpenActionPerformed

    private void jmnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnSaveAsActionPerformed
        // TODO add your handling code here:
        JTextArea textArea = null;
        JButton save = null;
        JFileChooser fileChooser = new JFileChooser();
        int retval = fileChooser.showSaveDialog(save);
        if (retval == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (file == null) {
                return;
            }
            if (!file.getName().toLowerCase().endsWith(".txt")) {
                file = new File(file.getParentFile(), file.getName() + ".txt");
            }
            try {
                textArea.write(new OutputStreamWriter(new FileOutputStream(file),
                        "utf-8"));
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
            }
        }
    }//GEN-LAST:event_jmnSaveAsActionPerformed

    private void jmnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnSaveActionPerformed
        // TODO add your handling code here:
        new MyNotePad().jmnSaveAsActionPerformed(evt);
    }//GEN-LAST:event_jmnSaveActionPerformed

    private void jmnFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnFontActionPerformed
        try {
            // TODO add your handling code here:
            MyFont myFont = new MyFont(this, true);
            myFont.setVisible(true);
            txtView.setFont(myFont.getNewText());
        } catch (Exception e) {
            Font font = new Font(txtView.getFont().getFamily(), txtView.getFont().getStyle(), txtView.getFont().getSize());
            txtView.setFont(font);
        }

    }//GEN-LAST:event_jmnFontActionPerformed

    private void jmnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnHelpActionPerformed
        // TODO add your handling code here:
        AboutNotePad aboutNotePad = new AboutNotePad(this, true);
        aboutNotePad.setVisible(true);
    }//GEN-LAST:event_jmnHelpActionPerformed

    private void jmnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jmnExitActionPerformed

    private void btnZoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomInActionPerformed
        // TODO add your handling code here:
        Font font = txtView.getFont();
        if (font.getSize() >= 8) {
            txtView.setFont(new Font(font.getFamily(), font.getStyle(), font.getSize() - 5));
        }
    }//GEN-LAST:event_btnZoomInActionPerformed

    private void btnZoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomOutActionPerformed
        // TODO add your handling code here:
        Font font = txtView.getFont();
        if (font.getSize() <= 100) {
            txtView.setFont(new Font(font.getFamily(), font.getStyle(), font.getSize() + 5));
        }

    }//GEN-LAST:event_btnZoomOutActionPerformed

    private void jmnReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnReplaceActionPerformed
        // TODO add your handling code here:
        MyReplace myReplace = new MyReplace(this, true, txtView);
        myReplace.setVisible(true);

    }//GEN-LAST:event_jmnReplaceActionPerformed

    private void jmnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnSearchActionPerformed
        // TODO add your handling code here:
        MySearch mySearch = new MySearch(this, true, txtView);
        mySearch.setVisible(true);
    }//GEN-LAST:event_jmnSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windonws".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyNotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyNotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyNotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyNotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MyNotePad().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnZoomIn;
    private javax.swing.JMenuItem btnZoomOut;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem jmnCopy;
    private javax.swing.JMenuItem jmnExit;
    private javax.swing.JMenu jmnFind;
    private javax.swing.JMenuItem jmnFont;
    private javax.swing.JMenuItem jmnHelp;
    private javax.swing.JCheckBoxMenuItem jmnNew;
    private javax.swing.JMenuItem jmnOpen;
    private javax.swing.JMenuItem jmnPaste;
    private javax.swing.JMenuItem jmnReplace;
    private javax.swing.JMenuItem jmnSave;
    private javax.swing.JMenuItem jmnSaveAs;
    private javax.swing.JMenuItem jmnSearch;
    private javax.swing.JMenu jmnWiewHelp;
    private javax.swing.JMenu jmnZoom;
    private javax.swing.JTextArea txtView;
    // End of variables declaration//GEN-END:variables
}