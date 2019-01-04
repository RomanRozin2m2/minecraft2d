package client;

import client.gui.GameGUI;
import server.Server;

public class Client {
    public static void main(String[] args) {
        Server server = new Server();
        GameGUI gg = new GameGUI(server);
    }
}
