import java.util.*;

class graph {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            graph.put(i, list);
        }
        addEdge(graph, 1, 9);
        addEdge(graph, 1, 4);
        addEdge(graph, 1, 6);
        addEdge(graph, 2, 3);
        addEdge(graph, 2, 8);
        addEdge(graph, 2, 9);
        addEdge(graph, 3, 1);
        addEdge(graph, 3, 4);
        addEdge(graph, 3, 7);
        addEdge(graph, 4, 8);
        addEdge(graph, 5, 4);
        addEdge(graph, 6, 9);
        addEdge(graph, 7, 10);
        addEdge(graph, 8, 5);
        addEdge(graph, 9, 10);
        addEdge(graph, 10, 2);
        addEdge(graph, 10, 3);
        addEdge(graph, 10, 6);
        BFS(graph);
    }

    public static void addEdge(HashMap<Integer, ArrayList<Integer>> graph, int source, int destination) {
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    public static void BFS(HashMap<Integer, ArrayList<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[11];
        queue.add(5);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (!visited[temp]) {
                System.out.print(temp + " ");
                visited[temp] = true;
                ArrayList<Integer> list = graph.get(temp);
                for (int i = 0; i < list.size(); i++) {
                    queue.add(list.get(i));
                }
            }
        }
    }
}