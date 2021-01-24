/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

/**
 * Registo das aulas
 *
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */
public class LessonDB {

    private Lesson[] lessons;

    /**
     * Construtor
     */
    public LessonDB() {
        this.lessons = new Lesson[0];
    }

    /**
     * Obtem as lições que se encontram no array
     *
     * @return Lições
     */
    public Lesson[] getLessons() {
        return lessons;
    }

    /**
     * Adiciona no array, redimensionando-o, uma nova lição
     *
     * @param lesson lição a ser inserida
     */
    public void addLesson(Lesson lesson) {
        Lesson[] newLessonArray = new Lesson[lessons.length + 1];
        System.arraycopy(lessons, 0, newLessonArray, 0, lessons.length);
        int j = lessons.length + 1;
        lessons = new Lesson[j];
        System.arraycopy(newLessonArray, 0, lessons, 0, lessons.length);
        lessons[lessons.length - 1] = lesson;
    }

    /**
     * Obtem uma determindada lição
     *
     * @param ID Número da lição
     * @return lição que contém o mesmo número de lição que o parametro
     */
    public Lesson getLesson(int ID) {
        for (int i = 0; i < lessons.length; i++) {
            if (lessons[i].getID() == ID) {
                return lessons[i];
            }
        }
        System.out.println("Sala inválida");
        return null;
    }

    /**
     * Obtem a posição à qual se encontra uma lição
     *
     * @param lesson Lição a ser verificada
     * @return posição no array da lição igual ao parametro
     */
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

    /**
     * Lista as lições através de texto
     */
    public void listLessons() {
        for (Lesson lesson : lessons) {
            System.out.println("Lição Nº: " + lesson.getID() + "\nTotal de presenças no inicio: " + lesson.getTotalAttendancesAtStart() + "\nTotal de presenças no fim: " + lesson.getTotalAttendancesAtEnd());
        }
    }

    /**
     * Lista as presenças num aula
     *
     * @param option opção escolhida
     */
    public void listAttendances(int option) {
        User[] studentsAtStart;
        User[] studentsAtEnd;

        Lesson lesson = null;
        for (Lesson lesson1 : lessons) {
            if (lesson1.getID() == option) {
                lesson = lesson1;
                break;
            }
        }

        if (lesson != null) {
            int numberOfStudentsAtStart = lesson.getTotalAttendancesAtStart();
            int numberOfStudentsAtEnd = lesson.getTotalAttendancesAtEnd();
            if (numberOfStudentsAtStart > 0) {
                studentsAtStart = lesson.getAttendancesAtStart().getUsers();
                System.out.println("Presenças no inicio da aula: ");
                for (int i = 0; i < numberOfStudentsAtStart; i++) {
                    System.out.println(studentsAtStart[i].getUserID());
                }
            }
            if (numberOfStudentsAtEnd > 0) {
                studentsAtEnd = lesson.getAttendancesAtEnd().getUsers();
                System.out.println("Presenças no fim da aula: ");
                for (int i = 0; i < numberOfStudentsAtEnd; i++) {
                    System.out.println(studentsAtEnd[i].getUserID());
                }
            }
        } else {
            System.out.println("Lição não encontrada");
        }
    }
}
