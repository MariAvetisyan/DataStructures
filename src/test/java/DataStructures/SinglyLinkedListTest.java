package DataStructures;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by mari.avetisyan on 23/09/2020.
 */

public class SinglyLinkedListTest {
    SinglyLinkedList llist = new SinglyLinkedList();

    @Test
    public void isEmpty() {
        assertEquals(llist.isEmpty(), true);
        llist.push(1);

        assertEquals(llist.isEmpty(), false);
        llist.clear();

        llist.shift(1);
        llist.unshift();
        assertEquals(llist.isEmpty(), true);

        llist.shift(1);
        llist.shift("aa");
        llist.unshift();
        llist.push(5);
        llist.pop();
        llist.push(5);
        assertEquals(llist.isEmpty(), false);

        llist.clear();
    }

    @Test
    public void size() {
        llist.shift(1);
        llist.shift("aa");
        llist.unshift();
        llist.push(5);
        llist.pop();
        llist.push(5);
        llist.push("P");
        llist.push("ty");
        assertEquals(llist.size(), 4);

        llist.clear();
        assertEquals(llist.size(), 0);

        llist.shift("aa");
        llist.unshift();
        llist.push(5);
        llist.pop();
        assertEquals(llist.size(), 0);

        llist.clear();
    }

    @Test
    public void areNodesEqual() {
        Node node1 = new Node(7);
        Node node2 = new Node("7");

        assertEquals(SinglyLinkedList.areNodesEqual(node1, node2), false);

        Node node3 = new Node('7');
        Node node4 = new Node("7");

        assertEquals(SinglyLinkedList.areNodesEqual(node3, node4), false);

        Node node5 = new Node("kuku");
        Node node6 = new Node("Kuku");

        assertEquals(SinglyLinkedList.areNodesEqual(node5, node6), false);

        Node node7 = new Node("abr");
        Node node8 = new Node("abr");

        assertEquals(SinglyLinkedList.areNodesEqual(node7, node8), true);

        llist.clear();
    }

    @Test
    public void isNodeExist() {
        llist.push(5);
        llist.push(-8);
        llist.push(0);
        llist.push(36);

        assertEquals(llist.isNodeExist(0), true);
        assertEquals(llist.isNodeExist("36"), false);
        assertEquals(llist.isNodeExist('5'), false);

        llist.clear();
    }

    @Test
    public void nodeIndex() {
        llist.push(5);
        llist.push(-8);
        llist.push(0);
        llist.push(36);

        assertEquals(llist.nodeIndex(0), 2);
        assertThrows(IllegalMonitorStateException.class, () -> {
           llist.nodeIndex(6);
        });
        assertThrows(IllegalMonitorStateException.class, () -> {
            llist.nodeIndex('0');
        });

        llist.clear();
    }

    @Test
    public void findNodeByIndex() {
        llist.push(5);
        llist.push(-8);
        llist.push(0);
        llist.push(36);

        assertEquals(llist.findNodeByIndex(1), -8);
        assertEquals(llist.findNodeByIndex(3), 36);
        assertThrows(IndexOutOfBoundsException.class, () -> {
           llist.findNodeByIndex(4);
        });

        llist.clear();
    }

    @Test
    public void findLastNode() {
        llist.push(5);
        llist.push(-8);
        llist.push(0);
        llist.push(36);

        Node node1 = new Node(36);
        Node node2 = llist.findLastNode();
        Node node3 = new Node(0);

        assertEquals(SinglyLinkedList.areNodesEqual(node2, node1), true);
        assertEquals(SinglyLinkedList.areNodesEqual(node2, node3), false);

        llist.clear();
    }

    @Test
    public void push() {
        llist.push(0);
        assertEquals(llist.toString(), " 0");

        llist.push("a");
        llist.push("b");
        llist.push("C");
        llist.push("f");
        llist.push('g');
        llist.push("KUKU");
        assertEquals(llist.toString(), " 0 a b C f g KUKU");

        llist.clear();
    }

    @Test
    public void shift() {
        llist.push("a");
        llist.push("b");
        llist.shift(2);
        llist.shift("k");
        llist.shift(8);

        assertEquals(llist.toString(), " 8 k 2 a b");
        llist.clear();
    }

    @Test
    public void pop() {
        llist.push("a");
        llist.push("b");
        llist.push("C");
        llist.push("f");
        llist.push('g');
        llist.push("KUKU");
        llist.pop();
        assertEquals(llist.toString(), " a b C f g");

        llist.pop();
        llist.pop();
        llist.pop();
        assertEquals(llist.toString(), " a b");

        llist.pop();
        llist.pop();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            llist.pop();
        });

    }

    @Test
    public void unshift() {
        llist.push("a");
        llist.push("b");
        llist.push("C");

        llist.unshift();

        assertEquals(llist.toString(), " b C");
        assertNotEquals(llist.toString(), " b c");

        llist.unshift();
        llist.unshift();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            llist.unshift();
        });

        llist.clear();
    }

    @Test
    public void concat() {
        llist.push("a");
        llist.push("b");
        llist.push("C");

        SinglyLinkedList llist2 = new SinglyLinkedList();

        llist2.push(1);
        llist2.push(2);
        llist2.push(3);

        llist.concat(llist2);

        assertEquals(llist.toString(), " a b C 1 2 3");
    }
}
