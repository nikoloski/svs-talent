package com.acme.thermoregulator;

public interface Thermoregulator extends Runnable {

    public void enablePower();

    public void disablePower();

    public void setTemperature(Integer temperature);

}
