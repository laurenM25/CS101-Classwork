public class B extends A {
    public B() {
        super(); // run A's constructor
        System.out.println("B object created");
    }

    /**
     * Overrides A's foo() method
     */
    public void foo() {
        System.out.println("Foo in B");
    }

    /**
     * Overloads the foo() method
     */
    public void foo(int x) {
        System.out.println("Foo v2 in B");
    }

    public void bar() {
        System.out.println("Bar in B");
    }

}
