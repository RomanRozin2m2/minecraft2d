package server.blocks;

import java.awt.*;

public abstract class Block {

    public Block(){

    }

    public abstract Color getColor();
    public abstract String getId();

    public boolean isPassable() {
        return false;
    }
}
