import java.io.*;
import java.util.*;

public class DoctorKattis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        TreeSet<Tuple> pq = new TreeSet<>();
        HashMap<String, Tuple> hm = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while (N-- > 0) {
            String[] token = br.readLine().split(" ");
            if (token[0].equals("0")) {
                String name = token[1];
                int level = Integer.parseInt(token[2]);
                Tuple newCat = new Tuple(name, level, count++);
                pq.add(newCat);
                hm.put(name, newCat);
            } else if (token[0].equals("1")) {
                String name = token[1];
                int ulevel = Integer.parseInt(token[2]);
                Tuple oldCat = hm.get(name);
                pq.remove(oldCat);
                Tuple newCat = new Tuple(name, hm.get(name).id + ulevel, hm.get(name).time);
                pq.add(newCat);
                hm.put(name, newCat);
            } else if (token[0].equals("2")) {
                String name = token[1];
                Tuple cat = hm.get(name);
                pq.remove(cat);
            } else if (token[0].equals("3")) {
                if (pq.isEmpty()) {
                    pw.println("The clinic is empty");
                } else {
                    pw.println(pq.first().name);
                }
            }
        }

        br.close();
        pw.close();
    }
}

class Tuple implements Comparable<Tuple> {
    String name;
    int id;
    int time;

    public Tuple(String name, int id, int time) {
        super();
        this.name = name;
        this.id = id;
        this.time = time;
    }

    public int compareTo(Tuple o) {
        if (o.id != this.id) {
            return o.id - this.id;
        } else {
            return this.time - o.time;
        }
    }
}