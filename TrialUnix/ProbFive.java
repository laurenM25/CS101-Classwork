public class ProbFive {

    public static String strip(String input) {
        int index = 0;
        for (; index < input.length(); ++index) {
            if (input.charAt(index) == '\0') {
                break;
            }
        }
        return input.substring(0, index);
    }

    public static void main(String[] args) {

        String str = "Hi my name is La\0uren.";
        System.out.println(strip(str));

    }

}