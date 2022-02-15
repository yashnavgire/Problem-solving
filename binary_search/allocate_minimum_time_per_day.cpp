/*
 * Ayush is studying for ninjatest which will be held after 'N' days, And to score good marks he has to study 'M' chapters and the ith chapter requires TIME[i] seconds to study. The day in Ayush’s world has 100^100 seconds. There are some rules that are followed by Ayush while studying.
1. He reads the chapter in a sequential order, i.e. he studies i+1th chapter only after he studies ith chapter.
2. If he starts some chapter on a particular day he completes it that day itself.
3. He wants to distribute his workload over 'N' days, so he wants to minimize the maximum amount of time he studies in a day.
Your task is to find out the minimal value of the maximum amount of time for which Ayush studies in a day, in order to complete all the 'M' chapters in no more than 'N' days.
For example

if Ayush want to study 6 chapters in 3 days and the time that each chapter requires is as follows:
Chapter 1 = 30
Chapter 2 = 20
Chapter 3 = 10
Chapter 4 = 40
Chapter 5 = 5
Chapter 6 = 45

Then he will study the chapters in the following order

| day 1 : 1 , 2 | day 2 : 3 , 4 | day 3 : 5 , 6 |
Here we can see that he study chapters in sequential order and the maximum time to study on a day is 50, which is the minimum possible in this case.

*
*/


long long ayushGivesNinjatest(int n, int m, vector<int> time) 
{	
	// Write your code here.
    if(n>time.size())
        return -1;
    
    int max = INT_MIN;
    long long high = 0;
    for(int i=0;i<time.size();i++)
    {
        high += time[i];
        max = std::max(max,time[i]);
    }
    
    long long low = max;
    while(low <= high)
    {
        long long mid = (low+high)/2;
        long long req_days = 1;
        
        //find required days for mid as ans
        long long sum =0;
        for(int i=0;i<time.size();i++)
        {
            sum+=time[i];
            if(sum  > mid)
            {
                req_days++;
                if(req_days > n)
                    break;
                sum = time[i];
            }
        }
        
        if(req_days <= n)
        {
            high = mid-1;
        }
        else
        {
            low = mid+1;
        }
    }
    
    return low;
}

/*
-basic approach :
1.find all combinations and apply greedy -> exponential time complexity 

-optimized approach using binary search -> nlog(n)
1.To use binary search for this question
2.we need to define search space.
(since binary search on index can't be applied on array,since it is not sorted 
and ordering should not be changed according to the question).

search space = (min_possible_ans,max_possible_ans)

min_possible_ans => max_element_of_array
this situation will be when days(n) will be same as array size.Therefore on each day
one book can be read.

max_possible_ans => (sum_of_all_elements)
this situation will be when n=1,i.e on 1 day all books to be read.

3.for every iteration of binary search , we will consider mid as ans
-we need to check if mid considered as ans satisfies the given condition.
(i.e : within n days we can split the array sequentially such that sum of elements
within one partition is <= mid
-> this will require traversing 
array for every iteration)
*/
