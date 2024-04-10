package org.example.view;

import org.example.view.dialog.DeleteDialog;
import org.example.view.dialog.DisplayDialog;
import org.example.view.dialog.InsertDialog;
import org.example.view.dialog.UpdateDialog;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JPanel jPanel;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mainFrame.setSize(425, 200);
                    mainFrame.setTitle("Main Frame");
                    mainFrame.setLocationRelativeTo(null);
                    mainFrame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public MainFrame() {

        jPanel = new JPanel();

        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jPanel);
        jPanel.setLayout(null);


        JButton btnInsert = new JButton("Insert");
        btnInsert.setBounds(36, 23, 100, 25);

        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InsertDialog dialog = new InsertDialog();
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setLocationRelativeTo(jPanel);
                dialog.setVisible(true);
            }
        });


        JButton btnUpdate = new JButton("Update");

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateDialog updateDialog=new UpdateDialog();
                updateDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                updateDialog.setLocationRelativeTo(jPanel);
                updateDialog.setSize(300, 200);
                updateDialog.setVisible(true);
            }
        });

        btnUpdate.setBounds(156, 23, 100, 25);

        JButton btnDelete = new JButton("Delete");

        btnDelete.setBounds(276, 23, 100, 25);

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteDialog deleteDialog = new DeleteDialog();
                deleteDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                deleteDialog.setLocationRelativeTo(jPanel);
                deleteDialog.setSize(250, 200);
                deleteDialog.setVisible(true);
            }
        });

        JButton btnDisplay = new JButton("Display");

        btnDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayDialog displayDialog = new DisplayDialog();
                displayDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                displayDialog.setLocationRelativeTo(jPanel);
                displayDialog.setSize(500, 500);
                displayDialog.setVisible(true);
            }
        });

        btnDisplay.setBounds(156, 73, 100, 25);

        jPanel.add(btnInsert);
        jPanel.add(btnDisplay);
        jPanel.add(btnDelete);
        jPanel.add(btnUpdate);


    }


}
