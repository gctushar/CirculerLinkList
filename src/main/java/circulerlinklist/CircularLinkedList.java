package circulerlinklist;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class CircularLinkedList<AnyType> implements List<AnyType> {

    private static class Node<AnyType> {

        private AnyType data;
        private Node<AnyType> next;

        public Node(AnyType d, Node<AnyType> n) {
            setData(d);
            setNext(n);
        }

        public AnyType getData() {
            return data;
        }

        public void setData(AnyType d) {
            data = d;
        }

        public Node<AnyType> getNext() {
            return next;
        }

        public void setNext(Node<AnyType> n) {
            next = n;
        }
    }

    private int theSize;
    private int modCount;
    private Node<AnyType> tail;

    public CircularLinkedList() {
        theSize = 0;
        modCount = 0;
        tail = null;

    }

    public void clear() {
        theSize = 0;
        modCount = 0;
        tail = null;
        return;
    }

    public int size() {

        return this.theSize;

    }

    public boolean isEmpty() {

        return theSize == 0;
    }

    public AnyType get(int index) {

        Node nowNode = tail;
        for (int now = 0; now < index; now++) {
            nowNode = nowNode.next;
        }
        return (AnyType) nowNode.data;
    }

    public AnyType set(int index, AnyType newValue) {

        Node nowNode = tail;
        for (int now = 0; now < index; now++) {
            nowNode = nowNode.next;
        }
        nowNode.setData(newValue);
        return (AnyType) nowNode.data;

    }

    public boolean add(AnyType newValue) {
        add(size(), newValue);
        return true;
    }

    public void add(int index, AnyType newValue) {

        int now = 0;

        if (index == 0) {
            tail = new Node(newValue, null);
            tail.next = tail;

        } else {
            Node nowNode = tail;

            for (now = 1; now < index; now++) {
                nowNode = nowNode.next;
            }

            Node temp = new Node(newValue, nowNode.next);
            nowNode.next = temp;

            if (index > theSize) {
                tail = temp;
            }
        }

        theSize++;
        return;

    }

    public AnyType remove(int index) {

        Node nowNode = tail;
        if (theSize == 0 || tail == null) {
            return null;
        }
        if (theSize == 1) {
            AnyType data = tail.data;
            theSize = 0;
            modCount = 0;
            tail = null;
            return data;
        }

        for (int now = 1; now < index; now++) {
            nowNode = nowNode.next;
        }

        Node temp = nowNode.next;
        nowNode.next = null;
        nowNode.next = temp.next;
        if (index == theSize) {
            tail = nowNode;
        }
        theSize--;

        return (AnyType) temp.getData();

    }

    public void rotate() {
        tail = tail.next;
    }

    public Iterator<AnyType> iterator() {
//        return new LinkedListIterator();
        return null;
    }

    private Node<AnyType> getNode(int index) {
        return (getNode(index, 0, size() - 1));
    }

    private Node<AnyType> getNode(int index, int lower, int upper) {

        Node nowNode = tail;
        for (int now = 0; now < index; now++) {
            nowNode = nowNode.next;
        }

        return nowNode;

    }
    /*
    private class LinkedListIterator implements Iterator<AnyType> {

        private Node<AnyType> previous;
        private Node<AnyType> current;
        private int expectedModCount;
        private boolean okToRemove;

        LinkedListIterator() {

        }

        public boolean hasNext() {

        }

        public AnyType next() {

        }

        public void remove() {

        }
    }
     */
}
