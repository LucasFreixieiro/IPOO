/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

/**
 * Registo de salas de aula
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */
public class ClassroomDB {

    private Classroom[] classrooms;

    /**
     * Construtor
     */
    public ClassroomDB() {
        this.classrooms = new Classroom[0];
    }

    /**
     * 
     * @return Salas de aula
     */
    public Classroom[] getClassrooms() {
        return classrooms;
    }

    /**
     * Cria mais uma sala de aula
     * @param classroom Sala de aula a ser adicionada
     */
    public void addClassrooms(Classroom classroom) {
        Classroom[] newClassroomArray = new Classroom[classrooms.length + 1];
        System.arraycopy(classrooms, 0, newClassroomArray, 0, classrooms.length);
        int j = classrooms.length + 1;
        classrooms = new Classroom[j];
        System.arraycopy(newClassroomArray, 0, classrooms, 0, classrooms.length);
        classrooms[classrooms.length - 1] = classroom;
    }

    /**
     * Remove uma sala de aula
     * @param classroom Sala de aula a ser removida
     */
    public void removeClassroom(Classroom classroom) {
        int index = getArrayIndex(classroom);
        Classroom[] newClassroomArray = new Classroom[classrooms.length - 1];
        System.arraycopy(classrooms, 0, newClassroomArray, 0, index);
        System.arraycopy(classrooms, index + 1, newClassroomArray, index, classrooms.length - index - 1);
        classrooms = new Classroom[classrooms.length - 1];
        System.arraycopy(newClassroomArray, 0, classrooms, 0, newClassroomArray.length);
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
     * Obter a posição da sala no array
     * @param classroom sala de aula a procurar
     * @return Posição da sala no aray quando igual à sala do parametro
     */
    public int getArrayIndex(Classroom classroom) {
        int index = 0;
        for (int i = 0; i < classrooms.length; i++) {
            if (classrooms[i].equals(classroom)) {
                index = i;
                break;
            }
        }
        return index;
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
