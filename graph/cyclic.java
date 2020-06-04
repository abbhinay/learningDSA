import java.util.*;

public class cyclic {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            graph.put(i, list);
        }
        addEdge(graph, 2, 0);
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 3);
        addEdge(graph, 0, 2);
        // isCyclicUsingBFS(graph);
        isCyclicUsingDFS(graph);
    }

    public static void addEdge(HashMap<Integer, ArrayList<Integer>> graph, int source, int destination) {
        graph.get(source).add(destination);
    }

    public static void isCyclicUsingBFS(HashMap<Integer, ArrayList<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[4];
        int counter = 0;
        queue.add(2);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (!visited[temp]) {
                visited[temp] = true;
                ArrayList<Integer> list = graph.get(temp);
                for (int i = 0; i < list.size(); i++) {
                    queue.add(list.get(i));
                }
            } else {
                counter++;
                System.out.println(temp + " ");
            }
        }
        System.out.println(counter);
    }

    public static void isCyclicUsingDFS(HashMap<Integer, ArrayList<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[4];
        int counter = 0;
        stack.push(2);
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            if (!visited[temp]) {
                visited[temp] = true;
                ArrayList<Integer> list = graph.get(temp);
                for (int i = 0; i < list.size(); i++) {
                    stack.push(list.get(i));
                }
            } else {
                counter++;
            }
        }
        System.out.println(counter);
    }
}