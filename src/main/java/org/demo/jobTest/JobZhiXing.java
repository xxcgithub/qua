package org.demo.jobTest;

import org.demo.job.XxcJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/9/11
 * Time: 9:15
 */
public class JobZhiXing {
    public static void main(String[] args) throws SchedulerException {
        //1.job  这个是做什么事
        JobDetail build = JobBuilder.newJob(XxcJob.class).withIdentity("key1","job1")
                .usingJobData("key2","job2")
                .build();

        //2.trigger  什么时间做
        Trigger build1 = TriggerBuilder.newTrigger()
                .withIdentity("tri1","tri1")
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(2)).build();

        //3.schedule  整合在什么时间做什么事
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        defaultScheduler.scheduleJob(build,build1);

        //4.启动
        defaultScheduler.start();

    }
}
