import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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

public class Congaline {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int n = Integer.parseInt(str[0]);

    LinkedNodes ll = new LinkedNodes();
    HashMap<Node, Node> findCouple = new HashMap<>();

    Node mic = new Node("lmao");
    boolean movedMic = false; // To set the initial mic pos
    for (int i = 0; i < n; i++) {
      String[] couple = br.readLine().split(" ");
      Node c0 = new Node(couple[0]);
      Node c1 = new Node(couple[1]);
      if (!movedMic) {
        mic = c0;
        movedMic = true;
      }
      findCouple.put(c0, c1);
      findCouple.put(c1, c0);
      ll.insert(c0);
      ll.insert(c1);
    }

    String[] instructions = br.readLine().split("");
    br.close();
    PrintWriter pw = new PrintWriter(System.out);

    ll.tail.next = mic;
    mic.prev = ll.tail;

    for (String instruction : instructions) {
      if (instruction.equals("F")) {
        mic = mic.prev;
      } else if (instruction.equals("B")) {
        mic = mic.next;
      } else if (instruction.equals("R")) {
        Node nextMic = mic.next;
        ll.insert(ll.remove(mic));
        mic = nextMic;
      } else if (instruction.equals("C")) {
        Node nextMic = mic.next;
        Node tmp = ll.remove(mic);
        ll.insert_at(tmp, findCouple.get(tmp));
        mic = nextMic;
      } else if (instruction.equals("P")) {
        pw.println(findCouple.get(mic).value);
      }
    }

    pw.println();
    // print the line

    String stop = ll.tail.next.value;
    pw.println(stop);
    Node start = ll.tail.next.next;
    while (start != null && !start.value.equals(stop)) {
      pw.println(start.value);
      start = start.next;
    }


    pw.close();
  }
}