import java.io.*;
import java.util.*;

public class FendOffTitan {
    public static final long INF = 1000000000;
    public static final int INFi = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        int x = Integer.parseInt(tokens[2])-1; // from
        int y = Integer.parseInt(tokens[3])-1; // to

        // Make the AL
        ArrayList<ArrayList<IntegerTriple>> AL = new ArrayList<>();
        for (int u = 0; u < n; u++) {
            ArrayList<IntegerTriple> Neighbor = new ArrayList<>();
            AL.add(Neighbor);
        }

        while (m-- > 0) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0])-1;
            int b = Integer.parseInt(tokens[1])-1;
            long w = Integer.parseInt(tokens[2]);
            int c = Integer.parseInt(tokens[3]);
            AL.get(a).add(new IntegerTriple(b, c, w));
            AL.get(b).add(new IntegerTriple(a, c, w));
        }

        ArrayList<IntegerTriple> dist = new ArrayList<>(Collections.nCopies(n, new IntegerTriple(INFi, INFi, INF)));
        dist.set(x, new IntegerTriple(0, 0, 0L));

        PriorityQueue<IntegerQuad> pq = new PriorityQueue<>();
        pq.offer(new IntegerQuad(x, 0, 0, 0L));

        // sort the pairs by non-decreasing distance from s
        while (!pq.isEmpty()) {                      // main loop
            IntegerQuad top = pq.poll();
            int t = top.second();
            int s = top.third();
            long d = top.fourth();
            int u = top.first();     // shortest unvisited u
            /*
            if (t > dist.get(u).first()) continue;             // check if there are more titans
            if (t ==  dist.get(u).first()) {
                if (s > dist.get(u).second()) continue;        // check if there are more shamans
                if (s == dist.get(u).second()) {
                    if (d > dist.get(u).third()) continue;
                }
            }
            */
            if (dist.get(u).compareTo(new IntegerTriple(t, s, d)) < 0) continue; // check if this is a better pair
            for (IntegerTriple v_w : AL.get(u)) {        // all edges from u
                int v = v_w.first();
                int obstacle = v_w.second();
                long w = v_w.third();
                int titan = 0, shaman = 0;
                if (obstacle == 1) {                 // if got shaman
                    shaman = 1;
                } else if (obstacle == 2) {                                    // if got titan
                    titan = 1;
                }
                if (dist.get(u).first()+titan > dist.get(v).first()) continue;
                if (dist.get(u).first()+titan == dist.get(v).first()) {
                    if (dist.get(u).second() + shaman > dist.get(v).second()) continue;
                    if (dist.get(u).second() + shaman == dist.get(v).second()) {
                        if (dist.get(u).third()+w >= dist.get(v).third()) continue;
                    }
                }
                dist.set(v, new IntegerTriple(dist.get(u).first() + titan, dist.get(u).second() + shaman, dist.get(u).third()+w));              // relax operation
                pq.offer(new IntegerQuad(v, dist.get(v).first(), dist.get(v).second(), dist.get(v).third())); // enqueue better pair
            }
        }

        if (dist.get(y).first() == INF && dist.get(y).second() == INF && dist.get(y).third() == INF) pw.println("IMPOSSIBLE");
            // print total length, total no. of shamans, total no. of titans
        else pw.println(dist.get(y).third() + " " + dist.get(y).second() + " " + dist.get(y).first());

        br.close();
        pw.close();
    }
}

class IntegerTriple implements Comparable<IntegerTriple> {
    Integer _first, _second;
    Long _third;

    public IntegerTriple(Integer f, Integer s, Long t) {
        _first = f;
        _second = s;
        _third = t;
    }

    public int compareTo(IntegerTriple o) {
        if (!this.first().equals(o.first()))
            return this.first() - o.first();
        else if (!this.second().equals(o.second()))
            return this.second() - o.second();
        else if (!this.third().equals(o.third()))
            return this.third() - o.third() > 0 ? 1 : -1;
        else return 0;
    }

    Integer first() { return _first; }
    Integer second() { return _second; }
    Long third() { return _third; }
}

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