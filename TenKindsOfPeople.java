import java.io.*;
import java.util.*;

public class TenKindsOfPeople {
    private static final boolean UNVISITED = false;        // we only need these two
    private static final boolean VISITED = true;

    // these variables have to be global to be easily accessible by our recursion (other ways exist)
    private static int[][] map;
    private static boolean[][] dfs_num;
    static int r;
    static int c;
    static int numCC = 0;
    static int[][] cc;

    private static void dfs(int i, int j) {
        cc[i][j] = numCC;   // normal usage
        dfs_num[i][j] = VISITED;                     // mark u as visited
        if (i > 0 && map[i][j] == map[i-1][j]) {
            if (dfs_num[i-1][j] == UNVISITED) dfs(i-1, j);
        }
        if (i < r-1 && map[i][j] == map[i+1][j]) {
            if (dfs_num[i+1][j] == UNVISITED) dfs(i+1, j);
        }
        if (j > 0 && map[i][j] == map[i][j-1]) {
            if (dfs_num[i][j-1] == UNVISITED) dfs(i, j-1);
        }
        if (j < c-1 && map[i][j] == map[i][j+1]) {
            if (dfs_num[i][j+1] == UNVISITED) dfs(i, j+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        // O(V) initialize map
        map = new int[r][c];
        for (int tmp = 0; tmp < r; tmp++) {
            String line = br.readLine();
            for (int i = 0; i < c; i++) map[tmp][i] = Character.getNumericValue(line.charAt(i));
        }
        /*
        // O(V) initialize Adjacency List
        // do we need adjancency list
        AL = new ArrayList<>();
        for (int i = 0; i < r*c+1; i++) AL.add(new ArrayList<>());
        for (int i = 0; i < r; ++i) {                // for each u in [0..V-1]
            for (int j = 0; j < c; ++j) {
                if (i > 0 && map[i][j] == map[i-1][j]) {
                    AL.get(i * c + j + 1).add(new IntegerPair(i-1, j)); // add (v, w)
                }
                if (i < r-1 && map[i][j] == map[i+1][j]) {
                    AL.get(i * c + j + 1).add(new IntegerPair(i+1, j)); // add (v, w)
                }
                if (j > 0 && map[i][j] == map[i][j-1]) {
                    AL.get(i * c + j + 1).add(new IntegerPair(i, j-1)); // add (v, w)
                }
                if (j < c-1 && map[i][j] == map[i][j+1]) {
                    AL.get(i * c + j + 1).add(new IntegerPair(i, j+1)); // add (v, w)
                }
            }
        }
        */
        // O(V+E) labelling cc
        dfs_num = new boolean[r][c];
        cc = new int[r][c];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (dfs_num[i][j] == UNVISITED) {
                    ++numCC;
                    dfs(i, j);
                }
            }
        }

        // O(n) check
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] tokens = br.readLine().split(" ");
            int r1 = Integer.parseInt(tokens[0]) - 1;
            int c1 = Integer.parseInt(tokens[1]) - 1;
            int r2 = Integer.parseInt(tokens[2]) - 1;
            int c2 = Integer.parseInt(tokens[3]) - 1;
            if (cc[r1][c1] == cc[r2][c2]) {
                if (map[r1][c1] == 1) {
                    pw.println("decimal");
                } else {
                    pw.println("binary");
                }
            } else {
                pw.println("neither");
            }
        }

        br.close();
        pw.close();
    }
}

class IntegerPair implements Comparable<IntegerPair> {
    Integer _first, _second;

    public IntegerPair(Integer f, Integer s) {
        _first = f;
        _second = s;
    }

    public int compareTo(IntegerPair o) {
        if (!this.first().equals(o.first()))
            return this.first() - o.first();
        else
            return this.second() - o.second();
    }

    Integer first() { return _first; }
    Integer second() { return _second; }
}