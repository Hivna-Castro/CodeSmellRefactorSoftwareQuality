package org.example.studyregistry;

import java.util.List;

public class WeeklyObjective {
    private String title;
    private String description;
    private String goal;

    public WeeklyObjective(String title, String description, String goal) {
        this.title = title;
        this.description = description;
        this.goal = goal;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getGoal() { return goal; }

    public List<String> toList() {
        return List.of(title, description, goal);
    }
}
