public class Duck extends Fowl {
    public Duck() {
        super();
        System.out.println("Specifically, a Duck is created.");
    }

    public void define() {
        System.out.println("This is a Duck.");
    }

    public void shouldRun() {
        System.out.println("Oh look, it's a duck. No need to run.");
    }

    public void shouldFeed() {
        System.out.println("feed it!");
    }
}
