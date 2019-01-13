package client.gui;

import server.Server;
import server.Constants;
import server.blocks.*;
import server.entities.Player;

import javax.swing.*;

public class GameGUI extends JFrame {
    Block[][] guiWorld;
    GameField field;
    Player player;
    Server server;
    KListener kl;

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
                    int sleepTime = 1000 / Constants.get().ticksPerSecond;
                    Thread.sleep(sleepTime);
                    repaint();
                }
                catch (InterruptedException e) {}
            }

        }).start();
    }

    private void initGUI() {
        field = new GameField(8, 8, server.getWorld(), 10);
        add(field);
        kl = new KListener(player);
        addKeyListener(kl);
    }
}


