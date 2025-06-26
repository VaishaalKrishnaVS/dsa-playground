package neetcode.linkedlist;

import util.IBaseClassV2;

import java.util.Objects;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", random=" + (Objects.isNull(random)?"null":random.val) +
                '}';
    }
}
public class CopyListwithRandomPointer implements IBaseClassV2<Node, Node> {
    public static void main(String[] args) {
        var cls =  new CopyListwithRandomPointer();
        // create a node with data [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;
        Node ans = cls.intution(head);
        while (ans != null) {
            System.out.println(ans);
            ans = ans.next;
        }
    }

    @Override
    public Node intution(Node head) {
        Node tr = head;
        while (tr != null) {
            Node nx = tr.next;
            tr.next = new Node(tr.val);
            tr = tr.next;
            tr.next = nx;
            tr = tr.next;
        }
        tr = head;
        while (tr != null) {
            Node nx = tr.next;
            nx.random = tr.random == null?null: tr.random.next;
            tr = tr.next.next;
        }
        tr = head;
        Node pd = new Node(0);
        Node ptr = pd;
        while (tr != null) {
            pd.next = tr.next;
            pd = pd.next;
            tr.next = tr.next.next;
            tr = tr.next;
        }
        return ptr.next;
    }
}
