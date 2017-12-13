package com.acme.acmeclientadapter.acmeventoelectricsadapter.foracme;

import com.acme.thermoregulator.Heater;
import org.springframework.stereotype.Component;

@Component
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
