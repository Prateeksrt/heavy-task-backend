package srt.heavy.task.repository;

import srt.heavy.task.models.TaskStats;

import java.util.List;

public interface TaskRepo {
    TaskStats add(TaskStats taskStats);

    List<TaskStats> all();

    int getSuccessCount();

    int getFailureCount();

    long getLastResponseTime();

    long getAverageResponseTime();

    List<Long> getLastTenResponseTime();
}
