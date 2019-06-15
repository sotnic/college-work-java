package oleksandr_sotnykov_exercise01;

// Oleksandr Sotnykov #300986475

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class GUIBooks extends JFrame implements ActionListener {
    // Declaring variables
    Container container;

    JLabel lblBook = new JLabel("Books Database");

    JButton addBtn = new JButton("Add");
    JButton deleteBtn = new JButton("Delete");
    JButton updateBtn = new JButton("Update");
    JButton searchBtn = new JButton("Search");
    JButton refreshBtn = new JButton("Refresh");

    JTextField txtSearch = new JTextField();
    JTable table = new JTable();
    JScrollPane tableScrollPane = new JScrollPane(table);
    DefaultTableModel model;

    // Placing frame elements
    public GUIBooks() {
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.lightGray);

        lblBook.setBounds(240, 10, 150, 20);

        addBtn.setBounds(140,70,80,30);
        updateBtn.setBounds(250, 70, 80, 30);
        deleteBtn.setBounds(360, 70, 80, 30);
        searchBtn.setBounds(390, 120, 80, 30);
        refreshBtn.setBounds(490, 120, 80, 30);

        txtSearch.setBounds(120, 120, 250, 30);

        tableScrollPane.setBounds(0, 160, 600, 240);

        container.add(lblBook);
        container.add(addBtn);
        container.add(updateBtn);
        container.add(deleteBtn);
        container.add(searchBtn);
        container.add(refreshBtn);
        container.add(tableScrollPane);
        container.add(txtSearch);

        table.setFillsViewportHeight(true);
        table.getTableHeader().setReorderingAllowed(false);

        addBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        searchBtn.addActionListener(this);

        booksModel();
        table.setModel(model);
    }
    // Populating a table model
    public DefaultTableModel booksModel() {
        try {
            Object rowData[][] = Functions.viewBooks();
            Object columnNames[] = {"Isbn", "Title", "Author", "Price", "Type", "Subject"};
            return model = new DefaultTableModel(rowData, columnNames);
        } catch (Exception e) {
            Object rowData[][] = {};
            Object columnNames[] = {"Isbn", "Title", "Author", "Price", "Type", "Subject"};
            return model = new DefaultTableModel(rowData, columnNames);
        }
    }
    // Assigning action events to the buttons
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == addBtn) {
                try {
                    addBookForm addForm = new addBookForm();
                    addForm.setTitle("New Book Record");
                    addForm.setPreferredSize(new Dimension(560, 400));

                    addForm.pack();
                    addForm.setVisible(true);

                    booksModel();
                    model.fireTableDataChanged();
                    table.setModel(model);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Sorry! Something went wrong!");
                }
            } else if (e.getSource() == updateBtn) {
                try {
                    updateBookForm updateForm = new updateBookForm();
                    updateForm.setTitle("Edit Book Record");
                    updateForm.setPreferredSize(new Dimension(560, 400));

                    int isbn = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
                    String title = String.valueOf(table.getValueAt(table.getSelectedRow(), 1));
                    String author = String.valueOf(table.getValueAt(table.getSelectedRow(), 2));
                    String price = String.valueOf(table.getValueAt(table.getSelectedRow(), 3));
                    String type = String.valueOf(table.getValueAt(table.getSelectedRow(), 4));
                    String subject = String.valueOf(table.getValueAt(table.getSelectedRow(), 5));

                    updateForm.updateBookRecord(isbn, title, author, price, type, subject);

                    updateForm.pack();
                    updateForm.setVisible(true);

                    booksModel();
                    model.fireTableDataChanged();
                    table.setModel(model);
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                    System.out.println("Sorry! Something went wrong!");
                }
            } else if (e.getSource() == deleteBtn) {
                try {
                    int isbn = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
                    Functions.deleteBook(isbn);

                    booksModel();
                    model.fireTableDataChanged();
                    table.setModel(model);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Sorry! Something went wrong!");
                }
            } else if (e.getSource() == searchBtn) {
                String searchField = txtSearch.getText();
                if (searchField.isEmpty()) {
                    System.out.println("Search field is empty");
                } else {
                    try {
                        Object searchTable[][] = Functions.searchIsbn(searchField);
                        Object columnNames[] = {"Isbn", "Title", "Author", "Price", "Type", "Subject"};
                        model = new DefaultTableModel(searchTable, columnNames);
                    } catch (Exception ex) {
                        Object searchTable[][] = {};
                        Object columnNames[] = {"Isbn", "Title", "Author", "Price", "Type", "Subject"};
                        model = new DefaultTableModel(searchTable, columnNames);
                    }
                    table.setModel(model);
                    model.fireTableDataChanged();
                }
                //if (titleOption.isSelected()) {
                //    if (searchField.isEmpty()) {
                //        System.out.println("Search field is empty");
                //    } else {
                //        try {
                //            Object searchTable[][] = Functions.searchTitle(searchField);
                //            Object columnNames[] = {"Isbn", "Title", "Author", "Price", "Type", "Subject"};
                //            model = new DefaultTableModel(searchTable, columnNames);
                //        } catch (Exception ex) {
                //            Object searchTable[][] = {};
                //            Object columnNames[] = {"Isbn", "Title", "Author", "Price", "Type", "Subject"};
                //            model = new DefaultTableModel(searchTable, columnNames);
                //        }
                //        table.setModel(model);
                //        model.fireTableDataChanged();
                //    }
                //} else if (authorOption.isSelected()) {
                //    if (txtSearch.getText().isEmpty()) {
                //        System.out.println("Search field is empty");
                //    } else {
                //        try {
                //            Object searchTable[][] = Functions.searchAuthor(searchField);
                //            Object columnNames[] = {"BookCode", "Title", "Author", "Price", "Type", "Subject"};
                //            model = new DefaultTableModel(searchTable, columnNames);
                //        } catch (Exception ex) {
                //            Object searchTable[][] = {};
                //            Object columnNames[] = {"BookCode", "Title", "Author", "Price", "Type", "Subject"};
                //            model = new DefaultTableModel(searchTable, columnNames);
                //        }
                //        table.setModel(model);
                //        model.fireTableDataChanged();
                //    }
                //}
            } else if (e.getSource() == refreshBtn) {
                booksModel();
                model.fireTableDataChanged();
                table.setModel(model);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
