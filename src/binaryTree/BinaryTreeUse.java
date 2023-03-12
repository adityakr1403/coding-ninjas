package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeUse {

    public static int getSum(BinaryTreeNode<Integer> root) {
        //Your code goes here.
        if (root == null) {
            return 0;
        }
        int sum = root.data;

        sum += getSum(root.left);
        sum += getSum(root.right);

        return sum;

    }

    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        //Your code goes here
        if (root == null) {
            return false;
        }

        if (root.data == x) {
            return true;
        }
        return isNodePresent(root.left, x) || isNodePresent(root.right, x);
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> temp = queue.poll();
            System.out.print(root.data + ":");
            System.out.print("L:" + (root.left == null ? -1 : root.left.data));
            System.out.println("R:" + (root.right == null ? -1 : root.right.data));
            if (temp.left != null) {
                queue.add(root.left);
            }
            if (temp.right != null) {
                queue.add(root.right);
            }
        }
    }


    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        //Your code goes here
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.data > x) {
            count++;
        }

        count += countNodesGreaterThanX(root.left, x);
        count += countNodesGreaterThanX(root.right, x);

        return count;
    }

    public void inorderTraversalHelper(BinaryTreeNode<Integer> root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversalHelper(root.left, list);
        list.add(root.data);
        inorderTraversalHelper(root.right, list);
    }

    public List<Integer> inorderTraversal(BinaryTreeNode<Integer> root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversalHelper(root, ans);

        return ans;
    }


    public static void changeToDepthTreeHelper(BinaryTreeNode<Integer> root, int depth) {
        //Your code goes here
        if (root == null) {
            return;
        }
        root.data = depth;
        changeToDepthTreeHelper(root.left, depth + 1);
        changeToDepthTreeHelper(root.right, depth + 1);
    }

    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        //Your code goes here
        changeToDepthTreeHelper(root, 0);
    }

    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null) {
            return;
        }

        if (root.left == null && root.right != null) {
            System.out.println(root.right.data);
        } else if (root.right == null && root.left != null) {
            System.out.println(root.left.data);
        }
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);

    }


    public static int[] diameterOfBinaryTreeHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            int[] ans = new int[2]; // height, diameter
            return ans;
        }
        int[] ansLeft;
        int[] ansRight;
        int[] ans = new int[2];
        ansLeft = diameterOfBinaryTreeHelper(root.left);
        ansRight = diameterOfBinaryTreeHelper(root.right);
        ans[0] = 1 + Math.max(ansLeft[0], ansRight[0]);
        ans[1] = Math.max(ansLeft[0] + ansRight[0], Math.max(ansLeft[1], ansRight[1]));

        return ans;
    }

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
        //Your code goes here
        int[] ans = diameterOfBinaryTreeHelper(root);
        return ans[1];
    }


    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null) {
            return;
        }

        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);

        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void preOrder(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);

    }


    public static BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder[preStart]);
        int rootPosInInOrder = inStart;
        for (int i = inStart; i < inEnd; i++) {
            if (inOrder[i] == root.data) {
                rootPosInInOrder = i;
                break;
            }
        }
        root.left = buildTreeHelper(preOrder, inOrder, preStart + 1, preStart + (rootPosInInOrder - inStart - 1), inStart + 1, rootPosInInOrder);
        root.right = buildTreeHelper(preOrder, inOrder, );

    }

    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {

        //Your code goes here
        BinaryTreeNode<Integer> root = buildTreeHelper(preOrder, inOrder, 0, preOrder.length, 0, inOrder.length);
        return root;
    }

    public static void printLevelWiseBinary(BinaryTreeNode<Integer> root) {
        //Your code goes here
        if (root == null){
            return;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTreeNode<Integer> temp = queue.poll();
            System.out.println();
        }
    }


    public static void main(String[] args) {

    }
}
