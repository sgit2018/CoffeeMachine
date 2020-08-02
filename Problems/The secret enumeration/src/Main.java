public class Main {

    public static void main(String[] args) {
        String wordStartsWith = "STAR";
        int counter = 0;

        for (Secret s : Secret.values()) {
            if (s.toString().startsWith(wordStartsWith)) {
                ++counter;
            }
        }
        System.out.println(counter);
    }
}
