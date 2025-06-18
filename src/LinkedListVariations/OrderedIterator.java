/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedListVariations;

import java.util.Iterator;

/**
 *
 * @author Angela Chang
 */
public class OrderedIterator<T> implements Iterator<T>
{
    private OrderedNode<T> node;
    
    public OrderedIterator(OrderedNode<T> n)
    {
        node = n;
    }
    
    @Override
    public boolean hasNext()
    {
        return node != null;
    }

    @Override
    public T next()
    {
        if(!hasNext())
        {
            return null;
        }
        T v = node.getValue();
        node = node.getNext();
        return v;
    }
}

