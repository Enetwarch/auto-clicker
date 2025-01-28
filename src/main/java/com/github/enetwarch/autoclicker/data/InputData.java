package com.github.enetwarch.autoclicker.data;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

public enum InputData {

    TOGGLE_SWITCH(NativeKeyEvent.VC_F9),
    KILL_SWITCH(NativeKeyEvent.VC_F10);

    private final int inputData;

    InputData(int inputData) {
        this.inputData = inputData;
    }

    public int get() {
        return inputData;
    }

}