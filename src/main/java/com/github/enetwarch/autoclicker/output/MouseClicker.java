package com.github.enetwarch.autoclicker.output;
import java.awt.Robot;
import java.util.logging.Logger;
import java.util.logging.Level;

public class MouseClicker implements Clicker {

    private final Robot robot;
    private final int mouseButton;
    private final int clickerDelay;
    private final Logger logger;

    public MouseClicker(Robot robot, int mouseButton, int clickerDelay, Logger logger) {
        this.robot = robot;
        this.mouseButton = mouseButton;
        this.clickerDelay = clickerDelay;
        this.logger = logger;
    }

    private volatile boolean running = false;
    private Thread virtualThread;

    private void loopClicks() {
        while (running) {
            try {
                robot.mousePress(this.mouseButton);
                robot.mouseRelease(this.mouseButton);
                Thread.sleep(this.clickerDelay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    @Override
    public void startClicking() {
        running = true;
        logger.log(Level.INFO, "Autoclicker toggle ON");
        virtualThread = Thread.ofVirtual().start(this::loopClicks);
    }

    @Override
    public void stopClicking() {
        running = false;
        logger.log(Level.INFO, "Autoclicker toggle OFF");
        if (virtualThread != null) {
            virtualThread.interrupt();
        }
    }

    @Override
    public void toggleClicker() {
        if (running) {
            stopClicking();
        } else {
            startClicking();
        }
    }

}