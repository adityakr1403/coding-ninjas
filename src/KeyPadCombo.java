import java.lang.reflect.Array;
import java.util.Arrays;

public class KeyPadCombo {

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

    public static String[] keypad(int n) {
        if (n == 0) {
            String[] ans = {""};
            return ans;
        }
        int x = n % 10;
        String[] smallAns = keypad(n / 10);
        String[] vals = helper(x);
        String[] result = new String[smallAns.length * vals.length];
        int k = 0;
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < smallAns.length; j++) {
                result[k++] = smallAns[j] + vals[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 234;
        String[] strs = keypad(n);
        System.out.println(Arrays.toString(strs));
    }
}
