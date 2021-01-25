/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Informações da aula
 *
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
    private int[][] lessonMapStart;
    private int[][] lessonMapEnd;

    /**
     * Construtor
     *
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
     * @return Professor
     */
    public User getTeacher(){
        return teacher;
    }

    /**
     * 
     * @return Sala de aula
     */
    public Classroom getClassroom(){
        return classroom;
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
     *
     * @param attendancesAtStart presenças no inicio da aula
     * @param map mapa da sala com as presenças no inicio da aula
     */
    public void startLesson(UserDB attendancesAtStart, int[][] map) {
        this.attendancesAtStart = attendancesAtStart;
        lessonStart = LocalTime.now();
        lessonMapStart = map;
        this.attendancesAtStart.setIDs();
    }

    /**
     * Método para terminar uma aula
     *
     * @param attendancesAtEnd presenças no fim da aula
     * @param map mapa da sala com as presenças no fim da aula
     */
    public void endLesson(UserDB attendancesAtEnd, int[][] map) {
        /*int size = attendancesAtEnd.getUsers().size();
        ArrayList<User> users = attendancesAtEnd.getUsers();
        for (int i = 0; i < size; i++) {
            users.get(i).getUserID();
        }*/

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
    public int getTotalAttendancesAtStart() {
        if (getAttendancesAtStart() != null) {
            return getAttendancesAtStart().getTotalCount();
        } else {
            return 0;
        }
    }

    /**
     *
     * @return Total de presenças no fim da aula
     */
    public int getTotalAttendancesAtEnd() {
        if (getAttendancesAtEnd() != null) {
            return getAttendancesAtEnd().getTotalCount();
        } else {
            return 0;
        }
    }

    /**
     * Define os Ids recebidos para cada utilizador.
     * Utiliza os ids transmitidos para preencher o array dos ids recebidos
     */
    public void setIDAtStart() {
        String ID;
        LocalDate today;
        User user;
        User user2;
        for(int i=0; i<lessonMapStart.length; i++){
            for(int j=0; j<lessonMapStart[i].length; j++){
                user = getUser(lessonMapStart[i][j], 1);
                if(user != null){
                    ID = UUID.randomUUID().toString();
                    today = LocalDate.now();
                    user.setTransmitedIds(ID, today);
                    //Repetir a repetição do array
                    //Serve para enviar o id parra os alunos na sala de aula
                    for(int z=0; z<lessonMapStart.length; z++){
                        for(int x=0; x<lessonMapStart[z].length; x++){
                            if(z != i && x != j){
                                user2 = getUser(lessonMapStart[z][x], 1);
                                if(i==0){
                                    if(j==0){
                                        if(z == i+1 && x == j+1){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else
                                            user2.setReceivedIDs(ID, today, 5);
                                    }
                                    else if(j<lessonMapStart[i].length - 1){
                                        if(z == )
                                    }
                                }
                            }
                        }
                    }
                }
                

            }
            
            
        }

        /*String ID;
        LocalDate today;
        for (int i = 0; i < users.size(); i++) {
            System.out.println(i);
            ID = UUID.randomUUID().toString();
            today = LocalDate.now();
            System.out.println(users.get(i).getUserID());
            users.get(i).setTransmitedIds(ID, today);
            for (int j = 0; j < users.size(); j++) {
                if (i != j) {
                    users.get(j).setReceivedIDs(ID, today);
                }
            }
        }*/
    }

    public User getUser(int number, int mode){
        if(mode == 1){
            return attendancesAtStart.getUser(String.valueOf(number));
        }
        else if(mode == 2){
            return attendancesAtEnd.getUser(String.valueOf(number));
        }
        else
            return null;
        
    }
}
