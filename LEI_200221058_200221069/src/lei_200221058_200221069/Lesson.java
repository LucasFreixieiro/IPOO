/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Lucas Freixieiro
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

    public Lesson(int ID, User teacher, Classroom classroom) {
        this.ID = ID;
        this.teacher = teacher;
        this.classroom = classroom;
        this.lessonDate = LocalDate.now();
        lessonStart = LocalTime.now();
    }

    public int getID() {
        return ID;
    }

    public LocalDate getLessonDate() {
        return lessonDate;
    }

    public LocalTime getLessonStart() {
        return lessonStart;
    }

    public LocalTime getLessonEnd() {
        return lessonEnd;
    }
    
    public void startLesson(UserDB attendancesAtStart){
        this.attendancesAtStart = attendancesAtStart;
        lessonStart = LocalTime.now();
        this.attendancesAtStart.setIDs();
    }
    
    public void endLesson(UserDB attendancesAtEnd){
        int size = attendancesAtEnd.getUsers().length;
        User[] users = attendancesAtEnd.getUsers();
        for(int  i=0; i<size;i++){
            users[i].getUserID();
        }
        this.attendancesAtEnd = attendancesAtEnd;
        lessonEnd = LocalTime.now();
        this.attendancesAtEnd.setIDs();
    }
    
    public UserDB getAttendancesAtStart() {
        return attendancesAtStart;
    }
    
    public UserDB getAttendancesAtEnd() {
        return attendancesAtEnd;
    }
    
    public int getTotalAttendancesAtStart(){
        if(getAttendancesAtStart() != null)
            return getAttendancesAtStart().getTotalCount();
        else
            return 0;
    }
    
    public int getTotalAttendancesAtEnd(){
        if(getAttendancesAtEnd() != null)
            return getAttendancesAtEnd().getTotalCount();
        else
            return 0;
    }
}
