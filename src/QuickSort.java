import java.util.Scanner;

public class QuickSort {
    public static void quicksort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivotPosition = partition(arr, start, end);
        quicksort(arr, start, pivotPosition - 1);
        quicksort(arr, pivotPosition + 1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int pivotPosition = end;
        for (int i = end; i > start ; i--) {
            if (arr[i] > pivot){
                swap(arr,i,pivotPosition--);
            }
        }
        swap(arr,start,pivotPosition);
        return pivotPosition;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        partition(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
