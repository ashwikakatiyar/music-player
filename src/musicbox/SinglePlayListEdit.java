/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package musicbox;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import LinkedListVariations.CircularLinkedList;
import LinkedListVariations.CircularNode;
import LinkedListVariations.CircularNodeIterator;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * SinglePlayListEdit --- frame to edit an existing PlayList
 *
 * @author Ashwika Katiyar, Aarushi Kahlon
 */
public class SinglePlayListEdit extends javax.swing.JFrame {

    private String type;
    private DefaultListModel mod;
    private DefaultListModel songLib;
    private PlayListManager allPL;
    private PlayList pl;

    /**
     * Creates new form SinglePlayListEdit Changes background based on user
     * selection Adds music from file and user made songs to songLibrary jList
     *
     * @param truckChoice A String containing the type of Food Truck chosen
     * @param manage A PlayListManager containing all of the playlists created
     * @param name A String containing the name of the PlayList to be edited
     */
    public SinglePlayListEdit(String truckChoice, PlayListManager manage, String name) throws FileNotFoundException {
        initComponents();
        ImageIcon bg = null;
        songLib = new DefaultListModel();
        mod = new DefaultListModel();
        type = truckChoice;
        switch (type) {
            case "Burgers and Sliders":
                bg = new ImageIcon("EditPLBurger.png");
                break;
            case "Desserts":
                bg = new ImageIcon("EditPLDessert.png");
                break;
            case "Pizza":
                bg = new ImageIcon("EditPLPizza.png");
                break;
            case "Breakfast and Brunch":
                bg = new ImageIcon("EditPLBreakfast.png");
                break;
            case "Crepes":
                bg = new ImageIcon("EditPLCrepe.png");
                break;
            case "Tacos and Burritos":
                bg = new ImageIcon("EditPLTaco.png");
                break;
        }
        jLabel1.setIcon(bg);
        this.setSize(bg.getIconWidth(), bg.getIconHeight());
        DefaultListModel mod = new DefaultListModel();
        PlayList list = new PlayList("MusicandLists/AllMusic.mList");
        Object[] str = list.toArray();
        for (Object s : str) {
            songLib.addElement(s);
            SongLibrary.setModel(songLib);
        }
        SongLibrary.setModel(songLib);
        allPL = manage;
        pl = allPL.findPlaylist(name);
        Object[] strPL = pl.toArray();
        for (Object s : strPL) {
            mod.addElement(s);
            userSongs.setModel(mod);
        }
        userSongs.setModel(mod);
    }

    /**
     * Creates new form SinglePlayListEdit Initializes private instance
     * variables Changes background based on user selection Adds music from file
     * and user made songs to songLibrary jList
     *
     * @param truckChoice A String containing the type of Food Truck chosen
     * @param manage A PlayListManager containing all of the playlists created
     * @param name A String containing the name of the PlayList to be edited
     * @param model A DefaultListModel containing all songs in the song library
     * @throws FileNotFoundException
     */
    public SinglePlayListEdit(String truckChoice, PlayListManager manage, String name, DefaultListModel model) throws FileNotFoundException {
        initComponents();
        ImageIcon bg = null;
        songLib = model;
        mod = new DefaultListModel();
        type = truckChoice;
        switch (type) {
            case "Burgers and Sliders":
                bg = new ImageIcon("EditPLBurger.png");
                break;
            case "Desserts":
                bg = new ImageIcon("EditPLDessert.png");
                break;
            case "Pizza":
                bg = new ImageIcon("EditPLPizza.png");
                break;
            case "Breakfast and Brunch":
                bg = new ImageIcon("EditPLBreakfast.png");
                break;
            case "Crepes":
                bg = new ImageIcon("EditPLCrepe.png");
                break;
            case "Tacos and Burritos":
                bg = new ImageIcon("EditPLTaco.png");
                break;
        }
        jLabel1.setIcon(bg);
        this.setSize(bg.getIconWidth(), bg.getIconHeight());
        PlayList list = new PlayList("MusicandLists/AllMusic.mList");
        Object[] str = list.toArray();
        for (Object s : str) {
            songLib.addElement(s);
            SongLibrary.setModel(songLib);
        }
        SongLibrary.setModel(songLib);
        allPL = manage;
        pl = allPL.findPlaylist(name);
        Object[] strPL = pl.toArray();
        for (Object s : strPL) {
            mod.addElement(s);
            userSongs.setModel(mod);
        }
        userSongs.setModel(mod);
    }

