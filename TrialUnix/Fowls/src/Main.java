public class Main {
    public static void main(String[] args) throws Exception {
        Fowl[] fowls = new Fowl[3];
        fowls[0] = new Fowl();
        fowls[1] = new Goose();
        fowls[2] = new Duck();

        System.out.println("\n");

        for (int j = 0; j < fowls.length; j++) {
            Fowl thisObj = fowls[j];
            thisObj.define();

            if (thisObj instanceof Goose) {
                Goose g = (Goose) thisObj;
                g.honk();
                g.shouldRun();
            }
            if (thisObj instanceof Duck) {
                Duck d = (Duck) thisObj;
                d.shouldFeed();
            }
        }
    }
}
