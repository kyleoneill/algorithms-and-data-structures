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
1. State - A value from its data type.
2. Identity - Distinguishes one object from another, like the place
   where its value is stored in memory.
3. Behavior - Effect of data-type operations.

The implementation has the responsibility for maintaining an object's identity.
A reference is used to access an object instance, as opposed to accessing the data
as a value.

An assignment statement with a reference type in Java (the language used in the
book) creates a copy of the reference. This does _not_ create a new object.
```java
Counter foo = new Counter(); // This creates a new counter with a tally of 0
Counter bar = foo; // This copies the reference of foo into bar
foo.increment(); // This increments the tally field of foo AND bar, as they share the same reference
System.out.println(bar.tally) // This prints 1. foo.increment() has also incremented bar
```
