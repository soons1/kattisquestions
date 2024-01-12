import java.util.*;
import java.io.*;
class Conquest {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] tokens = br.readLine().split(" ");
        int V = Integer.parseInt(tokens[0]);
        int E = Integer.parseInt(tokens[1]);
        ArrayList<ArrayList<Integer>> AL = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            AL.add(new ArrayList<>());
        }
        // read in edges
        for (int i = 0; i < E; i++) {
            tokens = br.readLine().split(" ");
            int u = Integer.parseInt(tokens[0]) - 1;
            int v = Integer.parseInt(tokens[1]) - 1;
            // undirected
            AL.get(u).add(v);
            AL.get(v).add(u);
        }
        int[] vertices = new int[V];
        boolean[] visited = new boolean[V];
        // read in vertex weights
        for (int i = 0; i < V; i++) {
            vertices[i] = Integer.parseInt(br.readLine());
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x -> vertices[x]));
        pq.addAll(AL.get(0));
        int total = vertices[0];
        visited[0] = true;
        while (!pq.isEmpty()) {
            // retrieve island with smallest population
            int u = pq.poll();
            // check if it can be conquered
            if (visited[u] || vertices[u] >= total) {
                continue;
            }
            visited[u] = true;
            total += vertices[u];
            // enqueue all edges incident to u if they are not visited
            for (int v : AL.get(u)) {
                if (!visited[v]) {
                    pq.add(v);
                }
            }
        }
        pw.println(total);
        pw.close();

    }
}
