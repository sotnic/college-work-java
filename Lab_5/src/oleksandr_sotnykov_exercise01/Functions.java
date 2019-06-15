package oleksandr_sotnykov_exercise01;

// Oleksandr Sotnykov #300986475

import java.sql.*;

public class Functions {
    static PreparedStatement ps = null;
    static Statement st = null;
    static Connection conn = Test.Connect();
    static ResultSet rs = null;

    // GUI operations for the BOOKS table
    public static Object[][] viewBooks() {
        Object[][] rowData = new Object[1000][6];
        int i = 0;
        try{
            st = conn.createStatement();
            rs = st.executeQuery("select * from books");

            while(rs.next()) {
                int isbn = rs.getInt(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                double price = rs.getDouble(4);
                String type = rs.getString(5);
                String subject = rs.getString(6);

                rowData[i][0] = isbn;
                rowData[i][1] = title;
                rowData[i][2] = author;
                rowData[i][3] = price;
                rowData[i][4] = type;
                rowData[i][5] = subject;

                i += 1;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return rowData;
    }
    public static void addBook(String title, String author, double price, String type, String subject) {
        try {
            ps = conn.prepareStatement("insert into books (TITLE, AUTHOR, PRICE, type, SUBJECT) values (?,?,?,?,?)");

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setDouble(3, price);
            ps.setString(4, type);
            ps.setString(5, subject);

            int row = ps.executeUpdate();
            System.out.println(row + " record have been added \n" + title + " added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void updateBook(String title, String author, double price, String type, String subject, int isbn) {
        try{
            ps = conn.prepareStatement("update books set TITLE = ?, AUTHOR = ?, PRICE = ?, type = ?, SUBJECT = ? where BOOKCODE = ?");

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setDouble(3, price);
            ps.setString(4, type);
            ps.setString(5, subject);
            ps.setInt(6, isbn);

            int row = ps.executeUpdate();
            System.out.println(row + " record have been updated");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void deleteBook(int isbn) {
        try {
            ps = conn.prepareStatement("delete from books where BOOKCODE = ?");
            ps.setInt(1, isbn);
            int row = ps.executeUpdate();
            System.out.println(row + " record has been deleted");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static Object[][] searchIsbn(String bookIsbn) {
        Object[][] searchBook = new Object[1000][6];
        int i = 0;
        try {
            ps = conn.prepareStatement("select  * from books where bookcode = ?");
            ps.setString(1, bookIsbn);
            rs = ps.executeQuery();
            while(rs.next()){
                int isbn = rs.getInt(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                double price = rs.getDouble(4);
                String type = rs.getString(5);
                String subject = rs.getString(6);

                searchBook[i][0] = isbn;
                searchBook[i][1] = title;
                searchBook[i][2] = author;
                searchBook[i][3] = price;
                searchBook[i][4] = type;
                searchBook[i][5] = subject;

                i += 1;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return searchBook;
    }

    // GUI operations for the SALES table
    public static Object[][] viewSales() {
        Object[][] rowData = new Object[1000][5];
        int i = 0;
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from sales");
            while(rs.next()) {
                int saleId = rs.getInt(1);
                int isbn = rs.getInt(2);
                String saleDate = rs.getString(3);
                int quantity = rs.getInt(4);
                double price = rs.getDouble(5);

                String[] newDate = saleDate.split(" ");

                rowData[i][0] = saleId;
                rowData[i][1] = isbn;
                rowData[i][2] = newDate[0];
                rowData[i][3] = quantity;
                rowData[i][4] = price;

                i += 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rowData;
    }
    public static void addSale(int isbn, Date date, int quantity, double price) {
        try {
            ps = conn.prepareStatement("insert into sales (BOOKCODE, SALEDDATE, QUANTITY, PRICE) values (?,?,?,?)");
            ps.setInt(1, isbn);
            ps.setDate(2, date);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);

            int row = ps.executeUpdate();
            System.out.println(row + " record have been added");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void updateSale(int saleId, int isbn, Date saleDate, int quantity, double price) {
        try {
            ps = conn.prepareStatement("update sales set  BOOKCODE = ?, SALEDDATE = ?, QUANTITY = ?, PRICE = ? where SALEID = ?");

            ps.setInt(1, isbn);
            ps.setDate(2, saleDate);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);
            ps.setInt(5, saleId);
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void deleteSale(int saleId) {
        try{
            ps = conn.prepareStatement("delete from SALES where SALEID = ?");
            ps.setInt(1, saleId);
            int row = ps.executeUpdate();
            System.out.println(row + " record has been deleted");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static Object[][] searchDate(Date date) {
        Object[][] searchSale = new Object[1000][5];
        int i = 0;
        try {
            ps = conn.prepareStatement("select * from SALES where SALEDDATE = ?");
            ps.setDate(1, date);
            rs = ps.executeQuery();
            while(rs.next()) {
                int saleId = rs.getInt(1);
                int isbn = rs.getInt(2);
                String saleDate = rs.getString(3);
                int quantity = rs.getInt(4);
                double price = rs.getDouble(5);

                String[] newDate = saleDate.split(" ");

                searchSale[i][0] = saleId;
                searchSale[i][1] = isbn;
                searchSale[i][2] = newDate;
                searchSale[i][3] = quantity;
                searchSale[i][4] = price;

                i += 1;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return searchSale;
    }
}
