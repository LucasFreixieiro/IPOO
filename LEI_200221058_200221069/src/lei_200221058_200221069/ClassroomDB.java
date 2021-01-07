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
public class ClassroomDB {

    private Classroom[] classrooms;

    public ClassroomDB() {
        this.classrooms = new Classroom[0];
    }

    public Classroom[] getClassrooms() {
        return classrooms;
    }

    public void addClassrooms(Classroom classroom) {
        Classroom[] newClassroomArray = new Classroom[classrooms.length + 1];
        System.arraycopy(classrooms, 0, newClassroomArray, 0, classrooms.length);
        int j = classrooms.length + 1;
        classrooms = new Classroom[j];
        System.arraycopy(newClassroomArray, 0, classrooms, 0, classrooms.length);
        classrooms[classrooms.length - 1] = classroom;
    }

    public void removeClassroom(Classroom classroom) {
        int index = getArrayIndex(classroom);
        Classroom[] newClassroomArray = new Classroom[classrooms.length - 1];
        System.arraycopy(classrooms, 0, newClassroomArray, 0, index);
        System.arraycopy(classrooms, index + 1, newClassroomArray, index, classrooms.length - index - 1);
        classrooms = new Classroom[classrooms.length - 1];
        System.arraycopy(newClassroomArray, 0, classrooms, 0, newClassroomArray.length);
    }

    public Classroom getClassroom(String name) {
        for (Classroom classroom : classrooms) {
            if (classroom.getName().equalsIgnoreCase(name)) {
                return classroom;
            }
        }
        System.out.println("Sala inválida");
        return null;
    }

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

    public boolean verifyClassroom(String name) {
        for (Classroom classroom : classrooms) {
            if (classroom.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
