package md.imagecapturingdevice;

import md.motiondetector.ImageCapturingDevice;

import java.util.Scanner;

public class ConsoleInputDevice implements ImageCapturingDevice {

    @Override
    public byte[] getImage() {
        Scanner input = new Scanner(System.in);
        String image;
        System.out.println("Waiting for image: ");
        image = input.nextLine();
        if (image.equals("exit")) {
            return new byte[0];
        }
        byte[] imageBytes = new byte[image.length()];
        for (int i = 0; i < image.length(); i++) {
            imageBytes[i] = ((byte) image.charAt(i));
        }
        return imageBytes;
    }
}
