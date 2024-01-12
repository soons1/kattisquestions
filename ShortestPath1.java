import java.io.*;
import java.util.*;

public class ShortestPath1 {
    public static final long INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String input;
        while (!(input = br.readLine()).equals("0 0 0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            // O(n) construct AL
            ArrayList<ArrayList<SP1Pair>> AL = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                AL.add(new ArrayList<>());
            }
            // O(m) construct AL
            while (m-- > 0) {
                String[] tokens = br.readLine().split(" ");
                int u = Integer.parseInt(tokens[0]);
                int v = Integer.parseInt(tokens[1]);
                long d = Long.parseLong(tokens[2]);
                AL.get(u).add(new SP1Pair(v, d));
            }

            ArrayList<Long> dist = new ArrayList<>(Collections.nCopies(n, INF));
            dist.set(s, 0L);
            // O((V+E)logV)
            // (Modified) Dijkstra's algorithm
            PriorityQueue<SP1Pair> pq = new PriorityQueue<>(); pq.offer(new SP1Pair(s, 0L));

            // sort the pairs by non-decreasing distance from s
            while (!pq.isEmpty()) {                      // main loop
                SP1Pair top = pq.poll();
                int u = top.first();     // shortest unvisited u
                long d = top.second();
                if (d > dist.get(u)) continue;             // a very important check
                for (SP1Pair v_w : AL.get(u)) {        // all edges from u
                    int v = v_w.first();
                    long w = v_w.second();
                    if (dist.get(u)+w >= dist.get(v)) continue; // not improving, skip
                    dist.set(v, dist.get(u)+w);              // relax operation
                    pq.offer(new SP1Pair(v, dist.get(v))); // enqueue better pair
                }
            }

            // O(q)
            while (q-- > 0) {
                int target = Integer.parseInt(br.readLine());
                if (dist.get(target) != INF) {
                    pw.println(dist.get(target));
                } else {
                    pw.println("Impossible");
                }
            }
        }

        br.close();
        pw.close();
    }
}

class SP1Pair implements Comparable<SP1Pair> {
    Integer _first;
    Long _second;

    public SP1Pair(Integer f, Long s) {
        _first = f;
        _second = s;
    }

    public int compareTo(SP1Pair o) {
        return this.second() - o.second() > 0 ? 1 : -1;
    }

    Integer first() { return _first; }
    Long second() { return _second; }
}
