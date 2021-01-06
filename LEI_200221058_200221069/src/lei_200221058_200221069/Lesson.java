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
    private UserDB attendances;
    private LocalDate lessonDate;
    private LocalTime lessonStart;
    private LocalTime lessonEnd;

    public Lesson() {
        this.lessonDate = LocalDate.now();
        lessonStart = LocalTime.now();
    }
    
    public void startLesson(){
        lessonStart = LocalTime.now();
    }
    
    public void endLesson(UserDB attendances){
        this.attendances = attendances;
        lessonStart = LocalTime.now();
    }
    
    public UserDB getAttendances() {
        return attendances;
    }
    
}
