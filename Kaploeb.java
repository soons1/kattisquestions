import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Kaploeb {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int l = Integer.parseInt(str[0]);
    int k = Integer.parseInt(str[1]);

    HashMap<String, Integer> totalTime = new HashMap<>();
    HashMap<String, Integer> totalLaps = new HashMap<>();

    for (int i = 0; i < l; i++) {
      String[] lap = br.readLine().split(" ");

      if (totalTime.containsKey(lap[0])) {
        int curr = totalTime.get(lap[0]);
        String[] newLap = lap[1].split("[.]", 0);
        curr += Integer.parseInt(newLap[0]) * 60 + Integer.parseInt(newLap[1]);
        totalTime.put(lap[0], curr);
      } else {
        String[] newLap = lap[1].split("[.]", 0);
        totalTime.put(lap[0], Integer.parseInt(newLap[0]) * 60 + Integer.parseInt(newLap[1]));
      }

      if (totalLaps.containsKey(lap[0])) {
        totalLaps.put(lap[0], totalLaps.get(lap[0]) + 1);
      } else {
        totalLaps.put(lap[0], 1);
      }
    }

    br.close();

    // filter out the ones with k laps
    List<List<Integer>> ranked = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : totalTime.entrySet()) {
      String key = entry.getKey();
      if (totalLaps.get(key) == k) {
        int value = entry.getValue();
        List<Integer> tmp = new ArrayList<>();
        tmp.add(Integer.parseInt(key));
        tmp.add(value);
        ranked.add(tmp);
      }
    }

    // sort according to timing
    ranked.sort(new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> o1, List<Integer> o2) {
        if (o1.get(1) > o2.get(1)) {
          return 1;
        } else if (o1.get(1) < o2.get(1)) {
          return -1;
        } else {
          if (o1.get(0) > o2.get(0)) {
            return 1;
          } else if (o1.get(0) < o2.get(0)) {
            return -1;
          } else {
            return 0;
          }
        }
      }
    });

    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < ranked.size(); i++) {
      pw.println(ranked.get(i).get(0));
    }
    pw.close();
  }
}