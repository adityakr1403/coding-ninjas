import java.util.Arrays;

public class ArraySubsets {

    public static int[][] subsets(int input[], int start) {
        if (start == input.length) {
            int[][] result = new int[1][0];
            return result;
        }
        int[][] smallAns = subsets(input, start + 1);
        int[][] result = new int[smallAns.length * 2][];
        int k = 0;



        for (int i = 0; i < smallAns.length; i++) {
            result[k] = new int[smallAns[i].length];
            for (int j = 0; j < smallAns[i].length; j++) {
                result[k][j] = smallAns[i][j];
            }
            k++;
        }
        for (int i = 0; i < smallAns.length; i++) {
            result[k] = new int[smallAns[i].length + 1];
            result[k][0] = input[start];
            for (int j = 0; j < smallAns[i].length ; j++) {
                result[k][j+1] = smallAns[i][j];
            }
            k++;
        }

        return result;
    }

    public static int[][] subsets(int input[]) {
        // Write your code here

        return subsets(input, 0);
    }

    public static void main(String[] args) {
        int[] arr = {19, 3, 9};
        int[][] ans = subsets(arr);
        System.out.println(ans.length);
        for (int i = 0; i < ans.length; i++) {

            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
