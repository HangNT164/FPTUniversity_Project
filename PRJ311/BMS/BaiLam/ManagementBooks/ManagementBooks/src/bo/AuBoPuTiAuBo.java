/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dao.AuBoPuTiAuDao;
import dao.BooksDao;
import dao.TitleAuthorDao;
import entity.AuBoPuTiAu;
import entity.Books;
import java.awt.Component;
import java.util.List;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import view.dialog.ViewDetailBook;

/**
 *
 * @author HangNT
 */
public class AuBoPuTiAuBo {

    public void showResult(JTable table, List<AuBoPuTiAu> listSearch, String key, int index) {
        switch (index) {
            case 0:
                listSearch = new AuBoPuTiAuDao().getAllBy("books.title_id", key);
                break;
            case 1:
                listSearch = new AuBoPuTiAuDao().getAllBy("title", key);
                break;
            case 2:
                listSearch = new AuBoPuTiAuDao().getAllBy("pub_name", key);
                break;
            case 3:
                listSearch = new AuBoPuTiAuDao().getAllBy("au_name", key);
                break;
            case 4:
                listSearch = new AuBoPuTiAuDao().getAllBy("notes", key);
                break;
            case 5:
                listSearch = new AuBoPuTiAuDao().getAll();
                break;
        }
        displayTable(table, listSearch);
    }

    public int choiceFunction(String title, String question, Object... objects) {
        Object[] options = new Object[objects.length];
        System.arraycopy(objects, 0, options, 0, objects.length);
        int n = JOptionPane.showOptionDialog(null,
                question,
                title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, //do not use a custom Icon
                options, //the titles of buttons
                options[0]); //default button title
        return n;
    }

    public void displayTable(JTable table, List<AuBoPuTiAu> lists) {
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
        int stt = 0;
        for (AuBoPuTiAu s : lists) {
            if (table.getModel().getRowCount() > 0 && s.getTitle_id().equals(table.getModel().getValueAt(table.getModel().getRowCount() - 1, 1))) {
                table.getModel().setValueAt(table.getModel().getValueAt(table.getModel().getRowCount() - 1, 4) + ", "
                        + s.getAuthors(), table.getModel().getRowCount() - 1, 4);
            } else {
//                    ((DefaultTableModel) table.getModel()).addRow(s.toDataRow());
                Object[] rowData2 = new Object[]{
                    "" + ++stt, "" + s.getTitle_id(), "" + s.getTitle(), "" + s.getPublishers(),
                    "" + s.getAuthors(), "" + s.getNotes()
                };
                ((DefaultTableModel) table.getModel()).addRow(rowData2);
            }
//            
        }
    }

    public void processFunction(Component jFrame, int number) {
        switch (number) {
            case 0: {
                jFrame.setVisible(false);
                break;
            }
            case 2: {
                break;
            }
            case 1: {
                break;
            }
        }
    }

    public void searchBook(JTable table, String text, Locale locale) {
        ViewDetailBook e = new ViewDetailBook(null, true, text, locale);
        int index = table.getSelectedRow(); // INDEX OF ROW
        String id = (String) table.getValueAt(index, 1);
        Books b = new BooksDao().getOne(id);
        AuBoPuTiAu df = new AuBoPuTiAu((String) table.getValueAt(index, 1),
                (String) table.getValueAt(index, 2),
                (String) table.getValueAt(index, 3),
                (String) table.getValueAt(index, 4),
                (String) table.getValueAt(index, 5));
        e.setEditObject(b, df);
        e.setSelectedOption();
        e.setVisible(true);
    }

    public void removeBooks(AuBoPuTiAu au) {
        boolean testRemoveTiAu = new TitleAuthorDao().delete(au.getTitle_id());
        boolean testRemoveBook = new BooksDao().delete(au.getTitle_id());
        if (testRemoveTiAu && testRemoveBook) {
            JOptionPane.showMessageDialog(null, "Delete success");
        } else {
            JOptionPane.showMessageDialog(null, "Delete fail");
        }
    }

    public void hideSomeThings(JComboBox jComboBox, JTextField jTextField, JLabel... jLabels) {
        jComboBox.setVisible(false);
        jTextField.setVisible(false);
        for (JLabel jLabel : jLabels) {
            jLabel.setVisible(false);
        }
    }

    public void showSomeThings(JComboBox jComboBox, JTextField jTextField, JLabel... jLabels) {
        jComboBox.setVisible(true);
        jTextField.setVisible(true);
        for (JLabel jLabel : jLabels) {
            jLabel.setVisible(true);
        }
    }

    public void showSomeThings(JLabel... jLabels) {
        for (JLabel jLabel : jLabels) {
            jLabel.setVisible(true);
        }
    }

    public void removeTable(JTable tableStudents) {
        while (tableStudents.getRowCount() > 0) {
            ((DefaultTableModel) tableStudents.getModel()).removeRow(0);
        }
    }
}
