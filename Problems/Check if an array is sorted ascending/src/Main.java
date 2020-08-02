
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt(); // reading a length
        int[] array = new int[len];  // creating an array with the specified length

        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt(); // read the next number of the array
        }
        boolean sorted = false;
        if (array.length > 1) {
            sorter:
            for (int k = 0; k < array.length - 1; k++) {
                if (array[k] <= array[k + 1]) {
                    sorted = true;
                } else {
                    sorted = false;
                    break sorter;
                }
            }
        } else {
            sorted = true;
        }
        System.out.println(sorted);
    }
}