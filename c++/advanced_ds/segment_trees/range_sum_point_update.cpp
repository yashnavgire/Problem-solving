/**
 * leetcode: https://leetcode.com/problems/range-sum-query-mutable/description/
 * 
 * 
 * Array based representation of segmentT
 */

#include <bits/stdc++.h>

class NumArray {
public:
    int* segTree;
    int numSize;

    NumArray(vector<int>& nums) {
        numSize = nums.size();    
        segTree = new int[nums.size()*4]{0};

        std::cout<<"nums size: "<<numSize<<std::endl;
        for(int i=0; i<numSize; i++) {
            // std::cout<<"num "<<i<<": "<<nums[i]<<std::endl;
            update(i, nums[i]);
        }
    }
    
    void update(int index, int val) {
        // std::cout<<"\npoint update received, index: "<<index<<" | val: "<<val<<std::endl;
        pointUpdateSeg(0, numSize-1, 0, index, val);
    }
    
    int sumRange(int left, int right) {
        // std::cout<<"sum range received left: "<<left<<" right: "<<right<<std::endl;
        return getSumSeg(left, right, 0, numSize-1, 0);        
    }

    int pointUpdateSeg(int segStart, int segEnd, int segTreeIndex, int index, int val) {
        // point not in range
        // std::cout<<"sti: "<<segTreeIndex<<" ss: "<<segStart<<" se: "<<segEnd<<std::endl;
        if (index < segStart || index > segEnd) { 
            // std::cout<<"not in range, returning: "<<segTree[segTreeIndex]<<std::endl;
            return segTree[segTreeIndex];    
        }

        // point is equal to required node
        if (index == segStart && index == segEnd) {
            // std::cout<<"point equals current node, index: "<<index<<" returning: "<<val<<std::endl;
            return segTree[segTreeIndex] = val;
        }

        // point is in range
        if (index >= segStart && index <= segEnd) {
            int mid = (segStart + segEnd)/2;
            int leftChild = pointUpdateSeg(segStart, mid, 2*segTreeIndex + 1, index, val);
            int rightChild = pointUpdateSeg(mid+1, segEnd, 2*segTreeIndex + 2, index, val);
            // std::cout<<"left: "<<leftChild<<" right: "<<rightChild<<" segTreeIndex: "<<segTreeIndex<<std::endl;
            segTree[segTreeIndex] = leftChild + rightChild; 
        }

        return segTree[segTreeIndex];
    }

    int getSumSeg(int left, int right, int segStart, int segEnd, int segTreeIndex) {
        //fully overlap
        // std::cout<<"getSum "<<" left: "<<left<<" right: "<<right<<" segStart: "<<segStart<<" segEnd: "<<segEnd<<" segTreeIndex: "<<segTreeIndex<<std::endl;
        if (segStart >= left && segEnd <= right) {
            return segTree[segTreeIndex];
        }
        
        //no overlap
        if ((segEnd < left) || (segStart > right)) {
            return 0;
        }

        //partial overlap
        int mid = (segStart + segEnd)/2;
        
        return getSumSeg(left, right, segStart, mid, 2*segTreeIndex + 1) + getSumSeg(left, right, mid+1, segEnd, 2*segTreeIndex + 2);  
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */