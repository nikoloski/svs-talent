package com;

import com.acme.thermoregulator.efficientthermoregulator.EfficientThermoregulator;
import com.acme.vendorclientadapter.ventoelectricsadapter.foracme.AcmeHeaterAdapter;
import com.acme.vendorclientadapter.ventoelectricsadapter.foracme.AcmeThermometerAdapter;
import com.acme.vendorclientadapter.ventoelectricsadapter.forventoelectrics.VentoelectricsThermoregulatorAdapter;
import com.ventoelectrics.powerswitch.PowerSwitch;
import com.ventoelectrics.thermoregulator.Thermoregulator;
import com.ventoelectrics.heater.Heater;
import com.ventoelectrics.waterheater.WaterHeater;
import com.ventoelectrics.thermometer.Thermometer;

import java.util.concurrent.TimeUnit;

public class WaterHeaterApplication {

    public static void main(String[] args) throws Exception {
        PowerSwitch powerSwitch = new PowerSwitch();
        Heater heater = new Heater();
        Thermometer thermometer = new Thermometer();

        /*//Standard thermoregulator
        StandardThermoregulator standardThermoregulator = new StandardThermoregulator(
                new AcmeHeaterAdapter(heater), new AcmeThermometerAdapter(thermometer));
        Thermoregulator thermoregulator = new VentoelectricsThermoregulatorAdapter(standardThermoregulator);
        Thread thread = new Thread(standardThermoregulator);*/

        //Efficient thermoregulator
        EfficientThermoregulator efficientThermoregulator = new EfficientThermoregulator(
                new AcmeHeaterAdapter(heater), new AcmeThermometerAdapter(thermometer));
        Thermoregulator thermoregulator = new VentoelectricsThermoregulatorAdapter(efficientThermoregulator);
        Thread thread = new Thread(efficientThermoregulator);

        WaterHeater waterHeater = new WaterHeater(powerSwitch, heater, thermometer, thermoregulator);

        simulateRun(waterHeater, thread);
    }

    private static void simulateRun(WaterHeater waterHeater, Thread thread) {
        thread.start();
        waterHeater.getThermoregulator().setTemperature(20);
        waterHeater.getPowerSwitch().turnOn();


        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
        }

        waterHeater.getThermoregulator().setTemperature(40);

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
        }

        waterHeater.getPowerSwitch().turnOff();
        thread.interrupt();
    }
}