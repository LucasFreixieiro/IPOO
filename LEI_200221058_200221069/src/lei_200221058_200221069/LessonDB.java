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
public class LessonDB {
    private Lesson[] lessons;

    public LessonDB() {
        this.lessons = new Lesson[0];
    }

    public Lesson[] getLessons() {
        return lessons;
    }
    
    public void addLesson(Lesson lesson){
        Lesson[] newLessonArray = new Lesson[lessons.length+1];
        System.arraycopy(lessons, 0, newLessonArray, 0, lessons.length);
        int j = lessons.length + 1;
        lessons = new Lesson[j];
        System.arraycopy(newLessonArray, 0, lessons, 0, lessons.length);
        lessons[lessons.length-1] = lesson;
    }
    
    public Lesson getLesson(int ID){
        for(int i=0; i<lessons.length; i++){
            if(lessons[i].getID() == ID){
                return lessons[i];
            }
        }
        System.out.println("Sala inválida");
        return null;
    }
    
    public int getArrayIndex(Lesson lesson) {
        int index=0;
        for(int i=0;i<lessons.length;i++){
            if(lessons[i].equals(lesson)){
                index=i;
                break;
            }
        }
        return index;
    }
    
    public void listLessons(){
        for(int i=0; i<lessons.length; i++){
            System.out.println("Lição Nº: " + lessons[i].getID() + "\nTotal de presenças no inicio: " + lessons[i].getTotalAttendancesAtStart() + "\nTotal de presenças no fim: " + lessons[i].getTotalAttendancesAtEnd());
        }
    }
    
    public void listAttendances(int option){
        User[] studentsAtStart;
        User[] studentsAtEnd;
        
        Lesson lesson = null;
        for(int i=0; i<lessons.length; i++){
            if(lessons[i].getID() == option){
                lesson = lessons[i];
                break;
            }
        }
        
        if(lesson != null){
            int numberOfStudentsAtStart = lesson.getTotalAttendancesAtStart();
            int numberOfStudentsAtEnd = lesson.getTotalAttendancesAtEnd();
            if(numberOfStudentsAtStart>0){
                studentsAtStart = lesson.getAttendancesAtStart().getUsers();
                System.out.println("Presenças no inicio da aula: ");
                for(int i=0; i<numberOfStudentsAtStart; i++){
                    System.out.println(studentsAtStart[i].getUserID());
                }
            } 
            if(numberOfStudentsAtEnd>0){
                studentsAtEnd = lesson.getAttendancesAtEnd().getUsers(); 
                System.out.println("Presenças no fima da aula: ");
                for(int i=0; i<numberOfStudentsAtEnd; i++){
                    System.out.println(studentsAtEnd[i].getUserID());
                }
            }         
        }
        else
            System.out.println("Lição não encontrada");
        
    }
}
