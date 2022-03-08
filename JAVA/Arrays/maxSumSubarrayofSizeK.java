// Problem Link :- https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        int i = 0, j = 0, sum = 0, max = 0;
        
        while (j < Arr.size()) {
            sum = sum + Arr.get(j);
            
            if ((j - i + 1) < K) {
                j++;
            } else if ((j - i + 1) == K) {
                max = Math.max(max, sum);
                sum = sum - Arr.get(i);
                i++;
                j++;
            }
        }
        
        return max;
    }
}
