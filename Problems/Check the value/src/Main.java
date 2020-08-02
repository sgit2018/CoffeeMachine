import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        String result = input < 10 ? "true" : "false";

        System.out.println(result);


    }
}