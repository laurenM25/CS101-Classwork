public class Prob7 {

    // problme 7
    public static boolean inBoundingBox(int[] p, int[] min, int[] max) {
        if (p[0] < max[0] && p[0] > min[0] && p[1] < max[0] && p[1] > min[0])
            return true;
        else
            return false;

    }

    public static void main(String[] args) {

        int[] ar_p = { -1, 4 };
        int[] ar_min = { 1 };
        int[] ar_max = { 6 };
        System.out.println(inBoundingBox(ar_p, ar_min, ar_max));

    }

}