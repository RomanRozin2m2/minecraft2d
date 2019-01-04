package server;

import server.blocks.*;

import java.util.Random;

public class World {
    private Block[][] world;
    private Random random;

    public World(int x_size, int y_size) {
        world = new Block[x_size][y_size];
        random = new Random();
        simpleGenerate();
    }

    private void simpleGenerate(){
        int half = world[0].length/2;
        for (int x = 0; x < world.length; x++) {
            for (int y = world[x].length-1; y >= 0; y--) {
                if (y > half){
                    world[x][y] = new Air();
                }
                if (y == half){
                    int ran = random.nextInt(2);
                    if (ran == 1){
                        world[x][y] = new Air();
                    }
                    else {
                        world[x][y] = new Grass();
                    }
                }
                if (y == half-1){
                    if (world[x][y+1].getId().equals(Air.id)) {
                        world[x][y] = new Grass();
                    }
                    else {
                        world[x][y] = new Dirt();
                    }
                }
                if (y < half-1){
                    int ran = random.nextInt(world[0].length-y);
                    if (ran < y){
                        world[x][y] = new Dirt();
                    }
                    else {
                        world[x][y] = new Stone();
                    }
                }
            }
        }
    }

    public Block[][] getWorld(){
        return world;
    }
}
