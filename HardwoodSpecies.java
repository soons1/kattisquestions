import java.io.*;
import java.util.*;

public class HardwoodSpecies {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        HashMap<String, Long> map = new HashMap<>();
        long total = 0;

        while (true) {
            String tree = br.readLine();
            if (tree == null || tree.isEmpty()) {
                break;
            }
            if (map.containsKey(tree)) {
                map.put(tree, map.get(tree) + 1);
            } else {
                map.put(tree, 1L);
            }
            total++;
        }

        TreeMap<String, Long> map2 = new TreeMap<>(map);

        for (Map.Entry<String, Long> entry : map2.entrySet()) {
            String percent = String.format("%.6f", (double) entry.getValue() / total * 100);
            pw.println(entry.getKey() + " " + percent);
        }

        br.close();
        pw.close();
    }
}