import java.sql.Date;

public class ToDo {
    private String name;
    private GenericList<Activity> activities;

    public ToDo(String name) {
        this.name = name;
        this.activities = new GenericList<>();
    }
    public void addActivity(Activity activity) {
        activities.add(activity);
    }
    public void addActivity(String title, String description, Date date) {
        activities.add(new Activity(title, description, date));
    }
    public String printActivities() {
        return activities.listElements();
    }
    
}
