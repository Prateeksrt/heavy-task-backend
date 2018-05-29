package srt.heavy.task.repository;

import org.springframework.stereotype.Repository;
import srt.heavy.task.models.TaskStats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryTaskRepo implements TaskRepo{

    private List<TaskStats> memory;
    private int limit;

    public InMemoryTaskRepo() {
        memory = new ArrayList<>();
        limit = 50;
    }

    @Override
    public TaskStats add(TaskStats taskStats) {
        memory.add(taskStats);
        if (memory.size() > limit)
            memory.remove(1);
        return taskStats;
    }

    @Override
    public List<TaskStats> all() {
        return memory;
    }

    @Override
    public int getSuccessCount() {
        if(memory.size() == 0)
            return 0;
        return (int) memory.stream()
                .filter(TaskStats::isSuccessful)
                .count();
    }

    @Override
    public int getFailureCount() {
        if(memory.size() == 0)
            return 0;
        return (int) memory.stream()
                .filter(t -> !t.isSuccessful())
                .count();
    }

    @Override
    public long getLastResponseTime() {
        if(memory.size() == 0)
            return 0;
        return memory.stream()
                .sorted(Comparator.comparing(TaskStats::getTimeStamp))
                .limit(1)
                .findFirst()
                .map(TaskStats::getResponseTime)
                .orElse(-1L);
    }

    @Override
    public long getAverageResponseTime() {
        if(memory.size() == 0)
            return 0;
        return memory.stream()
                .map(TaskStats::getResponseTime)
                .reduce((a,b) -> a+b)
                .orElse(0L)/ memory.size();
    }

    @Override
    public List<Long> getLastTenResponseTime() {
        if(memory.size() == 0)
            return Collections.emptyList();
        return memory.stream()
                .sorted(Comparator.comparing(TaskStats::getTimeStamp).reversed())
                .limit(10)
                .map(TaskStats::getResponseTime)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        memory.clear();
    }
}
