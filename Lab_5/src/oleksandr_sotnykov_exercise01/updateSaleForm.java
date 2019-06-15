package oleksandr_sotnykov_exercise01;

// Oleksandr Sotnykov #300986475

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateSaleForm extends JDialog implements ActionListener {
    // Declaring variables
    Container container;

    JLabel lblAddForm = new JLabel("New Sale Record");
    JLabel lblIsbn = new JLabel("ISBN: ");
    JLabel lblSaleDate = new JLabel("Sale Date: ");
    JLabel lblQuantity = new JLabel("Sale Quantity: ");
    JLabel lblPrice = new JLabel("Sale Price: ");
    JLabel lblSaleId = new JLabel();

    JTextField txtCode = new JTextField();
    JTextField txtSaleDate = new JTextField();
    JTextField txtQuantity = new JTextField();
    JTextField txtPrice = new JTextField();

    JButton editBtn = new JButton("Edit");
    JButton resetBtn = new JButton("Reset");
    JButton closeBtn = new JButton("Close");

    // Placing frame elements
    public updateSaleForm() {
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.lightGray);

        lblAddForm.setBounds(220, 10, 150, 20);
        lblIsbn.setBounds(50, 70, 120, 20);
        lblSaleDate.setBounds(50, 110, 120, 20);
        lblQuantity.setBounds(50, 150, 120, 20);
        lblPrice.setBounds(50, 190, 120, 20);
        lblSaleId.setBounds(10,10,120,20);
        lblSaleId.setVisible(false);

        txtCode.setBounds(200, 70, 200, 20);
        txtSaleDate.setBounds(200, 110, 200, 20);
        txtQuantity.setBounds(200, 150, 200, 20);
        txtPrice.setBounds(200, 190, 200, 20);

        editBtn.setBounds(60, 300, 120, 20);
        resetBtn.setBounds(210, 300, 120, 20);
        closeBtn.setBounds(360, 300, 120, 20);

        container.add(lblAddForm);
        container.add(lblIsbn);
        container.add(lblSaleDate);
        container.add(lblQuantity);
        container.add(lblPrice);
        container.add(lblSaleId);
        container.add(txtCode);
        container.add(txtSaleDate);
        container.add(txtQuantity);
        container.add(txtPrice);
        container.add(resetBtn);
        container.add(editBtn);
        container.add(closeBtn);

        editBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        closeBtn.addActionListener(this);

        this.setModal(true);
    }
    // Assigning action events to the buttons
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == editBtn)
                try {
                    String isbn = txtCode.getText();
                    java.sql.Date saleDate = java.sql.Date.valueOf(txtSaleDate.getText());
                    String quantity = txtQuantity.getText();
                    String price = txtPrice.getText();
                    String saleId = lblSaleId.getText();

                    Functions.updateSale(Integer.parseInt(saleId), Integer.parseInt(isbn), saleDate, Integer.parseInt(quantity), Double.parseDouble(price));
                    dispose();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                } else if (e.getSource() == resetBtn) {
                txtCode.setText(null);
                txtSaleDate.setText(null);
                txtQuantity.setText(null);
                txtPrice.setText(null);
            } else if (e.getSource() == closeBtn) {
                dispose();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void updateSaleRecord(int saleId, String isbn, String saleDate, String quantity, String price) {
        lblSaleId.setText(Integer.toString(saleId));
        txtCode.setText(isbn);
        txtSaleDate.setText(saleDate);
        txtQuantity.setText(quantity);
        txtPrice.setText(price);
    }
}
