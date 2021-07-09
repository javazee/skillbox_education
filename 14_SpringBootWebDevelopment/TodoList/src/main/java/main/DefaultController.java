package main;

import main.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@Controller
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DefaultController {

    @Autowired
    Storage storage;

    @RequestMapping("/")
    public String index(Model model) throws ExecutionException, InterruptedException {
        Iterable<Task> taskIterable = storage.getAllTasks().get();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        model.addAttribute("tasks", tasks);
        model.addAttribute("tasksCount", tasks.size());
        return "index";
    }
}
