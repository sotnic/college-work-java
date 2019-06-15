package oleksandr_sotnykov_exercise01;

// Oleksandr Sotnykov #300986475

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean i = true;
        // Using scanner to prompt user for input
        Scanner section = new Scanner(System.in);
        Scanner option = new Scanner(System.in);

        // Creating a while loop for a table selection
        while (i) {
            // Prompting a user to choose a table
            System.out.println("\nSelect the database table (Books or Sales): ");
            String table = section.nextLine();

            // Declaring an if statement to operate different tables
            if (table.toLowerCase().equals("books")) {
                while (true) {
                    // Prompting a user to select an operation
                    System.out.println("Please select the operation (Add / View / Update / Delete / Search / Quit): ");
                    String operation = option.nextLine();

                    if (operation.toLowerCase().equals("add")) {
                        Functions.Add(table);
                        break;
                    } else if (operation.toLowerCase().equals("view")) {
                        Functions.View(table);
                        break;
                    } else if (operation.toLowerCase().equals("update")) {
                        Functions.Update(table);
                        break;
                    } else if (operation.toLowerCase().equals("delete")) {
                        Functions.Delete(table);
                        break;
                    } else if (operation.toLowerCase().equals("search")) {
                        Functions.Search(table);
                        break;
                    } else if (operation.toLowerCase().equals("quit")) {
                        System.out.println("Good Bye!");
                        // assigning i variable to false in order to execute the application
                        i = false;
                        break;
                    } else {
                        System.out.println("\nWrong input!");
                    }
                }
            } else if (table.toLowerCase().equals("sales")) {
                while (true) {
                    System.out.println("Please select the operation (Add / View / Update / Delete / Search / Total / Quit): ");
                    String operation = option.nextLine();

                    if (operation.toLowerCase().equals("add")) {
                        Functions.Add(table);
                        break;
                    } else if (operation.toLowerCase().equals("view")) {
                        Functions.View(table);
                        break;
                    } else if (operation.toLowerCase().equals("update")) {
                        Functions.Update(table);
                        break;
                    } else if (operation.toLowerCase().equals("delete")) {
                        Functions.Delete(table);
                        break;
                    } else if (operation.toLowerCase().equals("search")) {
                        Functions.Search(table);
                        break;
                    } else if (operation.toLowerCase().equals("total")) {
                        Functions.TotalSold();
                        break;
                    } else if (operation.toLowerCase().equals("quit")) {
                        System.out.println("Good Bye!");
                        i = false;
                        break;
                    } else {
                        System.out.println("\nIncorrect operation input!");
                    }
                }
            } else if (table.toLowerCase().equals("quit")) {
                System.out.println("Good Bye!");
                i = false;
            } else {
                System.out.println("\nIncorrect table selection!");
            }
        }
    }
}

