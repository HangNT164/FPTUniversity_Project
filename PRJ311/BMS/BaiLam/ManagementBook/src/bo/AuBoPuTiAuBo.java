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
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HangNT
 */
public class AuBoPuTiAuBo {

    public void showResult(DefaultTableModel dtm, JTable table, List<AuBoPuTiAu> listSearch, String key, int index) {
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
            default:
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
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int stt = 0;
        for (AuBoPuTiAu s : lists) {

            Object[] rowData2 = new Object[]{
                "" + ++stt, "" + s.getTitle_id(), "" + s.getTitle(), "" + s.getPublishers(),
                "" + s.getAuthors(), "" + s.getNotes()
            };
            ((DefaultTableModel) table.getModel()).addRow(rowData2);
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

    public void removeBooks(AuBoPuTiAu au) {
        boolean testRemoveTiAu = new TitleAuthorDao().delete(au.getTitle_id());
        boolean testRemoveBook = new BooksDao().delete(au.getTitle_id());
        if (testRemoveTiAu&&testRemoveBook) {
            JOptionPane.showMessageDialog(null, "Delete success");
        } else {
            JOptionPane.showMessageDialog(null, "Delete fail");
        }  
    }
}
