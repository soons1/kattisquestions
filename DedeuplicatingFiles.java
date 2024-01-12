import java.io.*;
import java.util.*;

public class DedeuplicatingFiles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);


        int num;
        while ((num = Integer.parseInt(br.readLine())) != 0) {
            HashMap<String, Integer> hm = new HashMap<>();
            while (num-- > 0) {
                String sentence = br.readLine();
                if (hm.containsKey(sentence)) {
                    hm.put(sentence, hm.get(sentence) + 1);
                } else {
                    hm.put(sentence, 1);
                }
            }
            int collisions = 0;
            for (String s : hm.keySet()) {
                for (String st : hm.keySet()) {
                    if (s.equals(st)) continue;
                    char hashed1 = hash(s);
                    char hashed2 = hash(st);
                    if (hashed1 == hashed2) {
                        collisions += hm.get(s) * hm.get(st);
                    }
                }

            }
            pw.println(hm.size() + " " + collisions / 2);
        }

        br.close();
        pw.close();
    }

    static char hash(String s) {
        char res = (char) 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
        }
        return res;
    }
}