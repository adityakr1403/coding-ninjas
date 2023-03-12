import java.util.Stack;

public class Brackets {

    public static char helper(Character c) {
        switch (c) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
            default:
                return ' ';
        }
    }

    public static boolean isBalanced(String expression) {
        //Your code goes here
        Stack<Character> stack = new Stack<>();
        char[] cArr = expression.toCharArray();
        for (char c : cArr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if ( !stack.isEmpty() && stack.peek() == helper(c)) {
                stack.pop();
            } else if (stack.isEmpty()) {
                stack.push(c);
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        String str = "{{}}()[]";
        System.out.println(isBalanced(str));
    }
}
