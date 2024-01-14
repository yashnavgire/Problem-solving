primarility check and number of divisors of a number in O(sq_root(n)): 

1. all factors of a number(n) satisfies this condition - 
  a. it is <= sq_root(n) and it's counter part is >= sq_root(n)
     for ex: factors of 36 are 2,3,4,6,9,12,18 which can be written as
             2(<sq_rt(36)) x 18 (>sq_rt(36))
             3(<sq_rt(36)) x 12 (>sq_rt(36))
             4(<sq_rt(36)) x 9 (>sq_rt(36))
             6(<=sq_rt(36)) x 6 (>=sq_rt(36))
             
- Therefore to check a number is prime or not check if there is any factor from 1 to sq_root(number)
- To calulate total number of divisors calculate factors from 1 to sq_root(n) and do +1 for counter parts, 
  edge case is to handle when counter-part is same that is when factor is = sq_root(n) and hence need to considered only once.
 

Sieve of erastosnes..

- solves problem to calculate prime numbers from 1 to n in n(log(log n))
- instead of checking for factors for each number it 'iterates over the multiples of prime nos to mark composite numbers' and 
  remaining unmarked numbers at the end are prime
- 


GCD - greatest common divisor of nos.

- gcd(a, b) = gc(a, b-a)
- gcd(a, b) = gcd(b%a, b) // euclidean algo : O(log(max(a,b))
- application in coprime nos(where gcd of those numbers is 1 i.e : no common divisor)


Modular arithmetic : 

e = even, o = odd

general arithmetic rules

e + e = e
o + o = e
o + e = o

e * e = e
e * o = e
o * o = o

modular arithmetic rules

1. sum : (a+b)%m = ((a%m)+(b%m)) % m
2. mult : (a*b)%m = ((a%m)*(b%m)) % m
3. sub : (a-b)%m = ((a%m) - (b%m) + m) % m
4. div : fermat's little theorem using multiplicative inverse


  

  
  

  

