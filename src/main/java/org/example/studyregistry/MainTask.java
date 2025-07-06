package org.example.studyregistry;

import java.util.List;

public class MainTask {
    private String taskTitle;
    private String habit;
    private String cardStudy;

    public MainTask(String taskTitle, String habit, String cardStudy) {
        this.taskTitle = taskTitle;
        this.habit = habit;
        this.cardStudy = cardStudy;
    }

    public String getTaskTitle() { return taskTitle; }
    public String getHabit() { return habit; }
    public String getCardStudy() { return cardStudy; }

    public List<String> toList() {
        return List.of(taskTitle, habit, cardStudy);
    }
}

