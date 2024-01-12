import java.io.*;
import java.util.*;

public class Teque {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hm1 = new HashMap<>();
        HashMap<Integer, Integer> hm2 = new HashMap<>();

        int hm1head = 0;
        int hm1tail = 1;
        int hm2head = 0;
        int hm2tail = 1;

        while (N-- > 0) {
            String[] token = br.readLine().split(" ");
            if (token[0].equals("push_back")) {
                int val = Integer.parseInt(token[1]);
                hm2.put(hm2tail++, val);
                if ((hm1tail - hm1head + 1) < (hm2tail - hm2head + 1)) {
                    int tmp = hm2.get(++hm2head);
                    hm1.put(hm1tail++, tmp);
                    hm2.remove(hm2head);
                }
            } else if (token[0].equals("push_front")) {
                int val = Integer.parseInt(token[1]);
                hm1.put(hm1head--, val);
                if ((hm1tail - hm1head + 1) > (hm2tail - hm2head + 1 + 1)) {
                    int tmp = hm1.get(--hm1tail);
                    hm2.put(hm2head--, tmp);
                    hm1.remove(hm1tail);
                }
            } else if (token[0].equals("push_middle")) {
                int val = Integer.parseInt(token[1]);
                hm1.put(hm1tail++, val);
                if ((hm1tail - hm1head + 1) > (hm2tail - hm2head + 1 + 1)) {
                    int tmp = hm1.get(--hm1tail);
                    hm2.put(hm2head--, tmp);
                    hm1.remove(hm1tail);
                }
            } else if (token[0].equals("get")) {
                int idx = Integer.parseInt(token[1]);
                if (idx < hm1.size()) {
                    int i = hm1head + idx + 1;
                    pw.println(hm1.get(i));
                } else {
                    int i = hm2head + idx - hm1.size() + 1;
                    pw.println(hm2.get(i));
                }
            }
        }
        br.close();
        pw.close();
    }
}