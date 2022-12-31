# Chapter 1

## Summary of topics

1. Fundamentals - Data abstraction, basic data structures, ADTs for collections,
   methods for analyzing algorithm performance
2. Sorting - Rearranging arrays in order, a fundamental type of algorithm.
   Sorting algorithms that are considered in the book include insertion sort,
   selection sort, shellsort, quicksort, mergesort, and heapsort.
3. Searching - Finding a specific item in a large collection is also of
   fundamental importance. This includes binary search, search trees, and hashing.
4. Graphs - Sets of objects and connections, possibly with weights and orientation.
   The book considers depth first search, breadth first search, connectivity
   problems, Kruskal and Prim's algorithms for finding minimum spanning tree
   and Dijkstra's and Bellman-Ford algorithms for solving shortest-path problems.
5. Strings - Sorting and searching when keys are strings, substring search,
   regex, data compression algorithms
6. Context - Relate the material in the book to other advanced fields of study

## Data Abstraction

When using an ADT we focus on the operations specified in the API and do not care
about the data representation. When implementing an ADT we focus on the data,
then implement operations on that data.

ADTs are important because they support encapsulation. Implementing different
algorithms for the same task allow us to handle differing performance
characteristics without changing client code.

You do not need to know how a data type is implemented to use it.

### Objects

Objects are characterized by three essential properties

1. State - The values associated with a data type, the fields of an instance.
2. Identity - Distinguishes one object from another, like the place
   where its value is stored in memory.
3. Behavior - Effect of data-type operations. The methods of an instance.

The implementation has the responsibility for maintaining an object's identity.
A reference is used to access an object instance, as opposed to accessing the data
as a value.

An assignment statement with a reference type in Java (the language used in the
book) creates a copy of the reference. This does _not_ create a new object.

```java
Counter foo=new Counter(); // This creates a new counter with a tally of 0
        Counter bar=foo; // This copies the reference of foo into bar
        foo.increment(); // This increments the tally field of foo AND bar, as they share the same reference
        System.out.println(bar.tally) // This prints 1. foo.increment() has also incremented bar
```

Following this, passing an object to a method or function passes a reference
to the variable.

### Interfaces and Inheritance

An object of one class can utilize the functionality of another class by
inheriting from it. An interface is an "empty" class that is used to guarantee
certain functionality. Ex, if you know a class inherits from a `Printable`
interface, you know it has certain functions defined in the `Printable` interface.

Interface inheritance allows for functions to operate on any type that implements
the interface. Ex, a function that takes a type that implements the `Animal`
interface as a parameter can take a `Dog` or `Cat` that inherits from `Animal`.

### Immutability

Most objects in Java are mutable, with exceptions (Vector, String, etc).
The `final` keyword only turns a variable set to a primative type as
immutable. A `final` reference type can still be modified, ex

```java
public class Vector {
    private final double[] coords;

    public Vector(double[] a) {
        coords = a;
    }
}

    double[] a = { 3.0, 4.0 };
    Vector vec = new Vector(a);
a[0]=0.0; // This mutates the `final vec.a` field by bypassing the Vector API
```

This problem can be avoided by using a defensive copy. We can set `coords` to a
new array in the constructor and then iterate through `a`, copying each element
into `coords`. `a` consists of `double`s so the reference issue will not
be repeated further. This will be an `n` time operation rather than a constant
one, but it will prevent the described issue.

Most languages deal with immutability the same way Java does, or just have
all data be mutable. Rust deals with this issue by marking data as mutable with
a `mut` keyword. Data is, by default, moved (passing by value and switching
ownership). A passed reference can only be modified if given a `mut` reference
and only one of these can exist at a time (with exceptions).

## Bags, Queues, Stacks

Bags, queues, and stacks are collection data types. Collections revolve around
adding, removing, and examining objects in the collection. Each of these
collections rely on a linked list to function. They also rely on generics
and iteration.

Each of these should have an API that includes a no-argument
constructor, a method to add an item, a method to test if the
collection is empty, and a method that returns the size of the
collection. `Stack` and `Queue` should also have a method to
remove an item.

### Bag

A bag is a collection where items can be added but not removed.
A bag does not need an accessor for an individual item, but it
must be iterable.

### Queue

