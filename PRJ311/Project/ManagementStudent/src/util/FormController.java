/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;

/**
 *
 * @author HangNT
 */
public class FormController {

    public static void show(Component c) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace(System.out);
        }
        // nghia la thread la cac thanhphan cua gui muon show len dc load het da
        java.awt.EventQueue.invokeLater(() -> {
            DragListener dragListener=new DragListener();
            c.addMouseListener(dragListener);
            c.addMouseMotionListener(dragListener);
            c.setVisible(true);
        });
    }
}
