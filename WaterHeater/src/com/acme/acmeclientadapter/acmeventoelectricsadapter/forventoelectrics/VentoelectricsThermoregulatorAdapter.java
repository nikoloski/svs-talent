package com.acme.acmeclientadapter.acmeventoelectricsadapter.forventoelectrics;

import com.acme.thermoregulator.Thermoregulator;

public class VentoelectricsThermoregulatorAdapter implements com.ventoelectrics.thermoregulator.Thermoregulator {

    private Thermoregulator thermoregulator;

    public VentoelectricsThermoregulatorAdapter(Thermoregulator thermoregulator) {
        this.thermoregulator = thermoregulator;
    }

    @Override
    public void enablePower() {
        thermoregulator.enablePower();
    }

    @Override
    public void disablePower() {
        thermoregulator.disablePower();
    }

    @Override
    public void setTemperature(Integer temperature) {
        thermoregulator.setTemperature(temperature);
    }
}
