package oleksandr_sotnykov_exercise01;

// Oleksandr Sotnykov #300986475

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUISales extends JFrame implements ActionListener {
    // Declaring variables
    Container container;

    JLabel lblBook = new JLabel("Sales Database");
    JLabel lblSaleSearch = new JLabel("Sale Date (YYYY-MM-DD): ");

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
    public GUISales() {
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.lightGray);

        lblBook.setBounds(240, 10, 150, 20);

        lblSaleSearch.setBounds(140, 90, 200, 20);
        lblSaleSearch.setBackground(Color.lightGray);

        addBtn.setBounds(140,40,80,30);
        updateBtn.setBounds(250, 40, 80, 30);
        deleteBtn.setBounds(360, 40, 80, 30);
        searchBtn.setBounds(390, 120, 80, 30);
        refreshBtn.setBounds(490, 120, 80, 30);

        txtSearch.setBounds(120, 120, 250, 30);

        tableScrollPane.setBounds(0, 160, 600, 240);

        container.add(lblBook);
        container.add(lblSaleSearch);
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

        salesModel();
        table.setModel(model);
    }
    // Populating a table model
    public DefaultTableModel salesModel() {
        try {
            Object rowData[][] = Functions.viewSales();
            Object columnNames[] = {"SaleID", "Isbn", "Sales Date", "Quantity", "Price"};

            return model = new DefaultTableModel(rowData, columnNames);
        } catch (Exception e) {
            Object rowData[][] = {};
            Object columnNames[] = {"SaleID", "Isbn", "Sales Date", "Quantity", "Price"};

            return model = new DefaultTableModel(rowData, columnNames);
        }
    }
    // Assigning action events to the buttons
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == addBtn) {
                try {
                    addSaleForm saleForm = new addSaleForm();
                    saleForm.setTitle("New Sale Record");
                    saleForm.setPreferredSize(new Dimension(560, 400));

                    saleForm.pack();
                    saleForm.setVisible(true);

                    salesModel();
                    model.fireTableDataChanged();
                    table.setModel(model);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    System.out.println("Sorry! Something went wrong!");
                }

            } else if (e.getSource() == updateBtn){
                try {
                    updateSaleForm updateForm = new updateSaleForm();
                    updateForm.setTitle("Edit Sale Record");
                    updateForm.setPreferredSize(new Dimension(560, 400));

                    int saleId = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
                    String isbn = String.valueOf(table.getValueAt(table.getSelectedRow(), 1));
                    String saleDate = String.valueOf(table.getValueAt(table.getSelectedRow(),2));
                    String saleQuantity = String.valueOf(table.getValueAt(table.getSelectedRow(), 3));
                    String salePrice = String.valueOf(table.getValueAt(table.getSelectedRow(),4));

                    updateForm.updateSaleRecord(saleId, isbn, saleDate, saleQuantity, salePrice);

                    updateForm.pack();
                    updateForm.setVisible(true);

                    salesModel();
                    model.fireTableDataChanged();
                    table.setModel(model);
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                    System.out.println("Sorry! Something went wrong!");
                }
            } else if (e.getSource() == deleteBtn){
                try {
                    int saleId = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
                    Functions.deleteSale(saleId);

                    salesModel();
                    model.fireTableDataChanged();
                    table.setModel(model);
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                    System.out.println("Sorry! Something went wrong!");
                }
            } else if (e.getSource() == searchBtn){
                java.sql.Date saleDate = java.sql.Date.valueOf(txtSearch.getText());
                if (txtSearch.getText().isEmpty()) {
                    System.out.println("Search field is empty!");
                } else {
                    try {
                        Object searchTable[][] = Functions.searchDate(saleDate);
                        Object columnNames[] = {"SaleID", "ISBN", "Sales Date", "Quantity", "Price"};
                        model = new DefaultTableModel(searchTable, columnNames);
                    } catch (Exception ex) {
                        Object searchTable[][] = {};
                        Object columnNames[] = {"SaleID", "ISBN", "Sales Date", "Quantity", "Price"};
                        model = new DefaultTableModel(searchTable, columnNames);
                    }
                    table.setModel(model);
                    model.fireTableDataChanged();
                }
            } else if (e.getSource() == refreshBtn) {
                salesModel();
                model.fireTableDataChanged();
                table.setModel(model);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
