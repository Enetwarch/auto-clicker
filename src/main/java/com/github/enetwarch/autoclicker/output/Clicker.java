package com.github.enetwarch.autoclicker.output;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.InputEvent;
import com.github.enetwarch.autoclicker.util.Format;

public class Clicker {

    private static Robot robot;
    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            System.err.println("There was a problem initializing the robot.");
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    private static final int MOUSE_BUTTON = InputEvent.BUTTON1_DOWN_MASK;
    private static final int CLICKER_DELAY = 10;

    private static volatile boolean running = false;
    private static Thread virtualThread;

    private static void loopClicks() {
        while (running) {
            try {
                robot.mousePress(MOUSE_BUTTON);
                robot.mouseRelease(MOUSE_BUTTON);
                Thread.sleep(CLICKER_DELAY);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private static void startClicking() {
        running = true;
        Format.printMessage("Autoclicker toggle ON");
        virtualThread = Thread.ofVirtual().start(Clicker::loopClicks);
    }

    private static void stopClicking() {
        running = false;
        Format.printMessage("Autoclicker toggle OFF");
        if (virtualThread != null) {
            virtualThread.interrupt();
        }
    }

    public static void toggleClicker() {
        if (running) {
            stopClicking();
        } else {
            startClicking();
        }
    }

}