A queue is a first-in-first-out (FIFO) collection. New elements
are added to the back of the queue, removed elements are taken
from the front.

### Stack

A stack is a last-in-first-out (LIFO) collection. New elements
are added to the back of the stack, removed elements are taken
from the back.

An interesting use of a stack is an algorithm to evaluate
expressions, ex `( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )`.
Dijkstra's Two-Stack Algorithm for Expression Evaluation allows
two stacks to evaluate expressions like this, keeping one stack
for operations and another for values. Tokens are read and ops
and values are pushed onto two stacks (one each), when a closing
parenthesis is reached then an op and a value are popped off
the stack. Match on the op and perform that operation on the
value and a second value popped off the value stack. Add the
result onto the value stack. After all input is read and evaluated,
pop a val off the value stack and that is the expression result.

<h3 id="implementing-collections">
Implementing Collections
</h3>

In order to develop something like a bag, stack, or queue, it
helps to make a simple collection and then build out the
implementation.

The primary choice in developing an API implementation is to
choose a representation of the data. Ex, some `FixedCapacityStackOfStrings`
might be represented as an array of string values. This
`FixedCapacityStackOfStrings` might have a constructor that takes
an `int` which determines the array length, a `push` to append
a string, a `pop` to remove the most recently added string (it is
a stack), an `isEmpty` to determine if the stack is empty, and a
`size` to get the current number of strings on the stack.

The first problem with our example `FixedCapacityStackOfStrings`
is a lack of applicability; we can only use it for strings. It
would not be feasible to make a new class for each type we want
a stack for. This can be solved by replacing our string with a
generic, making our stack a `FixedCapacityStack` that takes some
`T` instead of `String`. We can change the class signature to look
like `public class FixedCapacityStack<T>`. In Java, `T` must be
a reference type. A primitive can be used by autoboxing the
reference-stand-in reference type (`Integer` for `int`, ex).

#### Array Resizing

Arrays have a set length. An API user can only use our class if
they either know an exact max size they need or have an
approximate guess and are willing to make an arbitrarily large
array, wasting resources. This problem can be solved by adding
a private `resize` method to our class and then in `push` we can
check if the array is full before adding a new element and
resizing it if so. It is typical to double the current max size
of an array during a resize. It is cheaper to resize a smaller
array and more expensive to resize a larger array, doubling the
max size allows us to resize less often as the dataset becomes
large. `resize` should take a parameter of the new max size and
`push` should pass it the current max doubled.

`resize` will create a new array with our new max size and copy
all the elements from the current array into the new one, then
set the current array to the new one.

Having `resize` take a parameter for a new max size allows for
`pop` to also resize the array if it becomes too empty and we need
to free memory. We should halve the array size if the used portion
is less than 1/4 of the array size. We choose 1/4 because after
it is halved, half of the resulting array will be used which is
a good amount to still be using while giving us space to add before
another resize.

#### Loitering

When we `pop` we should also `null`ify data we are removing so it
can be garbage collected. For example,

```java
// Autoformatter, WHY are you like this
public T pop(){
        T item=a[--n];
        a[n]=null; // Avoid loitering
        if(n>0&&n<=a.length/4)resize(a.length/2);
        return item;
        }
```

Setting `a[n] = null` when popping an item deletes our reference
to it. Doing this allows for the item to be orphened and garbage
collected when the client is done with it. If we did not do this,
we would retain our reference, regardless of if the client is
done with the data they popped, and the unused memory would not
be freed until a resize or a `push` that overwrites the given
`a[n]`.

#### Iteration

Iteration is a fundamental operation for a collection. Implementing
iteration depends on the language. In Python, an iterable is any
object that has the `__iter__()` and `__next__()` methods. In Java,
it's any class that implements the `Iterable` interface. In Rust,
it's any struct that implements the `Iterator` trait.

### Linked Lists

A recursive data structure that is either empty or is a bundle of
a generic item and a reference to either another linked list
or `null` if it is the tail node. A linked list is extremely
efficient when adding or removing elements in an arbitrary position.
In something like a vector, removing the first element requires us
to shift every element after the first to the left. In a linked
list, removing any arbitrary element requires us to stitch the
reference of the next element to the previous element, which is
a constant time operation. The drawback is that accessing an
element by index is an n time operation, as we can only get to
the `n`th element by traversing the list from the start.
