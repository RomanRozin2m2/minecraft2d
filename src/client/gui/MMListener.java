package client.gui;

import server.entities.Player;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MMListener implements MouseMotionListener {
    Player pl;
    JFrame frame;

    public MMListener(JFrame frame, Player player){
        pl = player;
        this.frame = frame;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        pl.setCursory(e.getY() - 32);
        pl.setCursorx(e.getX() - 8);
    }
}
