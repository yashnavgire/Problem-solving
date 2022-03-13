// Problem Link :- https://www.hackerrank.com/challenges/grid-challenge/problem?isFullScreen=true

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

    public static String gridChallenge(List<String> grid) {
        int i = 0, j = 0;
        char[][] mat = new char[grid.size()][grid.get(0).length()];
        
        for (String word : grid) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            for (i = 0; i < arr.length && j < mat.length; i++) {
                mat[j][i] = arr[i];
            }
            j++;
        }
        
        i = 0;
        j = 0;
        
        for (i = 0; i < mat[0].length; i++) {
            for (j = 1; j < mat.length; j++) {
                if (mat[j][i] < mat[j - 1][i]) {
                    return "NO";
                }
            }
        }
        
        return "YES";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridChallenge(grid);

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
