public class A {

    private String message;

    public A() {
        System.out.println("A object created");
        this.setMessage("Hello");
    }

    /**
     * Classic getter.
     * 
     * @return The message value.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Classic setter
     * 
     * @param message The new message to store.
     *                Does some basic validation.
     */
    public void setMessage(String message) {
        if (message.length() > 0)
            this.message = message;
    }

    public void foo() {
        System.out.println("Foo in A");
    }
}
