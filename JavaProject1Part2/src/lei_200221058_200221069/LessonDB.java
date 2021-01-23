/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.util.ArrayList;

/**
 * Registo das aulas
 *
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */
public class LessonDB {

    private ArrayList<Lesson> lessons;

    /**
     * Construtor
     */
    public LessonDB() {
        this.lessons = new ArrayList<>();
    }

    /**
     * Obtem as lições que se encontram na lista
     *
     * @return Lições
     */
    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    /**
     * Adiciona à lista uma nova lição
     *
     * @param lesson lição a ser inserida
     */
    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    /**
     * Obtem uma determinada lição
     *
     * @param ID Número da lição
     * @return lição que contém o mesmo número de lição que o parametro
     */
    public Lesson getLesson(int ID) {
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).getID() == ID) {
                return lessons.get(i);
            }
        }
        System.out.println("Sala inválida");
        return null;
    }

    /**
     * Lista as lições através de texto
     */
    public void listLessons() {
        for (int i = 0; i < lessons.size(); i++) {
            System.out.println("Lição Nº: " + lessons.get(i).getID() + "\nTotal de presenças no inicio: " + lessons.get(i).getTotalAttendancesAtStart() + "\nTotal de presenças no fim: " + lessons.get(i).getTotalAttendancesAtEnd());
        }
    }

    /**
     * Lista as presenças numa aula
     *
     * @param option opção escolhida
     */
    public void listAttendances(int option) {
        ArrayList<User> studentsAtStart;
        ArrayList<User> studentsAtEnd;

        Lesson lesson = null;
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).getID() == option) {
                lessons.set(i, lessons.get(i));
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
                    System.out.println(studentsAtStart.get(i).getUserID());
                }
            }
            if (numberOfStudentsAtEnd > 0) {
                studentsAtEnd = lesson.getAttendancesAtEnd().getUsers();
                System.out.println("Presenças no fim da aula: ");
                for (int i = 0; i < numberOfStudentsAtEnd; i++) {
                    System.out.println(studentsAtEnd.get(i).getUserID());
                }
            }
        } else {
            System.out.println("Lição não encontrada");
        }

    }
}
