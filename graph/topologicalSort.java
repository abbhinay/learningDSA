import java.util.*;

public class topologicalSort {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            graph.put(i, list);
        }
        addEdge(graph, 0, 3);
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 4);
        topologicalSort(graph);
    }

    public static void addEdge(HashMap<Integer, ArrayList<Integer>> graph, int source, int destination) {
        graph.get(source).add(destination);
    }

    public static void topologicalSort(HashMap<Integer, ArrayList<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[5];
        for (int i = 0; i < 5; i++) {
            if (!visited[i]) {
                topologicalSortHelper(i, visited, stack, graph);
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }
    }

    public static void topologicalSortHelper(int node, boolean[] visited, Stack<Integer> stack,
            HashMap<Integer, ArrayList<Integer>> graph) {
        visited[node] = true;
        ArrayList<Integer> list = graph.get(node);
        for (int i = 0; i < list.size(); i++) {
            if (!visited[list.get(i)]) {
                topologicalSortHelper(list.get(i), visited, stack, graph);
            }
        }
        stack.push(node);
    }
}