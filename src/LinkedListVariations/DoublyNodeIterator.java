/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedListVariations;

import java.util.Iterator;

/**
 * DoublyModeIterator --- class that represents DoublyNodeIterator objects
 * 
 * @author Ashwika Katiyar
 * @param <T>
 */
public class DoublyNodeIterator<T> implements Iterator<T> {

    private DoublySingleNode<T> prevNode;
    private DoublySingleNode<T> nextNode;

    /**
     * Initializes prevNode to prev and nextNode to next
     * @param prev The DoublySingleNode that is the value of prevNode
     * @param next The DoublySingleNode that is the value of nextNode
     */
    public DoublyNodeIterator(DoublySingleNode<T> prev, DoublySingleNode<T> next) {
        prevNode = prev;
        nextNode = next;
    }
    
    /**
     * Returns true if prevNode is not null and false otherwise
     * @return A Boolean that is true if prevNode is not null
     */
    public boolean hasPrev() {
        return prevNode != null;
    }
    
    /**
     * Returns the value of prevNode, sets prevNode to the previous node in 
     * the LinkedList, and sets nextNode to the current prevNode
     * @return A T obj that contains the current value of prevNode
     */
    public T prev(){
        DoublySingleNode temp = prevNode;
        nextNode = temp;
        prevNode = prevNode.getPrev();
        return (T) temp.getValue();
    }

    /**
     * Returns true if nextNode is not null and false otherwise
     * @return A Boolean that is true if nextNode is not null
     */
    @Override
    public boolean hasNext() {
        return nextNode != null;
    }

    /**
     * Returns the value of nextNode, sets nextNode to the next node in the
     * LinkedList, and sets prevNode to the current nextNode
     * @return A T obj that contains the current value of nextNode
     */
    @Override
    public T next() {
        DoublySingleNode temp = nextNode;
        prevNode = temp;
        nextNode = nextNode.getNext();
        return (T) temp.getValue();
    }

}
