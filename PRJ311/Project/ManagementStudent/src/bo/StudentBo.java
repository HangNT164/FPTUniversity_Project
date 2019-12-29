/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import dao.StudentDao;
import entity.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HangNT
 */
public class StudentBo {

    StudentDao studentDao = new StudentDao();

    public String displayDulicate(boolean test) {
        if (test) {
            return "Dulicate Student!!";
        }
        return "Add Success!!";
    }

    public void clearInput(JTextField... jTextField) {
        for (JTextField j : jTextField) {
            j.setText("");
        }
    }

    public String addStudent(String rollNumber, String name, boolean gender,
            String email, String phoneNumber, String address) {
        if (studentDao.isDulicapte(rollNumber)) {
            return "Dulicapte Student";  
        }
        if(rollNumber==null||name==null||email==null||phoneNumber==null||address==null){
            return "Information not right";
        }
        Student student = new Student(rollNumber, name, gender, email, phoneNumber, address);
        if (studentDao.add(student)) {
            return "Add successful";
        } else {
            return "Add Fail";
        }

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

    public void removeStudent(DefaultTableModel dtm, int index, List<Student> listStudent) {
        dtm.removeRow(index);
        boolean test = new StudentDao().delete(listStudent.get(index).getRollNumber());
        if (test) {
            listStudent.remove(index);
            JOptionPane.showMessageDialog(null, "Delete success");
        } else {
            JOptionPane.showMessageDialog(null, "Delete fail");
        }
    }

    public void viewRemoveStudent(DefaultTableModel dtm, int index, List<Student> lists, int number, JTextField... jTextFields) {
        switch (number) {
            case 0: {
                removeStudent(dtm, index, lists);
                clearInput(jTextFields);
                break;
            }
            case 1: {
                break;
            }
        }
    }

    public String update(Student student, int id) {
        if (new StudentDao().update(student, id)) {
            return "Update success!!!";
        }
        return "Update fail!!!";
    }

    public void displayTableStudent(JTable table, List<Student> lists) {
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
        DefaultTableModel dtm = new DefaultTableModel();
        dtm = (DefaultTableModel) table.getModel();
        int stt = 0;
        for (Student s : lists) {
            Object[] rowData2 = new Object[]{
                "  " + ++stt, "  " + s.getRollNumber(), " " + s.getFullName(),
                s.isGender() == true ? "  Male" : " Female",
                " " + s.getEmail(), "  " + s.getPhoneNumber(), " " + s.getAddress()
            };
            ((DefaultTableModel) table.getModel()).addRow(rowData2);
        }
    }

    public void processFunction(JFrame jFrame, int number) {
        switch (number) {
            case 0: {
                jFrame.dispose();
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

    public void displayMess(String mess, Student student) {
        if (mess.equalsIgnoreCase("Add successful")) {
            JOptionPane.showMessageDialog(null, mess);
        } else {
            JOptionPane.showMessageDialog(null, mess);
        }
    }

    public List<Student> showResult(JTable table, String key, int index, Locale locale) {
        List<Student> listSearch = new ArrayList<>();
        switch (index) {
            case 0:
                listSearch = new StudentDao().getAllBy("roll_number", key);
                break;
            case 1:
                listSearch = new StudentDao().getAllBy("full_name", key);
                break;
            case 2:
                listSearch = new StudentDao().getAllBy("", key);
                break;

        }
        return listSearch;
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

    public List<Student> listStudentMale(List<Student> listStudent) {
        List<Student> listMale = new ArrayList<>();
        for (Student s : listStudent) {
            if (s.isGender()) {
                listMale.add(s);
            }
        }
        return listMale;
    }

    public List<Student> listStudentFemale(List<Student> listStudent) {
        List<Student> listFemale = new ArrayList<>();
        for (Student s : listStudent) {
            if (!s.isGender()) {
                listFemale.add(s);
            }
        }
        return listFemale;
    }

    public void removeTable(JTable tableStudents) {
        while (tableStudents.getRowCount() > 0) {
            ((DefaultTableModel) tableStudents.getModel()).removeRow(0);
        }
    }

    public static void main(String[] args) {
        String s = new StudentBo().addStudent("HE130639", "DFGSDF", true, "SGSDFGSDF",
                "0123456960", "ABC");
        System.out.println(s);
    }
}
