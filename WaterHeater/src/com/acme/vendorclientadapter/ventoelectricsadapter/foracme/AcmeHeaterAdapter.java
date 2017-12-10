package com.acme.vendorclientadapter.ventoelectricsadapter.foracme;

import com.acme.thermoregulator.Heater;

public class AcmeHeaterAdapter implements Heater {

    private com.ventoelectrics.heater.Heater heater;

    public AcmeHeaterAdapter(com.ventoelectrics.heater.Heater heater) {
        this.heater = heater;
    }

    @Override
    public void enableHeating() {
        heater.startHeating();
    }

    @Override
    public void disableHeating() {
        heater.stopHeating();
    }
}
