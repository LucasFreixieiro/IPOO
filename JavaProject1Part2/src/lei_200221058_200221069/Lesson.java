/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Informações da aula
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */

/*
Classe que contém as informações acerca de uma aula
*/
public class Lesson {
    private int ID;
    private User teacher;
    private Classroom classroom;
    private UserDB attendancesAtStart;
    private UserDB attendancesAtEnd;
    private LocalDate lessonDate;
    private LocalTime lessonStart;
    private LocalTime lessonEnd;

    /**
     * Construtor
     * @param ID Identificador da aula
     * @param teacher Utilizador que deu a aula
     * @param classroom Sala de aula
     */
    public Lesson(int ID, User teacher, Classroom classroom) {
        this.ID = ID;
        this.teacher = teacher;
        this.classroom = classroom;
        this.lessonDate = LocalDate.now();
        lessonStart = LocalTime.now();
    }

    /**
     * @return Id da aula
     */
    public int getID() {
        return ID;
    }

    /**
     * 
     * @return Data da aula
     */
    public LocalDate getLessonDate() {
        return lessonDate;
    }

    /**
     * 
     * @return Hora do inicio
     */
    public LocalTime getLessonStart() {
        return lessonStart;
    }

    /**
     * 
     * @return Hora do fim
     */
    public LocalTime getLessonEnd() {
        return lessonEnd;
    }
    
    /**
     * Método para iniciar uma aula
     * @param attendancesAtStart presenças no inicio da aula
     */
    public void startLesson(UserDB attendancesAtStart){
        this.attendancesAtStart = attendancesAtStart;
        lessonStart = LocalTime.now();
        this.attendancesAtStart.setIDs();
    }
    
    /**
     * Método para terminar uma aula
     * @param attendancesAtEnd presenças no fim da aula
     */
    public void endLesson(UserDB attendancesAtEnd){
        int size = attendancesAtEnd.getUsers().size();
        ArrayList<User> users = attendancesAtEnd.getUsers();
        for(int  i=0; i<size;i++){
            users.get(i).getUserID();
        }
        this.attendancesAtEnd = attendancesAtEnd;
        lessonEnd = LocalTime.now();
        this.attendancesAtEnd.setIDs();
    }
    
    /**
     * 
     * @return Presenças no inicio da aula
     */
    public UserDB getAttendancesAtStart() {
        return attendancesAtStart;
    }
    
    /**
     * @return Presenças no fim da aula
     */
    public UserDB getAttendancesAtEnd() {
        return attendancesAtEnd;
    }
    
    /**
     * 
     * @return Total de presenças no inicio da aula
     */
    public int getTotalAttendancesAtStart(){
        if(getAttendancesAtStart() != null)
            return getAttendancesAtStart().getTotalCount();
        else
            return 0;
    }
    
    /**
     * 
     * @return Total de presenças no fim da aula
     */
    public int getTotalAttendancesAtEnd(){
        if(getAttendancesAtEnd() != null)
            return getAttendancesAtEnd().getTotalCount();
        else
            return 0;
    }
}
