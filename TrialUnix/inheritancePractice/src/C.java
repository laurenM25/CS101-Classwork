public class C extends B {

    public C() {
        super(); // run B's constructor
        System.out.println("C object created");
    }

    // an overloaded constructor that accepts a message
    public C(String message) {
        super(); // call B's no-args constructor
        System.out.println("C object");
        this.setMessage(message);
    }

    /**
     * Overridden setter for the message property.
     * This version adds a bit of additional validation.
     * Note that this class cannot access the message property directly, since it is
     * private to A.
     */
    public void setMessage(String message) {
        if (message.indexOf("C") >= 0) {
            super.setMessage(message); // call B's version of the setMessage method
        }
    }

    /**
     * Override's B's foo() method
     */
    public void foo() {
        System.out.println("Foo in C");
    }

    /**
     * Override's B's bar() method
     */
    public void bar() {
        System.out.println("Bar in C");
    }

    public void bum() {
        System.out.println("Bum in C");
    }

}