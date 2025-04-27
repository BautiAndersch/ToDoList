import org.json.JSONArray;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToDo toDoList = new ToDo("Future proyects");
        Scanner sc = new Scanner(System.in);
        JSONArray jsonArray = new JSONArray();
        int option;

        do {
            System.out.println("WELCOME TO TASKMANAGER by bautiandersch.\n");
            System.out.println("1-Add a task");
            System.out.println("2-Update a task");
            System.out.println("3-Delete a task");
            System.out.println("4-List tasks");
            System.out.println("5-Exit");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Describe your task:");
                    String desc = sc.nextLine();
                    toDoList.addTask(desc);

                    break;

                case 2:
                    System.out.println("Enter the task ID:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the new task description:");
                    String newDesc = sc.nextLine();
                    toDoList.updateTask(newDesc, id);
                    break;

                case 3:
                    System.out.println("Enter the task ID:");
                    int taskID = sc.nextInt();
                    toDoList.deleteTask(taskID);
                    break;

                case 4:
                    System.out.println("How do you want to list your tasks?");
                    System.out.println("1-Completed");
                    System.out.println("2-Pending");
                    System.out.println("3-All");
                    System.out.println("4-Back");
                    int option2 = sc.nextInt();
                    switch (option2) {
                        case 1:
                            System.out.println(toDoList.showCompletedTasks());
                            break;
                        case 2:
                            System.out.println(toDoList.showPendingTasks());
                            break;
                        case 3:
                            System.out.println(toDoList.showTasks());
                            break;
                    }
                    break;

                case 5:
                    System.out.println("Exiting");
                    break;
            }



        } while (option != 5);
        jsonArray = toDoList.toJSONArray();
        JSONUtiles.uploadJSON(jsonArray, "myToDoList");

    }
}