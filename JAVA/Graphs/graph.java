import java.io.*;
import java.util.*;

class graph {
    public static List<List<Integer>> createGraph(int size) {
        List<List<Integer>>adj = new ArrayList<>();

        for (int i = 0; i <= size; i++) {
            List<Integer> edges = new ArrayList<>();
            adj.add(edges);
        }

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(5);
        adj.get(5).add(3);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(2);
        adj.get(2).add(4);

        adj.get(5).add(1);
        adj.get(1).add(5);
        
        return adj;
    }

    public static void printGraph(List<List<Integer>>adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("The vertex" + " " + i + " ");
            List<Integer>edges = adj.get(i);
            for (int j = 0; j < edges.size(); j++) {
                System.out.println("edge" + " " + edges.get(j));
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < list.size(); i++) {
            list.add(i);
        }

        List<List<Integer>> adj = createGraph(5);
        printGraph(adj);
    }
}
