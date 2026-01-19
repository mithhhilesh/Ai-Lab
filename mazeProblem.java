import java.util.*;

public class mazeProblem {

    public static void bfs(Map<String, List<String>> graph,
                           String start,
                           String goal) {

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();

        queue.add(start);
        visited.add(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            if (current.equals(goal)) {
                printPath(parent, goal);
                return;
            }

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    parent.put(neighbor, current);
                }
            }
        }
    }

    static void printPath(Map<String, String> parent, String goal) {
        List<String> path = new ArrayList<>();
        String curr = goal;

        while (curr != null) {
            path.add(curr);
            curr = parent.get(curr);
        }

        Collections.reverse(path);
        System.out.println("\nShortest path: " + path);
    }

    public static void main(String[] args) {

        Map<String, List<String>> graph = new HashMap<>();

        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("D"));
        graph.put("C", Arrays.asList("E"));
        graph.put("D", Arrays.asList("G"));
        graph.put("E", Arrays.asList("F"));
        graph.put("G", Arrays.asList("I", "H"));
        graph.put("H", new ArrayList<>());
        graph.put("F", new ArrayList<>());
        graph.put("I", new ArrayList<>());

        bfs(graph, "A", "H");
    }
}
