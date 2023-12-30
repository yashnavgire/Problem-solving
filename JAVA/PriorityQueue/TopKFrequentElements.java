class Solution {

    class Node {

        int ele;
        int freq;

        public Node(int ele, int freq) {
            this.ele = ele;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int i = 0;
        int[] ans = new int[k];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> (b.freq - a.freq));
        Map<Integer, Integer> map = new HashMap<>();

        for (int ele : nums) {
            if (!map.containsKey(ele)) {
                map.put(ele, 1);
            } else {
                map.put(ele, map.get(ele) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            Node n = new Node(e.getKey(), e.getValue());
            pq.add(n);
        }

        for (i = 1; i <= k; i++) {
            Node node = pq.poll();
            ans[i-1] = node.ele;
        }

        return ans;
    }
}
