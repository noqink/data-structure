public class Code02_Heap01 {
    /**
     * 大根堆
     */
    public static class MyMaxHeap{
        private int heap[];
        private int heapSize;
        private final int limit;

        public MyMaxHeap(int limit) {
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        public void push(int value){
            if (heapSize > limit){
                throw new RuntimeException("heap is full!");
            }
            heap[heapSize] = value;
            heapInsert(heap, heapSize++);
        }

        /**
         * 把默认最后加进来的数往上提
         * @param arr
         * @param index
         * arr[index] > arr[(index - 1) / 2]
         * 已经包含两个条件
         * 1)arr[index] 不比arr[index父]大, 停
         * 2)index = 0, 停
         */
        private void heapInsert(int[] arr, int index){
            while (arr[index] > arr[(index - 1) / 2]){
                swap(arr, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        public void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        /**
         * 删除堆的最大值并返回, 重组堆
         * 用最后的值去顶替arr[0]
         * 再往下交换, 找到左孩子与右孩子之间更大的数, 如果更小, 则交换
         * @return
         */
        public int pop(){
            int ans = heap[0];
            // -- heapSize, 之后的数据进入无效区
            swap(heap, 0, -- heapSize);
            heapify(heap, 0, heapSize);
            return ans;
        }

        private void heapify(int[] arr, int index, int heapSize){
            int left = index * 2 + 1;
            while (left < heapSize){
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
                largest = arr[largest] > arr[index] ? largest : index;

                if (largest == index){
                    break;
                }
                swap(arr, index, largest);
                index = largest;
                left = index * 2 + 1;
            }
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }
    }

    public static class RightMaxHeap {
        private int[] arr;
        private final int limit;
        private int size;

        public RightMaxHeap(int limit) {
            arr = new int[limit];
            this.limit = limit;
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("heap is full");
            }
            arr[size++] = value;
        }

        public int pop() {
            int maxIndex = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            int ans = arr[maxIndex];
            arr[maxIndex] = arr[--size];
            return ans;
        }

    }

    public static void main(String[] args) {
        int value = 1000;
        int limit = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            int curLimit = (int) (Math.random() * limit) + 1;
            MyMaxHeap my = new MyMaxHeap(curLimit);
            RightMaxHeap test = new RightMaxHeap(curLimit);
            int curOpTimes = (int) (Math.random() * limit);
            for (int j = 0; j < curOpTimes; j++) {
                if (my.isEmpty() != test.isEmpty()) {
                    System.out.println("Oops!");
                }
                if (my.isFull() != test.isFull()) {
                    System.out.println("Oops!");
                }
                if (my.isEmpty()) {
                    int curValue = (int) (Math.random() * value);
                    my.push(curValue);
                    test.push(curValue);
                } else if (my.isFull()) {
                    if (my.pop() != test.pop()) {
                        System.out.println("Oops!");
                    }
                } else {
                    if (Math.random() < 0.5) {
                        int curValue = (int) (Math.random() * value);
                        my.push(curValue);
                        test.push(curValue);
                    } else {
                        if (my.pop() != test.pop()) {
                            System.out.println("Oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");

    }

}

