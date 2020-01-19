package jia;


import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SolutionTest {

    @Test
    public void lengthOfLongestSubstring() {
        Solution solution = new Solution();
        String raws = "pwwkew";
        int result = solution.lengthOfLongestSubstring(raws);
        System.out.println("result : " + result);
    }
      @Test
    public void tt() {
          final int[] i = {0};
          ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
          scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
              @Override
              public void run() {
//                  if (i[0] ==5) {
//                      scheduledExecutorService.shutdownNow();
//                  }
//
//                  if (scheduledExecutorService.isShutdown()) {
//                      System.out.println("isShutdown :"+ scheduledExecutorService.isShutdown());
//                      return;
//                  }

                  System.out.println("YYYYYYYYY");

                  i[0]++;

              }
          },0,1, TimeUnit.SECONDS);




      }



}