/*
Best Tutorial - https://www.topcoder.com/thrive/articles/Binary%20Indexed%20Trees
Question variants of BIT - https://medium.com/@adityakumar_98609/fenwick-tree-binary-index-tree-aca7824d9c2a

Problem it solves - 
1. Efficient mutable range query operations on array/contionous set applicable on invertible operations like sum, multiplication etc. 
Beneficial when write operations are significant
2. Time complexity for read and write - O(logN), Space complexity - O(N)


Intuition -
1. any index(number) can be represented as sum of powers of 2 <img src="./my-image.jpg" />

Invertible operations - 
operations which have an inverse function such that when both function perform by same amount on a number gives same value. i.e: f'(f(x)) = x 
ex: 
1. ((x+2)-2) = x : addition and subtraction are inverse of each other
2. ((x*2)/2) = x : multiplication and division are inverse of each other
3. (()) = 

why invertible operations only? - to perform the range query in BIT, inverse operation b/w 2 prefix range value is performed.
Ex: for range sum query b/w [l,r] = range(1,r) - range(1,l) i.e '-' is an inverse operation on sum.

*/<img src="./my-image.jpg" />