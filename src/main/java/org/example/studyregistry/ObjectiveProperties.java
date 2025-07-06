package org.example.studyregistry;

import java.util.List;

public class ObjectiveProperties {

    private final Integer id;
    private final Integer priority;
    private final Integer practicedDays;
    private final int day;
    private final int month;
    private final int year;
    private final ObjectiveDetails details;
    private final Double duration;
    private final boolean isActive;

    private ObjectiveProperties(
            Integer id, Integer priority, Integer practicedDays,
            int day, int month, int year,
            ObjectiveDetails details,
            Double duration, boolean isActive
    ) {
        this.id = id;
        this.priority = priority;
        this.practicedDays = practicedDays;
        this.day = day;
        this.month = month;
        this.year = year;
        this.details = details;
        this.duration = duration;
        this.isActive = isActive;
    }

    public void applyTo(StudyObjective objective) {
        objective.handleSetRegistry(id, details.name(), priority, isActive);
        objective.handleSetTextualInfo(
                details.title(), details.description(), details.topic(),
                details.objectiveInOneLine(), details.objectiveFullDescription(), details.motivation()
        );
        objective.handleSetTime(practicedDays, day, month, year, duration);
    }

    public static class Builder {
        Integer id = 0;
        Integer priority = 0;
        Integer practicedDays = 0;
        int day = 1;
        int month = 1;
        int year = 2000;

        String name = "";
        String title = "";
        String description = "";
        String topic = "";
        String objectiveInOneLine = "";
        String objectiveFullDescription = "";
        String motivation = "";
        Double duration = 0.0;
        boolean isActive = false;

        public Builder fromRawInput(List<Integer> ints, List<String> strings, Double duration, boolean isActive) {
            ObjectiveInputParser.populateBuilder(this, ints, strings, duration, isActive);
            return this;
        }

        public ObjectiveProperties build() {
            ObjectiveDetails details = new ObjectiveDetails(
                    name, title, description, topic,
                    objectiveInOneLine, objectiveFullDescription, motivation
            );

            return new ObjectiveProperties(
                    id, priority, practicedDays,
                    day, month, year,
                    details, duration, isActive
            );
        }
    }
}
