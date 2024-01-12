import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubSeqHard {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());

    for (int i = 0; i < num; i++) {
      int count = 0;
      br.readLine();
      int n = Integer.parseInt(br.readLine());
      String[] line = br.readLine().split(" ");

      // prefix sums
      HashMap<Long, Integer> sumLst = new HashMap<>();
      long prefixSum = 0;
      sumLst.put(Long.parseLong("0"), 1);
      for (int j = 0; j < n; j++) {
        prefixSum += Integer.parseInt(line[j]);
        long tmp = prefixSum - 47;
        if (sumLst.containsKey(tmp)) {
          count += sumLst.get(tmp);
        }
        sumLst.put(prefixSum, sumLst.get(prefixSum) == null ? 1 : sumLst.get(prefixSum) + 1);
      }

      System.out.println(count);
    }
  }
}