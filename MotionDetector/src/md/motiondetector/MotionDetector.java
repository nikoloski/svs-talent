package md.motiondetector;

public class MotionDetector implements Runnable {

    private Alarm alarm;
    private ImageCapturingDevice imageCapturingDevice;
    private byte[] previousImage;
    private String previousImageString;
    private boolean flag = true;

    public MotionDetector (Alarm alarm, ImageCapturingDevice imageCapturingDevice) {
        this.alarm = alarm;
        this.imageCapturingDevice = imageCapturingDevice;
    }

    @Override
    public void run() {
        previousImage = imageCapturingDevice.getImage();
        previousImageString = formatImage(previousImage);
        if (previousImageString.length() == 0) {
            return;
        }
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            detectChange (previousImageString);
            if (previousImageString.length() == 0) {
                return;
            }
        }
    }

    public void detectChange (String previousImageString) {
        byte[] currentImage = imageCapturingDevice.getImage();
        String currentImageString = formatImage(currentImage);

        if (currentImageString.length() == 0) {
            setPreviousImageString(currentImageString);
            return;
        }

        if (!currentImageString.equals(previousImageString)) {
            alarm.triggerAlarm();
        }

        setPreviousImageString(currentImageString);
    }

    public String formatImage (byte[] image) {
        StringBuilder stringBuilder = new StringBuilder();

        for (byte b : image) {
            stringBuilder.append(b);
        }

        return stringBuilder.toString();
    }

    public void setPreviousImageString(String previousImageString) {
        this.previousImageString = previousImageString;
    }
}
