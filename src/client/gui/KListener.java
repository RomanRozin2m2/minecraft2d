package client.gui;

import server.entities.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KListener implements KeyListener {
    Player player;
    CTRListener control;

    public KListener(Player pl, CTRListener ctrl){
        player = pl;
        control = ctrl;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (control.isCTRLholded){
            if (e.getKeyCode() == KeyEvent.VK_A) {
                player.runLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                player.runRight();
            }
        }
        else {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                player.walkLeft();
            } else if (e.getKeyCode() == KeyEvent.VK_D) {
                player.walkRight();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
