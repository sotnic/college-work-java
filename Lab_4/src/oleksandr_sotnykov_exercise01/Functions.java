package oleksandr_sotnykov_exercise01;

// Oleksandr Sotnykov #300986475

import java.sql.*;
import java.util.Scanner;

public class Functions {
    //Connecting to the database
    private static Connection Connect() {
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

    //Add new row of data
    public static void Add(String record) {
        Connection c;
        PreparedStatement statement = null;
        Scanner scanner = new Scanner(System.in);
        boolean i = true;

        try {
            c = Connect();
            if (record.equals("books")) {
                statement = c.prepareStatement("INSERT INTO BOOKS(TITLE, AUTHOR, PRICE, TYPE, SUBJECT) VALUES (?,?,?,?,?)");

                while (i) {
                    try {
                        System.out.println("Please fill in the form.");
                        System.out.println("Title: ");
                        String title = scanner.nextLine();
                        System.out.println("Author: ");
                        String author = scanner.nextLine();
                        System.out.println("Price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.println("Type: ");
                        String type = scanner.nextLine();
                        System.out.println("Subject: ");
                        String subject = scanner.nextLine();

                        // Populating fields
                        statement.setString(1, title);
                        statement.setString(2, author);
                        statement.setDouble(3, price);
                        statement.setString(4, type);
                        statement.setString(5, subject);

                        int row = statement.executeUpdate(); // Returns the row count

                        System.out.println("\n" + row + " row added");
                        System.out.println("\nBOOKS table has been updated");
                        i = false; // assigning i variable to a false in order to execute Add method
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Wrong input! Please try again...");
                    }
                }
            } else if (record.equals("sales")) {
                statement = c.prepareStatement("INSERT INTO SALES(BOOKCODE, SALEDDATE, QUANTITY, PRICE) VALUES (?,?,?,?)");
                while (i) {
                    try {
                        System.out.println("Please fill in the form.");
                        System.out.println("ISBN: ");
                        int isbn = Integer.parseInt(scanner.nextLine());
                        System.out.println("Sales Date: ");
                        String salesDate = scanner.nextLine();
                        System.out.println("Quantity: ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        System.out.println("Price: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        statement.setInt(1, isbn);
                        statement.setString(2, salesDate);
                        statement.setInt(3, quantity);
                        statement.setDouble(4, price);

                        int row = statement.executeUpdate();

                        System.out.println("\n" + row + " row added");
                        System.out.println("SALES table has been updated");
                        i = false;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Wrong input! Please try again...");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Wrong input! Please try again...");
        }
    }

    //Display the data of a table
    public static void View(String record) {
        Connection c = null;
        Statement statement = null;
        ResultSet tableData = null;

        try {
            c = Connect();
            statement = c.createStatement();
            if (record.toLowerCase().equals("books")) {

                tableData = statement.executeQuery("SELECT * FROM BOOKS");

                System.out.printf("\n----------------------------------------------------------------------------------------------------" +
                        "---------------------------------------");
                System.out.printf("\n%10s | %50s | %15s | %7s | %15s | %25s |", "ISBN", "Title", "Author", "Price", "Type", "Subject");
                System.out.printf("\n----------------------------------------------------------------------------------------------------" +
                        "---------------------------------------");
                while (tableData.next()) {
                    int isbn = tableData.getInt(1);
                    String title = tableData.getString(2);
                    String author = tableData.getString(3);
                    double price = tableData.getDouble(4);
                    String type = tableData.getString(5);
                    String subject = tableData.getString(6);

                    System.out.printf("\n%10d | %50s | %15s | %7.2f | %15s | %25s |", isbn, title, author, price, type, subject);
                    System.out.printf("\n----------------------------------------------------------------------------------------------------" +
                            "---------------------------------------");
                }
            } else if (record.toLowerCase().equals("sales")) {
                tableData = statement.executeQuery("SELECT * FROM SALES");

                System.out.printf("\n---------------------------------------------------------------------------");
                System.out.printf("\n%10s | %10s | %25s | %10s | %7s |", "Sales code", "ISBN", "Sales Date", "Quantity", "Price");
                System.out.printf("\n---------------------------------------------------------------------------");

                while (tableData.next()) {
                    int salesCode = tableData.getInt(1);
                    int isbn = tableData.getInt(2);
                    String date = tableData.getString(3);
                    int quantity = tableData.getInt(4);
                    double price = tableData.getDouble(5);
                    System.out.printf("\n%10d | %10d | %25s | %10d | %7.2f |", salesCode, isbn, date, quantity, price);
                    System.out.printf("\n---------------------------------------------------------------------------");
                }
            } else {
                System.out.println("Wrong table selection!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Collected information isn't correct!");
        }
    }

    //Updating a table
    public static void Update(String record) {
        Connection c;
        PreparedStatement statement = null;
        Scanner scanner = new Scanner(System.in);
        boolean i = true;
        String newValue;

        try {
            c = Connect();
            while (i) {
                if (record.toLowerCase().equals("books")) {
                    View(record);

                    System.out.printf("\nPlease enter the ISBN of a book you'd like to update: ");
                    int isbn = Integer.parseInt(scanner.nextLine());
                    System.out.println("\nPlease enter the field you'd like to update (Title / Author / Price / Type / Subject): ");
                    String option = scanner.nextLine();

                    if (option.toLowerCase().equals("title")) {
                        try {
                            System.out.printf("Please enter a new " + option + ": ");
                            newValue = scanner.nextLine();

                            statement = c.prepareStatement("UPDATE BOOKS SET TITLE = (?) WHERE BOOKCODE = (?)");
                            statement.setString(1, newValue);
                            statement.setInt(2, isbn);
                            statement.executeUpdate();
                            i = false; // assigning i variable to a false in order to execute Update method
                        } catch (Exception e) {
                            System.out.println("\nThe wrong input of a new value!");
                        }
                    } else if (option.toLowerCase().equals("author")) {
                        try {
                            System.out.printf("Please enter a new " + option + ": ");
                            newValue = scanner.nextLine();

                            statement = c.prepareStatement("UPDATE BOOKS SET author = (?) WHERE BOOKCODE = (?)");
                            statement.setString(1, newValue);
                            statement.setInt(2, isbn);
                            statement.executeUpdate();
                            i = false;
                        } catch (Exception e) {
                            System.out.println("\nThe wrong input of a new value!");
                        }
                    } else if (option.toLowerCase().equals("price")) {
                        try {
                            System.out.printf("Please enter a new " + option + ": ");
                            newValue = scanner.nextLine();

                            statement = c.prepareStatement("UPDATE BOOKS SET price = (?) WHERE BOOKCODE = (?)");
                            statement.setString(1, newValue);
                            statement.setInt(2, isbn);
                            statement.executeUpdate();
                            i = false;
                        } catch (Exception e) {
                            System.out.println("\nThe wrong input of a new value!");
                        }
                    } else if (option.toLowerCase().equals("type")) {
                        try {
                            System.out.printf("Please enter a new " + option + ": ");
                            newValue = scanner.nextLine();

                            statement = c.prepareStatement("UPDATE BOOKS SET type = (?) WHERE BOOKCODE = (?)");
                            statement.setString(1, newValue);
                            statement.setInt(2, isbn);
                            statement.executeUpdate();
                            i = false;
                        } catch (Exception e) {
                            System.out.println("\nThe wrong input of a new value!");
                        }
                    } else if (option.toLowerCase().equals("subject")) {
                        try {
                            System.out.printf("Please enter a new " + option + ": ");
                            newValue = scanner.nextLine();

                            statement = c.prepareStatement("UPDATE BOOKS SET subject = (?) WHERE BOOKCODE = (?)");
                            statement.setString(1, newValue);
                            statement.setInt(2, isbn);
                            statement.executeUpdate();
                            i = false;
                        } catch (Exception e) {
                            System.out.println("\nThe wrong input of a new value!");
                        }
                    } else {
                        System.out.println("\nWrong parameter selection! Try again...");
                    }
                } else if (record.toLowerCase().equals("sales")) {
                    View(record);

                    System.out.printf("\nPlease enter the sales ID you'd like to update: ");
                    int saleId = Integer.parseInt(scanner.nextLine());

                    System.out.println("\nPlease enter the field you'd like to update (SalesDate / Quantity / Price):");
                    System.out.printf("You can chose one option (SalesDate / Quantity / Price): ");
                    String option = scanner.nextLine();

                    if (option.toLowerCase().equals("salesdate")) {
                        try {
                            System.out.printf("Please enter a new " + option + ": ");
                            newValue = scanner.nextLine();

                            statement = c.prepareStatement("UPDATE SALES SET saleddate = (?) WHERE SALECODE = (?)");
                            statement.setString(1, newValue);
                            statement.setInt(2, saleId);
                            statement.executeUpdate();
                            i = false;
                        } catch (Exception e) {
                            System.out.println("\nThe wrong input of a new value!");
                        }
                    } else if (option.toLowerCase().equals("quantity")) {
                        try {
                            System.out.printf("Please enter a new " + option + ": ");
                            newValue = scanner.nextLine();

                            statement = c.prepareStatement("UPDATE SALES SET quantity = (?) WHERE SALECODE = (?)");
                            statement.setString(1, newValue);
                            statement.setInt(2, saleId);
                            statement.executeUpdate();
                            i = false;
                        } catch (Exception e) {
                            System.out.println("\nThe wrong input of a new value!");
                        }
                    } else if (option.toLowerCase().equals("price")) {
                        try {
                            System.out.printf("Please enter a new " + option + ": ");
                            newValue = scanner.nextLine();

                            statement = c.prepareStatement("UPDATE SALES SET price = (?) WHERE SALECODE = (?)");
                            statement.setString(1, newValue);
                            statement.setInt(2, saleId);
                            statement.executeUpdate();
                            i = false;
                        } catch (Exception e) {
                            System.out.println("\nThe wrong input of a new value!");
                        }
                    } else {
                        System.out.println("\nWrong parameter selection! Try again...");
                    }
                } else {
                    System.out.println("\nWrong table selection! Try again...");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("\nWrong input!");
        }
    }

    //This method is used to delete row from one of the tables
    public static void Delete(String record) {
        Connection c;
        PreparedStatement statement = null;
        Scanner scanner = new Scanner(System.in);
        boolean i = true;

        try {
            c = Connect();
            if (record.equals("books")) {
                statement = c.prepareStatement("DELETE FROM BOOKS WHERE BOOKCODE = (?)");

                while (i) {
                    try {
                        View(record);

                        System.out.printf("\nEnter ISBN of a book you'd like to delete: ");
                        int isbn = Integer.parseInt(scanner.nextLine());

                        statement.setInt(1, isbn);

                        int row = statement.executeUpdate();

                        System.out.println("\n" + row + " book deleted");
                        System.out.println("\nBOOKS table has been updated");
                        i = false;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Wrong input! Try again...");
                    }
                }
            } else if (record.equals("sales")) {
                statement = c.prepareStatement("DELETE FROM Sales WHERE SALECODE = (?)");

                while (i) {
                    try {
                        View(record);
                        System.out.printf("\nEnter the code of a sale you'd like to delete: ");
                        int saleCode = Integer.parseInt(scanner.nextLine());

                        statement.setInt(1, saleCode);

                        int row = statement.executeUpdate();

                        System.out.println("\n" + row + " sale deleted");
                        System.out.println("\nSALES table has been updated");
                        i = false;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Try again...");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    //Searching a record
    public static void Search(String record) {

        Connection c = null;
        PreparedStatement statement = null;
        ResultSet tableData = null;
        Scanner scanner = new Scanner(System.in);
        boolean i = true;

        try {
            c = Connect();
            if (record.equals("books")) {
                while (i) {
                    try {
                        System.out.printf("\nSelect the search option (Title / Author): ");
                        String option = scanner.nextLine();

                        if (option.toLowerCase().equals("title")) {
                            System.out.printf("\nEnter either a whole title or a part (Please notice that it's case sensitive): ");
                            String input = scanner.nextLine();
                            input = "%" + input + "%";
                            statement = c.prepareStatement("SELECT * FROM BOOKS WHERE TITLE LIKE (?) ");
                            statement.setString(1, input);

                            System.out.printf("\n----------------------------------------------------------------------------------------------------" +
                                    "--------------------------------------");
                            tableData = statement.executeQuery();
                            System.out.printf("\n%10s | %50s | %15s | %7s | %15s | %25s |", "ISBN", "Title", "Author", "Price", "Type", "Subject");
                            System.out.printf("\n----------------------------------------------------------------------------------------------------" +
                                    "--------------------------------------");
                            i = false;
                        } else if (option.toLowerCase().equals("author")) {
                            System.out.printf("\nEnter either a whole author name or a part (Please notice that it's case sensitive): ");
                            String input = scanner.nextLine();
                            input = "%" + input + "%";
                            statement = c.prepareStatement("SELECT * FROM BOOKS WHERE AUTHOR LIKE (?)");// This search is case sensitive
                            statement.setString(1, input);

                            System.out.printf("\n----------------------------------------------------------------------------------------------------" +
                                    "--------------------------------------");
                            tableData = statement.executeQuery();
                            System.out.printf("\n%10s | %50s | %15s | %7s | %15s | %25s |", "ISBN", "Title", "Author", "Price", "Type", "Subject");
                            System.out.printf("\n----------------------------------------------------------------------------------------------------" +
                                    "--------------------------------------");
                            i = false;
                        } else {
                            System.out.println("Incorrect search criteria input! Try again...");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (tableData.next()) {
                    int isbn = tableData.getInt(1);
                    String title = tableData.getString(2);
                    String author = tableData.getString(3);
                    double price = tableData.getDouble(4);
                    String type = tableData.getString(5);
                    String subject = tableData.getString(6);

                    System.out.printf("\n%10d | %50s | %15s | %7.2f | %15s | %25s", isbn, title, author, price, type, subject);
                }
            } else if (record.toLowerCase().equals("sales")) {
                while (i) {
                    try {
                        System.out.printf("\nPlease enter the sales date (format YY-MM-DD, allowed numbers only): ");
                        String input = scanner.nextLine();
                        statement = c.prepareStatement("SELECT * FROM SALES WHERE SALEDDATE = (?)");
                        statement.setString(1, input);

                        System.out.printf("\n--------------------------------------------------------------------------");
                        tableData = statement.executeQuery();
                        System.out.printf("\n%10s | %10s | %25s | %10s | %7s ", "Sales code", "ISBN", "Sales Date", "Quantity", "Price");
                        System.out.printf("\n--------------------------------------------------------------------------");
                        i = false;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (tableData.next()) {
                    int salesCode = tableData.getInt(1);
                    int isbn = tableData.getInt(2);
                    String date = tableData.getString(3);
                    int quantity = tableData.getInt(4);
                    double price = tableData.getDouble(5);

                    System.out.printf("\n%10d | %10d | %25s | %10d | %7.2f", salesCode, isbn, date, quantity, price);
                }
            } else {
                System.out.println("Incorrect input to search! Try again...");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Wrong table selection. Try again...");
        }
    }

    //Calculating the sum of income depending on sales date
    public static void TotalSold() {
        Connection c = null;
        PreparedStatement statement = null;
        ResultSet tableData = null;
        Scanner scanner = new Scanner(System.in);
        boolean i = true;

        try {
            while (i) {
                c = Connect();
                System.out.println("Please enter the date of sales total amount of which you'd like to calculate: ");
                String input = scanner.nextLine();

                statement = c.prepareStatement("SELECT saledDate, sum(quantity) as  \"Total amount of books\", sum(price * quantity) as \"Total Price\" from SALES where saledDate = (?) group by saledDate");
                statement.setString(1, input);
                tableData = statement.executeQuery();

                System.out.printf("\n--------------------------------------------------------------");
                System.out.printf("\n%25s | %15s | %15s ", "Sales Date", "Total Amount", "Total Price");
                System.out.printf("\n--------------------------------------------------------------");

                while (tableData.next()) {
                    String date = tableData.getString(1);
                    int totalQuantity = tableData.getInt(2);
                    double totalPrice = tableData.getDouble(3);

                    System.out.printf("\n%25s | %15d | %15.2f", date, totalQuantity, totalPrice);
                }
                i = false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
