//put imports you need here

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        while (scanner.hasNext()) {
            names.add(scanner.next());
        }
        Collections.reverse(names);
        names.forEach(System.out::println);
        scanner.close();
    }
}