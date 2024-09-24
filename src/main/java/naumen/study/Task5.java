package naumen.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Task5 implements Task{

    private volatile boolean timerIsOn = false;
    private ExecutorService executorService;
    private int remainingTime;

    public Task5(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    @Override
    public void start() {
        if (timerIsOn) {
            System.out.println("Timer is already on");
            return;
        }
        timerIsOn = true;
        executorService = Executors.newSingleThreadExecutor();

        executorService.submit(() -> {
            while (timerIsOn && remainingTime >= 0) {
                System.out.println("Остаток времени: " + remainingTime);
                if (remainingTime == 0) {
                    stop();
                    break;
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                remainingTime--;
            }
        });
    }

    @Override
    public void stop() {
        if (!timerIsOn) {
            System.out.println("No timer is running");
            return;
        }
        timerIsOn = false;
        executorService.shutdownNow();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("Timer did not terminate in time");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Timer stopped");
    }
}

