import java.util.*;

//https://www.youtube.com/watch?v=dis_c84ejhQ&t=333s
public class topologicalSort {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            graph.put(i, list);
        }
        addEdge(graph, 0, 2);
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 4);
        topologicalSort(graph, 5);
    }

    public static void addEdge(HashMap<Integer, ArrayList<Integer>> graph, int source, int destination) {
        graph.get(source).add(destination);
    }

    public static void topologicalSort(HashMap<Integer, ArrayList<Integer>> graph, int N) {
        int[] result = new int[N];
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] indegree = new int[N];
        for (int i = 0; i < indegree.length; i++) {
            indegree[i] = 0;
        }
        for (Map.Entry m : graph.entrySet()) {
            ArrayList<Integer> list = (ArrayList<Integer>) m.getValue();
            for (int j = 0; j < list.size(); j++) {
                indegree[list.get(j)]++;
            }
        }
        for (int k = 0; k < indegree.length; k++) {
            if (indegree[k] == 0) {
                queue.add(k);
            }
        }
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            result[index++] = temp;
            ArrayList<Integer> tempList = (ArrayList<Integer>) graph.get(temp);
            graph.remove(temp);
            for (int p = 0; p < tempList.size(); p++) {
                indegree[tempList.get(p)]--;
                if (indegree[tempList.get(p)] == 0) {
                    queue.add(tempList.get(p));
                }
            }
        }
        for (int q = 0; q < result.length; q++) {
            System.out.print(result[q] + " ");
        }
    }

    // public static void topologicalSort(HashMap<Integer, ArrayList<Integer>>
    // graph,) {
    // Stack<Integer> stack = new Stack<>();
    // boolean[] visited = new boolean[5];
    // for (int i = 0; i < 5; i++) {
    // if (!visited[i]) {
    // topologicalSortHelper(i, visited, stack, graph);
    // }
    // while (!stack.isEmpty()) {
    // System.out.print(stack.pop() + " ");
    // }
    // }
    // }

    // public static void topologicalSortHelper(int node, boolean[] visited,
    // Stack<Integer> stack,
    // HashMap<Integer, ArrayList<Integer>> graph) {
    // visited[node] = true;
    // ArrayList<Integer> list = graph.get(node);
    // for (int i = 0; i < list.size(); i++) {
    // if (!visited[list.get(i)]) {
    // topologicalSortHelper(list.get(i), visited, stack, graph);
    // }
    // }
    // stack.push(node);
    // }
}