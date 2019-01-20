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



            float xSpeed = player.getxSpeed();
            float ySpeed = player.getySpeed();

            float leftX = player.getX();
            float rightX = leftX + player.getWidth();

            float bottomY = player.getY();
            float topY = bottomY + player.getHeight();

            float nextX = leftX + xSpeed;
            float nextY = bottomY + ySpeed;

            player.setxSpeed(xSpeed * 0.9f);

            if (player.getySpeed() < 0) {
                player.setySpeed(ySpeed * 1.1f);
            }
            else if(player.getySpeed() > 0) {
                player.setySpeed(ySpeed * 0.8f);
            }

            int coordsLeftX = (int) (nextX);
            int coordsRightX = (int) (nextX + player.getWidth());

            int coordsBottomY = (int) (nextY);
            int coordsTopY = (int) (nextY + player.getHeight());

            if (xSpeed > 0) {
                for (int yCoord = coordsBottomY; yCoord <= coordsTopY; yCoord++) {
                    Block block = world.getWorld()[coordsRightX][yCoord];
                    if (!block.isPassable()) {
                        nextX = coordsRightX - player.getWidth();
                        player.setxSpeed(0);
                        break;
                    }
                }
            }
            else if (xSpeed < 0) {
                for (int yCoord = coordsBottomY; yCoord <= coordsTopY; yCoord++) {
                    Block block = world.getWorld()[coordsLeftX][yCoord];
                    if (!block.isPassable()) {
                        nextX = coordsLeftX + 1;
                        player.setxSpeed(0);
                        break;
                    }
                }
            }

            if (ySpeed > 0) {
                for (int xCoord = coordsLeftX; xCoord <= coordsRightX; xCoord++) {
                    Block block = world.getWorld()[xCoord][coordsTopY];
                    if (!block.isPassable()) {
                        nextY = coordsTopY - player.getHeight();
                        player.setySpeed(0);
                        break;
                    }
                }
            }
            else if (ySpeed < 0) {
                for (int xCoord = coordsLeftX; xCoord <= coordsRightX; xCoord++) {
                    Block block = world.getWorld()[xCoord][coordsBottomY];
                    if (!block.isPassable()) {
                        nextY = coordsBottomY + 1;
                        player.setySpeed(0);
                        break;
                    }
                }
            }

            if (player.getySpeed() == 0) {
                boolean canFall = true;
                for (int xCoord = coordsLeftX; xCoord <= coordsRightX; xCoord++) {
                    Block block = world.getWorld()[xCoord][coordsBottomY - 1];
                    if (!block.isPassable()) {
                        canFall = false;
                        break;
                    }
                }
                if (canFall) {
                    player.setySpeed(-0.1f);
                }
            }

            player.setX(nextX);
            player.setY(nextY);

        }
    }

    public World getWorld(){
        return world;
    }
}
