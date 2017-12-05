import java.util.Scanner;

public class StopWatchApplication {

    public static void main (String[] args) throws InterruptedException {
        System.out.println("Welcome to Darko Nikoloski's StopWatch Application!");
        System.out.println("The commands for using it are the following:");
        System.out.println("\t1. \"start\" - to start the stopwatch;");
        System.out.println("\t2. \"pause\" - to pause the stopwatch;");
        System.out.println("\t3. \"resume\" - to resume the stopwatch;");
        System.out.println("\t4. \"reset\" - to reset the stopwatch;");
        System.out.println("\t5. \"stop\" - to stop the stopwatch.");

        Scanner input = new Scanner(System.in);
        StopWatch sw = new StopWatch();
        Thread swTask = new Thread(sw);
        boolean flag = true;

        swTask.start();

        System.out.print("Your command: ");
        while (flag) {
            int command = input.nextInt();
            switch (command) {
                case 1:
                    sw.start();
                    break;
                case 2:
                    sw.pause();
                    break;
                case 3:
                    sw.resume();
                    break;
                case 4:
                    sw.reset();
                    break;
                case 5:
                    flag = false;
                    swTask.interrupt();
                    System.out.println("Exiting the StopWatch Application.");
                    break;
                default:
                    System.out.println("Invalid input, try again!");
                    break;
            }
        }
    }
}
