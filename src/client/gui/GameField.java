package client.gui;

import server.World;
import server.blocks.Block;
import server.entities.Player;

import javax.swing.*;
import java.awt.*;

public class GameField extends JComponent {
    int blockSize;
    World guiWorld;

    public void paint(Graphics g){
        showWorld(g);
        drawPlayer(g);
    }

    public GameField(int lineWidth, int lineHeight, World world, int blockSize){ // todo: move blockSize to settings
        setSize(lineWidth,  lineHeight);
        guiWorld = world;
        setVisible(true);
        this.blockSize = blockSize;
    }

    private void drawPlayer(Graphics g){
        g.setColor(Color.BLACK);
        for (int i = 0; i < guiWorld.getPlayers().toArray().length; i++) {

            Player player = guiWorld.getPlayers().get(i);

            int topLeftX = (int) (player.getX() * blockSize);
            int topLeftY =  getHeight() - (int) (player.getY() * blockSize + blockSize * player.getHeight());

            int width = (int) (player.getWidth()*blockSize);
            int height = (int) (player.getHeight()*blockSize);

            g.fillRect(topLeftX, topLeftY, width, height);
        }
    }

    private void showWorld(Graphics g){
        for (int x = 0; x < guiWorld.getWorld().length; x++){
            for (int y = 0; y < guiWorld.getWorld()[x].length; y++){
                Block block = guiWorld.getWorld()[x][y];

                int topLeftX = x * blockSize;
                int topLeftY = getHeight()-(y+1) * blockSize;

                if (block.hasTexture()) {
                    g.drawImage(block.getTexture(), topLeftX, topLeftY, blockSize, blockSize, this);
                }
                else {
                    g.setColor(block.getColor());
                    g.fillRect( topLeftX, topLeftY, blockSize, blockSize);
                }
            }
        }
    }
}
