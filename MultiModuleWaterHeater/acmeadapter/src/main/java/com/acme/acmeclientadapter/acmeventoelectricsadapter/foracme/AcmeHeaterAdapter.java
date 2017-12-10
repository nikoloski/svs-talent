package com.acme.acmeclientadapter.acmeventoelectricsadapter.foracme;

import com.acme.thermoregulator.Heater;

public class AcmeHeaterAdapter implements Heater {

    private com.ventoelectrics.heater.Heater heater;

    public AcmeHeaterAdapter(com.ventoelectrics.heater.Heater heater) {
        this.heater = heater;
    }

    public void enableHeating() {
        heater.startHeating();
    }

    public void disableHeating() {
        heater.stopHeating();
    }
}
