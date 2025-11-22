package exercise3;

import java.util.List;

public class ExerciseGroup {
    private String name;
    private List<Student> students;

    public ExerciseGroup(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }
}
