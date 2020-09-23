package DataStructures;

import java.util.ArrayList;

/**
 * Created by mari.avetisyan on 19/07/2020.
 */

class Node<T> {
    T val;
    Node nextNode;

    Node(T data) {
        this.val = data;
        this.nextNode = null;
    }
}

class SinglyLinkedList<T> {
    Node head = null;

    SinglyLinkedList(Node head) {
        this.head = head;
    }

    SinglyLinkedList() {
        this.head = null;
    }

    void print() {
        Node n = head;
        while(n != null) {
            System.out.print(n.val + "->");
            n = n.nextNode;
        }
        System.out.println();
    }

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = null;
    }

    int size() {
        int size = 0;
        Node tmp = head;
        while (tmp != null) {
            size++;
            tmp = tmp.nextNode;
        }

        return size;
    }

    static boolean areNodesEqual(final Node node1, final Node node2) {
        return node1.val == node2.val;
    }

    boolean isNodeExist(final T data) {
        Node tmp = head;
        Node node = new Node<T>(data);
        while (tmp != null) {
            if(areNodesEqual(tmp, node)) {
                return true;
            }

            tmp = tmp.nextNode;
        }
        return false;
    }

    private boolean isNodeExist(final Node node, final T data) {
        Node checkingNode = new Node<T>(data);
        if(node == null) {
            return false;
        } else if(areNodesEqual(node, checkingNode )) {
            return true;
        } else {
            return isNodeExist(node.nextNode, data);
        }
    }

    int nodeIndex(final T data) {
        Node node = new Node<T>(data);
        Node tmp = head;
        int index = 0;

        if(isNodeExist(data)) {
            while (tmp != null) {
                if(!areNodesEqual(tmp, node)) {
                    index++;
                } else {
                    return index;
                }
                tmp = tmp.nextNode;
            }
        } else {
            throw new IllegalMonitorStateException("There isn't such a node in this list.");
        }

        return 0;
    }

    T findNodeByIndex(int index) {
        if(index > size() - 1) {
            throw new IndexOutOfBoundsException("There is no " + index + " index in your list. The last index is " + (size() - 1));
        }

        Node tmp = this.head;
        int listIndex = 0;
        while(tmp != null) {
            if(index == listIndex) {
                return (T)(tmp.val);
            }
            tmp = tmp.nextNode;
            listIndex++;
        }
        return null;
    }

    Node findLastNode() {
        Node tmp = this.head;
        while(tmp != null) {
            if(tmp.nextNode == null) {
                return tmp;
            }

            tmp = tmp.nextNode;
        }

        return null;
    }

    void push(final T data) {
        Node newNode = new Node<T>(data);

        Node tmp = head;

        if(head == null) {
            head = newNode;
        } else if(head.nextNode == null) {
            head.nextNode = newNode;
        } else {
            while(true) {
                if(tmp.nextNode == null) {
                    tmp.nextNode = newNode;
                    break;
                } else {
                    tmp = tmp.nextNode;
                }
            }
        }

        newNode.nextNode = null;
    }

    void shift(final T data) {
        Node newNode = new Node<T>(data);
        newNode.nextNode = head;
        head = newNode;
    }

    void pop() {
        if(head == null) {
            throw new IndexOutOfBoundsException("There is no node in list for pop it out.");
        } else if(head.nextNode == null) {
            head = null;
        } else {
            Node tmp = head;
            while (true) {
                if (tmp.nextNode.nextNode == null) {
                    tmp.nextNode = null;
                    break;
                } else {
                    tmp = tmp.nextNode;
                }
            }
        }
    }

    void unshift() {
        if(head != null) {
            head = head.nextNode;
        } else {
            throw new IndexOutOfBoundsException("There is no node in list for unshift it.");
        }
    }

    SinglyLinkedList concat(SinglyLinkedList list2) {
        findLastNode().nextNode = list2.head;
        SinglyLinkedList res = new SinglyLinkedList(head);
        return res;
    }

    ArrayList<T> toArray() {
        int size = size();
        ArrayList<T> array = new ArrayList<T>(size);

        for(int i = 0; i < size; ++ i) {
            array.add(i, findNodeByIndex(i));
        }

        return array;
    }

    public String toString() {
        String res ="";
        Node tmp = this.head;
        while(tmp != null) {
            res += " " + tmp.val;
            tmp = tmp.nextNode;
        }

        return res;
    }
}

class LinkedList {
    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();

        llist.push("a");
        llist.push("b");
        llist.push("C");
        llist.shift("D");
        llist.shift("e");
        llist.push("f");
        llist.push('g');
        llist.push("KUKU");
        llist.print();
        llist.pop();
        llist.print();
        llist.unshift();

        System.out.println(llist.toString());

        llist.print();
//
//        System.out.println(llist.size());
//        DataStructures.SinglyLinkedList llist1 = new DataStructures.SinglyLinkedList();
//
//        llist1.push(7);
//        llist1.push(8);
//        llist1.push(9);
//        llist1.shift(0);
//        llist1.shift(1);
//
//
//        llist.concat(llist1).print();
//        System.out.println(llist.size());
//
//
//        System.out.println(llist.toArray());
    }
}
