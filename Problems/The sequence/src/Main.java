import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int counter = 0;
        labl3:
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
                counter++;
                if (counter == n) {
                    break labl3;
                }
            }
        }
        scanner.close();
    }

}