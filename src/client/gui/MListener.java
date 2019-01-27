package client.gui;

import client.Settings;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MListener implements MouseListener {

    private JFrame frame;

    public MListener(JFrame frame){
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getLocationOnScreen().x;
        int y = e.getLocationOnScreen().y;
        x = x;
        y = frame.getHeight() - y;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
