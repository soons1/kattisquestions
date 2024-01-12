import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hermits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());

        long[] ppl = new long[n];
        long[] ppl2 = new long[n];

        String[] pplList = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            ppl[i] = Long.parseLong(pplList[i]);
            ppl2[i] = Long.parseLong(pplList[i]);
        }

        int m = Integer.parseInt(br.readLine());

        while (m-- > 0) {
            String[] token = br.readLine().split(" ");
            int item1 = Integer.parseInt(token[0]) - 1;
            int item2 = Integer.parseInt(token[1]) - 1;
            ppl[item1] += ppl2[item2];
            ppl[item2] += ppl2[item1];
        }

        /*
        Arrays.sort(ppl, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (Long.compare(o2[0], o1[0]) != 0) {
                    return (int) (o1[0] - o2[0]);
                } else {
                    return (int) (o1[1] - o2[1]);
                }
            }
        });
         */
        int result = 0;
        long min = ppl[0];

        for (int i = 1; i < n; i++) {
            if (Long.compare(ppl[i], min) < 0) {
                min = ppl[i];
                result = i;
            }
        }

        br.close();
        pw.println(result + 1);
        pw.close();
    }
}