import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private int id;
    private static int count;
    private String description;
    private Status status;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    public Task( String description) {
        id=count;
        count++;
        this.description = description;
        this.status = Status.TODO;
        this.creationDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    public Task(int id, String description, Status status, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(description, task.description) && status == task.status && Objects.equals(creationDate, task.creationDate) && Objects.equals(updateDate, task.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, status, creationDate, updateDate);
    }


    @Override
    public String
    toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("description", description);
        jsonObject.put("status", status);
        jsonObject.put("creationDate", creationDate);
        jsonObject.put("updateDate", updateDate);
        return jsonObject;
    }

    public JSONArray toJSONArray() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(toJSON());
        return jsonArray;
    }


}
