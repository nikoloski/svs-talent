package com.acme.acmeclientadapter.acmeventoelectricsadapter.foracme;

import com.acme.thermoregulator.Thermometer;

public class AcmeThermometerAdapter implements Thermometer {

    private com.ventoelectrics.thermometer.Thermometer thermometer;

    public AcmeThermometerAdapter (com.ventoelectrics.thermometer.Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    public Integer getTemperature() {
        return thermometer.getTemperature();
    }
}
