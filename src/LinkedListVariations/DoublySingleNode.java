/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedListVariations;

/**
 * DoublySingleNode --- class that represents DoublySingleNode objects
 * 
 * @author Ashwika Katiyar
 * @param <T>
 */
public class DoublySingleNode<T> {

    T value;
    DoublySingleNode prevNode;
    DoublySingleNode nextNode;

    /**
     * Initializes value to T object and sets prevNode and nextNode to null
     * @param obj A T object that contains the given value of the node
     */
    public DoublySingleNode(T obj) {
        value = obj;
        prevNode = null;
        nextNode = null;
    }

    /**
     * Initializes value to T object and nextNode to DoublySingleNode object 
     * and sets prevNode to null
     * @param obj A T object that contains the given value of the current node
     * @param next A DoublySingleNode object that contains the next node
     */
    public DoublySingleNode(T obj, DoublySingleNode next) {
        value = obj;
        prevNode = null;
        nextNode = next;
    }

    /**
     * Initializes value to T object and prevNode to DoublySingleNode object 
     * and sets nextNode to null
     * @param prev A DoublySingleNode object that contains the previous node
     * @param obj A T object that contains the given value of the current node
     */
    public DoublySingleNode(DoublySingleNode prev, T obj) {
        value = obj;
        prevNode = prev;
        nextNode = null;
    }

    /**
     * Initializes value to T object and prevNode and nextNode to 
     * DoublySingleNode objects
     * @param prev DoublySingleNode object that contains the previous node
     * @param obj A T object that contains the given value of the current node
     * @param next A DoublySingleNode object that contains the next node
     */
    public DoublySingleNode(DoublySingleNode prev, T obj, DoublySingleNode next) {
        value = obj;
        prevNode = prev;
        nextNode = next;
    }

    /**
     * Returns prevNode
     * @return A DoublySingleNode object that contains the previous node
     */
    public DoublySingleNode getPrev() {
        return prevNode;
    }

    /**
     * Sets prevNode to the given DoublySingleNode object
     * @param prev A DoublySingleNode object that contains the previous node
     */
    public void setPrev(DoublySingleNode prev) {
        prevNode = prev;
    }

    /**
     * Returns value
     * @return A T object that contains the value of the current node
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets value to the given T object
     * @param obj A T object that contains the value of the current node
     */
    public void setValue(T obj) {
        value = obj;
    }
    
    /**
     * Returns nextNode
     * @return A DoublySingleNode object that contains the next node
     */
    public DoublySingleNode getNext() {
        return nextNode;
    }

    /**
     * Sets nextNode to the given DoublySingleNode object
     * @param next A DoublySingleNode object that contains the next node
     */
    public void setNext(DoublySingleNode next) {
        nextNode = next;
    }
}
