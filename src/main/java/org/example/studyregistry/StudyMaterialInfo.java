package org.example.studyregistry;

import java.util.List;

public class StudyMaterialInfo {
    private String topic;
    private String format;

    public StudyMaterialInfo(String topic, String format) {
        this.topic = topic;
        this.format = format;
    }

    public String getTopic() { return topic; }
    public String getFormat() { return format; }

    public List<String> toList() {
        return List.of(topic, format);
    }
}
