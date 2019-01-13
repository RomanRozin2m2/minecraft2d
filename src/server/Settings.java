package server;

public class Settings {

    private static Settings obj = new Settings();

    private Settings(){

    }

    public static Settings get() {
        return obj;
    }

    public int playerHealth = 20;
    public float playerHeight = 1.75f;
    public float playerWidth = 0.8f;

    public int ticksPerSecond = 20;
}
