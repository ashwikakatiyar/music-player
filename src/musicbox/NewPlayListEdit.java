/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package musicbox;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * NewPlayListEdit --- frame to allow user to create a new playlist
 *
 * @author Ashwika Katiyar
 */
public class NewPlayListEdit extends javax.swing.JFrame {

    private String type; //stores the food truck chosen by the user
    private DefaultListModel mod; //stores the model that the user will add their songs to which will be displayed in the userSongs jList
    private DefaultListModel songLib; //stores all the songs in the song library
    private PlayListManager allPL; //stores all the playlists the user makes
    private PlayList newPL; //stores the new playlist created

    /**
     * Creates new form NewPlayListEdit Changes background based on user
     * selection Adds music from file and user made songs to songLibrary jList
     *
     * @param truckChoice A String containing the type of Food Truck chosen
     * @param manage A PlayListManager containing all of the playlists created
     */
    public NewPlayListEdit(String truckChoice, PlayListManager manage) throws FileNotFoundException {
        initComponents();
        songLib = new DefaultListModel();
        mod = new DefaultListModel();
        ImageIcon bg = null;
        type = truckChoice;
        switch (type) {
            case "Burgers and Sliders":
                bg = new ImageIcon("NewPLBurger.png");
                break;
            case "Desserts":
                bg = new ImageIcon("NewPLDessert.png");
                break;
            case "Pizza":
                bg = new ImageIcon("NewPLPizza.png");
                break;
            case "Breakfast and Brunch":
                bg = new ImageIcon("NewPLBreakfast.png");
                break;
            case "Crepes":
                bg = new ImageIcon("NewPLCrepe.png");
                break;
            case "Tacos and Burritos":
                bg = new ImageIcon("NewPLTaco.png");
                break;
        }
        jLabel1.setIcon(bg);
        this.setSize(bg.getIconWidth(), bg.getIconHeight());
        PlayList list = new PlayList("MusicandLists/AllMusic.mList");
        Object[] str = list.toArray();
        for (Object s : str) {
            songLib.addElement(s);
        }
        songLibrary.setModel(songLib);
        allPL = manage;
        newPL = new PlayList();
    }

    /**
     * Creates new form NewPlayListEdit Initializes private instance variables
     * Changes background based on user selection Adds music from file and user
     * made songs to songLibrary jList
     *
     * @param truckChoice A String containing the type of Food Truck chosen
     * @param manage A PlayListManager containing all of the playlists created
     * @param model A DefaultListModel containing all songs in the song library
     * @throws FileNotFoundException
     */
    public NewPlayListEdit(String truckChoice, PlayListManager manage, DefaultListModel model) throws FileNotFoundException {
        initComponents();
        songLib = model;
        mod = new DefaultListModel();
        ImageIcon bg = null;
        type = truckChoice;
        switch (type) {
            case "Burgers and Sliders":
                bg = new ImageIcon("NewPLBurger.png");
                break;
            case "Desserts":
                bg = new ImageIcon("NewPLDessert.png");
                break;
            case "Pizza":
                bg = new ImageIcon("NewPLPizza.png");
                break;
            case "Breakfast and Brunch":
                bg = new ImageIcon("NewPLBreakfast.png");
                break;
            case "Crepes":
                bg = new ImageIcon("NewPLCrepe.png");
                break;
            case "Tacos and Burritos":
                bg = new ImageIcon("NewPLTaco.png");
                break;
        }
        jLabel1.setIcon(bg);
        this.setSize(bg.getIconWidth(), bg.getIconHeight());
        songLibrary.setModel(songLib);
        allPL = manage;
        newPL = new PlayList();
    }

