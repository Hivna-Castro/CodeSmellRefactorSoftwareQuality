package org.example.studyregistry;

import java.time.LocalDateTime;
import java.util.List;

public class StudyObjective extends Registry {
    private String title;
    private String description;
    private String topic;
    private Integer practicedDays;
    private LocalDateTime startDate;
    private Double duration;
    private String objectiveInOneLine;
    private String objectiveFullDescription;
    private String motivation;

    public StudyObjective(String title, String description) {
        this.title = title;
        this.description = description;
        this.name = title; // herdado de Registry
    }

    public void handleSetRegistry(Integer id, String name, Integer priority, boolean isActive) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.isActive = isActive;
    }

    public void handleSetTextualInfo(String title, String description, String topic,
                                     String objectiveInOneLine, String objectiveFullDescription, String motivation) {
        this.title = title;
        this.description = description;
        this.topic = topic;
        this.objectiveInOneLine = objectiveInOneLine;
        this.objectiveFullDescription = objectiveFullDescription;
        this.motivation = motivation;
    }

    public void handleSetTime(Integer practicedDays, int day, int month, int year, Double duration) {
        this.practicedDays = practicedDays;
        this.duration = duration;
        this.startDate = LocalDateTime.of(year, month, day, 0, 0);
    }

    public int handleSetObjectiveAdapter(List<Integer> intProps, List<String> stringProps, Double duration, boolean isActive) {
        ObjectiveProperties props = new ObjectiveProperties.Builder()
                .fromRawInput(intProps, stringProps, duration, isActive)
                .build();
        props.applyTo(this);
        return intProps.get(0);
    }

    // ✅ Getters exigidos pelos testes
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getTopic() { return topic; }
    public String getObjectiveInOneLine() { return objectiveInOneLine; }
    public String getObjectiveFullDescription() { return objectiveFullDescription; }
    public String getMotivation() { return motivation; }
    public Integer getPracticedDays() { return practicedDays; }
    public LocalDateTime getStartDate() { return startDate; }
    public Double getDuration() { return duration; }
    public boolean isActive() { return isActive; }

    public String getName() { return name; }
    public Integer getId() { return id; }
    public Integer getPriority() { return priority; }

    // Opcional: domínio
    public boolean isLongTermObjective() {
        return duration != null && duration > 30;
    }

    public String getGoalSummary() {
        return title + " — " + (objectiveInOneLine != null ? objectiveInOneLine : "");
    }

    @Override
    public String toString() {
        return "StudyObjective: " + getGoalSummary();
    }
}