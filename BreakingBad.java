import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BreakingBad {
  static HashMap<String, HashSet<String>> al;
  static HashSet<String> walt = new HashSet<>();
  static HashSet<String> jesse = new HashSet<>();
  static List<String> master = new ArrayList<>();

  static boolean can = true;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    al = new HashMap<>();

    int n = Integer.parseInt(br.readLine());
    while (n-- > 0) {
      String token = br.readLine();
      al.put(token, new HashSet<>());
      master.add(token);
    }

    int m = Integer.parseInt(br.readLine());
    while (m-- > 0) {
      String[] token = br.readLine().split(" ");
      String item1 = token[0];
      String item2 = token[1];
      al.get(item1).add(item2);
      al.get(item2).add(item1);
    }

    for (String s : master) {
      dfs(s);
    }

    if (can) {
      for (String s : walt) {
        pw.print(s + " ");
      }
      pw.println();
      for (String s : jesse) {
        pw.print(s + " ");
      }
    } else {
      pw.println("impossible");
    }

    br.close();
    pw.close();
  }

  static void dfs(String s) {
    if (!walt.contains(s) && !jesse.contains(s)) {
      walt.add(s);
    }

    for (String sus : al.get(s)) {
      if (walt.contains(s) && !walt.contains(sus) && !jesse.contains(sus)) {
        jesse.add(sus);
        dfs(sus);
      } else if (jesse.contains(s) && !walt.contains(sus) && !jesse.contains(sus)) {
        walt.add(sus);
        dfs(sus);
      } else if ((walt.contains(s) && walt.contains(sus)) || (jesse.contains(s) && jesse.contains(sus))) {
        can = false;
      }
    }
  }
}