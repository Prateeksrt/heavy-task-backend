package srt.heavy.task.tasks;

public interface Task<T> {

    boolean execute(T t);
}
