import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CourseScheduling {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    int N = Integer.parseInt(br.readLine());

    TreeMap<String, Set<String>> tm = new TreeMap<>();

    while (N-- > 0) {
      String[] token = br.readLine().split(" ");
      String name = token[0] + token[1];
      String course = token[2];
      if (tm.containsKey(course)) {
        tm.get(course).add(name);
      }
      else {
        Set<String> set = new HashSet<>();
        set.add(name);
        tm.put(course, set);
      }
    }

    for (Map.Entry<String, Set<String>> m : tm.entrySet()) {
      pw.println(m.getKey() + " " + m.getValue().size());
    }
    pw.close();
  }
}