class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n) {
    	int i = 0, j = 0, not_present = 0, flag = 0, celebrity = 0, present = 0;
    	int cnt = 0;
    	HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
    	
    	for (i = 0; i < M.length; i++) {
    	    flag = 0;
    	    for (j = 0; j < M[i].length; j++) {
    	        if (M[i][j] == 1) {
    	            flag = 1;
    	            if (!adj.containsKey(i)) {
    	                ArrayList<Integer> list = new ArrayList<>();
    	                list.add(j);
    	                adj.put(i, list);
    	            }
    	            else {
    	                ArrayList<Integer> list = adj.get(i);
    	                list.add(j);
    	                adj.put(i, list);
    	            }
    	        }
    	    }
    	    
    	    if (flag == 0) {
    	        present = 1;
    	        celebrity = i;
    	    }
    	}
    	
    	if (present == 0) {
    	    return -1;
    	}
    	
    	for (Map.Entry<Integer, ArrayList<Integer>> ele : adj.entrySet()) {
    	    int key = ele.getKey();
            
            if (key == celebrity) {
                continue;
            }
            
    	    ArrayList<Integer> list = ele.getValue();
    	    present = 0;
    	    
    	    for (int k : list) {
    	        if (k == celebrity) {
    	            present = 1;
    	        }
    	    }
    	    
    	    if (present == 1) {
    	        cnt++;
    	    }
    	}
    	
    	if (cnt == M.length - 1) {
    	    return celebrity;
    	}
    	
    	return -1;
    }
}
