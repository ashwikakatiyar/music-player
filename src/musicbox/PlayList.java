/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicbox;

import LinkedListVariations.CircularLinkedList;
import LinkedListVariations.CircularNode;
import LinkedListVariations.CircularNodeIterator;
import LinkedListVariations.DoublyLinkedList;
import LinkedListVariations.DoublySingleNode;
import LinkedListVariations.DoublyNodeIterator;
import LinkedListVariations.OrderedLinkedList;
import LinkedListVariations.OrderedNode;
import LinkedListVariations.OrderedIterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * PlayList --- class that represents PlayList objects
 *
 * @author Ashwika Katiyar, Aarushi Kahlon, Angela Chang
 */
public class PlayList implements Comparable {

    private DoublyLinkedList<String> playlist;
    private String name;
    private DoublyNodeIterator listIterator;

    /**
     * Reads the given file and adds it to the DoublyLinkedList playlist
     *
     * @author Aarushi Kahlon
     * @param fileName a String containing the name of the file containing the
     * songs to be added to the PlayList
     * @throws FileNotFoundException
     */
    public PlayList(String fileName) throws FileNotFoundException {
        playlist = new DoublyLinkedList();
        Scanner read = new Scanner(new File(fileName));
        while (read.hasNextLine()) {
            playlist.add(read.nextLine());
        }
        listIterator = (DoublyNodeIterator) playlist.iterator();
    }

    /**
     * Initializes playlist and listIterator PIVs
     */
    public PlayList() {
        playlist = new DoublyLinkedList();
        listIterator = (DoublyNodeIterator) playlist.iterator();
    }

    /**
     * Returns the PlayList as an array
     *
     * @return Object[]
     * @author Angela Chang
     */
    public Object[] toArray() {
        return playlist.toArray();
    }

    /**
     * Adds a song to the PlayList
     *
     * @author Ashwika Katiyar
     * @param song the Song object to be added
     * @return A Boolean that is true if the song was added to the PlayList
     */
    public boolean addSong(Object song) {
        boolean wasAdded = playlist.add(song.toString());
        listIterator = (DoublyNodeIterator) playlist.iterator();
        return wasAdded;
    }

    /**
     * Removes a song from the PlayList
     *
     * @author Aarushi Kahlon
     * @param object A String the containing the name of the song to be removed
     * @return A Boolean that is true if the song was removed from the PlayList
     */
    public boolean removeSong(String object) {
        boolean wasRemoved = playlist.remove(object);
        listIterator = (DoublyNodeIterator) playlist.iterator();
        return wasRemoved;
    }

    /**
     * Randomly shuffles the PlayList
     *
     * @author Aarushi Kahlon
     */
    public void shufflePlaylist() {
        Object[] toArray = playlist.toArray();
        Random rand = new Random();
        for (int i = 0; i < toArray.length; i++) {
            int index = rand.nextInt(i + 1);
            Object tempObject = toArray[index];
            toArray[index] = toArray[i];
            toArray[i] = tempObject;
        }
        playlist.clear();
        for (int b = 0; b < toArray.length; b++) {
            playlist.add((String) toArray[b]);
        }
    }

    /**
     * Returns the PlayList as a String
     *
     * @return A String containing the PlayList
     * @author Angela Chang
     */
    @Override
    public String toString() {
        return playlist.toString();
    }

    /**
     * Sorts the PlayList in alphabetical order
     *
     * @author Ashwika Katiyar
     */
    public void alphabeticalOrder() {
        OrderedLinkedList<String> order = new OrderedLinkedList<>();
        DoublyNodeIterator iterOrder = (DoublyNodeIterator) playlist.iterator();
        int i = 0;
        while (i < playlist.size() && iterOrder.hasNext()) {
            order.add((String) iterOrder.next());
        }
        DoublyLinkedList<String> temp = new DoublyLinkedList<>();
        OrderedIterator iterTemp = (OrderedIterator) order.iterator();
        while (i < playlist.size() && iterTemp.hasNext()) {
            temp.add((String) iterTemp.next());
        }
        playlist = temp;
    }

    /**
     * Keeps in the PlayList in the order the songs were added
     *
     * @author Ashwika Katiyar
     */
    public void selectedOrder() {
        DoublyLinkedList temp = new DoublyLinkedList();
        DoublyNodeIterator iter = (DoublyNodeIterator) playlist.iterator();
        int i = 0;
        while (i < playlist.size() && iter.hasNext()) {
            temp.add(iter.next());
        }
        playlist = temp;
    }

    /**
     * Moves to the next song in the PlayList
     *
     * @return A String containing the next song
     * @author Angela Chang
     */
    public String forward() {
        return (String) listIterator.next();
    }

    /**
     * moves to the previous song in the PlayList
     *
     * @return A String containing the previous song
     * @author Angela Chang
     */
    public String backward() {
        return (String) listIterator.prev();
    }

    /**
     * Compares this PlayList with the object o Returns 0 if they are the same
     * Returns -1 if this PlayList is longer than o Returns 1 if this PlayList
     * is shorter than o
     *
     * @param o The object to be compared with
     * @return a negative Integer, zero, or a positive Integer as this PlayList
     * is less than, equal to, or greater than the given object o
     * @author Ashwika Katiyar
     */
    @Override
    public int compareTo(Object o) {
        String pl = playlist.toString();
        String obj = o.toString();
        if (pl.equals(obj)) {
            return 0;
        } else if (pl.length() > obj.length()) {
            return -1;
        }
        return 1;
    }

    /**
     * Sets the name of the PlayList
     *
     * @param n A String containing the name of the PlayList
     * @author Angela Chang
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Returns the name of the PlayList
     *
     * @return A String containing the name of the PlayList
     * @author Angela Chang
     */
    public String getName() {
        return name;
    }

    /**
     * Checks if the PlayList has a next song
     *
     * @return A Boolean that returns true if the PlayList has a next song and
     * false if it does not
     * @author Angela Chang
     */
    public boolean hasNextSong() {
        return listIterator.hasNext();
    }
}
