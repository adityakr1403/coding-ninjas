import java.util.Arrays;

public class Susqeuences {
    public static String[] subSeq(String str) {
        if (str.length() == 0) {
            String[] ans = {""};
            return ans;
        }
        String[] smallAns = subSeq(str.substring(1));
        String[] result = new String[2 * smallAns.length];
        int k = 0;
        for (int i = 0; i < smallAns.length; i++) {
            result[k++] = str.charAt(0) + smallAns[i];
        }
        for (int i = 0; i < smallAns.length; i++) {
            result[k++] = smallAns[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "xyz";
        System.out.println(Arrays.toString(subSeq(str)));
    }
}
