package server;

import client.gui.GameGUI;

public class Server {
    World world;

    public Server(){
        world = new World(160,80);
    }

    public World getWorld(){
        return world;
    }
}
