package org.example.studyregistry;

import java.util.ArrayList;
import java.util.List;

public class StudyTaskManager {
    private static StudyTaskManager instance;
    private StudyMaterial studyMaterial = StudyMaterial.getStudyMaterial();
    List<Registry> registryList;
    List<String> weekResponsibilities = List.of();

    private StudyTaskManager(){
        this.registryList = new ArrayList<Registry>();
    }

    public static StudyTaskManager getStudyTaskManager(){
        if (instance == null) {
            instance = new StudyTaskManager();
        }
        return instance;
    }

    public List<String> getWeekResponsibilities() {
        return weekResponsibilities;
    }

    public void addRegistry(Registry registry){
        registryList.add(registry);
    }

    public List<String> searchInRegistries(String text){
        List<String> response = new ArrayList<>();
        for(Registry registry : registryList){
            String mix = (registry.getName() != null ? registry.getName() : "");
            if (mix.toLowerCase().contains(text.toLowerCase())){
                response.add(registry.getName());
            }
        }
        return response;
    }

    public void setUpWeek(String planName, WeeklyObjective objective, StudyMaterialInfo material,
                          StudyReminder reminder, MainTask mainTask) {
        this.weekResponsibilities = new ArrayList<>();
        this.weekResponsibilities.add(planName);
        this.weekResponsibilities.addAll(objective.toList());
        this.weekResponsibilities.addAll(material.toList());
        this.weekResponsibilities.addAll(reminder.toList());
        this.weekResponsibilities.addAll(mainTask.toList());
    }

    public void handleSetUpWeek(List<String> stringProperties) {
        String planName = stringProperties.get(0);

        WeeklyObjective objective = new WeeklyObjective(
                stringProperties.get(1), stringProperties.get(2), stringProperties.get(5)
        );

        StudyMaterialInfo material = new StudyMaterialInfo(
                stringProperties.get(3), stringProperties.get(4)
        );

        StudyReminder reminder = new StudyReminder(
                stringProperties.get(6), stringProperties.get(7)
        );

        MainTask mainTask = new MainTask(
                stringProperties.get(8), stringProperties.get(9), stringProperties.get(10)
        );

        setUpWeek(planName, objective, material, reminder, mainTask);
    }
}
