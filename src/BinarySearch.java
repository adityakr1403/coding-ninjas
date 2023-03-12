public class BinarySearch {

    public static int binarySearch(int[] arr, int x, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == x) {
            return mid;
        }
        if (x > arr[mid]) {
            return binarySearch(arr, x, mid + 1, end);
        }
        return binarySearch(arr, x, start, mid - 1);
    }

    public static int binarySearch(int[] arr, int x) {
        //Your code goes here
        return binarySearch(arr, x, 0, arr.length - 1);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(arr, 9));
    }
}
