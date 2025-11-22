package exercise3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentManagerTest {
    private StudentManager studentManager;
    private List<Course> courses;

    @Mock
    private Student mockStudent1;

    @Mock
    private Student mockStudent2;

    @Mock
    private ExerciseGroup mockGroup1;

    @Mock
    private ExerciseGroup mockGroup2;

    @Mock
    private Course mockCourse;

    @BeforeEach
    public void setup() {
        courses = new ArrayList<>();
        studentManager = new StudentManager(new ArrayList<>(), courses);
    }

    @Test
    public void testGenerateStudentDistribution_Success() {
        // Arrange - Mock student behavior
        when(mockStudent1.getFormattedInfo()).thenReturn("Alice (A123)");
        when(mockStudent2.getFormattedInfo()).thenReturn("Bob (B456)");

        // Arrange - Mock group behavior
        when(mockGroup1.getName()).thenReturn("Group 1");
        when(mockGroup1.getStudents()).thenReturn(List.of(mockStudent1));

        when(mockGroup2.getName()).thenReturn("Group 2");
        when(mockGroup2.getStudents()).thenReturn(List.of(mockStudent2));

        // Arrange - Mock course behavior
        when(mockCourse.getName()).thenReturn("Software Engineering");
        when(mockCourse.getExerciseGroups()).thenReturn(List.of(mockGroup1, mockGroup2));

        // Act
        courses.add(mockCourse);
        Map<String, List<String>> distribution =
            studentManager.generateStudentDistribution("Software Engineering");

        // Assert
        assertEquals(2, distribution.size());
        assertTrue(distribution.containsKey("Group 1"));
        assertTrue(distribution.containsKey("Group 2"));
        assertEquals(List.of("Alice (A123)"), distribution.get("Group 1"));
        assertEquals(List.of("Bob (B456)"), distribution.get("Group 2"));

        // Verify that methods were called on mocks
        verify(mockCourse).getName();
        verify(mockCourse).getExerciseGroups();
        verify(mockGroup1).getName();
        verify(mockGroup1).getStudents();
        verify(mockGroup2).getName();
        verify(mockGroup2).getStudents();
        verify(mockStudent1).getFormattedInfo();
        verify(mockStudent2).getFormattedInfo();
    }

    @Test
    public void testGenerateStudentDistribution_CourseNotFound() {
        // Arrange - Mock course with different name
        when(mockCourse.getName()).thenReturn("Object-Oriented Software Engineering");

        // Act
        courses.add(mockCourse);

        // Assert
        assertThrows(IllegalArgumentException.class, () ->
            studentManager.generateStudentDistribution("Software Engineering"));

        // Verify that getName was called during the search
        verify(mockCourse).getName();
    }
}
