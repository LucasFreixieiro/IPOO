/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lili
 */
public class LessonTest {

    private User teacher = new User("000000000", UserState.NORMAL);
    private User student = new User("200200200", UserState.NORMAL);
    private User student2 = new User("200200201", UserState.NORMAL);
    private Classroom classroom1 = new Classroom("F152", 10);
    private UserDB students = new UserDB();

    public LessonTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of startLesson method, of class Lesson.
     */
    @Test
    public void testStartLesson() {
        students.addUser(student);
        students.addUser(student2);

        Lesson instance = new Lesson(1, teacher, classroom1);
        instance.startLesson(students);
        UserDB users = instance.getAttendancesAtStart();

        for (int i = 0; i < students.getTotalCount(); i++) {
            assertEquals(students.getUsers()[i].getUserID(), users.getUsers()[i].getUserID());
        }

        //assertEquals(instance.getAttendancesAtStart().getTotalCount(),students.getTotalCount());
    }

    /**
     * Test of endLesson method, of class Lesson.
     */
    @Test
    public void testEndLesson() {
        students.addUser(student);
        students.addUser(student2);
        Lesson instance = new Lesson(1, teacher, classroom1);
        instance.endLesson(students);
        UserDB users = instance.getAttendancesAtEnd();

        for (int i = 0; i < students.getTotalCount(); i++) {
            assertEquals(students.getUsers()[i].getUserID(), users.getUsers()[i].getUserID());
        }

    }

    /**
     * Test of getTotalAttendancesAtStart method, of class Lesson.
     */
    @Test
    public void testGetTotalAttendancesAtStart() {
        Lesson instance = new Lesson(1, teacher, classroom1);
        students.addUser(student);
        int expResult = 0;
        int result = instance.getTotalAttendancesAtStart();
        assertEquals(expResult, result);
        instance.startLesson(students);
        result = instance.getTotalAttendancesAtStart();
        expResult = students.getTotalCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalAttendancesAtEnd method, of class Lesson.
     */
    @Test
    public void testGetTotalAttendancesAtEnd() {
        Lesson instance = new Lesson(1, teacher, classroom1);
        students.addUser(student);
        int expResult = 0;
        int result = instance.getTotalAttendancesAtEnd();
        assertEquals(expResult, result);
        instance.endLesson(students);
        result = instance.getTotalAttendancesAtEnd();
        expResult = students.getTotalCount();
        assertEquals(expResult, result);
    }

}
