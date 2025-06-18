/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package musicbox;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * MusicBox --- starts the MusicBox program
 *
 * @author Ashwika Katiyar
 */
public class MusicBox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StartPage f1 = new StartPage();
        f1.setVisible(true);
    }

}
