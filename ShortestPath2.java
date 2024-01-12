import java.io.*;
import java.util.*;

public class ShortestPath2 {
    public static final long INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        /*
        String input;
        while (!(input = br.readLine()).equals("0 0 0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            // O(n) construct AL
            ArrayList<ArrayList<IntegerQuad>> AL = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                AL.add(new ArrayList<>());
            }
            // O(m) construct AL
            while (m-- > 0) {
                String[] tokens = br.readLine().split(" ");
                int u = Integer.parseInt(tokens[0]);
                int v = Integer.parseInt(tokens[1]);
                int t0 = Integer.parseInt(tokens[2]);
                int p = Integer.parseInt(tokens[3]);
                long d = Long.parseLong(tokens[4]);
                AL.get(u).add(new IntegerQuad(v, t0, p, d));
            }

            ArrayList<Long> dist = new ArrayList<>(Collections.nCopies(n, INF));
            dist.set(s, 0L);
            // O((V+E)logV)
            // (Modified) Dijkstra's algorithm
            PriorityQueue<IntegerPair> pq = new PriorityQueue<>(); pq.offer(new IntegerPair(s, 0L));

            // sort the pairs by non-decreasing distance from s
            while (!pq.isEmpty()) {                      // main loop
                IntegerPair top = pq.poll();
                int u = top.first();     // shortest unvisited u
                long d = top.second();
                if (d > dist.get(u)) continue;             // a very important check
                for (IntegerQuad v_w : AL.get(u)) {        // all edges from u
                    int v = v_w.first();
                    long t1 = v_w.second();
                    long p1 = v_w.third();
                    long w = v_w.fourth();
                    if (p1 == 0 && t1 < dist.get(u)) continue;
                    while (t1 < dist.get(u)) {
                        t1 += p1;
                    }
                    if (t1+w >= dist.get(v)) continue; // not improving, skip
                    dist.set(v, t1+w);              // relax operation
                    pq.offer(new IntegerPair(v, dist.get(v))); // enqueue better pair
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
        */
        br.close();
        pw.close();
    }
}
/*
class IntegerQuad implements Comparable<IntegerQuad> {
    Integer _vertex, _first, _second;
    Long _third;

    public IntegerQuad(Integer v, Integer f, Integer s, Long t) {
        _vertex = v;
        _first = f;
        _second = s;
        _third = t;
    }

    public int compareTo(IntegerQuad o) {
        if (!this.second().equals(o.second()))
            return this.second() - o.second();
        else if (!this.third().equals(o.third()))
            return this.third() - o.third();
        else if (!this.fourth().equals(o.fourth()))
            return this.fourth() - o.fourth() > 0 ? 1 : -1;
        return 0;
    }

    Integer first() { return _vertex; }
    Integer second() { return _first; }
    Integer third() { return _second; }
    Long fourth() { return _third; }
}

class IntegerPair implements Comparable<IntegerPair> {
    Integer _first;
    Long _second;

    public IntegerPair(Integer f, Long s) {
        _first = f;
        _second = s;
    }

    public int compareTo(IntegerPair o) {
        return this.second() - o.second() > 0 ? 1 : -1;
    }

    Integer first() { return _first; }
    Long second() { return _second; }
}
*/