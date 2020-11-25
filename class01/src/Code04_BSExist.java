public class Code04_BSExist {
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R){
            mid = L + ((R - L) >> 1);
            if (num == sortedArr[mid]){
                return true;
            }else if (num > sortedArr[mid]){
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,2,2,3,4,5};
        System.out.println(exist(arr, 3));
    }
}
