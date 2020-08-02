import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int before = scanner.nextInt();
        boolean decreasing = false;
        boolean result = true;
        int increase = 1;
        while (scanner.hasNext()) {
            int current = scanner.nextInt();
            if (current == 0) {
                break;
            }
            increase++;
            if (current < before && increase == 2) {
                decreasing = true;
            } else if (current > before && increase > 2 && decreasing) {
                result = false;
            } else if (current < before && increase > 2 && !decreasing) {
                result = false;
            }
            before = current;
        }
        System.out.println(result);
    }
}