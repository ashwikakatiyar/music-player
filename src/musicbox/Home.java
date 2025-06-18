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

/**
 * Home --- frame for the home screen of the music player
 *
 * @author Ashwika Katiyar
 */
public class Home extends javax.swing.JFrame {

    private String type;
    private PlayListManager allPL;
    private DefaultListModel songLib;

    /**
     * Creates new form Home Initializes type, allPlaylists, and songLib Sets
     * background to default background Loads and displays allPlaylists, which
     * is the list of all playlists
     *
     * @param truckChoice A String containing the type of Food Truck chosen
     */
    public Home(String truckChoice) {
        initComponents();
        songLib = new DefaultListModel();
        ImageIcon bg = new ImageIcon("Pizza.png");
        jLabel1.setIcon(bg);
        this.setSize(bg.getIconWidth(), bg.getIconHeight());
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        type = truckChoice;
        DefaultListModel mod = new DefaultListModel();
        allPL = new PlayListManager();
        Object[] str = allPL.allPlaylistArray();
        for (Object s : str) {
            mod.addElement(s);
            jList1.setModel(mod);
        }
        jList1.setModel(mod);
    }

    /**
     * Creates new form Home Initializes type, allPlaylists, and songLib Sets
     * background based on Food Truck type Loads and displays allPlaylists,
     * which is the list of all playlists
     *
     * @param truckChoice A String containing the type of Food Truck chosen
     * @param manage A PlayListManager containing all of the playlists created
     */
    public Home(String truckChoice, PlayListManager manage) {
        initComponents();
        ImageIcon bg = null;
        songLib = new DefaultListModel();
        type = truckChoice;
        switch (type) {
            case "Burgers and Sliders":
                bg = new ImageIcon("Burger.png");
                break;
            case "Desserts":
                bg = new ImageIcon("Dessert.png");
                break;
            case "Pizza":
                bg = new ImageIcon("Pizza.png");
                break;
            case "Breakfast and Brunch":
                bg = new ImageIcon("Breakfast.png");
                break;
            case "Crepes":
                bg = new ImageIcon("Crepe.png");
                break;
            case "Tacos and Burritos":
                bg = new ImageIcon("Taco_Burrito.png");
                break;
        }
        jLabel1.setIcon(bg);
        this.setSize(bg.getIconWidth(), bg.getIconHeight());
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        DefaultListModel mod = new DefaultListModel();
        allPL = manage;
        Object[] str = allPL.allPlaylistArray();
        for (Object s : str) {
            mod.addElement(s);
            jList1.setModel(mod);
        }
        jList1.setModel(mod);
    }

    /**
     * Creates new form Home Initializes type, allPlaylists, and songLib Sets
     * background based on Food Truck type Loads and displays allPlaylists,
     * which is the list of all playlists
     *
     * @param truckChoice A String containing the type of Food Truck chosen
     * @param manage A PlayListManager containing all of the playlists created
     * @param model A DefaultListModel containing all the songs in the song
     * library
     */
    public Home(String truckChoice, PlayListManager manage, DefaultListModel model) {
        initComponents();
        songLib = model;
        ImageIcon bg = null;
        type = truckChoice;
        switch (type) {
            case "Burgers and Sliders":
                bg = new ImageIcon("Burger.png");
                break;
            case "Desserts":
                bg = new ImageIcon("Dessert.png");
                break;
            case "Pizza":
                bg = new ImageIcon("Pizza.png");
                break;
            case "Breakfast and Brunch":
                bg = new ImageIcon("Breakfast.png");
                break;
            case "Crepes":
                bg = new ImageIcon("Crepe.png");
                break;
            case "Tacos and Burritos":
                bg = new ImageIcon("Taco_Burrito.png");
                break;
        }
        jLabel1.setIcon(bg);
        this.setSize(bg.getIconWidth(), bg.getIconHeight());
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        DefaultListModel mod = new DefaultListModel();
        allPL = manage;
        Object[] str = allPL.allPlaylistArray();
        for (Object s : str) {
            mod.addElement(s);
            jList1.setModel(mod);
        }
        jList1.setModel(mod);
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
        jList1 = new javax.swing.JList<>();
        play = new javax.swing.JButton();
        changeTruck = new javax.swing.JButton();
        add = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setOpaque(false);
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 90, 420, 330);

        play.setText("Play Playlist");
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        getContentPane().add(play);
        play.setBounds(160, 460, 110, 23);

        changeTruck.setText("Change Truck");
        changeTruck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeTruckActionPerformed(evt);
            }
        });
        getContentPane().add(changeTruck);
        changeTruck.setBounds(20, 460, 130, 23);

        add.setText("Add Playlist");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add);
        add.setBounds(280, 460, 110, 23);

        edit.setText("Edit Playlist");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit);
        edit.setBounds(402, 460, 100, 23);

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 540, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * playActionPerformed --- opens the mainPlayer frame to play the selected
     * playlist
     *
     * @param evt
     */
    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        String plName = jList1.getSelectedValue();
        MainPlayer player = new MainPlayer(type, plName, allPL, songLib);
        player.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_playActionPerformed

    /**
     * addActionPerformed --- opens a frame to create a new playlist
     *
     * @param evt
     */
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try {
            NewPlayListEdit newPL = new NewPlayListEdit(type, allPL, songLib);
            newPL.setVisible(true);
            this.dispose();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addActionPerformed

    /**
     * creates a frame for the user to edit the playlist
     *
     * @param evt
     */
    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        try {
            String pl = jList1.getSelectedValue();
            SinglePlayListEdit editPL = new SinglePlayListEdit(type, allPL, pl, songLib);
            editPL.setVisible(true);
            this.dispose();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_editActionPerformed

    /**
     * changeTruckActionPerformed --- opens the frame to choose a new food truck
     *
     * @param evt
     */
    private void changeTruckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeTruckActionPerformed
        TruckTypeChoice fChoose = new TruckTypeChoice();
        fChoose.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_changeTruckActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton changeTruck;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton play;
    // End of variables declaration//GEN-END:variables
}
