import java.util.*;

/* 
    https://www.youtube.com/watch?v=mqKPgW3C5ps
*/
public class primsAlgo {
    public static void main(String[] args) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            HashMap<Integer, Integer> list = new HashMap<>();
            graph.put(i, list);
        }

        addEdge(graph, 0, 1, 4);
        addEdge(graph, 1, 3, 6);
        addEdge(graph, 3, 4, 5);
        addEdge(graph, 4, 2, 9);
        addEdge(graph, 2, 0, 8);
        addEdge(graph, 1, 2, 2);
        addEdge(graph, 3, 2, 3);

        prims(graph);
    }

    public static void addEdge(HashMap<Integer, HashMap<Integer, Integer>> graph, int source, int destination,
            int weight) {
        graph.get(source).put(destination, weight);
        graph.get(destination).put(source, weight);
    }

    public static void prims(HashMap<Integer, HashMap<Integer, Integer>> graph) {
        boolean[] visited = new boolean[6];
        int[] parent = new int[6];
        int[] distance = new int[6];
        for (int i = 0; i < 6; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(0);
        stack.push(0);
        distance[0] = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (!visited[temp]) {
                visited[temp] = true;
                HashMap<Integer, Integer> list = graph.get(temp);
                int min = Integer.MAX_VALUE;
                int number = temp;
                for (Map.Entry m : list.entrySet()) {
                    int destination = (int) m.getKey();
                    int weight = (int) m.getValue();
                    if (distance[destination] > weight) {
                        distance[destination] = weight;
                        parent[destination] = temp;
                        if (distance[destination] < min && !visited[destination]) {
                            min = distance[destination];
                            number = destination;
                        }
                    }
                }
                stack.push(number);
                queue.add(number);
            }
        }
        stack.pop();
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}