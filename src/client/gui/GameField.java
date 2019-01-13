package client.gui;

import client.Settings;
import server.World;
import server.blocks.Block;
import server.entities.Player;

import javax.swing.*;
import java.awt.*;

public class GameField extends JComponent {
    World guiWorld;

    public void paint(Graphics g){
        showWorld(g);
        drawPlayer(g);
    }

    public GameField(int lineWidth, int lineHeight, World world) {
        setSize(lineWidth,  lineHeight);
        guiWorld = world;
        setVisible(true);
    }

    private void drawPlayer(Graphics g) {
        g.setColor(Color.BLACK);
        int blockSize = Settings.get().blockSize;
        for (Player player: guiWorld.getPlayers()) {

            int topLeftX = (int) (player.getX() * blockSize);
            int topLeftY =  getHeight() - (int) (player.getY() * blockSize + blockSize * player.getHeight());

            int width = (int) (player.getWidth() * blockSize);
            int height = (int) (player.getHeight() * blockSize);

            g.fillRect(topLeftX, topLeftY, width, height);
        }
    }

    private void showWorld(Graphics g){
        int blockSize = Settings.get().blockSize;
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
                    g.fillRect(topLeftX, topLeftY, blockSize, blockSize);
                }
            }
        }
    }
}
