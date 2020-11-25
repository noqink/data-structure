public class Code05_BSNearLeft {
    // 在arr上，找满足>=value的最左位置
    public static int nearestIndex(int[] arr, int value){
        int L = 0;
        int R = arr.length - 1;
        int index = -1; // 记录最左的对号
        while (L <= R){
            int mid = L + ((R - L) >> 1);
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int arr[] = {1,1,1,2,2,2,3,3,3,4,4,4,4,5};
        System.out.println(nearestIndex(arr, 6));
    }
}
