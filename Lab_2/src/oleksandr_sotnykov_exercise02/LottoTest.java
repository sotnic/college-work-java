package oleksandr_sotnykov_exercise02;

import java.util.Scanner;

public class LottoTest {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Lotto array = new Lotto();
        int sum = Lotto.computerSum();

        for (int j = 0; j < 5; j++) {
            System.out.println("Type a number between 3 and 27 here:");

            int answer = input.nextInt();

            if (answer >= 3 && answer <= 27) {
                if (answer == sum) {
                    System.out.println("You won!");
                    break;
                } else {
                    if (j != 4) {
                        System.out.println("Wrong, try again.");
                    } else {
                        System.out.println("Sorry, computer won.");
                    }
                }
            } else {
                System.out.println("Your input is supposed to be in the range of numbers 3...27");
            }
        }
    }
}
