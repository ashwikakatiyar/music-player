/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedListVariations;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Aarushi Kahlon
 * @param <T>
 */
public class CircularLinkedList<T> extends LinkedList implements Collection<T>
{
    private CircularNode head;
    private CircularNode tail;
    
    public CircularLinkedList ()
    {
        head = null;
        tail = null;
    }
    
    public CircularLinkedList (T value)
    {
        head = (CircularNode<T>) value;
        tail = head;
    }
    
    @Override
    public int size() 
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int count = 0;
        CircularNode currentNode = head;
        if (head == null)
        {
            return 0;
        }
        do 
        {
            count++;
            currentNode = currentNode.getNextNode();
        }
        while (currentNode != head);
        return count;
    }

    @Override
    public boolean isEmpty() 
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return (head == null);
    }

    @Override
    public boolean contains(Object o) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        boolean check = false;
        CircularNode currentNode = head;
        if (head == null)
        {
            check = false;
        }
        do {
            if (currentNode.getValue().equals(o))
            {
                check = true;
            }
             currentNode = currentNode.getNextNode();
        }
        while (currentNode != head);
        return check;
    }

    @Override
    public Iterator<T> iterator() 
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return new CircularNodeIterator<>(head);
    }

    @Override
    public Object[] toArray() 
    {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        T[] temp = (T[]) Array.newInstance(head.getValue().getClass(), this.size());
        CircularNode curr = head;
        for (int i = 0; i < temp.length; i++)
        {
            temp[i] = (T) curr.getValue();
            curr = curr.getNextNode();
        }
        return temp;
    }

    @Override
    public <T> T[] toArray(T[] a) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        T[] newArr;
        if (a.length < size())
        {
            newArr = (T[]) Arrays.copyOf(a, size(), a.getClass());
            CircularNode front = head;
            int currIndex = 0;
            while (currIndex < size())
            {
                newArr[currIndex] = (T) front.getValue();
                currIndex++;
                front = front.getNextNode();
            }
            return newArr;
        }
        else
        {
            CircularNode temp = head;
            for (int i = 0; i < size(); i++)
            {
                a[i] = (T) temp.getValue();
                temp = temp.getNextNode();
                a[size()] = null;
            }
            
            return a;
        }
    }

    @Override
    public boolean add(T e) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        CircularNode newNode = new CircularNode(e);
        if (head != null)
        {
            tail.setNextNode(newNode);
        }
        else
        {
            head = newNode;
        }
        tail = newNode;
        tail.setNextNode(head);
        return (head == newNode || tail == newNode);
    }

    @Override
    public boolean remove(Object o) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        CircularNode current = head;
        boolean check = false;
        do 
        {
            CircularNode next = current.getNextNode();
            if (next.getValue().equals(o))
            {
                if (tail == head)
                {
                    tail = head = null;
                }
                else
                {
                    current.setNextNode(current.getNextNode().getNextNode());
                    if (head == next)
                    {
                        head = head.getNextNode();
                    }
                    if (tail == next)
                    {
                        tail = current;
                    }
                }
                check = true;
            }
            current = current.getNextNode();
        }
        while (current != head);
        return check;
    }

    @Override
    public boolean containsAll(Collection<?> c) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        boolean check = false;
        CircularNode current = head;        
        do 
        {
            for (Object obj: c)
            {
                check = contains(obj);
                if (current != null && current.getNextNode() != null)
                {
                    return check;
                }
                current = current.getNextNode();
            }
        }
        while (current != head);
        return check;
    }
        
    

    @Override
    public boolean addAll(Collection<? extends T> c) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        boolean flag = false;
        int count = 0;
        for (T element: c)
        {
            flag = add(element);                
            if (count == c.size()-1)
            {
                return flag;
            }
            count++;
        }
        return flag;
    }

    @Override
    public boolean removeAll(Collection<?> c) 
    {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        boolean change = false;
        int count = 0;
        for (Object obj: c)
        {
            if (contains(obj))
            {
                remove(obj);
                change = true;
            }
            if (count == c.size()-1)
            {
                return change;
            }
            count++;
        }
        return change;
    }

    @Override
    public boolean retainAll(Collection<?> c) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        boolean check = false;
        CircularNode current = head;
        Iterator itr = c.iterator();
        int count = size();
        if (!containsAll(c))
        {
            return false;
        }
        do
        {
            if (!current.getValue().equals(itr.next()))
            {
                remove(current.getValue());
                check =true;
                current = current.getNextNode();
            }
            else
            {
                current = current.getNextNode();
            }
            count--;
        }
        while (count > 0);
        return check;
    }

    @Override
    public void clear() 
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        head = tail = null;
    }
    @Override
    public String toString() 
    {
        String newStr = "";
        CircularNode curr = head;
        int count = 0;
        if (head != null)
        {
            do {
                newStr += curr.getValue();
                if (count < size()-1)
                {
                    newStr += ", ";
                }
                curr = curr.getNextNode();
                count++;
            }
            while (curr != head && curr != null);
        }
        return newStr;
    }
}