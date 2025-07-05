package org.example.studymaterial;

public record AudioStats(
        int rating,
        int viewCount,
        int shareCount
) {
    public boolean isPopular() {
        return viewCount > 1000 && rating >= 4;
    }
}
