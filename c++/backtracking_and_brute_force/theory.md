Brute-force => idea
Backtracking => implementation (brute force using recursion strategy)

------------

strategy for solving using brute force by creating possibilities and considering valid ones:

all possibilities in certain cases are created recursively and some cases iteratively

generators => create possibilites
checkers => check if a given possibility is valid

we need 2 main things -
1. identify constraints of problem
2. decide and apply generators and checker on the constraints


- generator can be applied on any constraints and checkers will be on the remaining constraints
- complex part is 99% time the generators
- so choose constraints on which the generators will be applied such that it reduces number of possibilites implicitly by
  eliminating obvious invalid possibilities in its generation 


###LCCM framework
Level-Choice-Check-Move

Level()
- how do we incrementally build the solution?
- how to make progress?
- this decides the recursion parameters and a particular recursion level 

Choice()
- possible choices from the current level

Check()
- if the selected choice is valid

Move()
- make a recursive call, if the check for the current choice is valid  

----------------

###Quesions solved

####2 dec'24

1. abcde/efghi = N, where (a ... i) can take unique values b/w (0..9) and 1<=N<=100 
- constraints: 1. uniques values, 2. equation
- considering generator here with 2nd as constraint will reduce valid possibility set.
i.e: find all combinations for (01234 <= abcde <= efghi * N) => (01234 <= abcde <= 98765 * N)
- checker for generated possibility will be 1st constraint

2. N queens in N*N board
constraints: 1. no 2 queens should be able to kill each other, 2. each row can have 1 queen

- level: current row where we need to fill the queens with state as already filled queens
- choice: try to fill in all columns for current row
- check: if by filling a particular column in curr row does not kill any queen then move
- move: recursion to next level by filling that cell, after this recursion in completed undo this state to explore other paths 

Here the meaning of recursive call is:
- rec(level) -> given a valid state of queen placement from [0 .. level], current recursive level should count number of valid placements from [level...N-1]

and the induction is => assuming (level-1) rows are valid verify if placing at (level) is valid 


3. Prime Palindrome numbers b/w [2, 10^9]
- constraints: 1. prime, 2. palindrome

- generate all palindromes and check if it is prime
- induction: palindromes can be generated recursively from one valid palindrome with length n=>length n+1 & length n+2

- level: valid palindrome with length n and n is even
- choice: create valid palindromes from length n to n+1(odd) and n+2(even)
- check: check generated palindromes of n+1 and n+2 are prime 
- move: from n+2 (which will have even length) possibilities call recursively to generate next (n+2+1) and (n+2+2) length palindromes 


4. Prime cycle: permutations of an array where sum of all pair of numbers with its neighbors is prime
- constraints: 1. sum of all pairs to be prime, 2. numbers cannot repeat in sequence

- induction: given a valid length of array (n) having all pairs sum prime, find all possibilities for n+1 element such that nth element and n+1 element sum is prime 

- level: index of array, rec(level) => means given [0..level-1] is valid with utilised elements stored, find valid sequences from [level ... N-1]