package exercise3;

import java.util.List;

public class Course {
    private String name;
    private List<ExerciseGroup> exerciseGroups;

    public Course(String name, List<ExerciseGroup> exerciseGroups) {
        this.name = name;
        this.exerciseGroups = exerciseGroups;
    }

    public String getName() {
        return name;
    }

    public List<ExerciseGroup> getExerciseGroups() {
        return exerciseGroups;
    }
}
