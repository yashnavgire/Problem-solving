### optimise the time complexity where all permutations are required.

#### it optimises time complexity from O(2^n) -> O(2^n/2)

1. applicable in problems where N~(40-60) and all permuatations are required
2. since 40! will exceed time limit, we try to divide the original set in 2 halfs (20, 20) and create permuatations independently for smaller lengths.
3. now we get 2 result set, if we do cross product of those 2 set we create original all permuatations which leads to again 40! or 2^40, which will exceed time limit.
4. so we try to optimise here based on constraints, i.e
    for every combination in result set 1 we try to find all possible combination efficiently(mostly Binary Search) such after combining it satisfies the constraint.
5. note that this strategy cannot be applied on all permumatation problems, its possible when -
    - The problem can be divided into two independent subproblems:
    - Both subproblems are of roughly equal size
    - Combining solutions is feasible
    - A matching or pairing criterion from 2 sets is available


example problem: 

1. from a set of given numbers N(1<=len(N)<=40), find number of subsets having sum of elements <= X for a given X.
- divide set in 2 halves 20, 20
- generate sum for all subsets in each set, TC: O(2*2^20)
- select one element from result set 1 which has sum say s1 and find possible subset sums from result set 2 by performing upper_bound on (X - s1)




