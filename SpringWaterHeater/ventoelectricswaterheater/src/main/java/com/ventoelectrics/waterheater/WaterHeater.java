package com.ventoelectrics.waterheater;

import com.ventoelectrics.heater.Heater;
import com.ventoelectrics.powerswitch.PowerSwitch;
import com.ventoelectrics.thermometer.Thermometer;
import com.ventoelectrics.thermoregulator.Thermoregulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class WaterHeater {

    private PowerSwitch powerSwitch;
    private Heater heater;
    private Thermometer thermometer;
    private Thermoregulator thermoregulator;

    @Autowired
    public WaterHeater(PowerSwitch powerSwitch, Heater heater, Thermometer thermometer, Thermoregulator thermoregulator) {
        this.powerSwitch = powerSwitch;
        this.heater = heater;
        this.thermometer = thermometer;
        this.thermoregulator = thermoregulator;

        this.powerSwitch.controlPowerFor(heater);
        this.powerSwitch.controlPowerFor(thermometer);
        this.powerSwitch.controlPowerFor(thermoregulator);
    }

    public void simulateRun () {
        thermoregulator.setTemperature(20);
        powerSwitch.turnOn();


        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
        }

        thermoregulator.setTemperature(40);

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
        }

        powerSwitch.turnOff();
    }
}
