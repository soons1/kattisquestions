import java.util.*;
import java.io.*;

public class Jetpack {
    private static char[][] field;
    private static boolean[][] visited;
    private static int size;
    private static int reachedFinal = -1;
    private static final Kattio io = new Kattio(System.in, System.out);

    public static void main(String[] args) throws Exception {
        size = io.getInt();
        field = new char[10][size];
        visited = new boolean[10][size];
        for (int i = 0; i < 10; i++) {
            String[] tokens = io.getWord().split("");
            for (int j = 0; j < size; j++) {
                field[i][j] = tokens[j].charAt(0);
            }
        }
        // depth first search
        dfs(9, 0);
        TreeMap<Integer, Integer> output = new TreeMap<>();
        int y = reachedFinal, count = 0;
        for (int i = size - 1; i > 0; i--) {
            // check up
            if (y < 9 && visited[y + 1][i - 1]) {
                y++;
                count++;
            } else if (y > 0 && visited[y - 1][i - 1]) {
                y--;
                if (count != 0) {
                    output.put(i, count);
                    count = 0;
                }
            } else if (y == 0){
                count++;
            } else {
                if (count != 0) {
                    output.put(i, count);
                    count = 0;
                }
            }
        }
        if (count != 0) {
            output.put(0, count);
        }
        io.println(output.size());
        for (Map.Entry<Integer, Integer> e : output.entrySet()) {
            io.printf("%d %d%n", e.getKey(), e.getValue());
        }

        io.close();
        io.flush();
    }
    private static void dfs(int r, int c) {
        if (reachedFinal != -1 || visited[r][c] || field[r][c] == 'X') {
            return;
        }
        visited[r][c] = true;
        if (c == size - 1) {
            reachedFinal = r;
            return;
        }
        if (r == 0) {
            dfs(r, c + 1);
        } else {
            dfs(r - 1, c + 1);
        }
        if (r == 9) {
            dfs(r, c + 1);
        } else {
            dfs(r + 1, c + 1);
        }
    }
}
class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}