import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 4, 8, 15, 11, 9};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr)); // [4, 8, 9, 11, 15]
        int searchValue = 11;
        System.out.println(binarySearch(arr, searchValue, 0, arr.length - 1));
    }

    static int binarySearch (int[] arr, int searchValue, int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) / 2);
            // mid
            if (arr[mid] == searchValue) {
                return mid;
            }
            // left
            if (searchValue < arr[mid]) {
                return binarySearch(arr, searchValue, start, mid - 1);
            } else { // right
                return binarySearch(arr, searchValue, mid + 1, end);
            }
        }
        return -1;
    }
}
