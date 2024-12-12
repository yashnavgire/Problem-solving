DP -> Can be applied on `DAG` where `DAG` is created as - nodes are states and edges represent the dependency b/w the states. (Which we also call as `recursion tree`)
- If the 2 or more state depends on same state (and this condition is true for multiple states) then we can reuse the computed value for that state by caching it
- It needs be DAG since we want to know which state depends(source) on other states(destination) and no cyclic dependency - as cycles will lead to deadlock and infinite recursion

`Top-Down(reverse topological order):` start from reverse topological order where we are not sure if its dependencies are evaluated, so first we resolve all the current state dependencies using recursion and then solve the current one (storing dp value at end of recursion is nothing but topo sort)

`Bottom-Up(topological order):` start evaluation from base case where we know the ans at it do not depend on any other state (topological order). We then move to evaluate state which are dependent on this base case and evaluate them. All the evaluated onces are stored and we compute the other states in topological order since that order guarantees all its dependent states are evaluated  

#### difference b/w DP and backtracking(implementation wise): 
- Generally the backatracking solution only keep position as level and other states are global
and this global state is updated every time. we do not maintain ans for each states in backtracking as there are no overlapping subproblems 
- Therefore `rec(level)` -> can give different ans based on different global state
- In dp as there are overlapping states, we maintain the ans for each state to reuse it.
and the `rec(level, other_states)` will always return same value for given level, state. 


#### notes:

- constraints in the problem makes a backtracking/recursive problem to be optimised as dp
(if it has overlapping sub-problem and optimal substructure).
- whenever there are multiple queries for same input, if we want to use the same dp array across the queries then the dp array states should not have a parameter which directly changes with the each query (that makes dp array answers cached specific to that query)
ex: if subset sum equals K -
   There are 2 ways to formulate the states for this: 
   1. dp[array_index][sum_till_now] -> represents if from [array_index ... n] with already consumed sum as 'sum_till_now' a subset with sum K exists  
   2. dp[array_index][left] -> represents if from [array_index ... n] can we form a subset with sum 'left' 


### DP Framework:

1. Recognise DP form (patterns : 5 types in 90%) - form helps to formulate states and transition of states (choices) 
2. State transition modelling: DP paramters to recursive function (states) and what are we computing (understand the meaning of recusion and dp) 
3. Transition modelling & base case -  
5. Time & space complexity check
   [O(V+E) -> toposort TC]
   In DP: V = `no. of states`
          E = `(no of states)*(no. of transitions in worst case * cost per transition)`
   Therefore, formula - `(no. of states) + (no of states)*(no. of transitions in worst case * avg cost per transition)` 
   in most cases cost per each transitions takes ~ O(1)
   `Note: the above TC is required only to compute dp one time, now once for all states cache is filled => any call to rec(state) with any state will run in O(1) as it will hit the cache`

5. Code (for all forms same)
   1. pruning
   2. base case
   3. cache check
   4. compute - for each transition
      i. In some cases transition cost could be high, one technique is to precompute the values for all such transitions.
         for ex: check if the current transition is palindrome substring, we can precompute for all substrings if those are palindromic or not using dp too in O(N^2) and just check while transitioning if substring from(i,j) is palindromic substring
   5. save and return for this state

![alt text](image.png)



#### Form1 = LCCM: knapsack variation - take choice at each level
1. overlapping sub-problem from all possible subsequence/subarray from (i,j)
2. states: are class/object in problem + constraints

//general state formulation
`dp(index/level, constraint_variable) - best ans from (index .... n) given constraint`

3. transitions: dp(index, constraint_variable) 
   -> take
   -> not_take
   or
   -> take one of the choices (for substring) 

Also known as knapsack variation
other problems -
a. find a subset sum equals K
b. climb stair



#### Form2: ending/starting at `i` where inclusion of `i` is mandatory (subsequence/subarray partitioning)
1. overlapping sub-problem from all possible subsequence from (i,j) which includes j in all combination 

2. states:
dp(index, other_constraint_optional) - best ans with combinations starting/ending at index(inclusion of index is mandatory in all combinations out of which best is selected to form this dp state)

`dp(index, other_constraint_optional) - returns optimal ans from all subsequence/subarray from (0...index], where index is always included `

mandatory inclusion of index basically means we are partitioning at `index`

3. transitions: 
for all j from index to 0 in array:
   //perform one partition from [j..index] and make a transition, out all those first partition at j for this state pick the min/max based on problem

   dp[index] = min/max(consider_value_from_j_to_index_in_computation + dp(j-1))



#### Form3: multi-sequence dp
1. similar to form1 of choosing but need to simulataneously choose from 2 or more array/string

2. state formulation: 
   `dp(int i, int j): returns optimal value from (i...N) and (j...M) of 2 arrays/strings of length N and M`
   
3. transitions:
   - given a state dp(i,j):
      //following are possibilities - can be all or some depending on problem
      choice on i (take/noTake/take one of choices from multiple) + dp(i+1,j)
      choice on j (take/noTake/take one of choices from multiple) + dp(i, j+1)
      choice on i and j both (take/noTake/take one of choices from multiple) + dp(i+1, j+1)


#### Form4: LR/Partition dp
1. overlapping sub-problem for all possible subarray from (i,j) [contigous combination from (i,j) with order maintained, i.e contigous and all elements considered + order of elements wrt original array mandatory]

start-end partitioning
merge partitions 

2. state formulation:
   - `dp(l, r, other_state): returns optimal ans for all subarray combinations from [l..r]`

3. transitions:
   - given a state dp(l, r):
     //move to different subarray combination possibilites based on what is asked in problem, for ex:
     consider l and r for current state calculation + dp(l+1, r-1) 



#### Form5: Game dp
1. game like question with turns
2. try to identify if from a given state going to atleast one losing state is possible?
   if yes then that state will be considered as winning, since player will move optimally to next losing state so opponent will lose
   

Form summary:
![alt text](image-1.png)

------------------------------------------------------------------------------------------------------------------------------------

11 Dec' 24

printing dp solution, which path gave optimal solution:

- basically we need to identify which transitions gave us the optimal solution at each state:
1. refer the dp cache value to get current state optimal `ans`
2. make transitions same as in dp rec code and check which one equals to `ans` and then break(if only one of the valid soltn to be printed)
3. save the transition in print solution 
4. recurse on the next state possible after considering step 2 identified optimal transition


12 Dec' 24

form4: 

- If we want to find optimal value from combinations of transitions in subarray for each state(i.e interval (l,r, ...some_other_state)) then use form4


form3: (similar to form1 of choosing but need to simulataneous choose from 2 or more array/string)

- Most of the questions where we need to match string 1 to string 2 - this form is used