package com.acme.acmeclientadapter.acmeventoelectricsadapter.forventoelectrics;

import com.acme.thermoregulator.Thermoregulator;

public class VentoelectricsThermoregulatorAdapter implements com.ventoelectrics.thermoregulator.Thermoregulator {

    private Thermoregulator thermoregulator;
    private Thread thread;

    public VentoelectricsThermoregulatorAdapter(Thermoregulator thermoregulator) {
        this.thermoregulator = thermoregulator;
        thread = new Thread(thermoregulator);
        thread.start();
    }

    @Override
    public void enablePower() {
        thermoregulator.enablePower();
    }

    @Override
    public void disablePower() {
        thermoregulator.disablePower();
        thread.interrupt();
    }

    @Override
    public void setTemperature(Integer temperature) {
        thermoregulator.setTemperature(temperature);
    }
}
