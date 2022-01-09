// Problem Link :- https://practice.geeksforgeeks.org/problems/subset-sums2234/1#

class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> result = new ArrayList<>();
        //System.out.println("Here");
        solve(arr, result, 0, 0, N);
        
        return result;
    }
    
    void solve(ArrayList<Integer> arr, ArrayList<Integer> result, int sum, int itr, int N) {
        
        if (itr == N) {
            result.add(sum);
            return;
        }
        sum += arr.get(itr);
        solve(arr, result, sum, itr+1, N);
        sum -= arr.get(itr);
        solve(arr, result, sum, itr+1, N);
        
        return;
    }
}
