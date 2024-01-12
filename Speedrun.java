import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Speedrun {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int g = Integer.parseInt(str[0]);
    int n = Integer.parseInt(str[1]);

    ArrayList<ArrayList<Integer>> tasks = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        String[] task = br.readLine().split(" ");
        int start = Integer.parseInt(task[0]);
        int end = Integer.parseInt(task[1]);
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(start);
        tmp.add(end);
        tasks.add(tmp);
    }

    tasks.sort((a, b) -> a.get(1) - b.get(1));

    ArrayList<ArrayList<Integer>> seq = new ArrayList<>();
    seq.add(tasks.get(0));
    tasks.remove(0);

    while (!tasks.isEmpty()) {
        if (tasks.get(0).get(0) < seq.get(seq.size() - 1).get(1)) {
            tasks.remove(0);
        } else {
            seq.add(tasks.get(0));
            tasks.remove(0);
        }
    }

    if (seq.size() >= g) {
        System.out.println("YES");
    } else {
        System.out.println("NO");
    }
  }
}