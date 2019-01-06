package server.blocks;

import java.awt.*;
import java.util.Objects;

public abstract class Block {

    public final static Color noColor = new Color(0xCC60D7);


    public Block(){

    }

    public Color getColor() {
        return noColor;
    }

    public abstract String getId();

    public boolean isPassable() {
        return false;
    }

    public Image getTexture() {
        return null;
    }

    public boolean hasTexture() {
        return Objects.nonNull(getTexture());
    }
}
