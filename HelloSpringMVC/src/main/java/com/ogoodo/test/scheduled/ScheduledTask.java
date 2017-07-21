package com.ogoodo.test.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class ScheduledTask {
	 @Scheduled(cron="0/15 * * * * ?")//每15秒执行一次
	 public void dosomething(){
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     System.out.println("这是SpringTask定时任务注解版，当前时  间："+sdf.format(new Date()));
	 }
}
