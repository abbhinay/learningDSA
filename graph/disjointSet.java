import java.util.*;

public class disjointSet {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> disjointSet = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            disjointSet.put(i, list);
        }

        union(disjointSet, 0, 1);
        union(disjointSet, 0, 2);
        union(disjointSet, 4, 0);
        union(disjointSet, 0, 7);
        union(disjointSet, 1, 0);
        union(disjointSet, 3, 8);
        union(disjointSet, 8, 9);

        int set = findParent(disjointSet, 1);
        System.out.println(set);
    }

    public static void union(HashMap<Integer, ArrayList<Integer>> disjointSet, int num1, int num2) {
        if (disjointSet.containsKey(num1) && disjointSet.containsKey(num2)) {
            unionOperation(disjointSet, num1, num2);
            return;
        }

        if (!disjointSet.containsKey(num1) && !disjointSet.containsKey(num2)) {

            int parent1 = findParent(disjointSet, num1);
            int parent2 = findParent(disjointSet, num2);
            unionOperation(disjointSet, parent1, parent2);
            return;
        }

        if (!disjointSet.containsKey(num1)) {
            int parent = findParent(disjointSet, num1);
            unionOperation(disjointSet, parent, num2);
            return;
        }

        if (!disjointSet.containsKey(num2)) {
            int parent = findParent(disjointSet, num2);
            unionOperation(disjointSet, num1, parent);
            return;
        }

    }

    public static int findParent(HashMap<Integer, ArrayList<Integer>> disjointSet, int num) {
        if (disjointSet.containsKey(num)) {
            return num;
        }
        for (Map.Entry m : disjointSet.entrySet()) {
            int parent = (int) m.getKey();
            ArrayList<Integer> list = (ArrayList<Integer>) m.getValue();
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == num) {
                    return parent;
                }
            }
        }
        return 0;
    }

    public static void unionOperation(HashMap<Integer, ArrayList<Integer>> disjointSet, int parent1, int parent2) {
        int len1 = disjointSet.get(parent1).size();
        int len2 = disjointSet.get(parent2).size();
        if (len1 < len2) {
            disjointSet.get(parent2).addAll(disjointSet.get(parent1));
            disjointSet.remove(parent1);
        } else {
            disjointSet.get(parent1).addAll(disjointSet.get(parent2));
            disjointSet.remove(parent2);
        }
    }
}