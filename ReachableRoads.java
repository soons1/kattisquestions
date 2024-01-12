import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReachableRoads {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            int m = Integer.parseInt(br.readLine());
            int r = Integer.parseInt(br.readLine());
            List<List<Integer>> al = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                al.add(new ArrayList<>());
            }

            for (int i = 0; i < r; i++) {
                String[] token = br.readLine().split(" ");
                int item1 = Integer.parseInt(token[0]);
                int item2 = Integer.parseInt(token[1]);
                al.get(item1).add(item2);
                al.get(item2).add(item1);
            }

            int cc = 0;
            boolean[] visited = new boolean[m];
            for (int i = 0; i < m; i++) {
                if (!visited[i]) {
                    ++cc;
                    visited[i] = true;
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    while (!q.isEmpty()) {
                        int u = q.poll();
                        List<Integer> neigh = al.get(u);
                        for (Integer v : neigh) {
                            if (!visited[v]) {
                                q.add(v);
                                visited[v] = true;
                            }
                        }
                    }
                }
            }
            pw.println(cc-1);
        }
        br.close();
        pw.close();
    }
}