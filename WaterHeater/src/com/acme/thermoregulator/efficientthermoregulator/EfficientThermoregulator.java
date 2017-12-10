package com.acme.thermoregulator.efficientthermoregulator;

import com.acme.thermoregulator.Heater;
import com.acme.thermoregulator.Thermoregulator;
import com.acme.thermoregulator.Thermometer;

import java.util.concurrent.TimeUnit;

public class EfficientThermoregulator implements Thermoregulator, Runnable {

    private Heater heater;
    private Thermometer thermometer;
    private Integer temperatureRegulation;
    private boolean powerEnabled = false;

    public EfficientThermoregulator (Heater heater, Thermometer thermometer) {
        this.heater = heater;
        this.thermometer = thermometer;
    }

    @Override
    public synchronized void run() {
        while (true) {
            if (!powerEnabled) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
            int temperature = thermometer.getTemperature();
            if (temperature > temperatureRegulation) {
                heater.disableHeating();
            } else {
                heater.enableHeating();
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    @Override
    public synchronized void enablePower() {
        powerEnabled = true;
        notifyAll();
    }

    @Override
    public void disablePower() {
        powerEnabled = false;
    }

    @Override
    public void setTemperature(Integer temperatureRegulation) {
        this.temperatureRegulation = temperatureRegulation;
    }
}
