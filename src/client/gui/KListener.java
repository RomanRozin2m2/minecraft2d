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
            System.out.println("A" + player.getxSpeed());
        }
        else if (e.getKeyCode() == KeyEvent.VK_D){
            player.walkRight();
            System.out.println("D" + player.getxSpeed());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
