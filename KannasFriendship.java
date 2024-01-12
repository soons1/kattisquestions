import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KannasFriendship {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    String[] first = br.readLine().split(" ");
    int Q = Integer.parseInt(first[1]);

    TreeMap<Long, Long> pool = new TreeMap<>();
    long ans = 0;

    while (Q-- > 0) {
      String[] token = br.readLine().split(" ");
      if (Integer.parseInt(token[0]) == 1) {
        long s = Long.parseLong(token[1]), e = Long.parseLong(token[2]);
        Long low = pool.lowerKey(s);
        if (low != null && pool.get(low) >= s) {
          s = low;
          e = Math.max(e, pool.get(low));
          ans -= pool.get(low) - low + 1;
          pool.remove(low);
        }
        while (pool.lowerKey(e+1) != null && pool.lowerKey(e+1) >= s) {
          long tmpE = pool.get(pool.lowerKey(e+1));
          e = Math.max(e, tmpE);
          ans -= tmpE - pool.lowerKey(e+1) + 1;
          pool.remove(pool.lowerKey(e+1));
        }
        pool.put(s, e);
        ans += e - s + 1;
        //pw.println(s);
        //pw.println(e);
      } else { // if (Integer.parseInt(token[0]) == 2)
        pw.println(ans);
      }
    }
    pw.close();
  }
}