package com.github.enetwarch.autoclicker.output;
import com.github.enetwarch.autoclicker.utilities.Output;

public class Clicker {

    private final int mouseButton;
    private final int clickerDelay;

    public Clicker(int mouseButton, int clickerDelay) {
        this.mouseButton = mouseButton;
        this.clickerDelay = clickerDelay;
    }

    private volatile boolean running = false;
    private Thread virtualThread;

    private void loopClicks() {
        while (running) {
            try {
                Output.robot.mousePress(this.mouseButton);
                Output.robot.mouseRelease(this.mouseButton);
                Thread.sleep(this.clickerDelay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void startClicking() {
        running = true;
        virtualThread = Thread.ofVirtual().start(this::loopClicks);
    }

    public void stopClicking() {
        running = false;
        if (virtualThread != null) {
            virtualThread.interrupt();
        }
    }

}