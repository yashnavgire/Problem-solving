// Problem Link :- https://www.hackerrank.com/challenges/candies/problem?isFullScreen=true

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static long candies(int n, List<Integer> arr) {
        int i = 0;
        long ans = 0;
        
        long[] left = new long[arr.size()];
        long[] right = new long[arr.size()];
        
        for (i = 0; i < arr.size(); i++) {
            left[i] = 1;
            right[i] = 1;    
        }
        
        for (i = 1; i < arr.size(); i++) {
            if (arr.get(i) > arr.get(i - 1)) {
                left[i] = left[i - 1] + 1;
            }
        }
        
        for (i = arr.size() - 2; i >= 0; i--) {
            if (arr.get(i) > arr.get(i + 1)) {
                right[i] = right[i + 1] + 1;
            }
        }
        
        for (i = 0; i < arr.size(); i++) {
            ans += Math.max(left[i], right[i]);    
        }
        
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
