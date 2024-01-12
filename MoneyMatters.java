import java.io.*;
import java.util.*;

public class MoneyMatters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        HashMap<Integer, Integer> hm = new HashMap<>();
        //UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            hm.put(i, value);
        }

        while (m-- > 0) {
            String[] token = br.readLine().split(" ");
            int a = Integer.parseInt(token[0]);
            int b = Integer.parseInt(token[1]);
            //uf.unionSet(a, b);
        }

        HashMap<Integer, Integer> hm2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int value = hm.get(i);
            //int root = uf.findSet(i);
            //if (hm2.containsKey(root)) {
            //    hm2.put(root, hm2.get(root) + value);
            //} else {
            //    hm2.put(root, value);
            //}
        }

        for (Map.Entry<Integer, Integer> e : hm2.entrySet()) {
            if (e.getValue() != 0) {
                pw.println("IMPOSSIBLE");
                pw.close();
                return;
            }
        }
        pw.println("POSSIBLE");

        br.close();
        pw.close();
    }
}
/*
// Union-Find Disjoint Sets Library written in OOP manner, using both path compression and union by rank heuristics
class UnionFind {                                              // OOP style
    private ArrayList<Integer> p, rank, setSize;
    private int numSets;

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