package com.ventoelectrics.thermometer;

import com.ventoelectrics.powerswitch.exception.NoPowerException;
import com.ventoelectrics.powerswitch.PoweredDevice;

import java.util.Random;

public class Thermometer implements PoweredDevice {

    private boolean powerEnabled = false;

    private Random random = new Random(System.currentTimeMillis());

    public Integer getTemperature() {
        if (!powerEnabled) {
            throw new NoPowerException();
        }
        return random.nextInt(60);
    }

    public void enablePower() {
        powerEnabled = true;
    }

    public void disablePower() {
        powerEnabled = false;
    }
}
