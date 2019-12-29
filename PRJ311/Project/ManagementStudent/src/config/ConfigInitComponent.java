/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author anhdt45
 */
public class ConfigInitComponent {

    public static void initJTextField(JTextField... list) {
        for (JTextField tf : list) {
            tf.setBorder(null);
            tf.setBorder(BorderFactory.createCompoundBorder(tf.getBorder(), BorderFactory.createEmptyBorder(0, 8, 0, 8)));
        }
    }

    public static void initJPasswordField(JPasswordField... list) {
        for (JPasswordField pf : list) {
            pf.setBorder(null);
            pf.setBorder(BorderFactory.createCompoundBorder(pf.getBorder(), BorderFactory.createEmptyBorder(0, 8, 0, 8)));
        }
    }

    public static void darkJPanelButton(JPanel... list) {

        for (JPanel panelButton : list) {
            panelButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    panelButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
                }

                @Override
                public void mouseExited(MouseEvent evt) {
                    panelButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
                }

                @Override
                public void mousePressed(MouseEvent evt) {
                    panelButton.setBackground(new java.awt.Color(120, 120, 120));
                }

                @Override
                public void mouseReleased(MouseEvent evt) {
                    panelButton.setBackground(new java.awt.Color(102, 102, 102));
                }
            });
        }
    }

    public static void linkJLabel(JLabel... list) {

        for (JLabel linkLabel : list) {
            linkLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent evt) {
                    linkLabel.setForeground(new java.awt.Color(204, 204, 204));
                }

                @Override
                public void mouseExited(MouseEvent evt) {
                    linkLabel.setForeground(new java.awt.Color(153, 153, 153));
                }
            });
        }
    }
}
