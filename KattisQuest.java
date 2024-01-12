import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KattisQuest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, PriorityQueue<Integer>> pool = new TreeMap<>(); // pq handles repeat E values

        while (N-- > 0) {
            String[] token = br.readLine().split(" ");
            if (token[0].equals("add")) {
                int E = Integer.parseInt(token[1]), G = Integer.parseInt(token[2]);
                if (pool.containsKey(E)) {
                    pool.get(E).add(G);
                }
                else {
                    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                    pq.add(G);
                    pool.put(E, pq);
                }

            }
            else { // if (token[0] == "get")
                int X = Integer.parseInt(token[1]);
                long ans = 0;
                while (X > 0) {
                    Map.Entry<Integer, PriorityQueue<Integer>> pos = pool.lowerEntry(X+1); // find largest energy quest from current pool of quest
                    if (pos == null) break;
                    X -= pos.getKey();
                    long points = pos.getValue().poll();
                    ans += points;
                    if (pos.getValue().isEmpty()) pool.remove(pos.getKey());
                }
                pw.println(ans);
            }
        }
        pw.close();
    }
}