/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedListVariations;

/**
 *
 * @author Aarushi Kahlon
 * @param <T>
 */
public class CircularNode<T>
{
    private T value;
    private CircularNode next;
    
    public CircularNode (T obj)
    {
        value = obj;
        next = null;
    }
    
    public CircularNode (T obj1, CircularNode obj2)
    {
        value = obj1;
        next = obj2;
    }
    
    public T getValue ()
    {
        return value;
    }
    
    public CircularNode getNextNode ()
    {
        return next;
    }
    
    public void setNextNode(CircularNode cow)
    {
        next = cow;
    }
    
    public void setValue(T grass)
    {
        value = grass;
    }
}
