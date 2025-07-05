package org.example.studymaterial;

public record AudioMetadata(AudioReference.AudioQuality audioQuality, boolean isDownloadable,
                            AudioDetails details,
                            AudioStats stats) {

    public AudioReference.AudioQuality getAudioQuality() {
        return audioQuality;
    }

    public AudioDetails getDetails() {
        return details;
    }

    public AudioStats getStats() {
        return stats;
    }

}