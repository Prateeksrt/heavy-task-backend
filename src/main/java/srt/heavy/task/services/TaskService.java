package srt.heavy.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import srt.heavy.task.models.OverallStats;
import srt.heavy.task.models.TaskStats;
import srt.heavy.task.repository.TaskRepo;
import srt.heavy.task.tasks.Task;

import java.util.Date;
import java.util.Random;

@Service
public class TaskService {

    private Task<Long> task;

    private TaskRepo taskRepo;
    private Random random = new Random();

    @Autowired
    public TaskService(TaskRepo taskRepo, Task<Long> task) {
        this.task = task;
        this.taskRepo = taskRepo;
    }

    public TaskStats createTask(){
        long initialTime = System.currentTimeMillis();
        boolean result = task.execute(nextNumber());
        long responseTime = System.currentTimeMillis() - initialTime;
        return taskRepo.add(new TaskStats(
                (int)Math.ceil(responseTime/1000),
                result,
                new Date()));
    }

    private long nextNumber() {
        return (long)random.nextInt(Integer.MAX_VALUE / 2);
    }

    public OverallStats getOverallStats(){
        return new OverallStats(
                taskRepo.getLastResponseTime(),
                taskRepo.getAverageResponseTime(),
                taskRepo.getSuccessCount(),
                taskRepo.getFailureCount(),
                new Date(),
                taskRepo.getLastTenResponseTime());
    }
}
