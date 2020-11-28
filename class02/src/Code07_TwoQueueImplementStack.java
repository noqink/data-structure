import java.util.LinkedList;
import java.util.Queue;

public class Code07_TwoQueueImplementStack {

    public static class TwoQueueStack<T> {
        public Queue<T> queue;
        public Queue<T> help;

        public TwoQueueStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(T value){ queue.offer(value);}

        public T poll() {
            while (queue.size() > 1){
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            Queue<T> temp = queue;
            queue = help;
            help = temp;
            return ans;
        }

        public T peek() {
            while (queue.size() > 1){
                help.offer(queue.poll());
            }
            T ans = queue.peek();
            Queue<T> temp = queue;
            queue = help;
            help = temp;
            queue.offer(ans);
            return ans;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        TwoQueueStack<Integer> stack = new TwoQueueStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.poll());
        System.out.println(stack.peek());
        System.out.println(stack.poll());
        System.out.println(stack.peek());
        System.out.println(stack.poll());
    }
}
