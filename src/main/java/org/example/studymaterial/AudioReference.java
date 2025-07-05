package org.example.studymaterial;

import java.util.List;

public class AudioReference extends Reference {

    public enum AudioQuality {
        LOW, MEDIUM, HIGH, VERY_HIGH
    }

    private AudioQuality audioQuality;

    public AudioReference(AudioQuality quality) {
        this.audioQuality = quality;
    }

    public AudioQuality getAudioQuality() {
        return audioQuality;
    }

    public void setAudioQuality(AudioQuality audioQuality) {
        this.audioQuality = audioQuality;
    }

    public static AudioQuality audioQualityAdapter(String quality) {
        return switch (quality.toLowerCase()) {
            case "low" -> AudioQuality.LOW;
            case "medium" -> AudioQuality.MEDIUM;
            case "high" -> AudioQuality.HIGH;
            case "very_high" -> AudioQuality.VERY_HIGH;
            default -> null;
        };
    }

    // ✅ Atualizado: método principal com nova estrutura
    public void editAudio(AudioMetadata metadata) {
        applyDetails(metadata.getDetails());
        applyStats(metadata.getStats());
        applyAudioAttributes(metadata);
    }

    private void applyDetails(AudioDetails details) {
        editBasic(details.title(), details.description(), details.link());
        this.setAccessRights(details.accessRights());
        this.setLicense(details.license());
        this.setLanguage(details.language());
    }

    private void applyStats(AudioStats stats) {
        this.setRating(stats.rating());
        this.setViewCount(stats.viewCount());
        this.setShareCount(stats.shareCount());
    }

    private void applyAudioAttributes(AudioMetadata metadata) {
        this.setAudioQuality(metadata.getAudioQuality());
        this.setDownloadable(metadata.isDownloadable());
    }

    // ✅ Atualizado: adaptador para criar AudioMetadata com nova estrutura
    public void editAudioAdapter(List<String> properties, List<Integer> intProperties, AudioQuality audioQuality, boolean isDownloadable) {
        AudioDetails details = new AudioDetails(
                properties.get(0), // title
                properties.get(1), // description
                properties.get(2), // link
                properties.get(3), // accessRights
                properties.get(4), // license
                properties.get(5)  // language
        );

        AudioStats stats = new AudioStats(
                intProperties.get(0), // rating
                intProperties.get(1), // viewCount
                intProperties.get(2)  // shareCount
        );

        AudioMetadata metadata = new AudioMetadata(audioQuality, isDownloadable, details, stats);
        this.editAudio(metadata);
    }

    public void editBasic(String title, String description, String link) {
        this.setTitle(title);
        this.setDescription(description);
        this.setLink(link);
    }
}

