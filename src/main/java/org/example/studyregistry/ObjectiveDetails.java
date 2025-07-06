package org.example.studyregistry;

public record ObjectiveDetails(
        String name,
        String title,
        String description,
        String topic,
        String objectiveInOneLine,
        String objectiveFullDescription,
        String motivation
) {}
