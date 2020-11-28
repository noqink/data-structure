/**
 * 数组实现队列
 */
public class Code04_RingArray {
    public static class MyQueue {
        private int[] arr;
        private int pushi;
        private int polli;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            this.arr = new int[limit];
            this.pushi = 0;
            this.polli = 0;
            this.size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit){
                throw new RuntimeException("栈满了，不能再加了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int poll() {
            if (size == 0){
                throw new RuntimeException("栈空了，不能再拿了");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }
        public boolean isEmpty() {
            return size == 0;
        }

        public int nextIndex(int i){
            return i < limit - 1 ? i + 1 : 0;
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
