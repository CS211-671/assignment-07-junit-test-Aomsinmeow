package ku.cs.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentListTest {

    @Test
    public void testAddNewStudent() {
        StudentList studentlist = new StudentList();
        studentlist.addNewStudent("6610412345", "First");
    }

    @Test
    public void testFindStudentById() {
        StudentList studentlist = new StudentList();
        studentlist.addNewStudent("6610412345", "First");
        assertNotNull(studentlist.findStudentById("6610412345"));
    }

    @Test
    public void testGiveScoreToId() {
        StudentList studentlist = new StudentList();
        studentlist.addNewStudent("6610412345", "First");
        studentlist.giveScoreToId("6610412345", 99);
        assertNotNull("A", studentlist.viewGradeOfId("6610412345"));
    }

    @Test
    public void testViewGradeOfId() {
        StudentList studentlist = new StudentList();
        studentlist.addNewStudent("6610412345", "First", 99);
        assertEquals("A", studentlist.viewGradeOfId("6610412345"));
    }

    @Test
    public void testGetStudents() {
        StudentList studentlist = new StudentList();
        studentlist.addNewStudent("6610412345", "First");
        studentlist.addNewStudent("6610412346", "Khaotung");

        ArrayList<Student> students = studentlist.getStudents();
        assertEquals(2, students.size());

        assertEquals("First", students.get(0).getName());
        assertEquals("Khaotung", students.get(1).getName());
    }
}