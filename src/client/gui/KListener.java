package client.gui;

import client.Settings;
import server.entities.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;

public class KListener implements KeyListener {
    Player player;
    ArrayList<Integer> keysPressed;
    Thread keyThread;


    public KListener(Player pl){
        player = pl;
        keysPressed = new ArrayList<Integer>();
        keyThread = new Thread(this::key);
        keyThread.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(!keysPressed.contains(e.getKeyCode())){
            keysPressed.add(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keysPressed.remove((Integer) e.getKeyCode());
    }

    private void key(){
        while (true){
            if (keysPressed.contains(Settings.get().keybinds.runKey) && keysPressed.contains(Settings.get().keybinds.leftKey)){
                player.runLeft();
            }
            else if (keysPressed.contains(Settings.get().keybinds.runKey) && keysPressed.contains(Settings.get().keybinds.rightKey)){
                player.runRight();
            }
            else if (!keysPressed.contains(Settings.get().keybinds.runKey) && keysPressed.contains(Settings.get().keybinds.leftKey)){
                player.walkLeft();
            }
            else if (!keysPressed.contains(Settings.get().keybinds.runKey) && keysPressed.contains(Settings.get().keybinds.rightKey)){
                player.walkRight();
            }
            if (keysPressed.contains(Settings.get().keybinds.jumpKey)){
                player.jump();
            }
            try {
                Thread.sleep(1000/Settings.get().framesPerSecond);
            }
            catch (InterruptedException e){

            }
        }
    }
}
