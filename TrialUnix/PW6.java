public class PW6 {
    public static void main(String[] args) {

        String primes = "";
        for (int j = 2; j <= 100; j++) {
            int counter = 0;
            for (int k = j; k >= 2; k--) {
                if (j % k == 0) {
                    counter++;
                }
            }
            if (counter == 1) {
                primes += j + " ";
            }

        }

        System.out.println(primes);

    }
}