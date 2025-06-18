/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package LinkedListVariations;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/**
 * DoublyLinkedList --- class that represents DoublyLinkedList objects
 * 
 * @author Ashwika Katiyar
 * @param <T> The data type of the objects in the LinkedList
 */
public class DoublyLinkedList<T extends Comparable> extends LinkedList implements Collection<T> {

    private DoublySingleNode<T> head;
    private DoublySingleNode<T> tail;

    /**
     * Sets head and tail to null
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Returns the number of nodes in the LinkedList
     *
     * @return An int with the number of nodes in the LinkedList
     */
    @Override
    public int size() {
        if (head == null) {
            return 0;
        }
        DoublySingleNode<T> current = head;
        int num = 0;
        while (current != null) {
            num++;
            current = current.getNext();
        }
        return num;
    }

    /**
     * Returns true if the LinkedList has zero nodes in it and false otherwise
     *
     * @return A Boolean that is true if there are zero nodes in the LinkedList
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if Object o is in the LinkedList and false otherwise
     * Precondition: o utilizes the Comparable Interface
     *
     * @param o The Object that the method is checking for in the LinkedList
     * @return A Boolean that is true if o exists in the LinkedList
     */
    @Override
    public boolean contains(Object o) {
        boolean containsO = false;
        DoublySingleNode<T> current = head;
        int i = 1;
        while (i < size() + 1) {
            if (current.getValue().compareTo(o) == 0) {
                containsO = true;
            }
            current = current.getNext();
            i++;
        }
        return containsO;
    }

    /**
     * Creates and returns an object of the NodeIterator class
     *
     * @return A NodeIterator object
     */
    @Override
    public Iterator<T> iterator() {
        DoublyNodeIterator<T> iter = new DoublyNodeIterator<>(null, head);
        return iter;
    }

    /**
     * Returns an array containing all of the elements in the LinkedList
     * 
     * @return An array containing all of the elements in the LinkedList
     */
    @Override
    public Object[] toArray() {
        T[] temp = (T[]) Array.newInstance(head.getValue().getClass(), this.size());
        DoublySingleNode<T> current = head;
        for (int i = 0; i < size(); i++) {
            temp[i] = current.getValue();
            current = current.getNext();
        }
        return temp;
    }

    /**
     * Returns all of the elements in the LinkedList in the given array
     * If the LinkedList is larger than the given array, then returns a new array
     * that is the size of the LinkedList
     * If the LinkedList is smaller than the given array, then fills remaining 
     * values with Null
     * 
     * @param <T> The data type of the objects in the LinkedList
     * @param a the array into which the elements of this LinkedList are to be 
     * stored, if it is big enough; otherwise, a new array of the same data type 
     * is allocated for this purpose
     * @return An array containing all of the elements in the LinkedList
     */
    @Override
    public <T> T[] toArray(T[] a) {
        DoublySingleNode<T> current = (DoublySingleNode<T>) head;
        if (a.length < this.size()) {
            a = (T[]) Array.newInstance(head.getValue().getClass(), this.size());
        }
        for (int i = 0; i < size(); i++) {
            a[i] = current.getValue();
            current = current.getNext();
        }
        return a;
    }

    /**
     * Adds T e to the LinkedList at the end as a SingleNode
     *
     * @param e The element to be added to the LinkedList
     * @return A Boolean that returns true if element was added
     */
    @Override
    public boolean add(T e) { 
        DoublySingleNode<T> node = new DoublySingleNode<>(e);
        boolean wasAdded =  false;
        if (isEmpty()) {
            node.setNext(head);
            if(head != null){
                head.setPrev(node);
            }
            head = node;
            tail = head;
            wasAdded = true;
        } 
        else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
            wasAdded = true;
        }
        return wasAdded;
    }

    /**
     * Removes Object o if it exists in the LinkedList and returns true Returns
     * false otherwise
     *
     * @param o The Object to be removed from the LinkedList
     * @return A Boolean that is true if o is removed from the LinkedList
     */
    @Override
    public boolean remove(Object o) { 
       boolean wasRemoved = false;
       DoublySingleNode<T> current = head;
       DoublySingleNode<T> prev = head;
        while (current != null) {
            if (current.getValue().compareTo(o) == 0) {
                wasRemoved = true;
                if (current == head) {
                    head = current.getNext();
                } 
                else {
                    while (prev.getNext() != current) {
                        prev = prev.getNext();
                    }
                    if(current.getNext() == null){
                        prev.setNext(null);
                    }
                    else{
                        prev.setNext(current.getNext());
                        current.getNext().setPrev(prev);
                    }
                }
            }
            current = current.getNext();
        }
        return wasRemoved;
    }

    /**
     * Returns true if this LinkedList contains all of the elements in the given
     * collection
     * 
     * @param c Collection to be checked against this LinkedList
     * @return A Boolean that true if this LinkedList contains all of the 
     * elements in the given collection 
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        boolean listContainsAll = true;
        Iterator iter = c.iterator();
        while (iter.hasNext()) {
            if (!contains((T) iter.next())) {
                listContainsAll = false;
            }
        }
        return listContainsAll;
    }

    /**
     * Adds all of the elements in the given collection to the end of the 
     * LinkedList
     * 
     * @param c Collection containing all the elements to be added to the 
     * LinkedList
     * @return A Boolean that is true if the LinkedList is changed 
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        Iterator iter = c.iterator();
        while (iter.hasNext()) {
            add((T) iter.next());
        }
        return true;
    }

    /**
     * Removes all if the elements in the LinkedList that are also contained in
     * the given collection
     * 
     * @param c Collection containing elements to be removed from the LinkedList
     * @return A Boolean that is true if the LinkedList is changed
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean wasChanged = false;
        Iterator iter = c.iterator();
        while (iter.hasNext()) {
            if (remove((T) iter.next())) {
                wasChanged = true;
            }
        }
        return wasChanged;
    }

    /**
     * Retains only the elements in this LinkedList that are contained in the 
     * given collection
     * Removes from this LinkedList all elements that are not contained in the 
     * given collection
     * 
     * @param c Collection containing elements to be retained in this LinkedList
     * @return A Boolean that is true if the LinkedList is changed
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean wasChanged = false;
        for (T temp : this) {
            if (!c.contains(temp)) {
                remove(temp);
                wasChanged = true;
            }
        }
        return wasChanged;
    }

    /**
     * Empties out the LinkedList
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    /**
     * Returns a String version of the LinkedList
     *
     * @return A string containing the LinkedList
     */
    @Override
    public String toString() {
       DoublySingleNode<T> current = head;
        String str = "[";
        for (int i = 1; i < size(); i++) {
            str += current.getValue() + ", ";
            current = current.getNext();
        }
        str += current.getValue() + "]";
        return str;
    }

}
