package server;

public class Constants {

    private static Constants obj = new Constants();

    private Constants(){

    }

    public static Constants get() {
        return obj;
    }

    public int playerHealth = 20;
    public float playerHeight = 1.75f;
    public float playerWidth = 0.8f;

    public int ticksPerSecond = 20;
}
