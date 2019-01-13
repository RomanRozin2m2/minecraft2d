package server;

import server.blocks.Block;
import server.entities.Player;

public class Server {
    private World world;
    private Thread mainThread;

    public Server(){
        world = new World(160,80);
        mainThread = new Thread(this::handleServer);
        mainThread.start();
    }

    private void handleServer() {
        while (true) {
            try {
                int sleepTime = 1000 / Settings.get().ticksPerSecond;
                Thread.sleep(sleepTime);
            }
            catch (InterruptedException e) {}

            handlePlayersMovement();
        }
    }

    private void handlePlayersMovement() {
        for (Player player : world.getPlayers()) {
            float xSpeed = player.getxSpeed();
            float ySpeed = player.getySpeed();

            float leftX = player.getX();
            float rightX = leftX + player.getWidth();

            float bottomY = player.getY();
            float topY = bottomY + player.getHeight();

            float nextX = leftX + xSpeed;
            float nextY = bottomY + ySpeed;

            player.setxSpeed(xSpeed * 0.9f);
            player.setySpeed(ySpeed * 0.9f);

            int coordsLeftX = (int) (nextX);
            int coordsRightX = (int) (nextX + player.getWidth());

            int coordsBottomY = (int) (nextY);
            int coordsTopY = (int) (nextY + player.getHeight());

            Block rightBottomBlock = world.getWorld()[coordsRightX][coordsBottomY];
            Block rightTopBlock = world.getWorld()[coordsRightX][coordsTopY];

            player.setX(nextX);
            player.setY(nextY);

        }
    }

    public World getWorld(){
        return world;
    }
}
