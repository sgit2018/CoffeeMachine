import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = number;
        while (scanner.hasNext()) {
            int nextNumber = scanner.nextInt();
            if (sum >= 1000) {
                sum = sum - 1000;
                break;
            } else {
                sum = sum + nextNumber;
            }
            if (nextNumber == 0 || number == 0) {
                break;
            }

        }
        scanner.close();
        System.out.println();
        System.out.println(sum);
    }

}