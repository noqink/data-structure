public class Code02_BubbleSort {

    public static void bubbleSort(int[] arr){

        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = arr.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    // 交换arr的i和j位置上的值
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 6, 5, 4};
        int arr1[] = {1};
        bubbleSort(arr);
        bubbleSort(arr1);

        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i : arr1) {
            System.out.print(i+" ");
        }
    }

}
