import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt(); // read the next number of the array
        }

        for (int j : arr) {
            sum += j;
        }
        System.out.println(sum);
    }
}