package tree;

import java.util.ArrayList;

public class Questions {


    public static boolean checkIfContainsX(TreeNode<Integer> root, int x) {

        // Write your code here
        if (root.data == x) {
            return true;
        }
        boolean ans = false;

        for (int i = 0; i < root.children.size(); i++) {
            ans = ans || checkIfContainsX(root.children.get(i), x);
        }
        return ans;
    }


    public static int maxSumNodeHelper(TreeNode<Integer> root) {
        int currentSum = root.data;
        for (int i = 0; i < root.children.size(); i++) {
            currentSum += root.children.get(i).data;
        }
        return currentSum;
    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root) {
        // Write your code here
        TreeNode<Integer> ans = root;
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> temp = maxSumNode(root.children.get(i));
            if (maxSumNodeHelper(root) < maxSumNodeHelper(temp)) {
                ans = temp;
            }
        }
        return ans;
    }

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {

        // Write your code here
        boolean ans = true;
        if (root1.children.size() != root2.children.size()) {
            ans = false;
            return ans;
        }

        for (int i = 0; i < root1.children.size(); i++) {
            if (root1.children.get(i).data != root2.children.get(i).data) {
                ans = false;
                return ans;
            }
        }

        for (int i = 0; i < root1.children.size(); i++) {
            ans = ans && checkIdentical(root1.children.get(i), root2.children.get(i));
        }
        return ans;
    }

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n) {

        // Write your code here
        TreeNode<Integer> ans = root.data > n ? root : null;

        if (ans == null) {
            for (int i = 0; i < root.children.size(); i++) {
                if (root.children.get(i).data > n) {
                    ans = root.children.get(i);
                    break;
                }
            }
            if (ans != null) {
                for (int i = 0; i < root.children.size(); i++) {
                    if (root.children.get(i).data > n && root.children.get(i).data < ans.data) {
                        ans = root.children.get(i);
                    }
                }
            }
        }
        TreeNode<Integer> temp = null;
        for (int i = 0; i < root.children.size(); i++) {
            temp = findNextLargerNode(root.children.get(i), n);
            if (temp != null && ans != null) {
                if (temp.data < ans.data) {
                    ans = temp;
                }
            } else if (temp != null && ans == null) {
                ans = temp;
            }
        }

        return ans;
    }


    public static ArrayList<TreeNode<Integer>> findSecondLargestHelper(TreeNode<Integer> root) {
        ArrayList<TreeNode<Integer>> ans = new ArrayList<>();
        ans.add(root);
        ans.add(null);
        for (int i = 0; i < root.children.size(); i++) {
            ArrayList<TreeNode<Integer>> temp = findSecondLargestHelper(root.children.get(i));
            if (temp.get(0).data > ans.get(0).data) {
                if (temp.get(1).data > ans.get(0).data) {
                    ans.set(0, temp.get(0));
                    ans.set(1, temp.get(1));
                } else {
                    TreeNode<Integer> x = ans.get(0);
                    ans.set(0, temp.get(0));
                    ans.set(1, x);
                }
            } else {
                ans.set(1, temp.get(0));
            }
        }
        return ans;
    }

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {


        // Write your code here
        ArrayList<TreeNode<Integer>> ans = findSecondLargestHelper(root);
        return ans.get(1);

    }

    public static int countLeafNodes(TreeNode<Integer> root) {

        // Write your code here
        int count = 0;
        if (root.children.size() == 0) {
            count = 1;
            return count;
        }
        for (int i = 0; i < root.children.size(); i++) {
            count = count + countLeafNodes(root.children.get(i));
        }
        return count;
    }


    public static void replaceWithDepthValueHelper(TreeNode<Integer> root, int depth) {

        // Write your code here
        root.data = depth;
        for (int i = 0; i < root.children.size(); i++) {
            replaceWithDepthValueHelper(root.children.get(i), depth + 1);
        }

    }

    public static void replaceWithDepthValue(TreeNode<Integer> root) {

        // Write your code here
        replaceWithDepthValueHelper(root, 0);

    }

    public static void main(String[] args) {

    }
}
