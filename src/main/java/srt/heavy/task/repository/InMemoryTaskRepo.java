package srt.heavy.task.repository;

import org.springframework.stereotype.Repository;
import srt.heavy.task.models.TaskStats;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryTaskRepo implements TaskRepo{

    private List<TaskStats> memory;

    public InMemoryTaskRepo() {
        memory = new ArrayList<>();
    }

    @Override
    public TaskStats add(TaskStats taskStats) {
        memory.add(taskStats);
        return taskStats;
    }

    @Override
    public List<TaskStats> all() {
        return memory;
    }

    @Override
    public int getSuccessCount() {
        return (int) memory.stream()
                .filter(TaskStats::isSuccessful)
                .count();
    }

    @Override
    public int getFailureCount() {
        return (int) memory.stream()
                .filter(t -> !t.isSuccessful())
                .count();
    }

    @Override
    public long getLastResponseTime() {
        return memory.stream()
                .sorted(Comparator.comparing(TaskStats::getTimeStamp))
                .limit(1)
                .findFirst()
                .map(TaskStats::getResponseTime)
                .orElse(-1L);
    }

    @Override
    public long getAverageResponseTime() {
        return memory.stream()
                .map(TaskStats::getResponseTime)
                .reduce((a,b) -> a+b)
                .orElse(0L)/ memory.size();
    }

    @Override
    public List<Long> getLastTenResponseTime() {
        return memory.stream()
                .sorted(Comparator.comparing(TaskStats::getTimeStamp).reversed())
                .limit(10)
                .map(TaskStats::getResponseTime)
                .collect(Collectors.toList());
    }
}
