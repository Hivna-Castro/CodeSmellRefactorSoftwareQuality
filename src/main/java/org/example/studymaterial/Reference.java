package org.example.studymaterial;

public abstract class Reference {
    private String title;
    private String description;
    private String link;
    private String accessRights;
    private String license;
    private boolean isDownloadable;
    private int rating;
    private String language;
    private int viewCount;
    private int downloadCount;
    private int shareCount;

    protected Reference(String title, String description, String link, String language, boolean isDownloadable) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.language = language;
        this.isDownloadable = isDownloadable;
        this.rating = 0;
        this.viewCount = 0;
        this.downloadCount = 0;
        this.shareCount = 0;
    }

    public void incrementViewCount() {
        this.viewCount++;
    }

    public void incrementDownloadCount() {
        if (isDownloadable) {
            this.downloadCount++;
        } else {
            throw new UnsupportedOperationException("Download não permitido para esta referência.");
        }
    }

    public void incrementShareCount() {
        this.shareCount++;
    }

    public void rate(int newRating) {
        if (newRating < 0 || newRating > 5) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 5.");
        }
        this.rating = newRating;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getLanguage() {
        return language;
    }

    public boolean getIsDownloadable() {
        return isDownloadable;
    }

    public int getRating() {
        return rating;
    }

    public int getViewCount() {
        return viewCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    protected void setLink(String link) {
        this.link = link;
    }

    protected void setLanguage(String language) {
        this.language = language;
    }

    protected String getAccessRights() {
        return accessRights;
    }

    protected void setAccessRights(String accessRights) {
        this.accessRights = accessRights;
    }

    protected String getLicense() {
        return license;
    }

    protected void setLicense(String license) {
        this.license = license;
    }

    protected void setDownloadable(boolean downloadable) {
        this.isDownloadable = downloadable;
    }

    protected void setRating(int rating) {
        this.rating = rating;
    }

    protected void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    protected void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }
}
