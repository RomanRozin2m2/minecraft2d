package client.gui;

import client.Settings;
import server.Server;
import server.blocks.*;
import server.entities.Player;

import javax.swing.*;

public class GameGUI extends JFrame {
    Block[][] guiWorld;
    GameField field;
    Player player;
    Server server;
    KListener kl;
    MListener ml;
    MMListener mml;

    public GameGUI(Server serv) {
        server = serv;
        guiWorld = server.getWorld().getWorld();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        player = server.getWorld().addPlayer();
        setSize(300, 300);
        initGUI();
        setVisible(true);

        new Thread(() -> {
            while (true) {
                try {
                    int sleepTime = 1000 / Settings.get().framesPerSecond;
                    Thread.sleep(sleepTime);
                    repaint();
                }
                catch (InterruptedException e) {}
            }

        }).start();
    }

    private void initGUI() {
        field = new GameField(8, 8, server.getWorld(), player);
        add(field);
        kl = new KListener(player);
        addKeyListener(kl);
        ml = new MListener(this);
        addMouseListener(ml);
        mml = new MMListener(this, player);
        addMouseMotionListener(mml);
    }

    public void blockBreak(int x,int y){
        field.guiWorld.getWorld()[x][y] = new Air();
    }
}


