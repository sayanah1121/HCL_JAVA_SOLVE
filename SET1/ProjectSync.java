// Question 33
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectSync {

    static List<Integer>[] graph;
    static boolean[] visited;

    static void dfs(int node) {
        visited[node] = true;
        for (int nei : graph[node]) {
            if (!visited[nei]) {
                dfs(nei);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int link_nodes = scanner.nextInt();
        int link_edges = scanner.nextInt();
        graph = (List<Integer>[]) new ArrayList[link_nodes + 1];
        for (int i = 0; i <= link_nodes; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < link_edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        visited = new boolean[link_nodes + 1];
        int components = 0;
        for (int i = 1; i <= link_nodes; i++) {
            if (!visited[i]) {
                components++;
                dfs(i);
            }
        }
        if (link_edges < link_nodes - 1) {
            System.out.println(-1);
        } else {
            int ans = link_nodes - link_edges + components - 2;
            System.out.println(ans);
        }
        scanner.close();
    }
}