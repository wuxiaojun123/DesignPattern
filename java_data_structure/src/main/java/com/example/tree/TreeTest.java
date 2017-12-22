package com.example.tree;

/**
 * Created by wuxiaojun on 17-5-10.
 */

public class TreeTest {


    public static void main(String[] args) {

        Tree theTree = new Tree();

        theTree.insert(50, 1.5);
        theTree.insert(25, 1.7);
        theTree.insert(75, 1.9);

        Node found = theTree.find(25);
        if (found != null) {
            System.out.println("Found the node with key 25");
        } else {
            System.out.println("Could not find node with key 25");
        }

    }


    static class Tree {

        private Node root;

        public Node find(int key) {

            Node current = root;

            while (current.iData != key) {

                if (key < current.iData) {
                    current = current.leftChild;
                } else {
                    current = current.rightChild;
                }

                if (current == null) {
                    return null;
                }
            }
            return current;
        }


        public void insert(int id, double dd) {
            Node newNode = new Node();
            newNode.iData = id;
            newNode.fData = dd;
            if (root == null) {
                root = newNode;
            } else {
                Node current = root;
                Node parent;
                while (true) {
                    parent = current;
                    if (id < current.iData) {

                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = newNode;
                            return;
                        }

                    }else{

                        current = current.rightChild;
                        if(current == null){
                            parent.rightChild = newNode;
                            return;
                        }

                    }
                }
            }
        }

        /***
         * 中序遍历
         * @param localRoot
         */
        private void inOrder(Node localRoot){
            if(localRoot != null){
                inOrder(localRoot.leftChild);
                System.out.println(localRoot.iData + " ");
                inOrder(localRoot.rightChild);
            }
        }

        /***
         * 查找最小值
         * @return
         */
        private Node minimum(){
            Node current,last = null;
            current = root;
            while (current != null){
                last = current;
                current = current.leftChild;
            }
            return last;
        }

        /***
         * 查找最大值
         * @return
         */
        private Node maxmum(){

            Node current,last = null;
            current = root;
            while (current != null){
                last = current;
                current = current.rightChild;
            }
            return last;
        }


        /***
         * 删除没有字节点
         * @param key
         */
        public boolean delete1(int key) {
            Node current = root;
            Node parent = root;
            boolean isLeftChild = true;

            while (current.iData != key){
                parent = current;
                if(key < current.iData){
                    isLeftChild = true;
                    current = current.leftChild;

                }else{
                    isLeftChild = false;
                    current = current.rightChild;

                }
                if(current == null){
                    return false;
                }
            }

            // 没有子节点
            if(current.leftChild==null && current.rightChild==null){
                if(current == root){
                    root = null;
                }else if(isLeftChild){
                    parent.leftChild = null;
                }else{
                    parent.rightChild = null;
                }
            }else if(current.rightChild == null){
                // 只有左子节点
                if(current == root){
                    root = current.leftChild;
                }else if(isLeftChild){
                    parent.leftChild = current.leftChild;
                }else{
                    parent.rightChild = current.leftChild;
                }

            }else if(current.leftChild == null){
                // 只有右子节点
                if(current == root){
                    root = current.rightChild;
                }else if(isLeftChild){
                    parent.leftChild = current.rightChild;
                }else{
                    parent.rightChild = current.rightChild;
                }

            }

            return isLeftChild;
        }

        public void delete(int key) {

        }

    }


    static class Node {

        int iData;
        double fData;
        Node leftChild;
        Node rightChild;

        public void displayNode() {
        }

    }

}
