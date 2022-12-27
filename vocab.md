- ADT - Abstract Data Type
  - A data type whose representation is hidden from the end user
  - Examples include bag, queue, and stack
- Aliasing - An assignment statement with a reference type that copies the
  reference and does not create a new object. This results in two variables
  that point to the same object, e.g.
  ```java
  Counter foo = new Counter(); // This creates a new counter with a tally of 0
  Counter bar = foo; // This copies the reference of foo into bar
  foo.increment(); // This increments the tally field of foo AND bar, as they share the same reference
  System.out.println(bar.tally) // This prints 1. foo.increment() has also incremented bar
  ```