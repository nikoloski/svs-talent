public class NumberPrinterApplication {

    public static void main(String[] args) throws InterruptedException {

        if (args.length == 2) {
            int number = Integer.parseInt(args[0]);
            int interval = Integer.parseInt(args[1]);
            Thread taskThread = new Thread(new NumberPrinter(number));
            taskThread.start();

            taskThread.join(interval);
            taskThread.interrupt();
            
        } else {
            System.out.println("Not enough arguments.");
        }

    }

    public static class NumberPrinter implements Runnable {

        private int number;

        public NumberPrinter (int number) {
            this.number = number;
        }

        @Override
        public void run() {
            for (int i = 1; i <= number; i++) {
                if(Thread.interrupted()) {
                    System.out.println("Time exceeded!");
                    return;
                }
                System.out.println(i);
            }
            System.out.println("Application finished.");
        }
    }

}
