/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicbox;

import LinkedListVariations.DoublyLinkedList;
import LinkedListVariations.DoublyNodeIterator;
import LinkedListVariations.DoublySingleNode;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * PlayListManager --- class that represents PlayListManager objects to manage a
 * DoublyLinkedList of PlayList objects
 *
 * @author Ashwika Katiyar
 */
public class PlayListManager {

    private DoublyLinkedList<PlayList> allPlaylist;

    /**
     * Initializes allPlayList as an empty DoublyLinkedList
     */
    public PlayListManager() {
        allPlaylist = new DoublyLinkedList();
    }

    /**
     * Adds a new PlayList to the existing list of playlists
     *
     * @param newPlay the PlayList object to be added
     * @throws FileNotFoundException
     */
    public void addPlayList(PlayList newPlay) throws FileNotFoundException {
        allPlaylist.add(newPlay);
    }

    /**
     * Returns all PlayList names in the PlayListManager as an array
     *
     * @return A String array containing all the PlayList names
     */
    public String[] allPlaylistArray() {
        String[] names = new String[allPlaylist.size()];
        DoublyNodeIterator iter = (DoublyNodeIterator) allPlaylist.iterator();
        for (int i = 0; i < allPlaylist.size(); i++) {
            PlayList temp = (PlayList) iter.next();
            names[i] = temp.getName();
        }
        return names;
    }

    /**
     * Finds and returns the PlayList in the PlayListManager with the given name
     * If the PlayList is not found, returns an empty PlayList
     *
     * @param name A String containing the name of the PlayList to be found
     * @return A PlayList object containing a PlayList with the given name or an
     * empty PlayList if one with the given name does not exist
     */
    public PlayList findPlaylist(String name) {
        DoublyNodeIterator iter = (DoublyNodeIterator) allPlaylist.iterator();
        while (iter.hasNext()) {
            PlayList temp = (PlayList) iter.next();
            if (temp.getName().equals(name)) {
                return temp;
            }
        }
        return new PlayList();
    }
}
