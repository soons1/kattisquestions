import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pivot {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] happiness = br.readLine().split(" ");
    br.close();

    List<Integer> lst = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      lst.add(Integer.parseInt(happiness[i]));
    }

    List<Integer> cumMax = new ArrayList<>();
    cumMax.add(lst.get(0));
    for (int i = 1; i < n; i++) {
      cumMax.add(Math.max(lst.get(i), cumMax.get(i-1)));
    }

    List<Integer> cumMin = new ArrayList<>();
    cumMin.add(lst.get(lst.size()-1));
    for (int i = n-2; i >= 0 ; i--) {
      cumMin.add(Math.min(lst.get(i), cumMin.get(cumMin.size()-1)));
    }
    Collections.reverse(cumMin);

    int count = 0;
    for (int i = 0; i < n; i++) {
        if ((lst.get(i) >= cumMax.get(i)) && (lst.get(i) <= cumMin.get(i))) {
            count++;
        }
    }

    System.out.println(count);
  }
}
