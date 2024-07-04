### Time complexity

Can be considered as rate of change of execution time of the algorithm as the input size increases

IF n = input size then dy/dx = time complexity [O(N)]


### Sapce complexity

Can be considered as rate of change of total space (auxilary + input) required to execute the algorithm

where,
auxilary : the extra space for ds used to solve the problem

input : space required to store input values

### Note 

Big O notation 

- TC of worst case scenario

- ignore constants & small values (when the input value is high these values are negligible when calculating rateof change)

Theta notation

- TC of best case scenario

Omega notation
- TC of average case scenario


### identify time-complexity required by constraints

https://codeforces.com/blog/entry/21344

If n ≤ 12, the time complexity can be O(n!).

If n ≤ 25, the time complexity can be O(2n).

If n ≤ 100, the time complexity can be O(n4).

If n ≤ 500, the time complexity can be O(n3).

If n ≤ 104, the time complexity can be O(n2).

If n ≤ 106, the time complexity can be O(n log n).

If n ≤ 108, the time complexity can be O(n).

If n > 108, the time complexity can be O(log n) or O(1).
