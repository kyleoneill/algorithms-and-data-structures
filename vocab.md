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
- Handle, Reference, Pointer
  - Pointer - A bundle of an address and a type, describing where some
    data is located in memory and what type that data is.
  - Reference - An alias of an object. References are sometimes implemented
    as pointers that are automatically dereferenced upon use. A usage of a
    reference is a usage of the object.
  - Handle - An opaque reference to an object, the type of the handle is
    unrelated to the referenced element. It can be thought of as (but is not
    literally) a pointer to a pointer. A good example is the returned `int`
    of a system call to `open`. `open` returns an `int` which represents an
    entry in the open files table. That entry is responsible for storing
    reference data, the handle is a way to reference the entry. This allows
    for the implementation of the table to be refactored without breaking
    compatiblity, as long as `open` always returns an `int` referring to a table
    entry.
- Covariance
  - Covarient - Subtyping relation of simple types are preserved for complex
    ones. A list constructor is covarient if `Cat` is a subtype of `Animal` and
    a `List<Cat>` is a subtype of `List<Animal>`.
  - Contravariant - Subtyping relation of simple types are reversed for
    complex ones. A function type constructor is contravariant if a function
    that converts an `Animal` to a `String` is a subtype of one that converts
    a `Cat` to a `String`.
  - Invariant - No variance in use.
  - Covariance is the quality of becoming more specific (`Cat` is covariant
    to `Animal`) and contravariance is the quality of becoming more general
    `Animal` is contravariant to `Cat`).
