import java.time.LocalDateTime;
import java.util.ArrayList;

public class ToDo {
    private String name;
    private ArrayList<Task> tasks;

    public ToDo(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }
    public void addTask(String description) throws DuplicateTaskException {
        for (Task task : tasks) {
            if (task.getStatus()==Status.DONE || !task.getDescription().equals(description)) {
                tasks.add(new Task(description));
            } else {
                throw new DuplicateTaskException("task already exists || task already in progress");
            }
        }
    }

    public void updateTask(String description,int index) throws TaskNotFoundException {
        for (Task task : tasks) {
            if(index== task.getId()){
               task.setDescription(description);
               task.setUpdateDate(LocalDateTime.now());
            }
            else {
                throw new TaskNotFoundException("There is no such task");
            }
        }
    }

    public void deleteTask(int index) throws TaskNotFoundException {
        for (int i=0;i<tasks.size();i++){
            if(tasks.get(i).getId() == index){
                tasks.remove(i);
            }
            else {
                throw new TaskNotFoundException("There is no such task");
            }
        }
    }
    public String showCompletedTasks(){
        StringBuilder list = new StringBuilder();
        for (Task task : tasks){
            if(task.getStatus()==Status.DONE){
                list.append(task.getDescription());
            }
        }
        return list.toString();
    }

    public String showTasks(){
        StringBuilder list = new StringBuilder();
        for (Task task : tasks){
            list.append(task.getDescription()+task.getCreationDate());
        }
        return list.toString();
    }

    public String showPendingTasks(){
        StringBuilder list = new StringBuilder();
        for (Task task : tasks){
            if(task.getStatus()==Status.inPROGRESS||task.getStatus()==Status.TODO){
                list.append(task.getDescription()+task.getCreationDate());
            }
        }
        return list.toString();
    }


}
