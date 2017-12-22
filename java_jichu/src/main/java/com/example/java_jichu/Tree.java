package com.example.java_jichu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wuxiaojun on 2017/12/21.
 */

public class Tree {

    public TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    /***
     * 前序遍历
     * @param node
     */
    public void preLeft(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + "\t");
            preLeft(node.left);
            preLeft(node.right);
        }
    }

    /***
     * 中序遍历
     * @param node
     */
    public void preMiddle(TreeNode node) {
        if (node != null) {
            preLeft(node.left);
            System.out.print(node.value + "\t");
            preLeft(node.right);
        }
    }

    /**
     * 后序遍历
     * @param node
     */
    public void preRight(TreeNode node) {
        if (node != null) {
            preLeft(node.left);
            preLeft(node.right);
            System.out.print(node.value + "\t");
        }
    }

    /***
     * 层序遍历
     * @param root
     */
    public static void preLevel(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            System.out.print(temp.value + "\t");
            if (temp.left != null) q.add(temp.left);
            if (temp.right != null) q.add(temp.right);
        }
    }

    /***
     * 层序遍历
     * @param treeNode
     */
    public void preLevel2(TreeNode treeNode) {
        if (treeNode != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(treeNode);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                System.out.print(convert(node.value) + "\t");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    /**
     * 拿到数值的后三位
     * @param value
     * @return
     */
    public String convert(int value){
        String valueStr = String.valueOf(value);
        int length = valueStr.length();
        if(length > 3){
            return valueStr.substring(length-3);
        }
        return null;
    }

    /***
     * 获取所有结点
     * @param node
     * @return
     */
    public int getCountNode(TreeNode node) {
        int count = 0;
        if (node != null) {
            count += 1;
            count += getCountNode(node.left);
            count += getCountNode(node.right);
        }
        return count;
    }

    /**
     * 树的深度
     *
     * @param treeNode
     * @return
     */
    public int getDepth(TreeNode treeNode) {
        if (treeNode != null) {
            int leftDepth = getDepth(treeNode.left);
            int rightDepth = getDepth(treeNode.right);
            return 1 + ((leftDepth > rightDepth) ? leftDepth : rightDepth);
        }
        return 0;
    }

}
