package main;

import main.model.Task;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class TaskController {

    @GetMapping("/tasks/")
    public List<Task> list() {
        return new ArrayList<>(Storage.getAllTasks());
    }

    @PostMapping("/tasks/")
    public int add(Task task) {
        return Storage.addTask(task);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Task task = Storage.getTask(id);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("/tasks/{id}")
    public int updateTask(Task newTask, @PathVariable int id) {
       return Storage.updateTask(newTask, id);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable int id) {
        Storage.deleteTask(id);
    }
}
