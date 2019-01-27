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
    public float playerEyeY = 0.9f;
    public float playerEyeX = 0.5f;
    public int maxBreakDistance = 20;

    public int ticksPerSecond = 20;
}
