// Problem Link :- https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/#

class Solution{
    static Boolean isPresent = false;
    static Boolean isSubsetSum(int N, int arr[], int sum){
        //System.out.println("Hello");
        ArrayList<Integer> list = new ArrayList();
        solve(arr, sum, 0, 0, list);
        return (list.size() > 0 ? true : false);
    }
    
    static void solve(int[] arr, int target, int itr, int sum, List<Integer> list) {
        //System.out.println("Hello");
        if (itr < 0 || itr > arr.length) {
            return;
        }
        
        if (itr == arr.length) {
            if (sum == target) {
                isPresent = true;
                list.add(1);
            }
            return;
        }
        
        if (arr[itr] <= target) {
            //System.out.println("My" + itr);
            solve(arr, target, itr+1, sum+arr[itr], list);
            solve(arr, target, itr+1, sum, list);
        }
        else {
            solve(arr, target, itr+1, sum, list);
        }
        
        return;
    }
}
