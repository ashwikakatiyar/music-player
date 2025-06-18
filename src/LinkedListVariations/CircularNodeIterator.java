/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedListVariations;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Aarushi Kahlon
 * @param <T>
 */
public class CircularNodeIterator<T> implements Iterator<T> {
private CircularNode<T> type;

    public CircularNodeIterator(CircularNode<T> value) 
    {
        type = value;
    }
    
    @Override
    public boolean hasNext() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return (type != null);
    }

    @Override
    public T next() 
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (!hasNext())
        {
            throw new NoSuchElementException();
        }
        else
        {
            T temp = type.getValue();
            type = type.getNextNode();
            return temp;
        }
    }    
}
