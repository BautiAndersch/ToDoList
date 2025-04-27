import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ToDo {
    private String name;
    private ArrayList<Task> tasks;


    public ToDo(String name) {
        this.name = name;
        this.tasks = JSONUtiles.TaskFromJSON("myToDoList");
    }
    public void addTask(String description)  {
        tasks.add(new Task(description));
    }

    public void updateTask(String description,int index) throws TaskNotFoundException {
        boolean found = false;
        for (Task task : tasks) {
            if (index == task.getId()) {
                task.setDescription(description);
                task.setUpdateDate(LocalDateTime.now());
                found = true;
                break;
            }

        }
        if (!found) {
            throw new TaskNotFoundException("There is no such task");
        }
    }

    public void deleteTask(int index) throws TaskNotFoundException {
        boolean found = false;
        for (int i=0;i<tasks.size();i++){
            if(tasks.get(i).getId() == index){
                tasks.remove(i);
                found = true;
                break;
            }

        }
        if(!found) {
            throw new TaskNotFoundException("There is no such task");
        }
    }
    public String showCompletedTasks(){
        StringBuilder builder = new StringBuilder();
        for (Task task : tasks) {
            if (task.getStatus()==Status.DONE) {
                builder.append(task.getDescription()+"\n");
            }
        }
        return builder.toString();
      }
    public String showTasks(){
        StringBuilder list = new StringBuilder();
        for (Task task : tasks) {
            list.append(task.getDescription()+","+task.getStatus()+","+task.getCreationDate()+"\n");
        }
        return list.toString();
    }

    public String showPendingTasks(){
        StringBuilder list = new StringBuilder();

        for (Task task : tasks){
            if(task.getStatus()==Status.inPROGRESS||task.getStatus()==Status.TODO){
                list.append(task.getDescription()+","+task.getCreationDate()+"\n");
            }
        }
        return list.toString();
    }
    public String list(){
        StringBuilder list = new StringBuilder();
        for (Task task : tasks) {
            list.append(task.getDescription()+task.getCreationDate());
        }
        return list.toString();
    }

    public JSONObject toJSON(){
        JSONObject obj = new JSONObject();
        obj.put("name",name);
        obj.put("tasks",list());
        return obj;
    }
    public JSONArray toJSONArray(){
        JSONArray array = new JSONArray();
        for (Task task : tasks){
            array.put(task.toJSON());
        }
        return array;
    }


}
