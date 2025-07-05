package org.example.studyplanner;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class HabitData {
    private String name;
    private String motivation;
    private int dailyMinutesDedication;
    private int dailyHoursDedication;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int seconds;
    private boolean isConcluded;

    private HabitData(Builder builder) {
        applyBasic(builder);
        applyDate(builder);
    }

    private void applyBasic(Builder builder) {
        this.name = builder.name;
        this.motivation = builder.motivation;
        this.dailyMinutesDedication = builder.dailyMinutesDedication;
        this.dailyHoursDedication = builder.dailyHoursDedication;
        this.isConcluded = builder.isConcluded;
    }

    private void applyDate(Builder builder) {
        this.year = builder.year;
        this.month = builder.month;
        this.day = builder.day;
        this.hour = builder.hour;
        this.minute = builder.minute;
        this.seconds = builder.seconds;
    }

    public static class Builder {
        private String name;
        private String motivation;
        private int dailyMinutesDedication;
        private int dailyHoursDedication;
        private int year;
        private int month;
        private int day;
        private int hour;
        private int minute;
        private int seconds;
        private boolean isConcluded;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder motivation(String motivation) {
            this.motivation = motivation;
            return this;
        }

        public Builder dailyMinutes(int minutes) {
            this.dailyMinutesDedication = minutes;
            return this;
        }

        public Builder dailyHours(int hours) {
            this.dailyHoursDedication = hours;
            return this;
        }

        public Builder dateTime(LocalDateTime dt) {
            this.year = dt.getYear();
            this.month = dt.getMonthValue();
            this.day = dt.getDayOfMonth();
            this.hour = dt.getHour();
            this.minute = dt.getMinute();
            this.seconds = dt.getSecond();
            return this;
        }

        public Builder isConcluded(boolean concluded) {
            this.isConcluded = concluded;
            return this;
        }

        public HabitData build() {
            return new HabitData(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getMotivation() {
        return motivation;
    }

    public boolean isConcluded() {
        return isConcluded;
    }

    public LocalTime getDedicationTime() {
        return LocalTime.of(dailyHoursDedication, dailyMinutesDedication);
    }

    public LocalDateTime getStartDate() {
        return LocalDateTime.of(year, month, day, hour, minute, seconds);
    }
}