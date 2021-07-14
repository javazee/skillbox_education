package main;

import main.model.Task;
import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class DefaultController {

    @Autowired
    TaskRepository taskRepository;

    @Value("${company.name}")
    String companyName;

    String currentDate = getCurrentDate();


    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        model.addAttribute("tasks", tasks);
        model.addAttribute("tasksCount", tasks.size());
        model.addAttribute("currentDate", currentDate);
        model.addAttribute("company", companyName);
        return "index";
    }

    public String getCurrentDate() {
        return new SimpleDateFormat("dd.MM.yy").format(new Date());
    }
}
