package exercise3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentManager {
    private List<Student> students;
    private List<Course> courses;

    public StudentManager(List<Student> students, List<Course> courses) {
        this.students = students;
        this.courses = courses;
    }

    public Map<String, List<String>> generateStudentDistribution(String courseName) {
        // Find the course by name
        Course targetCourse = courses.stream()
            .filter(course -> course.getName().equals(courseName))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Course not found: " + courseName));

        // Generate distribution map
        Map<String, List<String>> distribution = new HashMap<>();
        
        for (ExerciseGroup group : targetCourse.getExerciseGroups()) {
            List<String> studentInfo = group.getStudents().stream()
                .map(Student::getFormattedInfo)
                .collect(Collectors.toList());
            distribution.put(group.getName(), studentInfo);
        }

        return distribution;
    }
}
