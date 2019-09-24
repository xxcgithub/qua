package org.demo.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/9/10
 * Time: 19:29
 */

/**
 * 定义任务类
 */
public class XxcJob implements Job {
    /**
     * 这个方法是任务被触发时，执行的方法
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("方法执行"+new Date());
        System.out.println(context.getJobDetail().getKey().getGroup());
        System.out.println(context.getJobDetail().getKey().getName());
        System.out.println(context.getJobDetail().getKey().getClass());
        System.out.println(context.getJobDetail().getJobDataMap().get("key2"));
        System.out.println(context.getTrigger().getKey().getName());
    }
}
