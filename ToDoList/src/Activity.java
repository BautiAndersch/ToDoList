import java.util.Date;
import java.util.Objects;

public class Activity {
    private String title;
    private String description;
    private Date date;
    private Boolean completed;

    public Activity(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(title, activity.title) && Objects.equals(description, activity.description) && Objects.equals(date, activity.date) && Objects.equals(completed, activity.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, date, completed);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", completed=" + completed +
                '}';
    }
}
