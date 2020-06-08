import java.util.*;

public class kruskals {
    public static void main(String[] args) {
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            graph.put(i, map);
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        addEdge(graph, 0, 3, 4, list);
        addEdge(graph, 0, 1, 2, list);
        addEdge(graph, 0, 3, 5, list);
        addEdge(graph, 1, 3, 1, list);
        addEdge(graph, 1, 5, 8, list);
        addEdge(graph, 1, 4, 3, list);
        addEdge(graph, 1, 2, 7, list);
        addEdge(graph, 1, 6, 4, list);
        addEdge(graph, 2, 4, 10, list);
        addEdge(graph, 2, 6, 6, list);
        addEdge(graph, 3, 4, 2, list);
        addEdge(graph, 5, 6, 1, list);

        findMST(graph);
    }

    public static void addEdge(HashMap<Integer, HashMap<Integer, Integer>> graph, int source, int destination,
            int weight, ArrayList<ArrayList<Integer>> list) {
        graph.get(source).put(destination, weight);
        graph.get(destination).put(source, weight);
        ArrayList<Integer> child = new ArrayList<>();
        child.add(weight);
        child.add(source);
        child.add(destination);
        list.add(child);
    }

    public static void findMST(HashMap<Integer, HashMap<Integer, Integer>> graph) {

    }

    public static class Compare implements Comparator<HashMap<K, V> graph>{

        @Override
        public int compare(K k1, K k2){
            return node1.get()
        }
    }
}