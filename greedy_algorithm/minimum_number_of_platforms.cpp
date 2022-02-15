/*
 * You have been given two arrays, 'AT' and 'DT', representing the arrival and departure times of all trains that reach a railway station.
   Your task is to find the minimum number of platforms required for the railway station so that no train needs to wait.

Constraints:

1 <= T <= 10
1 <= N <= 50000
0 <= AT[i] <= DT[i] <= 2359

Where 'AT[i]' and 'DT[i]' are the elements of the arrival and the departure arrays respectively.

Time limit: 1 sec

Sample Input 1:

2
6
900 940 950 1100 1500 1800
910 1200 1120 1130 1900 2000
4
100 200 300 400
200 300 400 500

Sample Output 1:

3
2

**/

int calculateMinPatforms(int at[], int dt[], int n) {
    // Write your code here.

    //sort
    sort(at,at+n);
    sort(dt,dt+n);

    int ans = 0;
    int curr_trains = 0;
    int start = 0,end = 0;
    while(start < n)
    {
        if(start < n && at[start] <= dt[end])
        {
            curr_trains++;
            ans = std::max(ans,curr_trains);
            start++;
        }
        else{
            curr_trains--;
            end++;
        }
    }

    return ans;
}


/*
*
1. sort start and end array.
calculate at particular time instance in start/end array how many trains
are present on platform.

2. with 2 pointer (one in start and other at end) traverse both arrays and update the
number of trains on station at every particular time.

*
*/
