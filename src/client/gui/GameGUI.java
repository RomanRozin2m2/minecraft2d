package client.gui;

import server.Server;
import server.blocks.*;

import javax.swing.*;
import java.awt.*;

public class GameGUI extends JFrame {
    Block[][] guiWorld;
    JComponent field;
    Server server;

    public GameGUI(Server serv) {
        server = serv;
        guiWorld = server.getWorld().getWorld();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        initGUI();
        setVisible(true);
    }

    private void initGUI() {
        field = new GameField(8, 8, server.getWorld(), 10);
        add(field);
    }
}


