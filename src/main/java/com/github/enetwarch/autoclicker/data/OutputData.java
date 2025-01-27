package com.github.enetwarch.autoclicker.data;

import java.awt.event.InputEvent;

public enum OutputData {

    MOUSE_BUTTON(InputEvent.BUTTON1_DOWN_MASK),
    CLICKER_DELAY(100);

    private final int outputData;

    OutputData(int outputData) {
        this.outputData = outputData;
    }

    public int get() {
        return outputData;
    }

}