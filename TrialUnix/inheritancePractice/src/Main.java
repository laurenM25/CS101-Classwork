public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("\nInstantiating objects to put in array...\n");
        // create an array of 3 A objects
        A[] objects = new A[3];

        // store an A object, a B object, and a C object in the array
        // this is possible because B and C objects are both also A objects - they
        // inherit from A
        objects[0] = new A();
        objects[1] = new B();
        objects[2] = new C();

        // loop through the array of A objects
        System.out.println("\nLooping through objects in array...\n");
        for (int i = 0; i < objects.length; i++) {
            // get access to each object
            A thisObj = objects[i];

            // call each's foo() method... A objects all have foo methods, so this is ok
            thisObj.foo();
            // thisObj.bar(); // only B and C objects have a bar method, yet thisObj is
            // declared as type A, so Java will not let us call the bar method on an A-typed
            // variable

            // check whether any given object is a B, and run the B-specific bar method if
            // so
            if (thisObj instanceof B) {
                B bObj = (B) thisObj; // cast this object to a variable of type B
                bObj.bar(); // now we can run the B-specific bar method.
                // ((B) thisObj).bar(); // another way to cast and call this method
            }

            // check whether any given object is a C, and run the C-specific bum method if
            // so
            if (thisObj instanceof C) {
                C cObj = (C) thisObj; // cast this object to a variable of type C
                cObj.bum(); // now we can run the C-specific bar method.
                // ((C) thisObj).bum(); // another way to cast and call this method
            }
        }

    }
}