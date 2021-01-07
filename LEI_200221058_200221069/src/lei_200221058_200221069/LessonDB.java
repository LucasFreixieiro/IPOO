/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

/**
 *
 * @author Lucas Freixieiro
 */
public class LessonDB {

    private Lesson[] lessons;

    public LessonDB() {
        this.lessons = new Lesson[0];
    }

    public Lesson[] getLessons() {
        return lessons;
    }

    public void addLesson(Lesson lesson) {
        Lesson[] newLessonArray = new Lesson[lessons.length + 1];
        System.arraycopy(lessons, 0, newLessonArray, 0, lessons.length);
        int j = lessons.length + 1;
        lessons = new Lesson[j];
        System.arraycopy(newLessonArray, 0, lessons, 0, lessons.length);
        lessons[lessons.length - 1] = lesson;
    }

    public Lesson getLesson(int ID) {
        for (int i = 0; i < lessons.length; i++) {
            if (lessons[i].getID() == ID) {
                return lessons[i];
            }
        }
        System.out.println("Sala inválida");
        return null;
    }

    public int getArrayIndex(Lesson lesson) {
        int index = 0;
        for (int i = 0; i < lessons.length; i++) {
            if (lessons[i].equals(lesson)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void listLessons() {
        for (int i = 0; i < lessons.length; i++) {
            System.out.println("Lição Nº: " + lessons[i].getID() + "\nTotal de presenças: " + lessons[i].getTotalAttendances());
        }
    }

    public void listAttendances(int option) {
        Lesson lesson = null;
        for (int i = 0; i < lessons.length; i++) {
            if (lessons[i].getID() == option) {
                lesson = lessons[i];
                break;
            }
        }

        if (lesson != null) {
            int numberOfStudents = lesson.getTotalAttendances();
            User[] students = lesson.getAttendances().getUsers();

            for (int i = 0; i < numberOfStudents; i++) {
                System.out.println(students[i].getUserID());
            }
        } else {
            System.out.println("Lição não encontrada");
        }

    }
}
