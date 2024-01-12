import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TravelTheSkies {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    String[] first = br.readLine().split(" ");
    int k = Integer.parseInt(first[0]);
    int n = Integer.parseInt(first[1]);
    int m = Integer.parseInt(first[2]);

    List<List<Integer>> master = new ArrayList<>();

    while (m-- > 0) {
      String[] token = br.readLine().split(" ");
      int u = Integer.parseInt(token[0]);
      int v = Integer.parseInt(token[1]);
      int d = Integer.parseInt(token[2]);
      int z = Integer.parseInt(token[3]);
      List<Integer> lst = new ArrayList<>();
      lst.add(d);
      lst.add(u);
      lst.add(v);
      lst.add(z);
      master.add(lst);
    }

    HashMap<String, Integer> hm = new HashMap<>();
    int kn = k*n;
    while (kn-- > 0) {
      String[] token = br.readLine().split(" ");
      String a = token[0];
      String b = token[1];
      int c = Integer.parseInt(token[2]);
      a += " " + b;
      hm.put(a, c);
    }

    master.sort(new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> o1, List<Integer> o2) {
        return o1.get(0) - o2.get(0);
      }
    });

    for (int i = 1; i <= n; i++) {
        for (List<Integer> tmp : master) {
            if (tmp.get(0) == i) {
                int u = tmp.get(1);
                int v = tmp.get(2);
                int z = tmp.get(3);
                String uv = u + " " + i;
                if (hm.containsKey(uv)) {
                    if (hm.get(uv) >= z) {
                        hm.put(uv, hm.get(uv) - z);
                        if (i < n) {
                            String vu = v + " " + (i+1);
                            hm.put(vu, hm.get(vu) + z);
                        }
                    } else {
                        pw.println("suboptimal");
                        pw.close();
                        return;
                    }
                }
            }
        }

        if (i < n) {
            for (int j = 1; j <= k; j++) {
                String abNext = j + " " + (i + 1);
                if (hm.containsKey(abNext)) {
                    hm.put(abNext, hm.get(abNext) + hm.get(j + " " + i));
                }
            }
        }
    }

    pw.println("optimal");
    pw.close();
  }
}