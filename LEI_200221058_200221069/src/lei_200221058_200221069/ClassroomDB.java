/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import org.apache.commons.lang3.ArrayUtils;

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
    
    public void addClassrooms(Classroom classroom){
        classrooms = ArrayUtils.add(classrooms, classroom);
    }
    
    public void removeClassroom(String name){
        for(Classroom classroom : classrooms){
            if(classroom.getName().equalsIgnoreCase(name)){
                classrooms = ArrayUtils.removeElement(classrooms, classroom);
                return;
            }
        }
    }
}
