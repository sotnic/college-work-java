package oleksandr_sotnykov_exercise03;

import java.util.Arrays;

public class SortNumbers {

    public static void main(String[] args) {

        int[] array = new int[] {3, 34, 6, 120, 22, 18, 33, 78, 55, 9};

        System.out.println("--- Sorting numbers in ascending order ---");

        Arrays.sort(array);

        for (int number: array) {
            System.out.print(number + " ");
        }

        System.out.println(" ");
        System.out.println("--- Sorting numbers in descending order ---");

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
