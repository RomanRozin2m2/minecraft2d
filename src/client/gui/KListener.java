package client.gui;

import server.entities.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KListener implements KeyListener {
    Player player;

    public KListener(Player pl){
        player = pl;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A){
            player.walkLeft();
        }
        else if (e.getKeyCode() == KeyEvent.VK_D){
            player.walkRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
