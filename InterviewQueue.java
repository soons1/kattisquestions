import java.io.*;
import java.util.*;
//wip
public class InterviewQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String[] scores = br.readLine().split(" ");
        /*
        LinkedNodes ll = new LinkedNodes();
        for (int i = 0; i < N; i++) {
            Node n = new Node(Long.parseLong(scores[i]));
            ll.insert(n);
        }

        StringBuilder sb = new StringBuilder();
        LinkedList<Node> toCheck = new LinkedList<>();
        Node curr = ll.head;
        while (curr != null) {
            long val = curr.value;
            if (curr.prev != null) {
                if (curr.prev.value > val) {
                    sb.append(curr.value).append(" ");
                    curr.prev.next = curr.next;
                    toCheck.add(curr.prev);
                    if (curr.next != null) {
                        curr.next.prev = curr.prev;
                        toCheck.add(curr.next);
                    }
                    curr = curr.next;
                    continue;
                }
            }
            if (curr.next != null) {
                if (curr.next.value > val) {
                    sb.append(curr.value).append(" ");
                    curr.next.prev = curr.prev;
                    toCheck.add(curr.next);
                }

            }
            curr = curr.next;
        }

        int minutes = 0;
        LinkedList<Node> toCheckLoop = new LinkedList<>();
        while (!toCheck.isEmpty()) {
            sb.append("\n");
            ListIterator<Node> iter = toCheck.listIterator();
            while (iter.hasNext()) {
                Node checking = iter.next();
                long val = checking.value;
                if (checking.prev != null) {
                    if (checking.prev.value > val) {
                        sb.append(checking.value).append(" ");
                        checking.prev.next = checking.next;
                        toCheckLoop.add(checking.prev);
                        if (checking.next != null) {
                            checking.next.prev = checking.prev;
                            toCheckLoop.add(checking.next);
                        }
                        continue;
                    }
                }
                if (checking.next != null) {
                    if (checking.next.value > val) {
                        sb.append(checking.value).append(" ");
                    }
                    checking.next.prev = checking.prev;
                    toCheckLoop.add(checking.next);
                }
            }
            toCheck = toCheckLoop;
            toCheckLoop = new LinkedList<>();
            minutes += 1;
        }
        pw.println(minutes);
        pw.println(sb.toString());
*/
        br.close();
        pw.close();
    }
}

/*
class LinkedNodes {
    public Node head;
    public Node tail;
    public int size;

    public LinkedNodes() {
        this.tail = null;
        this.size = 0;
    }

    public void insert(Node n) {
        if (this.size == 0) {
            this.head = n;
        }
        if (this.tail != null) {
            if (this.tail.next != null) {
                this.tail.next.prev = n;
                n.next = this.tail.next;
            }
            this.tail.next = n;
        }
        n.prev = this.tail;
        this.tail = n;
        this.size += 1;
    }
    public void insert_at(Node n, Node i) {
        Node prev = i;
        Node curr = n;
        Node succ = i.next;
        prev.next = curr;
        curr.prev = prev;
        curr.next = succ;
        succ.prev = curr;
        if (this.tail == prev) {
            this.tail = curr;
        }
        this.size += 1;
    }

    public Node remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (this.head == node) {
            this.head = node.next;
        }
        if (this.tail == node) {
            this.tail = node.prev;
        }
        node.next = null;
        node.prev = null;
        this.size -= 1;
        return node;
    }
}

class Node {
    public long value;
    public Node next;
    public Node prev;

    public Node(long value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

 */