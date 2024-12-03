### optimise the time complexity where all permutations are required.

#### it optimises time complexity from O(2^n) -> O(2^n/2) or O(X^n) -> O(x^n/2)

1. applicable in problems where N~(40-60) and all permuatations are required
2. since 40! will exceed time limit, we try to divide the original set in 2 halfs (20, 20) and create permuatations independently for smaller lengths.
3. now we get 2 result set, if we do cross product of those 2 set we create original all permuatations which leads to again 40! or 2^40, which will exceed time limit.
4. so we try to optimise here based on constraints, i.e
    for every combination in result set 1 we try to find all possible combination efficiently(mostly Binary Search) such after combining it satisfies the constraint.
5. note that this strategy cannot be applied on all permumatation problems, its possible when -
    - The problem can be divided into two independent subproblems:
    - Both subproblems are of roughly equal size (on an average in the algorithm)
    - Combining solutions is feasible
    - A matching or pairing criterion from 2 sets is available


### Note 
- generally meet in the middle or what needs to be divided and solved independently depends on the recursion level in brute force algo.
- the constraints for divided sets are defined by dividing levels
- on the divided constraints we create result sets independently and instead of doing cross product b/w 2 result sets which will be basically brute force result set we try to optimise search in other result set by fixing one result set element at a time


Example problems: 

2nd dec' 24

1. From a set of given numbers N(1<=len(N)<=40), find number of subsets having sum of elements <= X for a given X.
- divide set in 2 halves 20, 20
- generate sum for all subsets in each set, TC: O(2*2^20)
- select one element from result set 1 which has sum say s1 and find possible subset sums from result set 2 by performing upper_bound on (X - s1)

3rd dec' 24

2. Four sum variants
    1. find if there are four elements such that, a+b+c+d=target for array with length 1<=N<=1000, where a,b,c,d can repeat
    2. find if there are four elements such that, a+b+c+d=target for array with length 1<=N<=1000, where a,b,c,d are distinct
    3. find the elements {a,b,c,d} such that, a+b+c+d=target for array with length 1<=N<=1000, where a,b,c,d are distinct
    4. find total number of 4 pairs such that, a+b+c+d=target for array with length 1<=N<=1000, where a,b,c,d are distinct

    for repeated numbers allowed:
    - find all pairs sum(c+d) and store in map
    - again check all pairs (a,b) and see if T-(a+b) exists in map

    for distinct variants common algorithm is: (we cannot store all pairs some here)
    - here in one half/section we keep sum of all 2 pairs say c+d in a map
    - in 2nd section we iterate over a and b and check if (T - (a + b)) is in map
    - move b one step back and update map by adding sum of new pairs of b with elements from [b+1...n]      

    for other variants 3 & 4
    3. in map we keep the pair c,d
    4. in map we keep the count of a particular sum in map rather just if that sum exists or not

    As per our note, here in brute force soln the level in recursion is constraint on the problem. i.e
    number of elements equals target = 4.
    Therefore level is number of element remaining to choose from current index. following is recursive function definition
    rec(index, level=4/3/2/1): possible ways to choose level number of elements from (index ... n)
    
3. Square partition
    1. level in brute force here is array index
    rec(level, a,b,c,d): => given index level and 4 side length a,b,c,d, check whether with (level+1...n) can form a square
        //base
        if a==b==c==d:
            return true
        
        //choices -> in which side current index to be considered 
        rec(level+1, a+arr[level], b, c, d)
        rec(level+1, a, b+arr[level], c, d)
        rec(level+1, a, b, c+arr[level], d)
        rec(level+1, a, b, c, d+arr[level])

        return false
        

4. String reversals
    1. given string s, find if it can be converted to string T by reversing any of its substring by 4 times
    
    - here the brute force recursive approach is:

    The constraint is string can be reversed by 4 times.
    
    rec(s, number_of_reversals_remaining): given string s generate all possible strings by reversing each substring number_of_reversals_remaining times

        // base case
        if (number_of_reversals_remaining == 0)
            add in gen

        for each substring in s:
            rec(revers(substring, number_of_reversals_remaining-1))

    - so to decide on what to choose to divide on to solve independetly for possible meet_in_middle algo here based on level in brute force which is number_of_reversals_remaining can be considered

    - instead of creating all possiblities for 4 reversals on a string, we can create all possibilities on 2 reversals on S(initial string) and all possibilities on 2 reversals on T(target string)

    - from the above result sets if there one matching pair then we can say its possible to convert S->T by reversing 4 times

    Observation above is: if a string is reversed even number of times it results in same string

