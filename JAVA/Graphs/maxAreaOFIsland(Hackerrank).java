// Problem Link :- https://www.hackerrank.com/challenges/connected-cell-in-a-grid/problem?isFullScreen=true

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

    public static int connectedCell(List<List<Integer>> matrix) {
        int i = 0, j = 0, max = 0;
        int[][] grid = new int[matrix.size()][matrix.get(0).size()];
        int[][] visited = new int[matrix.size()][matrix.get(0).size()];
        
        for (List<Integer> list : matrix) {
            j = 0;
            
            for (int ele : list) {
                grid[i][j] = ele;
                j++;
            }
            i++;
        }
        
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j, visited, grid));
                }
            }
        }
        
        return max;
    }
    
    public static int dfs(int i, int j, int[][] visited, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j] == 1) {
            return 0;
        }
        
        visited[i][j] = 1;
        
        return 1 + dfs(i + 1, j, visited, grid)
                + dfs(i - 1, j, visited, grid)
                + dfs(i, j + 1, visited, grid)
                + dfs(i, j - 1, visited, grid)
                + dfs(i - 1, j - 1, visited, grid)
                + dfs(i + 1, j + 1, visited, grid)
                + dfs(i - 1, j + 1, visited, grid)
                + dfs(i + 1, j - 1, visited, grid);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
