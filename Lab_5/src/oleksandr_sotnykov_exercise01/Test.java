package oleksandr_sotnykov_exercise01;

// Oleksandr Sotnykov #300986475

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Test {
    static Connection conn = null;
    static GUIBooks booksWindow = new GUIBooks();
    static GUISales salesWindow = new GUISales();

    public static Connection Connect() {
        Connection c = null;
        try {
            //Accessing a database by loading an oracle driver
            Class.forName("oracle.jdbc.OracleDriver");
            // Establish connection to database
            String connectionURL1 = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD"; //Use this connection URL IN CENTENNIAL
            String connectionURL2 = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD"; // Use this Connection URL OUTSIDE Centennial
            // Assigning user name and password for connecting
            String userName = "COMP214F18_001_P_24";
            String userPassword = "password";

            //Checking both connections inside the college and outside
            try {
                c = DriverManager.getConnection(connectionURL1, userName, userPassword);
            } catch (Exception e) {
                c = DriverManager.getConnection(connectionURL2, userName, userPassword);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }
    public static JMenuBar MenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("DB Tables");
        menuBar.add(menu);

        JMenuItem bookMenu = new JMenuItem("Books Table");
        bookMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                booksWindow.setVisible(true);
                salesWindow.dispose();
            }
        });
        menu.add(bookMenu);

        JMenuItem saleMenu = new JMenuItem("Sale Table");
        saleMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salesWindow.setVisible(true);
                booksWindow.dispose();
            }
        });
        menu.add(saleMenu);
        return menuBar;
    }

    public static void main(String[] args) {
        booksWindow.setVisible(true);
        booksWindow.setTitle("Book Store Database");
        booksWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        booksWindow.setJMenuBar(Test.MenuBar());
        booksWindow.setSize(600, 400);

        salesWindow.setTitle("Book Store Database");
        salesWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        salesWindow.setSize(600, 400);
        salesWindow.setJMenuBar(Test.MenuBar());
    }
}