import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class Index {
  public Index before;
  public Index after;
  public String word;

  public Index (String word) {
    this.word = word;
    this.after = null;
    this.before = null;
  }
}

public class JoinStrings {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<Index> adj = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      Index c = new Index(br.readLine());
      adj.add(c);
    }


    int fin = 1;
    if (n > 1) {
      for (int i = 0; i < n - 1; i++) {
        String[] tmp = br.readLine().split(" ");
        int a = Integer.parseInt(tmp[0]);
        int b = Integer.parseInt(tmp[1]);
        Index update = adj.get(a-1);
        Index original = adj.get(b-1);
        if(update.before != null) {
          update.before.after = original;
        }

        update.after = (update.before == null)
                ? original
                : update.after;

        update.before = (original.after != null)
                ? original.before
                : original;
        fin = a;
      }
    }
    br.close();

    PrintWriter pw = new PrintWriter(System.out);
    boolean done = false;
    Index curr = adj.get(fin - 1);
    while (!done) {
        pw.print(curr.word);
        curr = curr.after;
        if (curr == null) {
          done = true;
        }
    }
    pw.close();
  }
}

