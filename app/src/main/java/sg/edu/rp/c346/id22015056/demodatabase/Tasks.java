package sg.edu.rp.c346.id22015056.demodatabase;

import androidx.annotation.NonNull;

public class Tasks {
    private int id;
    private String description;
    private String date;

    public Tasks(int id, String description, String date) {
        this.id = id;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Task " + id + ": " + description + " (" + date + ")";
    }
}
