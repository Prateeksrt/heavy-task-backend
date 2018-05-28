package srt.heavy.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import srt.heavy.task.models.OverallStats;
import srt.heavy.task.models.TaskStats;
import srt.heavy.task.services.TaskService;

@RestController("task")
@CrossOrigin
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public TaskStats create() {
        return taskService.createTask();
    }

    @RequestMapping(method = RequestMethod.GET)
    public OverallStats all(){
        return taskService.getOverallStats();
    }
}
