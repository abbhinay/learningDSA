import java.util.*;

//https://www.youtube.com/watch?v=JcN_nq1EAr4
public class shortestPathUsingDijkstra {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> distance = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            graph.put(i, list);
            distance.put(i, Integer.MAX_VALUE);
        }
        addEdge(graph, 0, 3);
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 4);
        shortestUsingBFS(graph, 0, 4, distance);
    }

    public static void addEdge(HashMap<Integer, ArrayList<Integer>> graph, int source, int destination) {
        graph.get(source).add(destination);
    }

    public static void shortestUsingBFS(HashMap<Integer, ArrayList<Integer>> graph, int source, int destination,
            HashMap<Integer, Integer> distance) {
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> parent = new HashMap<>();
        distance.put(source, 0);
        boolean[] visited = new boolean[5];
        queue.add(source);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (!visited[temp]) {
                visited[temp] = true;
                ArrayList<Integer> list = graph.get(temp);
                for (int i = 0; i < list.size(); i++) {
                    int no = list.get(i);
                    if (distance.get(no) > distance.get(temp) + 1) {
                        distance.put(no, distance.get(temp) + 1);
                        parent.put(list.get(i), temp);
                    }
                    queue.add(list.get(i));
                }
            }
        }
        int iterator = destination;
        System.out.print(iterator);
        while (iterator != source) {
            iterator = parent.get(iterator);
            System.out.print("->" + iterator);
        }
    }
}