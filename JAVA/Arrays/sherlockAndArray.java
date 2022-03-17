// Problem Link :- https://www.hackerrank.com/challenges/one-month-preparation-kit-sherlock-and-array/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-two

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

    public static String balancedSums(List<Integer> arr) {
        if (arr.size() == 1) {
            return "YES";
        }
        int i = 0, j = 0, found = 0, sum = 0;
        int[] left = new int[arr.size()];
        int[] right = new int[arr.size()];
        
        for (i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
            left[i] = sum;
        }
        
        sum = 0;
        
        for (i = arr.size() - 1; i >= 0; i--) {
            sum += arr.get(i);
            right[i] = sum;
        }
        
        for (i = 1; i < arr.size() - 1; i++) {
            if (left[i - 1] == right[i + 1]) {
                found = 1;
                break;
            }
        }
        
        if (right[1] == 0 || left[left.length - 2] == 0) {
            found = 1; 
        }
        
        return (found == 1) ? "YES" : "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result.balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
