package org.example.studyregistry;

import java.util.List;

public class StudyReminder {
    private String title;
    private String description;

    public StudyReminder(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }

    public List<String> toList() {
        return List.of(title, description);
    }
}
