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
                int sleepTime = 1000 / Constants.get().ticksPerSecond;
                Thread.sleep(sleepTime);
            }
            catch (InterruptedException e) {}

            handlePlayersMovement();
        }
    }

    private void handlePlayersMovement() {
        for (Player player : world.getPlayers()) {

            while (isGoingToCollide(player)) {
                player.setxSpeed(player.getxSpeed() * 0.7f);
                player.setySpeed(player.getySpeed() * 0.7f);
            }

            float xSpeed = player.getxSpeed();
            float ySpeed = player.getySpeed();

            float leftX = player.getX();
            float bottomY = player.getY();

            float nextX = leftX + xSpeed;
            float nextY = bottomY + ySpeed;

            player.setX(nextX);
            player.setY(nextY);

            applyGravity(player);

        }
    }

    public World getWorld(){
        return world;
    }

    private boolean isGoingToCollide(Player player) {
        float xSpeed = player.getxSpeed();
        float ySpeed = player.getySpeed();

        float leftX = player.getX();
        float rightX = leftX + player.getWidth();

        float bottomY = player.getY();
        float topY = bottomY + player.getHeight();

        float nextX = leftX + xSpeed;
        float nextY = bottomY + ySpeed;

        int coordsLeftX = (int) (nextX);
        int coordsRightX = (int) (nextX + player.getWidth());

        int coordsBottomY = (int) (nextY);
        int coordsTopY = (int) (nextY + player.getHeight());

        boolean isAvailablePoint = true;

        for (int currX = coordsLeftX; currX <= coordsRightX; currX++) {
            for (int currY = coordsBottomY; currY <= coordsTopY; currY++) {
                if (!world.getWorld()[currX][currY].isPassable()) {
                    isAvailablePoint = false;
                }
            }
        }

        return !isAvailablePoint;
    }

    private void applyGravity(Player player) {
        float currYVelocity = player.getySpeed();

        player.setySpeed(currYVelocity - 0.01f);

        if (isGoingToCollide(player)) {
            player.setySpeed(currYVelocity);
        }
    }
}
