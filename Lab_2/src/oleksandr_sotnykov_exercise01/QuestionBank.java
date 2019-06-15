package oleksandr_sotnykov_exercise01;

import java.security.SecureRandom;
import java.util.Scanner;

public class QuestionBank {

    // declaring instance variables
    private static String question1 = "\nThe symbol, which is used to store value in a variable, is known as:\nA. ==\nB. +=\nC. =\nD. %";
    private static String question2 = "\nWhich of the following arithmetic operators is remainder operator:\nA. *\nB. +\nC. %\nD. /";
    private static String question3 = "\nWhich of the following keywords indicates that a method will not return any information:\nA. int\nB. void\nC. double\nD. String";
    private static String question4 = "\nWhich of the following format specifiers represents the placeholder for string:\nA. %d\nB. &s\nC. &n\nD. %s";
    private static String question5 = "\nEnables a program to read data for use in a program:\nA. Stream\nB. Scanner\nC. System\nD. Prompt";
    private static String question6 = "\nAn access modifier that makes variables accessible only for methods of the class where\nthey are declared is:\nA. protected\nB. public\nC. private\nD. default";
    private static String question7 = "\nKeyword that requests memory from the system to store an object, then calls the\ncorresponding class's constructor to initialize the object:\nA. fields\nB. next\nC. void\nD. new";
    private static String question8 = "\nVariables declared in a method's body that can be used only in that method:\nA. global variables\nB. method variables\nC. instance variables\nD. local variables";
    private static String question9 = "\nWhen each object of a class maintains its own copy of an attribute, the field that\nrepresents the attribute is also known as a(n) _____:\nA. format specifier\nB. instance variable\nC. modifier\nD. parameters";
    private static String question10 = "\nThe name of the array followed by the index of the particular element in square brackets is:\nA. array-access expression\nB. index array\nC. arguments\nD. index-array expression";
    private static String answer1 = "c";
    private static String answer2 = "c";
    private static String answer3 = "b";
    private static String answer4 = "d";
    private static String answer5 = "b";
    private static String answer6 = "c";
    private static String answer7 = "d";
    private static String answer8 = "d";
    private static String answer9 = "b";
    private static String answer10 = "a";

    // creating an object to generate messages randomly
    private static SecureRandom random = new SecureRandom();

    // declaring an array to store instance variables
    private static final String[] test = {question1, question2, question3, question4, question5,
            question6, question7, question8, question9, question10};

    // variables for counting correct and incorrect answers
    private static int correct = 0;
    private static int incorrect = 0;

    // method to simulate a question
    public static int simulateQuestion() {

        // reducing the possibility of repeating questions
        int index = random.nextInt(10000) % 10;

        System.out.println(test[index]);
        return index;
    }

    // method to ask a user for an answer
    public static String inputAnswer() {

        Scanner input = new Scanner(System.in);

        System.out.println("Type your answer here:");
        String answer = input.next();

        return answer;
    }

    // method to generate messages
    public static String[] generateMessage() {

        // creating an arrays to store different messages
        final String[] messages1 = {"Excellent!", "Good!","Keep up the good work!", "Nice work!"};
        final String[] messages2 = {"No. Please try again", "Wrong. Try once more", "Don't give up!", "No. Keep trying.."};

        // generating a random message from each array
        int index1 = random.nextInt(messages1.length);
        int index2 = random.nextInt(messages2.length);

        // returning an array with two string values
        return new String[] {messages1[index1], messages2[index2]};
    }

    // method to run the program by checking correctness of the questions
    public static void checkAnswer() {

        // for loop to display five questions only
        for (int i = 0; i < 5; i++) {

            // assigning a new variable of type int to the returned value from the simulateQuestion() method
            int index = simulateQuestion();
            // assigning a new variable of type String to the user's input value from the inputAnswer() method
            String answer = inputAnswer();
            // assigning a new array of type String to the returned array value from the simulateQuestion() method
            String[] message = generateMessage();

            // creating a switch statement for different questions
                switch (index) {
                    case 0:
                        if (answer.equals(answer1)) {
                            System.out.println(message[0]);
                            correct++;
                        } else {
                            System.out.println(message[1]);
                            incorrect++;
                        }
                        break;
                    case 1:
                        if (answer.equals(answer2)) {
                            System.out.println(message[0]);
                            correct++;
                        } else {
                            System.out.println(message[1]);
                            incorrect++;
                        }
                        break;
                    case 2:
                        if (answer.equals(answer3)) {
                            System.out.println(message[0]);
                            correct++;
                        } else {
                            System.out.println(message[1]);
                            incorrect++;
                        }
                        break;
                    case 3:
                        if (answer.equals(answer4)) {
                            System.out.println(message[0]);
                            correct++;
                        } else {
                            System.out.println(message[1]);
                            incorrect++;
                        }
                        break;
                    case 4:
                        if (answer.equals(answer5)) {
                            System.out.println(message[0]);
                            correct++;
                        } else {
                            System.out.println(message[1]);
                            incorrect++;
                        }
                        break;
                    case 5:
                        if (answer.equals(answer6)) {
                            System.out.println(message[0]);
                            correct++;
                        } else {
                            System.out.println(message[1]);
                            incorrect++;
                        }
                        break;
                    case 6:
                        if (answer.equals(answer7)) {
                            System.out.println(message[0]);
                            correct++;
                        } else {
                            System.out.println(message[1]);
                            incorrect++;
                        }
                        break;
                    case 7:
                        if (answer.equals(answer8)) {
                            System.out.println(message[0]);
                            correct++;
                        } else {
                            System.out.println(message[1]);
                            incorrect++;
                        }
                        break;
                    case 8:
                        if (answer.equals(answer9)) {
                            System.out.println(message[0]);
                            correct++;
                        } else {
                            System.out.println(message[1]);
                            incorrect++;
                        }
                        break;
                    case 9:
                        if (answer.equals(answer10)) {
                            System.out.println(message[0]);
                            correct++;
                        } else {
                            System.out.println(message[1]);
                            incorrect++;
                        }
                        break;
                    default:
                        System.out.println("Wrong input!");
                        break;
                }
        }
        // counting correct and incorrect answers
        System.out.println("Number of correct answers is " + correct);
        System.out.println("Number of incorrect answers is " + incorrect);
    }
}
