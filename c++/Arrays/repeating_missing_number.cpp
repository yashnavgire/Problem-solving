vector<int> Solution::repeatedNumber(const vector<int> &A) {
    long long int n = A.size();

    long long int S = (n * (n+1) ) /2;
    long long int P = (n * (n +1) *(2*n +1) )/6;
    long long int missingNumber=0, repeating=0;
     
    for(int i=0;i<A.size(); i++){
       S -= (long long int)A[i];
       P -= (long long int)A[i]*(long long int)A[i];
    }
     
    missingNumber = (S + P/S)/2;

    repeating = missingNumber - S;

    vector <int> ans;

    ans.push_back(repeating);
    ans.push_back(missingNumber);

    return ans;
}


//s = sum of elements from 1 to n
//p = sum of squares of elements from 1 to n

//s1 = sum of all array elements 
//p1 = sum of squares of all array elements 

//missing - repeating = s - s1
//missing + repeating = (p - p1)/(s - s1)


//1. find duplicate
//         3   1   2   5   3
// --->   -3   -1  -2      -3 

//2. find missing
// x = (sum of 1 to n) - (sum of array)
// missing = duplicate + x
