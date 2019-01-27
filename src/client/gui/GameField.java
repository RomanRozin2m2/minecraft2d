package client.gui;

import client.Settings;
import server.World;
import server.blocks.Block;
import server.entities.Player;

import javax.swing.*;
import java.awt.*;

public class GameField extends JComponent {
    World guiWorld;
    Player currpl;

    public void paint(Graphics g){
        showWorld(g);
        drawPlayer(g);
        drawEyeLine(g);
    }

    public GameField(int lineWidth, int lineHeight, World world, Player player) {
        setSize(lineWidth,  lineHeight);
        guiWorld = world;
        currpl = player;
        setVisible(true);
    }

    private void drawEyeLine(Graphics g){
        g.setColor(Color.YELLOW);
        float ex = currpl.getX() + currpl.getEyeX();
        float ey = currpl.getY() + currpl.getEyeY();
        int fex = (int) (ex*Settings.get().blockSize);
        int fey = (int) (ey*Settings.get().blockSize);
        int cursx = currpl.getCursorx();
        int cursy = currpl.getCursory();
        g.drawLine(fex, getHeight() - fey, cursx, cursy);
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
        guiWorld.getWorld()[(int)currpl.getX()][(int)currpl.getY()-1].isHighlight = true;
        int blockSize = Settings.get().blockSize;
        boolean useTextures = Settings.get().renderMode == RenderMode.Textures;
        for (int x = 0; x < guiWorld.getWorld().length; x++){
            for (int y = 0; y < guiWorld.getWorld()[x].length; y++){
                Block block = guiWorld.getWorld()[x][y];

                int topLeftX = x * blockSize;
                int topLeftY = getHeight()-(y+1) * blockSize;

                if (block.hasTexture() && useTextures) {
                    g.drawImage(block.getTexture(), topLeftX, topLeftY, blockSize, blockSize, this);
                }
                else {
                    g.setColor(block.getColor());
                    g.fillRect(topLeftX, topLeftY, blockSize, blockSize);
                }
                if (block.isHighlight){
                    g.setColor(new Color(0x7CC5C800, true));
                    g.fillRect(topLeftX, topLeftY, blockSize, blockSize);
                }
            }
        }
    }
}
