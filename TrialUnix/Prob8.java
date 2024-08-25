public class Prob8 {
    public static int distanceTwoDimension(int[] min, int[] max) {
        int x = min[0];
        int y = min[1];
        int z = max[0];
        int w = max[1];

        int distance = Math.abs(x - z) + Math.abs(y - w);

        return distance;
    }

    public static void main(String[] args) {
        int[] ar_min = { 22, 8 };
        int[] ar_max = { 45, 2 };

        int distance = distanceTwoDimension(ar_min, ar_max);
        System.out.println(distance);
    }
}