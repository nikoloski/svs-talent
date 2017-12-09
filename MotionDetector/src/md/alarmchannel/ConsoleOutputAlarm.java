package md.alarmchannel;

import md.motiondetector.Alarm;

public class ConsoleOutputAlarm implements Alarm {

    @Override
    public void triggerAlarm() {
        System.out.println("Alarm");
    }
}
