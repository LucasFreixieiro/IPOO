/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.util.ArrayList;

/**
 * Registo de salas de aula
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */
public class ClassroomDB {

    private ArrayList<Classroom> classrooms;

    /**
     * Construtor
     */
    public ClassroomDB() {
        this.classrooms = new ArrayList<>();
    }

    /**
     * 
     * @return Salas de aula
     */
    public ArrayList<Classroom> getClassrooms() {
        return classrooms;
    }

    /**
     * Cria mais uma sala de aula
     * @param classroom Sala de aula a ser adicionada
     */
    public void addClassrooms(Classroom classroom) {
        classrooms.add(classroom);
    }

    /**
     * Remove uma sala de aula
     * @param classroom Sala de aula a ser removida
     */
    public void removeClassroom(Classroom classroom) {
        classrooms.remove(classroom);
    }

    /**
     * Obtem uma sala de aula com um determinado nome
     * @param name Nome da sala de aula
     * @return Sala com nome igual ao do parametro
     */
    public Classroom getClassroom(String name) {
        for (Classroom classroom : classrooms) {
            if (classroom.getName().equalsIgnoreCase(name)) {
                return classroom;
            }
        }
        System.out.println("Sala inválida");
        return null;
    }

    /**
     * Verifica se sala já existe
     * @param name Nome da sala de aula a verificar
     * @return Verdadeiro se a sala de aula já existe/ Falso se não existe
     */
    public boolean verifyClassroom(String name) {
        for (Classroom classroom : classrooms) {
            if (classroom.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
