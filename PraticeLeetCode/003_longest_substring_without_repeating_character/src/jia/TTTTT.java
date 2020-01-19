package jia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TTTTT {
    public static void main(String[] args) {

        int INVOKE_PERIOD = 1<<1;
        final int[] i = {1};
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                long time = System.currentTimeMillis();
                Date date = new Date();
                date.setTime(time);
                System.out.println("current time  : "+ simpleDateFormat.format(date));


                  if (i[0] ==5) {
                      scheduledExecutorService.shutdownNow();
                  }

                  if (scheduledExecutorService.isShutdown()) {
                      System.out.println("isShutdown :"+ scheduledExecutorService.isShutdown());
                      return;
                  }


                i[0]++;

            }
        },0,INVOKE_PERIOD, TimeUnit.SECONDS);


    }
}
