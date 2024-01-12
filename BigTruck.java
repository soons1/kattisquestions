import java.io.*;
import java.util.*;

public class BigTruck {
    public static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        String[] items = br.readLine().split(" ");
        int[] itemArray = new int[n+1];
        for (int i = 0; i < n; i++) {
            itemArray[i+1] = Integer.parseInt(items[i]);
        }
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<IntegerP>> AL = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            AL.add(new ArrayList<>());
        }
        while (m-- > 0) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int d = Integer.parseInt(line[2]);
            AL.get(a).add(new IntegerP(b, d));
            AL.get(b).add(new IntegerP(a, d));
        }

        // PQ with items, dist, node
        PriorityQueue<IntegerT> pq = new PriorityQueue<>(); pq.offer(new IntegerT(itemArray[1], 0, 1));
        // for each node, we have weight and items
        int[][] dist = new int[n+1][2];
        for (int i = 1; i < dist.length; i++) {
            dist[i][0] = INF;
            dist[i][1] = itemArray[i];
        }
        dist[1][0] = 0;

        while (!pq.isEmpty()) {                      // main loop
            IntegerT top = pq.poll();
            int i = top.first(), w = top.second(), v = top.third();     // shortest unvisited u
            if (v == n) break;                        // GUARANTEED TO BE THE SHORTEST PATH
            if (w > dist[v][0]) continue;            // a very important check
            if (i < dist[v][1]) continue;            // a very important check
            for (IntegerP v_w : AL.get(v)) {        // all edges from u
                int ve = v_w.first(), vw = v_w.second();
                if (dist[ve][0] > dist[v][0] + vw || (dist[ve][0] == dist[v][0] + vw && dist[ve][1] < itemArray[ve] + i)) {
                    dist[ve][0] = dist[v][0] + vw;
                    dist[ve][1] = itemArray[ve] + i;
                    pq.offer(new IntegerT(dist[ve][1], dist[ve][0], ve));
                }
            }
        }

        if (dist[n][0] == INF) pw.println("impossible");
        else pw.println(dist[n][0] + " " + dist[n][1]);

        br.close();
        pw.close();
    }
}


class IntegerP implements Comparable<IntegerP> {
    Integer _first, _second;

    public IntegerP(Integer f, Integer s) {
        _first = f;
        _second = s;
    }

    public int compareTo(IntegerP o) {
        if (!this.second().equals(o.second())) {
            return this.second() - o.second();
        } else {
            return this.first() - o.first();
        }
    }

    Integer first() { return _first; }
    Integer second() { return _second; }
}

class IntegerT implements Comparable<IntegerT> {
    Integer _first, _second, _third;

    public IntegerT(Integer f, Integer s, Integer t) {
        _first = f;
        _second = s;
        _third = t;
    }

    public int compareTo(IntegerT o) {
        if (!this.second().equals(o.second())) {
            return this.second() - o.second();
        } else {
            return o.first() - this.first();
        }
    }

    Integer first() { return _first; }
    Integer second() { return _second; }
    Integer third() { return _third; }
}