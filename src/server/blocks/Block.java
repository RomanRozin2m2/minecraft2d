package server.blocks;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public abstract class Block {

    public boolean isHighlight;
    public final static Color noColor = new Color(0xCC60D7);
    public final static Image invalid = getTextureImage("data/textures/invalid.png");


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

    public static Image getTextureImage(String path) {
        try {
            return ImageIO.read(new File(path));
        }
        catch (IOException e) {
            return invalid;
        }
    }
}
