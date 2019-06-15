package oleksandr_sotnykov_exercise01;

// Oleksandr Sotnykov #300986475

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateBookForm extends JDialog implements ActionListener {
    // Declaring variables
    Container container;

    JLabel lblAddForm = new JLabel("New Book Record");
    JLabel lblTitle = new JLabel("Title: ");
    JLabel lblAuthor = new JLabel("Author: ");
    JLabel lblPrice = new JLabel("Price: ");
    JLabel lblType = new JLabel("Type: ");
    JLabel lblSubject = new JLabel("Subject: ");
    JLabel lblIsbn = new JLabel();

    JTextField txtTitle = new JTextField();
    JTextField txtAuthor = new JTextField();
    JTextField txtPrice = new JTextField();
    JTextField txtType = new JTextField();
    JTextField txtSubject = new JTextField();

    JButton editBtn = new JButton("Edit");
    JButton resetBtn = new JButton("Reset");
    JButton closeBtn = new JButton("Close");

    // Placing frame elements
    public updateBookForm() {
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.lightGray);

        lblAddForm.setBounds(220, 10, 150, 20);
        lblTitle.setBounds(50, 70, 120, 20);
        lblAuthor.setBounds(50, 110, 120, 20);
        lblPrice.setBounds(50, 150, 120, 20);
        lblType.setBounds(50, 190, 120, 20);
        lblSubject.setBounds(50, 230, 120, 20);
        lblIsbn.setBounds(10,10,120,20);
        lblIsbn.setVisible(false);

        txtTitle.setBounds(200, 70, 200, 20);
        txtAuthor.setBounds(200, 110, 200, 20);
        txtPrice.setBounds(200, 150, 200, 20);
        txtType.setBounds(200, 190, 200, 20);
        txtSubject.setBounds(200, 230, 200, 20);

        editBtn.setBounds(60, 300, 120, 20);
        resetBtn.setBounds(210, 300, 120, 20);
        closeBtn.setBounds(360, 300, 120, 20);

        container.add(lblAddForm);
        container.add(lblTitle);
        container.add(lblAuthor);
        container.add(lblPrice);
        container.add(lblType);
        container.add(lblSubject);
        container.add(lblIsbn);
        container.add(txtTitle);
        container.add(txtAuthor);
        container.add(txtPrice);
        container.add(txtType);
        container.add(txtSubject);
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
                    String bookTitle = txtTitle.getText();
                    String bookAuthor = txtAuthor.getText();
                    String bookPrice = txtPrice.getText();
                    String bookType = txtType.getText();
                    String bookSubject = txtSubject.getText();
                    String isbn = lblIsbn.getText();

                    Functions.updateBook(bookTitle, bookAuthor, Double.parseDouble(bookPrice), bookType, bookSubject, Integer.parseInt(isbn));
                    dispose();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            else if (e.getSource() == resetBtn) {
                txtTitle.setText(null);
                txtAuthor.setText(null);
                txtPrice.setText(null);
                txtType.setText(null);
                txtSubject.setText(null);
            } else if (e.getSource() == closeBtn) {
                dispose();
            }
        } catch (Exception entire) {
            System.out.println(entire.getMessage());
        }
    }
    public void updateBookRecord(int isbn, String title, String author, String price, String type, String subject) {
        lblIsbn.setText(Integer.toString(isbn));
        txtTitle.setText(title);
        txtAuthor.setText(author);
        txtPrice.setText(price);
        txtType.setText(type);
        txtSubject.setText(subject);
    }
}
