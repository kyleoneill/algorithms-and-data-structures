# Algorithms
## Algorithms
An algorithm is any well defined computational procedure that takes some value(s)
as input and produces some value(s) as output in a finite amount of time, transforming
the input through a sequence of computational steps.

Algorithms for a given problem are _correct_ if they _halt_, finish computing in
a finite amount of time, for every input. Incorrect algorithms might not halt on some
input instances, but can still be useful (there are useful incorrect algorithms for finding
large prime numbers).

## Data Structures
A data structure is a way to store and organize data in order to facilitate access and
modification.

# Turing Machine
A mathematical model of computation describing an abstract machine. The machine
manipulates symbols on a tape according to a table of rules. At each step of operation,
the head reads a symbol off of the tape and then, depending on its internal state and rules,
will either write a new symbol in that cell, move left, move right, or halt.

Turing machines differ from real-world computers as real-world computers use random-access
memory and are not limited to moving left/right on a tape.

A computational model or system is turing-complete if it can simulate a turing machine, which
indicates that it can implement any computer algorithm.

## Nondeterministic Turing Machine
A nondeterministic turing machine is a theoretical model of computation where there is
more than one possible action that can be taken in a given situation. The next state is
not completely determined by its action and the current symbol it is reading.

# Computational Complexity
## P
A problem is P if it is tractable (can be solved in practice rather than in theory only) and
can be solved in polynomial time by a deterministic turing machine. The "selection sort"
algorithm on `n` integers performs An<sup>2</sup> operations, where `A` is some constant.
Since it runs in O(n<sup>2</sup>), it is a polynomial-time algorithm.

## NP
NP is the set of problems which can be _solved_ in polynomial time by a nondeterministic
turing machine and _verified_ in polynomial time by a deterministic turing machine. All P problems
are also NP, but not all NP problems are P. A problem is NP and not P if it cannot be solved in
polynomial time but a solution can be verified to be correct in polynomial time.

## NP-Complete

## NP-Hard

## P vs. NP Problem
This is an unsolved problem which asks if P=NP, or, if every problem whose
solution can be quickly verified can also be quickly solved.

## Efficiency
There are different algorithms to accomplish the same task with trade-offs. As an example,
"insertion sort" is a sorting algorithm with c\*n<sup>2</sup> runtime and "merge sort" is a sorting
algorithm with c\*n\*lg(n), where `c` represents some unique constant for both algorithms and `n` represents the size of the input. Constants can be discarded when comparing how algorithms
grow in runtime as their inputs increase, so these two problems can be described as `n` and `lg(n)`.
This means that insertion sort usually runs faster for small inputs, but merge sort runs faster
as the input size grows.

PAGE 15
