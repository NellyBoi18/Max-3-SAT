# Max3SAT
This program implements an algorithm in Java which, when given a MAX 3-SAT instance, produces an assignment which satisfies at least 7/8 of the clauses.

# Input:
The input will start with a positive integer n giving the number of variables, then a positive integer m giving the number of clauses and then m lines describing each clause. The description of the clause will have three integers x y z, where |x| encodes the variable number appearing in the first literal in the clause, the sign of x will be negative if and only if the literal is negated, and likewise for y and z to describe the two remaining literals. For example, 3 − 1 − 4 corresponds to the clause $x_3 \bigvee \bar{x_1} \bigvee \bar{x_4}$

# Output:
The program outputs an assginment that satisfies at least ⌊7/8⌋m clauses. It returns n numbers in a line, using a ±1 encoding for each variable (the ith number should be 1 if $x_i$ is assigned TRUE, and -1 otherwise).

# Sample:
**Input:**\
10\
5\
-1 -2 -5\
6 9 4\
-9 -7 -8\
2 -7 10\
-1 3 -6\

**Output:**\
-1 1 1 1 1 1 -1 1 1 1

The maximum number of satisfied clauses is 5, so the assignment should satisfy at least ⌊$\frac{7}{8}$ × 5⌋ = 4 clauses. The given output above is just one possible correct output.