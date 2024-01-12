import java.io.*;
import java.util.*;

public class SailingFriends {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int B = Integer.parseInt(nums[1]);
        int M = Integer.parseInt(nums[2]);

        //UnionFind uf = new UnionFind(N);

        String[] boats = br.readLine().split(" "); // length B

        while (M-- > 0) {
            String[] ports = br.readLine().split(" ");
            int f1 = Integer.parseInt(ports[0]) - 1;
            int f2 = Integer.parseInt(ports[1]) - 1;
            //uf.unionSet(f1, f2);
        }

        Set<Integer> boatsI = new HashSet<>();
        for (int i = 0; i < B; i++) {
            //boatsI.add(uf.findSet(Integer.parseInt(boats[i]) - 1));
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            //if (!boatsI.contains(uf.findSet(i))) {
                //boatsI.add(uf.findSet(i));
                //count++;
            //}
        }

        pw.println(count);

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