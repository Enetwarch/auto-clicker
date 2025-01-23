package data;
import java.awt.event.InputEvent;

public enum Data {
 
    MOUSE_BUTTON(InputEvent.BUTTON1_DOWN_MASK),
    CLICKER_DELAY(100);

    private final int data;

    private Data(int data) {
        this.data = data;
    }

    public int get() {
        return data;
    }

}