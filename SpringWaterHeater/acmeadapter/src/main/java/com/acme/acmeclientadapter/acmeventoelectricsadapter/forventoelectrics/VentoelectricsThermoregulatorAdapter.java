package com.acme.acmeclientadapter.acmeventoelectricsadapter.forventoelectrics;

import com.acme.thermoregulator.Thermoregulator;
import org.springframework.stereotype.Component;

@Component
public class VentoelectricsThermoregulatorAdapter implements com.ventoelectrics.thermoregulator.Thermoregulator {

    private Thermoregulator thermoregulator;
    private Thread thread;

    public VentoelectricsThermoregulatorAdapter(Thermoregulator thermoregulator) {
        this.thermoregulator = thermoregulator;
        thread = new Thread(thermoregulator);
        thread.start();
    }

    public void enablePower() {
        thermoregulator.enablePower();
    }

    public void disablePower() {
        thermoregulator.disablePower();
        thread.interrupt();
    }

    public void setTemperature(Integer temperature) {
        thermoregulator.setTemperature(temperature);
    }
}
