package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Tree {
    public static TreeNode takeInput(Scanner scanner) {
        System.out.println("Enter the node data");
        TreeNode<Integer> root = new TreeNode<>(scanner.nextInt());
        System.out.println("Enter the number of children of " + root.data);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            root.children.add(takeInput(scanner));
        }
        return root;
    }

    public static void print(TreeNode<Integer> root) {

    }

    public static void printHelper(List<List<Integer>> list) {
        for (List<Integer> x : list) {
            for (Integer y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }

    }

    public static void printLevelWise(TreeNode<Integer> root) {
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Print output and don't return it.
         * Taking input is handled automatically.
         */

        List<List<Integer>> ans = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            List<Integer> temp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();
                temp.add(node.data);
                for (TreeNode<Integer> ele : node.children) {
                    queue.add(ele);
                }
            }
            ans.add(temp);
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode<Integer> root = takeInput(scanner);
        printLevelWise(root);

    }
}
