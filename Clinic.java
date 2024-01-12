import java.io.*;
import java.util.*;

public class Clinic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        /*
        String[] token = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);
        long k = Long.parseLong(token[1]);

        PriorityQueue<Tuple> pq = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple a, Tuple b) {
                long diff = b.severity - a.severity + (a.time - b.time) * k;
                return diff == 0L ? a.name.compareTo(b.name) : diff > 0L ? 1 : -1;
            }
        });
        HashMap<String, Tuple> hm = new HashMap<>();

        while (N-- > 0) {
            String[] line = br.readLine().split(" ");
            if (line[0].equals("1")) {
                long t = Long.parseLong(line[1]);
                String n = line[2];
                long s = Long.parseLong(line[3]);
                Tuple newPatient = new Tuple(n, s, t);
                pq.add(newPatient);
                hm.put(n, newPatient);
            } else if (line[0].equals("2")) {
                if (pq.isEmpty()) {
                    pw.println("doctor takes a break");
                } else {
                    Tuple announce = pq.poll();
                    while (announce.name.equals("DELETED")) {
                        announce = pq.poll();
                    }
                    hm.remove(announce.name);
                    pw.println(announce.name);
                }
            } else {
                String name = line[2];
                if (hm.containsKey(name)) {
                    hm.get(name).name = "DELETED";
                }
            }
        }
*/
        br.close();
        pw.close();
    }
}

/*
class Tuple implements Comparable<Tuple> {
    String name;
    long severity;
    long time;

    public Tuple(String name, long severity, long time) {
        super();
        this.name = name;
        this.severity = severity;
        this.time = time;
    }

    public int compareTo(Tuple o) {
        return Long.compare(this.severity, o.severity);
    }
}

 */