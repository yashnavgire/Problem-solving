// Problem Link :- https://www.hackerrank.com/challenges/one-month-preparation-kit-pangrams/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one

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

    public static String pangrams(String s) {
        int i = 0;
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        s = s.replaceAll("\\s", "");
        System.out.println(s);
        
        for (i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            arr[ch - 'a']++;
        }
        
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                return "not pangram";
            }
        }
        
        return "pangram";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
