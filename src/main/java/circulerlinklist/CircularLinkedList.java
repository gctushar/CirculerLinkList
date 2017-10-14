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

    }

    public void clear() {

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

        }

        theSize++;
        return;

    }

    public AnyType remove(int index) {

    }

    public void rotate() {

    }

    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    private Node<AnyType> getNode(int index) {
        return (getNode(index, 0, size() - 1));
    }

    private Node<AnyType> getNode(int index, int lower, int upper) {

    }

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
}
