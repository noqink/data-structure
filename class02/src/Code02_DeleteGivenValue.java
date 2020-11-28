/**
 * 删除链表中指定值的结点
 */
public class Code02_DeleteGivenValue {

    public static class Node{
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public static Node removeValue(Node head, int num){
        // 先找到值不是value的结点，作为头结点
        while (head != null){
            if (head.value != num){
                break;
            }
            head = head.next;
        }

        // 找到后删除后面的
        Node pre = head; // 上一个不等于num的位置
        Node cur = head; // cur每次跳一次, 遍历链表
        while (cur != null){
            if (cur.value == num){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int i = 0;
        Node head = new Node(i);
        Node pre = head;
        while (i < 7){
            Node newHead = new Node(++i);
            pre.next = newHead;
            pre = newHead;
        }
//
//        while (head!=null){
//            System.out.print(head.value);
//            head = head.next;
//        }

        Node node = removeValue(head, 3);
        while (node!=null){
            System.out.print(node.value);
            node = node.next;
        }
    }
}
