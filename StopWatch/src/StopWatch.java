public class StopWatch implements Runnable {

    private int seconds = 0;
    public boolean working = false;
    private boolean paused = true;

    @Override
    public void run() {
        while (true) {
            if (!working) {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
            System.out.println(seconds++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public synchronized void start() {
        if (paused && seconds == 0) {
            working = true;
            paused = false;
            notifyAll();
        } else {
            System.out.println("Stopwatch is either in working state or has been paused, try resuming it.");
        }
    }

    public synchronized void pause() {
        if (working) {
            working = false;
            paused = true;
        } else {
            System.out.println("Stopwatch is already paused, try again with another command.");
        }
    }

    public synchronized void resume() {
        if (paused && seconds > 0) {
            paused = false;
            working = true;
            notifyAll();
        } else {
            System.out.println("Stopwatch is either in working state or it has just been reset, try again with another command.");
        }
    }

    public synchronized void reset() {
        if (paused && seconds > 0) {
            seconds = 0;
        } else {
            System.out.println("Stopwatch is either in working state or it has just been reset, try again with another command.");
        }
    }

}
