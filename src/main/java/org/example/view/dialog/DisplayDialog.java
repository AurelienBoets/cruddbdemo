package org.example.view.dialog;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class DisplayDialog extends JDialog {
    public DisplayDialog() {
        ContactDao dao = new ContactDao();
        List<Contact> data = dao.getAll();
        String[] columnNames = {"ID", "Nom", "Numéro"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Contact contact : data) {
            String[] row = {contact.getId() + "", contact.getName(), contact.getNumber()};
            model.addRow(row);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}
