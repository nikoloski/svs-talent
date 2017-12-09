package md;

import md.alarmchannel.ConsoleOutputAlarm;
import md.imagecapturingdevice.ConsoleInputDevice;
import md.motiondetector.MotionDetector;

public class MotionDetectorApplication {

    public static void main (String[] args) {

        System.out.println("Welcome to Darko Nikoloski's Motion Detector Application!");
        System.out.println("A \"Waiting for image:\" will appear on your screen with a 1 second delay for you to input the byte array image.");
        System.out.println("To stop the application type \"exit\" without the quotation marks.");
        System.out.println("The application will start in 3 seconds!\n");

        MotionDetector motionDetector = new MotionDetector(new ConsoleOutputAlarm(), new ConsoleInputDevice());
        Thread motionDetectorThread = new Thread(motionDetector);
        motionDetectorThread.start();
    }

}
