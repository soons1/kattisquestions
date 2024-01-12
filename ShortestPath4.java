import java.io.*;
import java.sql.Array;
import java.util.*;
// wip
public class ShortestPath4 {
    public static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine());
        /*
        while (tc-- > 0) {
            br.readLine();
            int v = Integer.parseInt(br.readLine());
            // O(V)
            ArrayList<ArrayList<IntegerP>> AL = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                AL.add(new ArrayList<>());
            }
            // O(E)
            for (int num = 0; num < v; num++) {
                String[] line = br.readLine().split(" ");
                int x = Integer.parseInt(line[0]);
                for (int i = 1; i < 2*x+1; i++) {
                    int vertex = Integer.parseInt(line[i++]);
                    int w = Integer.parseInt(line[i]);
                    AL.get(num).add(new IntegerP(vertex, w));
                }
            }
            int q = Integer.parseInt(br.readLine());
            while (q-- > 0) {
                String[] line = br.readLine().split(" ");
                int s = Integer.parseInt(line[0]);
                int t = Integer.parseInt(line[1]);
                int k = Integer.parseInt(line[2]) - 1;
                int ans = -1;

                //Dijkstra's
                PriorityQueue<IntegerT> pq = new PriorityQueue<>(); pq.offer(new IntegerT(0, 0, s));
                //ArrayList<IntegerP> dist = new ArrayList<>(Collections.nCopies(v, new IntegerP(INF, INF))); dist.set(s, new IntegerP(0, 0));
                int[][] dist = new int[k+1][v];
                for (int[] row : dist) {
                    Arrays.fill(row, INF);
                }
                for (int i = 0; i < k+1; i++) {
                    dist[i][s] = 0;
                }

                while (!pq.isEmpty()) {                      // main loop
                    IntegerT top = pq.poll();
                    int j = top.first(), w = top.second(), n = top.third();     // shortest unvisited u
                    if (n == t) {
                        ans = w;
                        break;
                    }
                    if (w > dist[j][n]) continue;            // a very important check
                    if (j >= k) continue;
                    for (IntegerP v_w : AL.get(n)) {        // all edges from u
                        int ve = v_w.first(), vw = v_w.second();
                        if (dist[j + 1][ve] > dist[j][n] + vw) {
                            dist[j + 1][ve] = dist[j][n] + vw;
                            pq.offer(new IntegerT(j + 1, dist[j + 1][ve], ve));
                        }
                    }
                }

                pw.println(ans);
            }

            pw.println("");
        }
*/
        br.close();
        pw.close();
    }
}
/*
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
            return this.first() - o.first();
        }
    }

    Integer first() { return _first; }
    Integer second() { return _second; }
    Integer third() { return _third; }
}
*/