package org.example.studyplanner;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ToDo implements PlannerMaterial, Comparable<ToDo> {
    private Integer id;
    private String title;
    private String description;
    private int priority;
    private List<LocalDateTime> executionHistory = new ArrayList<>();

    public ToDo(Integer id, String title, String description, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public void addExecutionTime(LocalDateTime dateTime) {
        executionHistory.add(dateTime);
    }

    public String formatExecutionHistory() {
        if (executionHistory.isEmpty()) {
            return "No tracks found\n";
        }
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (LocalDateTime time : executionHistory) {
            sb.append(formatter.format(time)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return MessageFormat.format("[(Priority:{3}) ToDo {0}: {1}, {2}]", id, title, description, priority);
    }

    public boolean matches(String searchTerm) {
        if (searchTerm == null) return false;
        String search = searchTerm.toLowerCase();
        return (title != null && title.toLowerCase().contains(search)) ||
                (description != null && description.toLowerCase().contains(search));
    }

    @Override
    public int compareTo(ToDo other) {
        return Integer.compare(this.priority, other.priority);
    }

    // Getters e Setters permanecem para compatibilidade
    public Integer getId() {
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
}