    /**
     * Creates new form SinglePlayListEdit Changes the background based on user
     * selection Adds music from file to songLibrary jList
     *
     * @param truckChoice A String containing the type of Food Truck chosen
     * @throws FileNotFoundException
     */
    public SinglePlayListEdit(String truckChoice) throws FileNotFoundException {
        initComponents();
        ImageIcon bg = null;
        type = truckChoice;
        switch (type) {
            case "Burgers and Sliders":
                bg = new ImageIcon("EditPLBurger.png");
                break;
            case "Desserts":
                bg = new ImageIcon("EditPLDessert.png");
                break;
            case "Pizza":
                bg = new ImageIcon("EditPLPizza.png");
                break;
            case "Breakfast and Brunch":
                bg = new ImageIcon("EditPLBreakfast.png");
                break;
            case "Crepes":
                bg = new ImageIcon("EditPLCrepe.png");
                break;
            case "Tacos and Burritos":
                bg = new ImageIcon("EditPLTaco.png");
                break;
        }
        jLabel1.setIcon(bg);
        this.setSize(bg.getIconWidth(), bg.getIconHeight());
        DefaultListModel mod = new DefaultListModel();
        PlayList list = new PlayList("MusicandLists/AllMusic.mList");
        Object[] str = list.toArray();
        for (Object s : str) {
            mod.addElement(s);
            SongLibrary.setModel(mod);
        }
        SongLibrary.setModel(mod);
        allPL = new PlayListManager();
        pl = new PlayList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        SongLibrary = new javax.swing.JList<>();
        playlistOrder = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        userSongs = new javax.swing.JList<>();
        add = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        addLib = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(540, 540));
        setSize(new java.awt.Dimension(540, 540));
        getContentPane().setLayout(null);

        SongLibrary.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(SongLibrary);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 120, 240, 260);

        playlistOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alphabetical", "Selected Order", "Randomized" }));
        getContentPane().add(playlistOrder);
        playlistOrder.setBounds(380, 420, 150, 23);

        userSongs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(userSongs);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(270, 120, 260, 290);

        add.setText("Add Song");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add);
        add.setBounds(10, 420, 100, 23);

        remove.setText("Remove Song");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        getContentPane().add(remove);
        remove.setBounds(120, 420, 120, 23);

        addLib.setText("Add Song to Library");
        addLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLibActionPerformed(evt);
            }
        });
        getContentPane().add(addLib);
        addLib.setBounds(50, 390, 150, 23);

        save.setText("Save Playlist");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save);
        save.setBounds(250, 420, 120, 23);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 540, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * addActionPerformed --- adds the selected song into user playlist
     *
     * @author Aarushi Kahlon
     * @param evt
     */
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        Object cat = SongLibrary.getSelectedValue();
        mod.addElement(cat);
        userSongs.setModel(mod);
        pl.addSong(cat);
    }//GEN-LAST:event_addActionPerformed

    /**
     * removeActionPerformed --- removes the selected song from user playlist
     *
     * @author Aarushi Kahlon
     * @param evt
     */
    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        int index = userSongs.getSelectedIndex();
        String rem = userSongs.getSelectedValue();
        if (index != -1) {
            mod.removeElement(rem);
        }
        pl.removeSong(rem);
    }//GEN-LAST:event_removeActionPerformed

    /**
     * saveActionPerformed --- saves the edited playlist
     *
     * @author Ashwika Katiyar
     * @param evt
     */
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String order = (String) playlistOrder.getSelectedItem();
        switch (order) {
            case "Alphabetical":
                pl.alphabeticalOrder();
                break;
            case "Selected Order":
                pl.selectedOrder();
                break;
            case "Randomized":
                pl.shufflePlaylist();
                break;
        }
        Home fHome = new Home(type, allPL, songLib);
        fHome.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_saveActionPerformed

    /**
     * addLibActionPerformed --- opens a frame for the user to enter their own
     * song to their playlist
     *
     * @author Ashwika Katiyar
     * @param evt
     */
    private void addLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLibActionPerformed
        AddToSongLibrary fAdd = new AddToSongLibrary(type, pl.getName(), allPL);
        fAdd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addLibActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> SongLibrary;
    private javax.swing.JButton add;
    private javax.swing.JButton addLib;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> playlistOrder;
    private javax.swing.JButton remove;
    private javax.swing.JButton save;
    private javax.swing.JList<String> userSongs;
    // End of variables declaration//GEN-END:variables
}
