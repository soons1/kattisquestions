import java.io.*;
import java.util.*;

public class Chatter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String tmp;
        while ((tmp = br.readLine()) != null) {
            String[] tokens = tmp.split(" ");
            int n = Integer.parseInt(tokens[0]);
            int r = Integer.parseInt(tokens[1]);
            int a = Integer.parseInt(tokens[2]);
            int b = Integer.parseInt(tokens[3]);
            int c = Integer.parseInt(tokens[4]);

            //UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                int x = 0;
                int y = 0;
                while (x == y) {
                    r = (r * a + b) % c;
                    x = r % n;
                    r = (r * a + b) % c;
                    y = r % n;
                }
                //uf.unionSet(x, y);
            }

            //pw.println(uf.numDisjointSets() + " ");
            TreeMap<Integer, Integer> hm2 = new TreeMap<>(Collections.reverseOrder());

            for (int i = 0; i < n; i++) {
                //int e = uf.sizeOfSet(i);
                //if (hm2.containsKey(e)) {
                //    hm2.put(e, hm2.get(e) + 1);
                //} else {
                //    hm2.put(e, 1);
                //}
            }

            for (Map.Entry<Integer, Integer> e : hm2.entrySet()) {
                if (e.getValue()/e.getKey() == 1) {
                    pw.print(e.getKey() + " ");
                } else {
                    pw.print(e.getKey() + "x" + e.getValue()/e.getKey() + " ");
                }
            }
        }
        br.close();
        pw.close();
    }
}
/*
// Union-Find Disjoint Sets Library written in OOP manner, using both path compression and union by rank heuristics
class UnionFind {                                              // OOP style
    public ArrayList<Integer> p, rank, setSize;
    public int numSets;

    public UnionFind(int N) {
        p = new ArrayList<>(N);
        rank = new ArrayList<>(N);
        setSize = new ArrayList<>(N);
        numSets = N;
        for (int i = 0; i < N; i++) {
            p.add(i);
            rank.add(0);
            setSize.add(1);
        }
    }

    public int findSet(int i) {
        if (p.get(i) == i) return i;
        else {
            int ret = findSet(p.get(i)); p.set(i, ret);
            return ret; } }

    public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

    public void unionSet(int i, int j) {
        if (!isSameSet(i, j)) { numSets--;
            int x = findSet(i), y = findSet(j);
            // rank is used to keep the tree short
            if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
            else                           { p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
                if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1); } } }
    public int numDisjointSets() { return numSets; }
    public int sizeOfSet(int i) { return setSize.get(findSet(i)); }
}
 */