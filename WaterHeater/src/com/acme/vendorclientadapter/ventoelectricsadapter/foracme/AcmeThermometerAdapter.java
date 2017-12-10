package com.acme.vendorclientadapter.ventoelectricsadapter.foracme;

import com.acme.thermoregulator.Thermometer;

public class AcmeThermometerAdapter implements Thermometer {

    private com.ventoelectrics.thermometer.Thermometer thermometer;

    public AcmeThermometerAdapter (com.ventoelectrics.thermometer.Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    @Override
    public Integer getTemperature() {
        return thermometer.getTemperature();
    }
}
