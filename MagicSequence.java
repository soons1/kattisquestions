import java.io.*;
import java.util.*;

public class MagicSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] abc = br.readLine().split(" ");
            int A = Integer.parseInt(abc[0]);
            int B = Integer.parseInt(abc[1]);
            int C = Integer.parseInt(abc[2]);
            String[] xy = br.readLine().split(" ");
            int X = Integer.parseInt(xy[0]);
            int Y = Integer.parseInt(xy[1]);

            PriorityQueue<Long> pq = new PriorityQueue<>();
            long curr = A;
            long prev = 0;
            for (int i = 0; i < N; i++) {
                if (i != 0) {
                    curr = (prev * B + A) % C;
                }
                prev = curr;
                pq.add(curr);
            }

            long val = 0;
            for (int i = 0; i < N; i++) {
                val = (val * X + pq.poll()) % Y;
            }

            pw.println((int) val);
        }

        br.close();
        pw.close();
    }
}