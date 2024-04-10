package org.example.view.dialog;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import java.awt.*;

public class UpdateDialog extends JDialog {
    private JTextField idInput;
    private JTextField nameInput;
    private JTextField numberInput;
    private final ContactDao dao = new ContactDao();

    public UpdateDialog() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel inputPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel idLabel = new JLabel("ID");
        JLabel nameLabel = new JLabel("Nom");
        JLabel numberLabel = new JLabel("Numéro");

        idInput = new JTextField(10);
        nameInput = new JTextField(10);
        numberInput = new JTextField(10);
        nameInput.setEnabled(false);
        numberInput.setEnabled(false);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchContact());

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> validateUpdate());

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());

        gbc.gridy = 0;
        gbc.gridx = 2;
        inputPanel.add(searchButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(idLabel, gbc);
        gbc.gridy = 1;
        inputPanel.add(nameLabel, gbc);
        gbc.gridy = 2;
        inputPanel.add(numberLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(idInput, gbc);
        gbc.gridy = 1;
        inputPanel.add(nameInput, gbc);
        gbc.gridy = 2;
        inputPanel.add(numberInput, gbc);

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();

    }

    private void searchContact() {
        int id = Integer.parseInt(idInput.getText());
        Contact contact = dao.getById(id);
        if (contact == null) {
            JOptionPane.showMessageDialog(this, "Can't find contact!");
        } else {
            idInput.setEnabled(false);
            numberInput.setText(contact.getNumber());
            nameInput.setText(contact.getName());
            numberInput.setEnabled(true);
            nameInput.setEnabled(true);
        }
    }

    private void validateUpdate() {
        int id = Integer.parseInt(idInput.getText());
        String name = nameInput.getText();
        String number = numberInput.getText();
        if (!name.isEmpty() && !number.isEmpty()) {
            Contact contact = new Contact();
            contact.setId(id);
            contact.setName(name);
            contact.setNumber(number);
            if (dao.update(contact)) {
                JOptionPane.showMessageDialog(this, "Successful update");
                dispose();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Can't update");
    }
}
