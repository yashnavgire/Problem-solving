/*
 * To solve this in O(n),given problem can be simplified as :
    
    1. consider subarray[0 to 4] from an array. 
       let  p : prefix xor (i.e xor from 0 to 4 )
    		y : xor of some elements subarray(suppose xor from 0 to 2)
            x : required xor (in this case it is from xor from 3 to 4)

			we can write ,
            p = y ^ x
              or
            y = p ^ x
            
     2. if we can find all such y(i.e cnt of subarrays having xor y) 
		within 0 to 4,that means those many subarrays within 0 to 4 exists 
        having xor as x.

	3. therefore while traversing the array we can keep prefix xor(p) and
	   count of every unique xor in a map.
     
    4. check for count(p^x) in map for every iteration and add that in the ans.
    
    5. check for current element is equal to required xor value,if yes add in ans.
*
*/

int subarraysXor(vector<int> &arr, int x)
{
    int p = 0;
    int ans = 0;
    unordered_map<int,int> mp;

    for(int i=0;i<arr.size();i++)
    {
        p = p ^ arr[i];
		
        if(p == x)
            ans++;
        
        if(mp.find(p^x)!=mp.end()) 
        {
            ans+=mp[p^x];
        }

        mp[p]=mp[p]+1;
    }

    return ans;
}
