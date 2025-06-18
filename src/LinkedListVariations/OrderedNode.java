/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedListVariations;

/**
 *
 * @author Angela Chang
 */
public class OrderedNode<T>
{
    private T value;
    private OrderedNode nextNode;
    
    public OrderedNode(T v)
    {
        value = v;
        nextNode = null;
    }
    
    public OrderedNode(T v, OrderedNode n)
    {
        value = v;
        nextNode = n;
    }
    
    public T getValue()
    {
        return value;
    }
    
    public OrderedNode<T> getNext()
    {
        return nextNode;
    }
    
    public void setValue(T v)
    {
        value = v;
    }
    
    public void setNext(OrderedNode<T> n)
    {
        nextNode = n;
    }
}