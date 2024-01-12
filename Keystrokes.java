import java.io.*;
import java.util.*;

public class Keystrokes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        /*
        String[] keystrokes = br.readLine().split("");
        LinkedNodes ln = new LinkedNodes();
        Node cursor = new Node("??");
        Node head = cursor;
        ln.insert(cursor);

        for (String s : keystrokes) {
            if (s.equals("L")) {
                cursor = cursor.prev;
            } else if (s.equals("R")) {
                cursor = cursor.next;
            } else if (s.equals("B")) {
                Node tmp = cursor.prev;
                ln.remove(cursor);
                cursor = tmp;
            } else {
                Node n = new Node(s);
                if (cursor.equals(ln.tail)) {
                    ln.insert(n);
                } else {
                    ln.insert_at(n, cursor);
                }
                cursor = n;
            }
        }

        head = head.next;
        while (head != null) {
            pw.print(head.value);
            head = head.next;
        }
*/
        br.close();
        pw.close();
    }
}
/*
class Node {
    public String value;
    public Node next;
    public Node prev;

    public Node(String value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

class LinkedNodes {
    public Node tail;
    public int size;

    public LinkedNodes() {
        this.tail = null;
        this.size = 0;
    }

    public void insert(Node n) {
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
        if (this.tail == node) {
            this.tail = node.prev;
        }
        node.next = null;
        node.prev = null;
        this.size -= 1;
        return node;
    }
}
*/