/**
 * CECS 277-07
 * Project 5 - Collections (Part 1)
 * Professor Mimi Opkins
 * @author Ryan Ignasiak, Tina Vu, Matthew Chen
 * 11/09/20
 */
import java.util.PriorityQueue;

public class ToDoList {
    private PriorityQueue<Task> tasks = new PriorityQueue<>();

    /**
     Constructs a ToDoList class with an empty PriorityQueue.
     */
    ToDoList(){}

    /**
     * Adds a new Task object to the PriorityQueue after checking to make sure it doesn't already exist
     * @param t the Task object to be added*/
    public void addTask(Task t) {
        boolean exists = false;
        for (Task k: tasks) {
            if (k.equals(t)) {
                exists = true;
                System.out.println("Task already exists!");
            }
        }
        if (!exists) {
            tasks.add(t);
        }
    }

    /**
     * Creates a Task object from String info and adds it to the PriorityQueue
     * @param s the String of Task object info to be added*/
    public void addTask(String s) {
        if (s.length() < 7) {
            System.out.println("Bad command");
            return;
        }
        boolean exists = false;
        String concat = "";
        String[] arr = s.split(" ");
        try {
            Integer.parseInt(arr[1]);
        }
        catch (NumberFormatException e) {
            System.out.println("The priority must be an integer between 1 and 9.");
            return;
        }
        if (!arr[0].toLowerCase().equals("add")) {
            System.out.println("Bad command");
        }
        else {
            for (int i = 2; i < arr.length; i++) {
                concat += arr[i] + " ";
            }
            Task t = new Task(Integer.parseInt(arr[1]), concat.substring(0, concat.length()-1));
            for (Task k : tasks) {
                if (k.equals(t)) {
                    exists = true;
                    System.out.println("Task already exists!");
                }
            }
            if (!exists) {
                tasks.add(t);
            }
        }
    }

    /**
     * Removes and returns the highest-priority Task object from the PriorityQueue after making sure it isn't empty
     * @return the highest-priority Task object*/
    public String nextTask() {
        if (tasks.peek() != null) {
            return tasks.poll().getDescription();
        } else {
            return "There are no tasks in the list.";
        }
    }

    /**
     * Overrides the toString method
     * @return the PriorityQueue list of Task objects*/
    @Override
    public String toString() {
        String s = "";
        for (Task t: tasks) {
            s += t.getPriority() + " " + t.getDescription() + "\n";
        }
        return s;
    }
}
