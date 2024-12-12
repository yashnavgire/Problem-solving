11 Dec'24

#### Generating balanced bracket sequences of length N with depth at max k
- balanced bracket check or generation is done by `depth of bracket sequence`, where depth increases `+1` for '(' and `-1` for ')' 

1. form -> form1
2. state space formulation -> (index, d): returns number of sequences from (index...N) with depth at max k
3. transition modelling -> 
    there are 2 choices at each index('(' or ')')
    choice1 transition '(' : (index+1, d+1)
    choice2 transition ')' : (index+1, d-1)

    base case -> when we reach N(index) and depth is 0 (since we want balanced sequence) then we can say it is valid sequence (return 1) else return 0
4. time complexity check -> no_of_states*(1+no_of_transition*cost_per_transition) 
                            = (N*K)*(1+2*1) = 3*N*K
                            = O(N*K) 


