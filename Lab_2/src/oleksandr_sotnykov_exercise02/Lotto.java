package oleksandr_sotnykov_exercise02;

public class Lotto {

    // declaring a new array with three values in it
    private static int[] numbers = new int[3];

    // constructor for generating a random number between 1 and 9
    public Lotto() {
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 9 + 1);
        }
    }

    // method to calculate sum of the generated numbers
    public static int computerSum() {

        int sum = 0;
        System.out.println("\n-- LOTTO --");
        for (int value : numbers) {
            System.out.print(value + "\t");
            sum += value;
        }
        System.out.println("\nComputer sum is " + sum + " (in order to know how to win)");

        return sum;
    }
}
