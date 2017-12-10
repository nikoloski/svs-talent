package com.ventoelectrics.waterheater;

import com.ventoelectrics.heater.Heater;
import com.ventoelectrics.powerswitch.PowerSwitch;
import com.ventoelectrics.thermometer.Thermometer;
import com.ventoelectrics.thermoregulator.Thermoregulator;

public class WaterHeater {

    private PowerSwitch powerSwitch;

    private Heater heater;

    private Thermometer thermometer;

    private Thermoregulator thermoregulator;

    public WaterHeater(PowerSwitch powerSwitch, Heater heater, Thermometer thermometer, Thermoregulator thermoregulator) {
        this.powerSwitch = powerSwitch;
        this.heater = heater;
        this.thermometer = thermometer;
        this.thermoregulator = thermoregulator;

        this.powerSwitch.controlPowerFor(heater);
        this.powerSwitch.controlPowerFor(thermometer);
        this.powerSwitch.controlPowerFor(thermoregulator);
    }

    public PowerSwitch getPowerSwitch() {
        return powerSwitch;
    }

    public Thermoregulator getThermoregulator() {
        return thermoregulator;
    }
}