    /**
     * Creates new form NewPlayListEdit Changes the background based on user
     * selection Adds music from file to songLibrary jList
     *
     * @param truckChoice A String containing the type of Food Truck chosen
     * @throws FileNotFoundException
     */
    public NewPlayListEdit(String truckChoice) throws FileNotFoundException {
        initComponents();
        ImageIcon bg = null;
        mod = new DefaultListModel();
        songLib = new DefaultListModel();
        type = truckChoice;
        switch (type) {
            case "Burgers and Sliders":
                bg = new ImageIcon("NewPLBurger.png");
                break;
            case "Desserts":
                bg = new ImageIcon("NewPLDessert.png");
                break;
            case "Pizza":
                bg = new ImageIcon("NewPLPizza.png");
                break;
            case "Breakfast and Brunch":
                bg = new ImageIcon("NewPLBreakfast.png");
                break;
            case "Crepes":
                bg = new ImageIcon("NewPLCrepe.png");
                break;
            case "Tacos and Burritos":
                bg = new ImageIcon("NewPLTaco.png");
                break;
        }
        jLabel1.setIcon(bg);
        this.setSize(bg.getIconWidth(), bg.getIconHeight());
        PlayList list = new PlayList("MusicandLists/AllMusic.mList");
        Object[] str = list.toArray();
        for (Object s : str) {
            songLib.addElement(s);
        }
        songLibrary.setModel(songLib);
        newPL = new PlayList();
        allPL = new PlayListManager();
    }

    public NewPlayListEdit() {
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
        songLibrary = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        userSongs = new javax.swing.JList<>();
        add = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        playlistOrder = new javax.swing.JComboBox<>();
        playlistName = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(540, 540));
        getContentPane().setLayout(null);

        songLibrary.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(songLibrary);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 150, 240, 260);

        userSongs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane3.setViewportView(userSongs);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(270, 150, 260, 260);

        add.setText("Add Song");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add);
        add.setBounds(40, 420, 100, 23);

        remove.setText("Remove Song");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        getContentPane().add(remove);
        remove.setBounds(200, 420, 120, 23);

        playlistOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alphabetical", "Selected Order", "Randomized" }));
        getContentPane().add(playlistOrder);
        playlistOrder.setBounds(380, 120, 150, 23);
        getContentPane().add(playlistName);
        playlistName.setBounds(110, 120, 140, 20);

        save.setText("Save Playlist");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save);
        save.setBounds(380, 420, 120, 23);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 540, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * addActionPerformed --- adds the selected song to the user's playlist
     *
     * @param evt
     */
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        Object cat = songLibrary.getSelectedValue();
        mod.addElement(cat);
        userSongs.setModel(mod);
        newPL.addSong(cat);
        String order = (String) playlistOrder.getSelectedItem();
        switch (order) {
            case "Alphabetical":
                newPL.alphabeticalOrder();
                break;
            case "Selected Order":
                newPL.selectedOrder();
                break;
            case "Randomized":
                newPL.shufflePlaylist();
                break;
        }
    }//GEN-LAST:event_addActionPerformed

    /**
     * removeActionPerformed --- removes the selected song from the user's
     * playlist
     *
     * @param evt
     */
    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        int index = userSongs.getSelectedIndex();
        String rem = userSongs.getSelectedValue();
        if (index != -1) {
            mod.remove(index);
        }
        newPL.removeSong(rem);
        String order = (String) playlistOrder.getSelectedItem();
        switch (order) {
            case "Alphabetical":
                newPL.alphabeticalOrder();
                break;
            case "Selected Order":
                newPL.selectedOrder();
                break;
            case "Randomized":
                newPL.shufflePlaylist();
                break;
        }
    }//GEN-LAST:event_removeActionPerformed

    /**
     * saveActionPerformed --- saves the user's playlist under the entered
     * playlist name and returns to Home
     *
     * @param evt
     */
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        newPL.setName(playlistName.getText());
        String order = (String) playlistOrder.getSelectedItem();
        switch (order) {
            case "Alphabetical":
                newPL.alphabeticalOrder();
                break;
            case "Selected Order":
                newPL.selectedOrder();
                break;
            case "Randomized":
                newPL.shufflePlaylist();
                break;
        }
        if (playlistName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter a Playlist Name");
        } else {
            try {
                allPL.addPlayList(newPL);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewPlayListEdit.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(newPL);
            Home fHome = new Home(type, allPL, songLib);
            fHome.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_saveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField playlistName;
    private javax.swing.JComboBox<String> playlistOrder;
    private javax.swing.JButton remove;
    private javax.swing.JButton save;
    private javax.swing.JList<String> songLibrary;
    private javax.swing.JList<String> userSongs;
    // End of variables declaration//GEN-END:variables
}
