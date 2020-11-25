public class Code01_SelectionSort {

    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        // 0～n-1
        // 1～n-1
        // 2～n-1
        for (int i = 0; i < arr.length -1; i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 6, 5, 4};
        int arr1[] = {1};
        selectionSort(arr);
        selectionSort(arr1);

        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i : arr1) {
            System.out.print(i+" ");
        }
    }

}
