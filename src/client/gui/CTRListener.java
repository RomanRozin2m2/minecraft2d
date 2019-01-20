package client.gui;

import server.entities.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CTRListener implements KeyListener {
    public boolean isCTRLholded;

    public CTRListener(){

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_CONTROL){
            isCTRLholded = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_CONTROL){
            isCTRLholded = false;
        }
    }
}
