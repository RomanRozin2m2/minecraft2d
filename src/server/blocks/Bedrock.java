package server.blocks;

import java.awt.*;

public class Bedrock extends Block {

    public final static Color color = new Color(0x653200);
    public final static String id = "bedrock";
    public final static Image texture = getTextureImage("data/textures/bedrock.png");

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isPassable() {
        return false;
    }

    @Override
    public Image getTexture() {
        return texture;
    }

}
