package client.gui;

import server.World;

import javax.swing.*;
import java.awt.*;

public class GameField extends JComponent {
    int blockSize;
    World guiWorld;

    public void paint(Graphics g){
        showWorld(g);
    }

    public GameField(int lineWidth, int lineHeight, World world, int blockSize){
        setSize(lineWidth,  lineHeight);
        guiWorld = world;
        setVisible(true);
        this.blockSize = blockSize;
    }

    private void showWorld(Graphics g){
        for (int x = 0; x < guiWorld.getWorld().length; x++){
            for (int y = 0; y < guiWorld.getWorld()[x].length; y++){
                g.setColor(guiWorld.getWorld()[x][y].getColor());
                g.fillRect( x* blockSize, getHeight()-(y+1) * blockSize, blockSize, blockSize);
            }
        }
    }
}
