package org.example.studyplanner;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ToDo implements PlannerMaterial{
    private Integer id;
    private String title;
    private String description;
    private int priority;

    public ToDo(Integer id, String title, String description, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return MessageFormat.format("[(Priority:{3}) ToDo {0}: {1}, {2}]", id, title, description, priority);
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String formatWithTracks(List<LocalDateTime> tracks) {
        StringBuilder result = new StringBuilder();
        result.append(this.toString()).append("\n");

        if (tracks == null || tracks.isEmpty()) {
            result.append("No tracks found\n");
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            for (LocalDateTime ldt : tracks) {
                result.append(formatter.format(ldt)).append("\n");
            }
        }
        return result.toString();
    }
}
