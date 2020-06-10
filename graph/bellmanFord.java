import java.util.*;

/* 
https://www.youtube.com/watch?v=KudAWAMiQog
=> Bellman Ford is Dijkstra Algorithm called V-1 times where V is the no of Vertices in graph. We will write Dikstra Algorithm and call it V-1 times from a loop.
=> Bellman For is used in place of Dijkstra because Dijkstra can fail when it comes to -ve Edges in a graph. But Bellman Ford will survive there.
=> Bellman For will not survive when there is a negative cycle in a graph.
=> Complexity :- O(EV)
*/
public class bellmanFord {
    public static void main(String[] args) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            HashMap<Integer, Integer> list = new HashMap<>();
            graph.put(i, list);
        }
        addEdge(graph, 0, 1, 6);
        addEdge(graph, 0, 2, 4);
        addEdge(graph, 0, 3, 5);
        addEdge(graph, 1, 4, -1);
        addEdge(graph, 2, 1, -2);
        addEdge(graph, 2, 4, 3);
        addEdge(graph, 3, 2, -2);
        addEdge(graph, 3, 5, -1);
        addEdge(graph, 4, 5, 3);
        int[] parent = new int[6];
        int[] distance = new int[6];
        for (int i = 0; i < distance.length; i++) {
            if (i == 0) {
                distance[i] = 0;
            } else {
                distance[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < 6; i++) {
            parent = bellmanFord(graph, 0, 5, parent, distance);
        }

        int iterator = 5;
        while (iterator != 0) {
            System.out.println(iterator + " ");
            iterator = parent[iterator];
        }
    }

    public static void addEdge(HashMap<Integer, HashMap<Integer, Integer>> graph, int source, int destination,
            int weight) {
        graph.get(source).put(destination, weight);
    }

    public static int[] bellmanFord(HashMap<Integer, HashMap<Integer, Integer>> graph, int source, int destination,
            int[] parent, int[] distance) {
        boolean[] visited = new boolean[6];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (!visited[temp]) {
                visited[temp] = true;
                HashMap<Integer, Integer> list = graph.get(temp);
                for (Map.Entry m : list.entrySet()) {
                    int child = (int) m.getKey();
                    int weight = (int) m.getValue();
                    if (distance[child] > distance[temp] + weight) {
                        distance[child] = distance[temp] + weight;
                        parent[child] = temp;
                    }
                    queue.add(child);
                }
            }
        }
        return parent;
    }
}