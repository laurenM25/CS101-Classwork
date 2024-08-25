public class Main {

    public static String backwards(String original) {
        // base case: return the original
        if (original.length() <= 1) {
            return original;
        }
        // recursive case: return the last character + the backwards of the remainder
        else {
            char lastChar = original.charAt(original.length() - 1);
            String remainder = original.substring(0, original.length() - 1);
            return lastChar + backwards(remainder);
        }
    }

    public static void main(String[] args) {
        String bckwds = backwards("hello");
        System.out.println(bckwds);
    }
}
