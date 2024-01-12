import java.io.*;
import java.util.*;

public class Treehouses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int e = Integer.parseInt(tokens[1]);
        int p = Integer.parseInt(tokens[2]);
        /*
        // HM to store coordinates
        HashMap<Integer, DoublePair> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] coors = br.readLine().split(" ");
            double x = Double.parseDouble(coors[0]);
            double y = Double.parseDouble(coors[1]);
            hm.put(i, new DoublePair(x, y));
        }

        // UnionFind to check for cycles
        UnionFind uf = new UnionFind(n);
        // Add to UF
        while (p-- > 0) {
            String[] cable = br.readLine().split(" ");
            int a = Integer.parseInt(cable[0]) - 1;
            int b = Integer.parseInt(cable[1]) - 1;
            uf.unionSet(a, b);
        }

        //Connecting first e nodes
        for (int i = 0; i < e; i++) {
            uf.unionSet(0, i);
        }

        ArrayList<CustomTriple> EL = new ArrayList<>();
        // Add to EL
        for (int i = e; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                double w = Math.sqrt(Math.pow(hm.get(i).first() - hm.get(j).first(), 2) + Math.pow(hm.get(i).second() - hm.get(j).second(), 2));
                EL.add(new CustomTriple(w, i, j));
            }
        }
        Collections.sort(EL);                        // sort by w, O(E log E)

        // Kruskal's algorithm
        double mst_cost = 0, num_taken = 0;             // no edge has been taken
                  // all V are disjoint sets
        for (int i = 0; i < EL.size(); ++i) {                // up to O(E)
            CustomTriple front = EL.get(i);
            if (uf.isSameSet(front.second(), front.third())) continue; // check
            mst_cost += front.first();                 // add w of this edge
            uf.unionSet(front.second(), front.third());// link them
            ++num_taken;                               // 1 more edge is taken
            if (num_taken == n-1) break;               // optimization
        }

        String res = String.format("%.10f", mst_cost);
        pw.println(res.substring(0, 8));
        */
        br.close();
        pw.close();
    }
}
/*
class UnionFind {                                              // OOP style
    private ArrayList<Integer> p, rank, setSize;
    private int numSets;

    public UnionFind(int N) {
        p = new ArrayList<Integer>(N);
        rank = new ArrayList<Integer>(N);
        setSize = new ArrayList<Integer>(N);
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
            return ret;
        }
    }

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

class DoublePair implements Comparable<DoublePair> {
    Double _first, _second;

    public DoublePair(Double f, Double s) {
        _first = f;
        _second = s;
    }

    public int compareTo(DoublePair o) {
        if (!this.first().equals(o.first()))
            return this.first() - o.first() > 0 ? 1 : -1;
        else
            return this.second() - o.second() > 0 ? 1 : -1;
    }

    Double first() { return _first; }
    Double second() { return _second; }
}

class CustomTriple implements Comparable<CustomTriple> {
    Double _first;
    Integer _second, _third;

    public CustomTriple(Double f, Integer s, Integer t) {
        _first = f;
        _second = s;
        _third = t;
    }

    public int compareTo(CustomTriple o) {
        return this.first() - o.first() < 0 ? -1 : 1;
    }

    Double first() { return _first; }
    Integer second() { return _second; }
    Integer third() { return _third; }
}
 */