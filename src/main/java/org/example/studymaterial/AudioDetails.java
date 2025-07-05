package org.example.studymaterial;

public record AudioDetails(
        String title,
        String description,
        String link,
        String accessRights,
        String license,
        String language
) {
    public boolean isValid() {
        return title != null && !title.isBlank()
                && description != null && !description.isBlank()
                && link != null && link.startsWith("http");
    }
}
