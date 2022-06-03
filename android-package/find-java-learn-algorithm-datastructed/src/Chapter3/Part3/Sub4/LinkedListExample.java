package Chapter3.Part3.Sub4;

public class LinkedListExample {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        // 노드와 링크를 동시에 생성할 수 있다
        ListNode node0 = new ListNode(0, node1);
        System.out.println(node0);
    }
}
