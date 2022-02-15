class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
         int i = m-1, j = n-1, k = m+n-1;
        
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            }
            else {
                nums1[k--] = nums1[i--];
                nums1[k--] = nums2[j--];
            }
        }
        
        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
        
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        
        return;
        
    }
};


//1.both nums1 and nums2 have elements
    // -all positive
    // -all negative
    // -mixture of positive-negative

//2.nums2 empty

//3.nums1 empty



// 1,6,9,0,0,0  2,4,7 -> 
    
// 1,6,0,0,7,9
    
// 1 2 4 
  

