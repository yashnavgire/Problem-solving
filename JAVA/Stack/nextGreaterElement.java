/*

Given an integer array, find the next greater element for every array element. The next greater element of a number x is the first greater number to the right of x in the array.

In other words, for each element A[i] in the array A, find an element A[j] such that j > i and A[j] > A[i] and the value of j should be as minimum as possible. If the next greater element doesn't exist in the array for any element, consider it -1.

Input:  [2, 7, 3, 5, 4, 6, 8]
Output: [7, 8, 5, 6, 6, 8, -1]

Input:  [5, 4, 3, 2, 1]
Output: [-1, -1, -1, -1, -1]

Note that the next greater element for the last array element is always -1.

*/

class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int i = 0, j = 0, flag = 0;
        int[] arr = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (i = nums2.length-1; i >= 0; i--) {
            
            if (st.isEmpty()) {
                map.put(nums2[i], -1);
            } else if (!st.isEmpty() && st.peek() > nums2[i]) {
                map.put(nums2[i], st.peek());
            } else if (!st.isEmpty() && st.peek() <= nums2[i]) {
                while (!st.isEmpty() && st.peek() <= nums2[i]) {
                    st.pop();
                }

                if (st.isEmpty()) {
                    map.put(nums2[i], -1);
                } else if (st.peek() > nums2[i]) {
                    map.put(nums2[i], st.peek());
                }
            }

            st.push(nums2[i]);
        }

        for (int num : nums1) {
            if (map.containsKey(num) && map.get(num) != -1) {
                arr[j++] = map.get(num);
            } else {
                arr[j++] = -1;
            }
        }

        return arr;
    }
}
