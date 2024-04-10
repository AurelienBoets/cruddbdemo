package org.example.view.dialog;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertDialog extends JDialog {



    public InsertDialog(){
        JButton jButton = new JButton("OK");
        JLabel nameLabel=new JLabel("Nom:");
        JLabel numberLabel=new JLabel("Nombre:");
        JTextField nameInput=new JTextField(10);
        JTextField numberInput=new JTextField(10);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints=new GridBagConstraints();
        constraints.anchor=GridBagConstraints.CENTER;
        constraints.gridx=0;
        constraints.gridy=0;
        add(nameLabel,constraints);
        constraints.gridx=1;
        add(nameInput,constraints);
        constraints.gridy=1;
        add(numberInput,constraints);
        constraints.gridx=0;
        add(numberLabel,constraints);
        constraints.gridy=2;
        constraints.gridwidth=2;
        add(jButton,constraints);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contact contact = new Contact();
                ContactDao contactDao = new ContactDao();
                int count=0;
                if(!nameInput.getText().isEmpty() && !numberInput.getText().isEmpty()) {
                    contact.setName(nameInput.getText());
                    contact.setNumber(numberInput.getText());
                    count = contactDao.addContact(contact);
                }
                if(count>0){
                    JOptionPane.showConfirmDialog(null, "Operation succeed");
                }else{
                    JOptionPane.showConfirmDialog(null, "Operation Failed");
                }
                dispose();
            }
        });
        setSize(500,550);

    }




}
