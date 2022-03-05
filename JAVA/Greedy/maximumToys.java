// Problem Link :- https://practice.geeksforgeeks.org/problems/maximize-toys0331/1

class Solution{
    static int toyCount(int N, int K, int arr[]) {
        int i = 0, toys = 0;
        
        Arrays.sort(arr);
        
        for (i = 0; i < arr.length; i++) {
            if (K - arr[i] >= 0) {
                K = K - arr[i];
                toys++;
            }
        }
        
        return toys;
    }
}
