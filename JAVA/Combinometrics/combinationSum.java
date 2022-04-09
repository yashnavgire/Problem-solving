class Solution
{

    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>(A);
        A.clear();
        A.addAll(set);
        Collections.sort(A);
        solve(A, list, new ArrayList<>(), B, 0);
        // Collections.sort(list);
        return list;
    }
    
    static void solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> tempList, int target, int idx) {
        
        if (target < 0) {
            return;
        }
        
        
        if (target == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        
        for (int i = idx; i < A.size(); i++) {
            if (target - A.get(i) >= 0) {
                idx = i;
                tempList.add(A.get(i));
                solve(A, list, tempList, target - A.get(i), idx);
                tempList.remove(tempList.size() - 1);
            }
            
        }
        
        return;
    }
}
