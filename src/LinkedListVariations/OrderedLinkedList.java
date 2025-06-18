/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedListVariations;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Arrays;

/**
 *
 * @author Angela Chang
 */
public class OrderedLinkedList<T> extends LinkedList implements Collection<T>
{
    OrderedNode<T> head;
    OrderedNode<T> tail;
    
    public boolean isForward;
    /**
     * Constructs an empty linked list.
     * The list is initially empty with both the head and tail set to {@code null}.
     */
    public OrderedLinkedList()
    {
        head = null;
        tail = null;
        isForward = true;
        sortFoward();
    }
    
    /**
     * Constructs a linked list with an initial element.
     * @param iv the initial value to be stored in the list
     */
    public OrderedLinkedList(T iv)
    {
        head = new OrderedNode<T>(iv);
        tail = head;
        isForward = true;
        sortFoward();
    }
    
    /**
     * @return the number of elements in the list
     */
    @Override
    public int size()
    {
        int count = 0;
        OrderedNode current = head;
        while (current != null)
        {
            count++;
            current = current.getNext();
        }
        return count;
    }
    
    /**
     * @return {@code true} if the list is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Checks whether the specified object is present in the linked list.
     * The object must implement the {@link Comparable} interface for comparison.
     * 
     * @param o the object to search for
     * @return {@code true} if the object is present in the list, {@code false} otherwise
     */
    @Override
    public boolean contains(Object o)
    {
        if (!(o instanceof Comparable))
        {
            return false;
        }
        OrderedNode<T> current = head;
        while (current != null)
        {
            if(((Comparable<T>) current.getValue()).compareTo((T)o) == 0)
            {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    /**
     * @return an iterator for the list
     */
    @Override
    public Iterator<T> iterator()
    {
        return new OrderedIterator<T>(head);
    }
    
    /**
     * @return an array containing all of the elements in the list
     */
    @Override
    public Object[] toArray()
    {
        T[] temp = (T[])Array.newInstance(head.getValue().getClass(), this.size());
        OrderedNode current = head;
        for(int i = 0; current != null; i++)
        {
            temp[i] = (T)current.getValue();
            current = current.getNext();
        }
        return temp;
    }
    
    /**
     * Returns an array containing all of the elements in this linked list, 
     * and stores them in the specified array.
     * If the specified array is large enough to contain the elements, 
     * it is used; otherwise, a new array is created.
     * 
     * @param a the array into which the elements of the list are to be stored
     * @param <T> the type of the array elements
     * @return an array containing the elements of the list
     */
    @Override
    public <T> T[] toArray(T[] a)
    {
        if(a.length < size())
        {
            return (T[])toArray();
        }
        else
        {
            OrderedNode current = head;
            for(int i = 0; current != null; i++)
            {
                a[i] = (T)current.getValue();
                current = current.getNext();
            }
            return a;
        }
    }
    
    /**
     * Adds the specified element to the end of the linked list.
     * 
     * @param e the element to be added to the list
     * @return {@code true} if the element was added successfully
     */
    @Override
    public boolean add(T e)
    {
        OrderedNode newNode = new OrderedNode(e);
        if (head == null)
        {
            head = newNode;
            tail = newNode;
        } 
        else
        {
            tail.setNext(newNode);
            tail = newNode;
        }
        if(isForward)
        {
            sortFoward();
        }
        else
        {
            sortBackward();
        }
        return true;
    }
    
    /**
     * Removes the first occurrence of the specified object from the linked list.
     * The object must implement the {@link Comparable} interface for comparison.
     * 
     * @param o the object to be removed
     * @return {@code true} if the object was removed, {@code false} otherwise
     */
    @Override
    public boolean remove(Object o)
    {
        if (head == null) return false;
        
        OrderedNode<T> current = head;
        OrderedNode<T> previous = null;
        
        while (current != null) {
            if(((Comparable) current.getValue()).compareTo((T)o) == 0)
            {
                if (previous == null)
                {
                    head = current.getNext();
                }
                else
                {
                    previous.setNext(current.getNext());
                }
                if (current.getNext() == null)
                {
                    tail = previous;
                }
                return true;
            }
            previous = current;
            current = current.getNext();
        }
        return false;
    }
    
    /**
     * Checks if the linked list contains all elements from the specified collection.
     * 
     * @param c the collection whose elements are to be checked for presence
     * @return {@code true} if the list contains all elements from the collection, {@code false} otherwise
     */
    @Override
    public boolean containsAll(Collection<?> c)
    {
        for(Object item : c)
        {
            if(!contains(item))
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Adds all elements from the specified collection to the linked list.
     * 
     * @param c the collection whose elements are to be added
     * @return {@code true} if the list was modified as a result of the operation
     */
    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        for(T item : c)
        {
            add(item);
        }
        return true;
    }
    
    /**
     * Removes all elements from the linked list that are also present in the specified collection.
     * 
     * @param c the collection containing elements to be removed
     * @return {@code true} if the list was modified as a result of the operation
     */
    @Override
    public boolean removeAll(Collection<?> c)
    {
        boolean result = false;
        for (Object item : c) {
            while (contains(item))
            {
                result |= remove(item);
            }
        }
        return result;
    }

    /**
     * Retains only the elements in the linked list that are also contained in the specified collection.
     * 
     * @param c the collection containing elements to be retained
     * @return {@code true} if the list was modified as a result of the operation
     */
    @Override
    public boolean retainAll(Collection<?> c)
    {
        OrderedNode<T> current = head;
        OrderedNode<T> previous = null;
        
        while (current != null)
        {
            if (!c.contains(current.getValue()))
            {
                if (previous == null)
                {
                    head = current.getNext();
                }
                else
                {
                    previous.setNext(current.getNext());
                }

                if (current.getNext() == null)
                {
                    tail = previous;
                }
                current = current.getNext();
            } 
            else 
            {
                previous = current;
                current = current.getNext();
            }
        }
        return true;
    }
    
    /**
     * Removes all elements from the linked list.
     */
    @Override
    public void clear()
    {
        head = null;
        tail = null;
    }
    
    /**
     * Sorts the elements in the linked list in ascending order using a simple selection sort.
     * The elements must implement {@link Comparable} for sorting.
     */
    private void sortFoward()
    {
        if (head == null || head.getNext() == null){return;}
        
        OrderedNode current = head;
        while (current != null)
        {
            OrderedNode min = current;
            OrderedNode loop = current.getNext();

            while (loop != null) 
            {
                if (((Comparable<T>) loop.getValue()).compareTo((T)min.getValue()) < 0) 
                {
                    min = loop;
                }
                loop = loop.getNext();
            }

            if (min != current)
            {
                T temp = (T)current.getValue();
                current.setValue(min.getValue());
                min.setValue(temp);
            }
            current = current.getNext();
        }
    }
    
    /**
     * Sorts the elements in the linked list in descending order using a simple selection sort.
     * The elements must implement {@link Comparable} for sorting.
     */
    private void sortBackward()
    {
        if (head == null || head.getNext() == null){return;}
        
        OrderedNode current = head;
        while (current != null)
        {
            OrderedNode min = current;
            OrderedNode loop = current.getNext();

            while (loop != null) 
            {
                if (((Comparable<T>) loop.getValue()).compareTo((T)min.getValue()) > 0) 
                {
                    min = loop;
                }
                loop = loop.getNext();
            }

            if (min != current)
            {
                T temp = (T)current.getValue();
                current.setValue(min.getValue());
                min.setValue(temp);
            }
            current = current.getNext();
        }
    }
    
    
    /**
     * Returns a string representation of the linked list.
     * 
     * @return a string representation of the linked list
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[");
        OrderedNode current = head;
        
        while (current != null)
        {
            sb.append(current.getValue());
            if (current.getNext() != null)
            {
                sb.append(", ");
            }
            current = current.getNext();
        }
        
        sb.append("]");
        return sb.toString();
    }
}
