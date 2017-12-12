package com.acme.thermoregulator.efficientthermoregulator;

import com.acme.thermoregulator.Heater;
import com.acme.thermoregulator.Thermoregulator;
import com.acme.thermoregulator.Thermometer;
import com.ventoelectrics.powerswitch.exception.NoPowerException;

import java.util.concurrent.TimeUnit;

public class EfficientThermoregulator implements Thermoregulator {

    private Heater heater;
    private Thermometer thermometer;
    private Integer temperatureRegulation;
    private boolean powerEnabled = false;

    public EfficientThermoregulator (Heater heater, Thermometer thermometer) {
        this.heater = heater;
        this.thermometer = thermometer;
    }

    public synchronized void run() {
        while (true) {
            if (!powerEnabled) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            try {
                int temperature = thermometer.getTemperature();
                if (temperature > temperatureRegulation) {
                    heater.disableHeating();
                } else {
                    heater.enableHeating();
                }
            } catch (NoPowerException e) {
                continue;
            }
        }
    }

    public synchronized void enablePower() {
        powerEnabled = true;
        notifyAll();
    }

    public void disablePower() {
        powerEnabled = false;
    }

    public void setTemperature(Integer temperatureRegulation) {
        this.temperatureRegulation = temperatureRegulation;
    }
}
