/**
 * CECS 277-07
 * Project 5 - Collections (Part 1)
 * Professor Mimi Opkins
 * @author Ryan Ignasiak, Tina Vu, Matthew Chen
 * 11/09/20
 */
public class Task implements Comparable<Task>{

    private int priority = 0;
    private String description = "";

    /**
     * Constructs a Task object with empty description and priority set to 0
     */
    Task(){}

    /**
     * Constructs a Task objects with the provided parameters
     * @param p an integer representing the priority level
     * @param d a String description of the task
     */
    Task(int p, String d) {
        if (p < 1 || p > 9) {
            System.out.println("Please choose an integer between 1 and 9");
        }
        else {
            priority = p;
            description = d;
        }
    }

    /** Sets the priority level
     * @param p an integer representing the priority level
     */
    public void setPriority(int p) {
        priority = p;
    }

    /** Sets the Task description
     * @param d a String description of the task
     */
    public void setDescription(String d) {
        description = d;
    }

    /**
     * Returns the String description of the task
     * @return the String description'
     */
    public String getDescription() {
        return description;
    }

    /** Returns the priority level
     * @return the priority integer
     */
    public int getPriority() {
        return priority;
    }

    /** Overrides the toString method
     * @return the priority level integer followed by the String description
     */
    public String toString() {
        return "Priority: " + priority + " Description: " + description;
    }

    /** Overrides the hashCode method
     * @return a hashcode integer of the lower case Task object String description*/
    @Override
    public int hashCode() {
        return description.toLowerCase().hashCode();
    }

    /** Overrides the equals method
     * @return a boolean result of the comparison between Task objects using the String description to determine equivalency*/
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Task)) {
            return false;
        }
        Task c = (Task) o;
        if (CharSequence.compare(description.toLowerCase(), c.getDescription().toLowerCase()) == 0) {
            System.out.println("HashCode comparison: " + this.hashCode() + " = " + c.hashCode());
        }
        return CharSequence.compare(description.toLowerCase(), c.getDescription().toLowerCase()) == 0;
    }

    /**
     * Returns an integer result of the comparison between Task object priority integers
     * @return the integer result*/
    public static int compare(Task t, Task k) {
        int x = t.getPriority();
        int y = k.getPriority();
        if (x == y) {
            return 0;
        }
        else if (x > y) {
            return 1;
        }
        else {
            return -1;
        }
    }

    /**
     * Overrides the compareTo method so that the basis for comparison in Task objects is priority level
     * @return the integer result*/
    @Override
    public int compareTo(Task t) {
        return Task.compare(this, t);
    }
}
