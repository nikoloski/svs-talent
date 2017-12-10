package com.acme.acmeclientadapter.acmeventoelectricsadapter.forventoelectrics;

import com.acme.thermoregulator.Thermoregulator;

public class VentoelectricsThermoregulatorAdapter implements com.ventoelectrics.thermoregulator.Thermoregulator {

    private Thermoregulator thermoregulator;

    public VentoelectricsThermoregulatorAdapter(Thermoregulator thermoregulator) {
        this.thermoregulator = thermoregulator;
    }

    public void enablePower() {
        thermoregulator.enablePower();
    }

    public void disablePower() {
        thermoregulator.disablePower();
    }

    public void setTemperature(Integer temperature) {
        thermoregulator.setTemperature(temperature);
    }
}
