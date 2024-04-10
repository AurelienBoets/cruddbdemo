package org.example.view.dialog;

import org.example.dao.ContactDao;

import javax.swing.*;
import java.awt.*;

public class DeleteDialog extends JDialog {

    private JTextField idTextField;
    private final ContactDao dao=new ContactDao();

    public DeleteDialog(){
        JLabel idLabel = new JLabel("ID");
        idTextField = new JTextField(10);
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        JPanel panelMain = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        cancelButton.addActionListener(e->dispose());
        okButton.addActionListener(e->validateDelete());

        inputPanel.add(idLabel);
        inputPanel.add(idTextField);
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        panelMain.add(inputPanel, BorderLayout.NORTH);
        panelMain.add(buttonPanel, BorderLayout.SOUTH);
        add(panelMain);
    }

    private void validateDelete() {
        int id = Integer.parseInt(idTextField.getText());
        if (dao.deleteById(id)) {
            JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Record Can't Be Deleted !");
        }
    }
}
