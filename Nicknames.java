import java.io.*;
import java.util.*;

public class Nicknames {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        HashMap<String, Set<String>> hm = new HashMap<>();
        int A = Integer.parseInt(br.readLine());

        while (A-- > 0) {
            String name = br.readLine();
            for (int i = 1; i <= name.length(); i++) {
                String initial = name.substring(0, i);
                if (hm.containsKey(initial)) {
                    hm.get(initial).add(name);
                } else {
                    HashSet<String> hs = new HashSet<>();
                    hs.add(name);
                    hm.put(initial, hs);
                }
            }
        }

        int B = Integer.parseInt(br.readLine());

        while (B-- >0) {
            String nickname = br.readLine();
            if (hm.containsKey(nickname)) {
                pw.println(hm.get(nickname).size());
            } else {
                pw.println(0);
            }
        }
        br.close();
        pw.close();
    }
}