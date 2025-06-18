/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package musicbox;

import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Player --- class to handle the playback of audio files from a PlayList
 *
 * @author Angela Chang
 */
public class Player implements LineListener {

    private AudioInputStream audioInputStream;
    private Clip clip;

    private Long currentFrame;
    private PlayList playList;
    private PlayList ogPlayList;

    /**
     * Contains the status of the song
     */
    private enum Status {
        Play,
        Pause,
        Stop
    }
    Status currentStatus;

    /**
     * Initializes the audio player with the given PlayList Plays the first song
     * in the PlayList if available.
     *
     * @param pl the PlayList object to be played
     */
    public Player(PlayList pl) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        playList = pl;
        ogPlayList = playList;
        if (playList.hasNextSong()) {
            String[] parts = playList.forward().split(":");
            System.out.println("MusicandLists/" + parts[1]);
            openAudio("MusicandLists/" + parts[1]);
            currentStatus = Status.Play;
        }
    }

    /**
     * Opens an audio file
     *
     * @param filePath a String containing path to the audio file
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     */
    private void openAudio(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.addLineListener(this);
    }

    /**
     * Stops the current song and closes the audio
     */
    public void stop() {
        clip.stop();
        clip.close();
        currentStatus = Status.Stop;
    }

    /**
     * Starts or resumes the song from where it left off
     *
     * @throws LineUnavailableException
     * @throws IOException
     * @throws UnsupportedAudioFileException
     */
    public void play() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        if (currentStatus == Status.Pause) {
            clip.setMicrosecondPosition(currentFrame);
            clip.start();
        }
        clip.start();
        currentStatus = Status.Play;
    }

    /**
     * Plays the song that is selected
     *
     * @param song A String containing the name of the song to be played
     * @throws LineUnavailableException
     * @throws IOException
     * @throws UnsupportedAudioFileException
     */
    public void playSelectedSong(String song) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        openAudio("MusicandLists/" + song.substring(song.indexOf(":") + 1));
        if (currentStatus == Status.Pause) {
            clip.setMicrosecondPosition(currentFrame);
            clip.start();
        }
        clip.start();
        currentStatus = Status.Play;
    }

    /**
     * Pauses the song
     */
    public void pause() {
        currentFrame = clip.getMicrosecondPosition();
        clip.stop();
        currentStatus = Status.Pause;
    }

    /**
     * Moves to the next song in the playlist as long as there are next songs to
     * play
     *
     * @param type the Type of the LineEvent occurring
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException
     * @throws IOException
     */
    private void next(LineEvent.Type type) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (playList.hasNextSong()) {
            if (type == LineEvent.Type.STOP) {
                clip.close();
                String[] parts = playList.forward().split(":");
                System.out.println("MusicandLists/" + parts[1]);
                openAudio("MusicandLists/" + parts[1]);
                clip.start();
            }

        }
    }

    /**
     * Transitions to the next song when current song finishes playing
     *
     * @param event The LineEvent that triggered the update
     */
    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
        System.out.println(currentStatus);
        if (type == LineEvent.Type.STOP && currentStatus != Status.Pause) {
            try {
                next(type);
            } catch (UnsupportedAudioFileException ex) {
                java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
    }
}
