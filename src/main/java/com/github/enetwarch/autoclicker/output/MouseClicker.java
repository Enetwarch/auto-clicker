package com.github.enetwarch.autoclicker.output;
import java.awt.Robot;
import com.github.enetwarch.autoclicker.util.Format;

public class MouseClicker implements Clicker {

    private final Robot robot;
    private final int mouseButton;
    private final int clickerDelay;

    public MouseClicker(Robot robot, int mouseButton, int clickerDelay) {
        this.robot = robot;
        this.mouseButton = mouseButton;
        this.clickerDelay = clickerDelay;
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
        Format.printMessage("Autoclicker toggle ON");
        virtualThread = Thread.ofVirtual().start(this::loopClicks);
    }

    @Override
    public void stopClicking() {
        running = false;
        Format.printMessage("Autoclicker toggle OFF");
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