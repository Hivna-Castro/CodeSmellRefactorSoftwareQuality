package org.example.studysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchLog {
    private List<String> searchHistory;
    private Map<String, Integer> searchCount;
    private boolean isLocked;
    private int numUsages;
    private String logName;

    public SearchLog(String logName) {
        this.searchHistory = new ArrayList<>();
        this.searchCount = new HashMap<>();
        this.logName = logName;
        this.numUsages = 0;
        this.isLocked = false;
    }

    public void addSearchHistory(String query) {
        if (isLocked) {
            throw new IllegalStateException("Log is locked. Cannot add search.");
        }
        searchHistory.add(query);
        searchCount.put(query, searchCount.getOrDefault(query, 0) + 1);
        numUsages++;
    }

    public List<String> getSearchHistory() {
        return new ArrayList<>(searchHistory);
    }

    public int getNumUsages() {
        return numUsages;
    }

    public String getLogName() {
        return logName;
    }
}
