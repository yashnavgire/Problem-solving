/*
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Constraints:

    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106

*
*/

class Solution {
public:

    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() > nums2.size())
        {
            return findMedianSortedArrays(nums2,nums1);
        }

        int low = 0,high = nums1.size(),n=(nums1.size()+nums2.size()+1)/2;
        double ans = 0.0;
        while(low <= high)
        {
            int mid = (low+high)/2;
            int part2 = n - mid;

            int l1 = mid == 0 ? INT_MIN : nums1[mid-1];
            int r1 = mid == nums1.size() ? INT_MAX : nums1[mid];
            int l2 = part2 == 0 ? INT_MIN : nums2[part2-1];
            int r2 = part2 == nums2.size() ? INT_MAX : nums2[part2];

            //check for valid partition
            if(l1 <= r2 && l2 <= r1)
            {
                //if even elements in total -> median = avg(max(l1,l2) , min(r1,r2))
                if((nums1.size()+nums2.size())%2 == 0)
                    ans = ((double)std::max(l1,l2) + (double)std::min(r1,r2))/2;
                else
                    ans = (double)std::max(l1,l2);

                break;
            }

            else if(l1 > r2)
            {
                high = mid - 1;
            }

            else
            {
                low = mid + 1;
            }
        }

        return ans;
    }
};

/*
-Intuition is to obtain the correct partition pt->basically there will be 2 partitions left and right of median.
-If we are able to find which elements from nums1 and nums2 need to be considered in left partition-> we can find median from that.

1.To search the corerct partition pt we can use binary search on the vector with less number of elements.
2.remaining elements to form left partition can be taken from other vector.


Ex:
nums1 = [1,2,3] , nums2 = [4,5,6,7,8]

total_length = 3+5 = 8 -> left partition should be of 4 elements

1.First iteration of binary search on nums1 will give partition point at index 1
i.e: [1,2] therefore other 2 will be taken from nums2 from 0 to 1 index(since sorted increasing order).
        left_partition  right_partition
nums1:      [1,2(l1)]        [3(r1)]
nums2:      [4,5(l2)]        [6(r2),7,8]


2.For a partition to be valid all left elements should be less than right.
-within the array(nums1 and nums2) that check is already satisfied since array is sorted
-we need to check
    last element of nums1 left_partion(l1) with first element of right partition of nums2(r2)
        and
    last element of nums2 left_partion(l2) with first element of right partition of nums1(r1)

    i.e l1<=r2 and l2<=r1 -> then considered partition is valid.


3.If partition is invalid : update low and high accordingly for next binary search iteration.

4.corner case : when low goes >= vector_size set element as INT_MAX and high goes < 0  set element as INT_MIN
*/
