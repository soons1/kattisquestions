import java.io.*;
import java.util.*;
//wip
public class NNProblems2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int Q = Integer.parseInt(tokens[1]);
        TreeMap<Long, Integer> map = new TreeMap<>();
        HashMap<Long, Integer> hm = new HashMap<>();

        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            long diff = Long.parseLong(nums[i]);
            if (map.containsKey(diff)) {
                map.put(diff, hm.get(diff) + 1);
                hm.put(diff, hm.get(diff) + 1);
            } else {
                map.put(diff, 1);
                hm.put(diff, 1);
            }
        }

        while (Q-- > 0) {
            String[] line = br.readLine().split(" ");
            int type = Integer.parseInt(line[0]);
            long compare = Long.parseLong(line[1]);
            if (type == 1) {
                if (map.higherKey(compare) == null) {
                    pw.println(-1);
                    continue;
                }
                long key = map.higherKey(compare);
                if (hm.get(key) == 1) {
                    map.remove(key);
                    hm.remove(key);
                } else {
                    map.replace(key, hm.get(key) - 1);
                    hm.replace(key, hm.get(key) - 1);
                }
                pw.println(key);
            } else {
                if (map.containsKey(compare)) {
                    if (hm.get(compare) == 1) {
                        map.remove(compare);
                        hm.remove(compare);
                    } else {
                        map.replace(compare, hm.get(compare) - 1);
                        hm.replace(compare, hm.get(compare) - 1);
                    }
                    pw.println(compare);
                } else {
                    if (map.lowerKey(compare) == null) {
                        pw.println(-1);
                        continue;
                    }
                    long key = map.lowerKey(compare);
                    if (hm.get(key) == 1) {
                        map.remove(key);
                        hm.remove(key);
                    } else {
                        map.replace(key, hm.get(key) - 1);
                        hm.replace(key, hm.get(key) - 1);
                    }
                    pw.println(key);
                }
            }
        }
        br.close();
        pw.close();
    }
}
