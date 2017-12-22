package com.example.java_jichu;

public class Test {

    public static void main(String[] args) {
        int values[] = {80099, 16114, 63108, 25032, 31044, 59069, 39099, 13110, 34101, 66120, 19116, 72105, 70045, 38032, 41110, 12105, 75110, 27105, 1105, 9114, 67117, 20101, 21100, 11032, 79046, 32112, 5111, 6117, 45116, 22032, 61097, 65120, 49110, 15101, 82109, 50103, 54110, 17101, 46032, 4121,
                76097, 7032, 57105, 2102, 58044, 8097, 44099, 73064, 81111, 43097, 30112, 14116, 60109, 74104, 77105, 35097, 64058, 29112, 55032, 33108, 71108, 40111, 47088, 52117, 56076, 68097, 37101, 78114, 24110, 53097, 69110, 48105, 18115, 26072, 3032, 42116, 62105, 51120, 28065, 10101, 23105, 36115};
        int length = values.length;
        // 使用冒泡排序将数组有序化
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (values[j] > values[j + 1]) {
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.print(values[i] + "\t");
        }
        // 生成一颗二叉树
        TreeNode root = createBinaryTree(values, 0);
        Tree tree = new Tree(root);
        // 使用各种方法遍历
        System.out.println("\n层序遍历");
        tree.preLevel(root);
        System.out.println("\n层序遍历打印后三位");
        tree.preLevel2(root);
        System.out.println("\n左序遍历");
        tree.preLeft(root); // 左序遍历
        System.out.println("\n中序遍历");
        tree.preMiddle(root); // 中序遍历
        System.out.println("\n右序遍历");
        tree.preRight(root); // 右序遍历

        System.out.println("\n树的深度是");
        int count = tree.getDepth(root);
        System.out.println(count);

    }

    /***
     * 创建一颗二叉树
     * @param values 值
     */
    public static TreeNode createBinaryTree(int[] values, int index) {
        TreeNode root = null;
        if (index < values.length) {
            root = new TreeNode(values[index]);
            root.left = createBinaryTree(values, 2 * index + 1);
            root.right = createBinaryTree(values, 2 * index + 2);
        }
        return root;
    }

}
