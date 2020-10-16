/**
 * binary tree based collection
 * we won't implement any Java collection interface with all methods
 * we implement only add() for filling the tree and Node, as minimum required set and also iterator
 */

package com.nahorny.pattern.behavioral.iterator;

import java.util.LinkedList;

public class TreeContainer implements Collection{ //means interface in this package, not java.util.Collection
    private Node root;

    /**
     * @param o - notNull payload
     * @return true if add successful
     */
    public boolean add(Object o) {
        if (o == null) return false;
        if (root == null) {
            root = new Node((Integer) o);
            return true;
        } else {
            return adding((Integer) o, root);
        }
    }

    /**
     *
     * @param o - payload
     * @param node - top of the tree for the first iteration / top of subtree for next one
     * @return
     */
    private boolean adding(int o, Node node) {
        if (node.payload == o) {
            return false;
        } else if (node.payload > o) {
            if (node.left == null) {
                node.left = new Node(o);
            } else {
                adding(o, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(o);
            } else {
                adding(o, node.right);
            }
        }
        return true;
    }

    @Override
    public Iterator getIterator() {
        return new Iterator() {
            LinkedList<Node> stack;

            {
                Node rootIt = root;
                stack = new LinkedList<>();
                while (rootIt != null) {
                    stack.push(rootIt);
                    rootIt = rootIt.left;
                }
            }

            public boolean hasNext() {
                return !stack.isEmpty();
            }

            public Object next() {
                Node node = stack.pop();
                int result = node.payload;
                if (node.right != null) {
                    node = node.right;
                    while (node != null) {
                        stack.push(node);
                        node = node.left;
                    }
                }
                return result;
            }
        };
    }


    public class Node implements Comparable {

        private int payload;
        private Node right, left;

        public Node(int payload) {
            this.payload = payload;
        }

        @Override
        public String toString() {
            return "[node.payload: " + payload + ']';
        }

        @Override
        //payload have to be comparable to find correct position in tree
        public int compareTo(Object o) {
            Node other = (Node) o;
            return (this.payload) - (other.payload);//it's a simple way to compare int
        }
    }//Node
}
