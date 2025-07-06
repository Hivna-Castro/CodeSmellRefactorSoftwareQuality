package org.example.studyregistry;

import java.util.List;

public class ObjectiveInputParser {
    public static void populateBuilder(ObjectiveProperties.Builder builder, List<Integer> ints, List<String> strings, Double duration, boolean isActive) {
        extractIntegerFields(builder, ints);
        extractStringFields(builder, strings);
        assignRemainingFields(builder, duration, isActive);
    }

    private static void extractIntegerFields(ObjectiveProperties.Builder builder, List<Integer> ints) {
        builder.id = ints.get(0);
        builder.priority = ints.get(1);
        builder.practicedDays = ints.get(2);
        builder.day = ints.get(3);
        builder.month = ints.get(4);
        builder.year = ints.get(5);
    }

    private static void extractStringFields(ObjectiveProperties.Builder builder, List<String> strings) {
        builder.name = strings.get(0);
        builder.title = strings.get(1);
        builder.description = strings.get(2);
        builder.topic = strings.get(3);
        builder.objectiveInOneLine = strings.get(4);
        builder.objectiveFullDescription = strings.get(5);
        builder.motivation = strings.get(6);
    }

    private static void assignRemainingFields(ObjectiveProperties.Builder builder, Double duration, boolean isActive) {
        builder.duration = duration;
        builder.isActive = isActive;
    }
}
