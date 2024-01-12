import java.io.*;
import java.util.*;
// wip
public class MajorityCard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, PriorityQueue<Long>> tm = new TreeMap<>();
        HashMap<Long, Integer> hm = new HashMap<>();
        LinkedList<Long> ll = new LinkedList<>();

        while (N-- > 0) {
            String[] round = br.readLine().split(" ");
            String cmd = round[0];
            if (cmd.equals("PUT_TOP")) {
                int X = Integer.parseInt(round[1]);
                long Y = Long.parseLong(round[2]);
                // add to linkedlist
                for (int j = 0; j < X; j++) {
                    ll.addFirst(Y);
                }
                if (hm.containsKey(Y)) {
                    int oldVal = hm.get(Y);
                    tm.get(oldVal).remove(Y);
                    if (tm.get(oldVal).isEmpty()) {
                        tm.remove(oldVal);
                    }
                    hm.put(Y, oldVal + X);
                    if (tm.containsKey(hm.get(Y))) {
                        tm.get(hm.get(Y)).add(Y);
                    } else {
                        PriorityQueue<Long> pq = new PriorityQueue<>();
                        pq.add(Y);
                        tm.put(hm.get(Y), pq);
                    }
                } else {
                    hm.put(Y, X);
                    PriorityQueue<Long> pq = new PriorityQueue<>();
                    pq.add(Y);
                    tm.put(X, pq);
                }
            } else if (cmd.equals("PUT_BOTTOM")) {
                int X = Integer.parseInt(round[1]);
                long Y = Integer.parseInt(round[2]);
                // add to linkedlist
                for (int j = 0; j < X; j++) {
                    ll.addLast(Y);
                }
                if (hm.containsKey(Y)) {
                    int oldVal = hm.get(Y);
                    tm.get(oldVal).remove(Y);
                    if (tm.get(oldVal).isEmpty()) {
                        tm.remove(oldVal);
                    }
                    hm.put(Y, oldVal + X);
                    if (tm.containsKey(hm.get(Y))) {
                        tm.get(hm.get(Y)).add(Y);
                    } else {
                        PriorityQueue<Long> pq = new PriorityQueue<>();
                        pq.add(Y);
                        tm.put(hm.get(Y), pq);
                    }
                } else {
                    hm.put(Y, X);
                    PriorityQueue<Long> pq = new PriorityQueue<>();
                    pq.add(Y);
                    tm.put(X, pq);
                }
            } else if (cmd.equals("REMOVE_TOP")) {
                int Z = Integer.parseInt(round[1]);
                // remove from linkedlist
                HashMap<Long, Integer> toCheck = new HashMap<>();
                for (int j = 0; j < Z; j++) {
                    Long tmp = ll.removeFirst();
                    if (toCheck.containsKey(tmp)) {
                        toCheck.put(tmp, toCheck.get(tmp) + 1);
                    } else {
                        toCheck.put(tmp, 1);
                    }
                }
                // update treemap and hashmap
                for (Long l : toCheck.keySet()) {
                    int oldVal = hm.get(l);
                    // remove old value from treemap
                    tm.get(oldVal).remove(l);
                    if (tm.get(oldVal).isEmpty()) {
                        tm.remove(oldVal);
                    }
                    hm.put(l, oldVal - toCheck.get(l));
                    // add new value to treemap
                    if (tm.containsKey(hm.get(l))) {
                        tm.get(hm.get(l)).add(l);
                    } else {
                        PriorityQueue<Long> pq = new PriorityQueue<>();
                        pq.add(l);
                        tm.put(hm.get(l), pq);
                    }

                }
            } else {
                int Z = Integer.parseInt(round[1]);
                // remove from linkedlist
                HashMap<Long, Integer> toCheck = new HashMap<>();
                for (int j = 0; j < Z; j++) {
                    Long tmp = ll.removeLast();
                    if (toCheck.containsKey(tmp)) {
                        toCheck.put(tmp, toCheck.get(tmp) + 1);
                    } else {
                        toCheck.put(tmp, 1);
                    }
                }
                // update treemap and hashmap
                for (Long l : toCheck.keySet()) {
                    int oldVal = hm.get(l);
                    // remove old value from treemap
                    tm.get(oldVal).remove(l);
                    if (tm.get(oldVal).isEmpty()) {
                        tm.remove(oldVal);
                    }
                    hm.put(l, oldVal - toCheck.get(l));
                    // add new value to treemap
                    if (tm.containsKey(hm.get(l))) {
                        tm.get(hm.get(l)).add(l);
                    } else {
                        PriorityQueue<Long> pq = new PriorityQueue<>();
                        pq.add(l);
                        tm.put(hm.get(l), pq);
                    }

                }
            }
            // print smallest majority
            pw.println(tm.lastEntry().getValue().peek());
        }

        br.close();
        pw.close();
    }
}
