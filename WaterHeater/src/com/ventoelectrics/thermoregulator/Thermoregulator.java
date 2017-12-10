package com.ventoelectrics.thermoregulator;

import com.ventoelectrics.powerswitch.PoweredDevice;

public interface Thermoregulator extends PoweredDevice {

    void setTemperature(Integer temperature);
}
