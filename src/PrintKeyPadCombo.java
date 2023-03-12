public class PrintKeyPadCombo {
    public static String[] helper(int x) {
//        2-abc 3-def 4-ghi 5-jkl 6-mno 7-pqrs 8-tuv 9-wxyz
        String[][] vals = {{},
                {},
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"}};
        return vals[x];
    }

    public static void printKeypad(int input, String outputSoFar) {
        if (input == 0) {
            System.out.println(outputSoFar);
            return;
        }
        int n = input % 10;
        String[] str = helper(n);
        for (int i = 0; i < str.length; i++) {
            printKeypad(input / 10, outputSoFar + str[i]);
        }

    }

    public static void printKeypad(int input) {
        printKeypad(input, "");
    }

    public static void main(String[] args) {
        int num = 234;
        printKeypad(num);
    }
}
