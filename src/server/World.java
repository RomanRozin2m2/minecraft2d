package server;

import server.blocks.*;
import server.entities.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
    private Block[][] world;
    private Random random;
    private List<Player> players;

    public World(int x_size, int y_size) {
        players = new ArrayList<>();
        world = new Block[x_size][y_size];
        random = new Random();
        simpleGenerate2();
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

    private void simpleGenerate2(){
        int currHeight = world[0].length/2;
        for (int x = 0; x < world.length; x++) {
            switch (random.nextInt(5)) {
                case 0: currHeight--; break;
                case 1: currHeight++; break;
                default: break;
            }
            for (int y = world[x].length - 1; y > currHeight; y--) {
                world[x][y] = new Air();
            }
            world[x][currHeight] = new Grass();
            int bedrockLevel = random.nextInt(3);
            for (int y = currHeight - 1; y > bedrockLevel; y--) {
                if (random.nextInt(world[0].length-y) < y){
                    world[x][y] = new Dirt();
                }
                else {
                    world[x][y] = new Stone();
                }
            }
            for (int y = bedrockLevel; y >= 0; y--) {
                world[x][y] = new Bedrock();
            }
        }
    }

    public Player addPlayer(){
        Random random = new Random();
        for (int x = 0; x < world.length; x++) {
            for (int y = world[x].length-2; y > 0; y--) {
                if (world[x][y+1].getId().equals(Air.id) &&
                        world[x][y].getId().equals(Air.id) &&
                        world[x][y-1].getId().equals(Grass.id)){
                    if (x == world.length-1){
                        return summonPlayer(x,y);
                    }
                    else if (random.nextInt(16) == 1){
                        return summonPlayer(x,y);
                    }
                }
            }
        }
        return null;
    }

    private Player summonPlayer(int x, int y){
        Player player = new Player(x,y);
        players.add(player);
        return player;
    }

    public Block[][] getWorld(){
        return world;
    }

    public List<Player> getPlayers(){
        return players;
    }
}
