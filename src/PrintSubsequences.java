public class PrintSubsequences {
    public static void printSubsequences(String str, String outputSoFar){
        if (str.length()== 0){
            System.out.println(outputSoFar);
            return;
        }
        printSubsequences(str.substring(1), outputSoFar);
        printSubsequences(str.substring(1),outputSoFar + str.charAt(0));
    }

    public static void printSubsequences(String str){
        printSubsequences(str, "");
    }

    public static void main(String[] args) {
        String str = "xyz";
        printSubsequences(str);
    }
}
