//public class CheckIfArraySorted {
//    public static boolean check(int[] arr) {
//        if (arr.length <= 1){
//            return true;
//        }
//        int[] smallerArr = new int[arr.length -1];
//        for (int i = 1; i < arr.length; i++) {
//            smallerArr[i-1] = arr[i];
//        }
//
//        boolean isRightArrSorted = check(smallerArr);
//        if (isRightArrSorted){
//            if (arr[0] < smallerArr[0]){
//                return true;
//            }else {
//                return false;
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        System.out.println(check(arr));
//    }
//
//    private static int firstIndex(int input[], int x, int startIndex) {
//        if (startIndex >= input.length -1) {
//            if (input[startIndex] == x) {
//                return startIndex;
//            } else {
//                return -1;
//            }
//            if (input[startIndex] == x) {
//                return startIndex;
//            }
//
//            return firstIndex(input, x, startIndex + 1);
//        }
//    }
//}
