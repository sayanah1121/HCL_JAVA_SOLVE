// Question 54
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class DistributedSystemRecovery {

    public static void main(String[] args) {
        // Simulating the user's STDIN
        Scanner scanner = new Scanner(System.in);

        // Reading network_nodes and number of edges
        int network_nodes = scanner.nextInt();
        int n = scanner.nextInt(); // Number of edges

        int[] network_from = new int[n];
        int[] network_to = new int[n];

        for (int i = 0; i < n; i++) {
            network_from[i] = scanner.nextInt();
            network_to[i] = scanner.nextInt();
        }

        int company = scanner.nextInt();
        scanner.close();

        // Getting the recovery order
        List<Integer> result = recoverNetwork(network_nodes, network_from, network_to, company);

        // Printing the result
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + (i == result.size() - 1 ? "" : " "));
        }
        System.out.println();
    }

    public static List<Integer> recoverNetwork(int network_nodes, int[] network_from, int[] network_to, int company) {
        // 1. Build the adjacency list for the graph
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i <= network_nodes; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < network_from.length; i++) {
            adj.get(network_from[i]).add(network_to[i]);
            adj.get(network_to[i]).add(network_from[i]);
        }

        // 2. Initialize BFS structures
        List<Integer> recoveryOrder = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[network_nodes + 1];

        // Start BFS from the company node
        queue.add(company);
        visited[company] = true;

        // 3. Perform BFS level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> nodesAtThisDistance = new ArrayList<>();

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                int currentNode = queue.poll();
                
                // Find all unvisited neighbors
                for (int neighbor : adj.get(currentNode)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        nodesAtThisDistance.add(neighbor);
                    }
                }
            }
            
            // Tie-breaking: sort nodes at the same distance by their ID
            Collections.sort(nodesAtThisDistance);
            
            // Add the sorted nodes to the final recovery order and the queue for the next level
            for (int node : nodesAtThisDistance) {
                recoveryOrder.add(node);
                queue.add(node);
            }
        }
        
        return recoveryOrder;
    }
}
