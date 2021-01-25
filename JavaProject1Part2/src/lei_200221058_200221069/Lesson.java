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
        setIDAtStart();
    }

    /**
     * Método para terminar uma aula
     *
     * @param attendancesAtEnd presenças no fim da aula
     * @param map mapa da sala com as presenças no fim da aula
     */
    public void endLesson(UserDB attendancesAtEnd, int[][] map) {

        this.attendancesAtEnd = attendancesAtEnd;
        lessonEnd = LocalTime.now();
        this.lessonMapEnd = map;
        setIDAtEnd();
        /*ArrayList<User> users1 = this.attendancesAtEnd.getUsers();
        for(User user1 : users1){
            System.out.println(user1.getUserID());
            System.out.println("Transmitidos:");
            ArrayList<Id> ids = user1.getTransmitedIds();
            for (Id id : ids) {
                System.out.println(id.toString());
            }
            System.out.println("----------");
            System.out.println("Recebidos:");
            ArrayList<Id> ids2 = user1.getReceivedIDs();
            for (Id id : ids2) {
                System.out.println(id.toString());
            }
            System.out.println("----------");
        }*/
        //this.attendancesAtEnd.setIDsAtEnd();
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
                if(lessonMapStart[i][j] != 0){
                    user = getUser(lessonMapStart[i][j], 1);
                    if(user != null){
                        ID = UUID.randomUUID().toString();
                        today = LocalDate.now();
                        user.setTransmitedIds(ID, today);
                        //Repetir a repetição do array
                        //Serve para enviar o id parra os alunos na sala de aula
                        for(int z=0; z<lessonMapStart.length; z++){
                            for(int x=0; x<lessonMapStart[z].length; x++){
                                if(lessonMapStart[z][x] != 0){
                                    if(z != i || x != j){
                                        user2 = getUser(lessonMapStart[z][x], 1);
                                        if(isBelow(z, i) && x == j){
                                            user2.setReceivedIDs(ID, today, 2);
                                        }
                                        else if(isUp(z, i) && x == j){
                                            user2.setReceivedIDs(ID, today, 2);
                                        }
                                        else if(isLeft(x, j) && z == i){
                                            user2.setReceivedIDs(ID, today, 2);
                                        }
                                        else if(isRight(x, j) && z == i){
                                            user2.setReceivedIDs(ID, today, 2);
                                        }
                                        else if(isRight(x, j+1) && z == i){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else if(isLeft(x, j-1) && z == i){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else if(isUp(z, i+1) && x == j){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else if(isBelow(z, i-1) && x == j){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else if(isLeft(x, j) && isUp(z, i)){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else if(isLeft(x, j) && isBelow(z, i)){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else if(isRight(x, j) && isUp(z, i)){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else if(isRight(x, j) && isBelow(z, i)){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else{
                                            user2.setReceivedIDs(ID, today, 5);
                                        }
                                    }
                                }
                            }
                        }
                    }    
                }  
            }
        }
    }

    /**
     * Define os Ids recebidos para cada utilizador.
     * Utiliza os ids transmitidos para preencher o array dos ids recebidos
     */
    public void setIDAtEnd() {
        String ID;
        LocalDate today;
        User user;
        User user2;
        for(int i=0; i<lessonMapEnd.length; i++){
            for(int j=0; j<lessonMapEnd[i].length; j++){
                if(lessonMapEnd[i][j] != 0){
                    user = getUser(lessonMapEnd[i][j], 2);
                    if(user != null){
                        ID = UUID.randomUUID().toString();
                        today = LocalDate.now();
                        user.setTransmitedIds(ID, today);
                        //Repetir a repetição do array
                        //Serve para enviar o id parra os alunos na sala de aula
                        for(int z=0; z<lessonMapEnd.length; z++){
                            for(int x=0; x<lessonMapEnd[z].length; x++){
                                if(lessonMapStart[z][x] != 0){
                                    if(z != i || x != j){
                                        user2 = getUser(lessonMapStart[z][x], 1);
                                        if(isBelow(z, i) && x == j){
                                            user2.setReceivedIDs(ID, today, 2);
                                        }
                                        else if(isUp(z, i) && x == j){
                                            user2.setReceivedIDs(ID, today, 2);
                                        }
                                        else if(isLeft(x, j) && z == i){
                                            user2.setReceivedIDs(ID, today, 2);
                                        }
                                        else if(isRight(x, j) && z == i){
                                            user2.setReceivedIDs(ID, today, 2);
                                        }
                                        else if(isRight(x, j+1) && z == i){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else if(isLeft(x, j-1) && z == i){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else if(isUp(z, i+1) && x == j){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else if(isBelow(z, i-1) && x == j){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else if(isLeft(x, j) && isUp(z, i)){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else if(isLeft(x, j) && isBelow(z, i)){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else if(isRight(x, j) && isUp(z, i)){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else if(isRight(x, j) && isBelow(z, i)){
                                            user2.setReceivedIDs(ID, today, 4);
                                        }
                                        else{
                                            user2.setReceivedIDs(ID, today, 5);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
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

    /**
     * Verifica se a posição que estamos a verificar está embaixo da posição principal 
     * @param currentPosition Posição atual
     * @param mainPosition Posição principal
     * @return Verdadeiro se estiver | Falso se não estiver
     */
    public boolean isBelow(int currentPosition, int mainPosition){
        return currentPosition - mainPosition == 1;
    }

    /**
     * Verifica se a posição que estamos a verificar está emcima da posição principal 
     * @param currentPosition Posição atual
     * @param mainPosition Posição principal
     * @return Verdadeiro se estiver | Falso se não estiver
     */
    public boolean isUp(int currentPosition, int mainPosition){
        return mainPosition - currentPosition == 1;
    }

    /**
     * Verifica se a posição que estamos a verificar está à direita da posição principal 
     * @param currentPosition Posição atual
     * @param mainPosition Posição principal
     * @return Verdadeiro se estiver | Falso se não estiver
     */
    public boolean isLeft(int currentPosition, int mainPosition){
        return mainPosition - currentPosition == 1;
    }

    /**
     * Verifica se a posição que estamos a verificar está à esquerda da posição principal 
     * @param currentPosition Posição atual
     * @param mainPosition Posição principal
     * @return Verdadeiro se estiver | Falso se não estiver
     */
    public boolean isRight(int currentPosition, int mainPosition){
        return currentPosition - mainPosition == 1;
    }

    /**
     * Atribui as presenças no inicio da aula
     * @param attendancesAtStart Presenças no inicio da aula
     */
    public void setAttendancesAtStart(UserDB attendancesAtStart) {
        this.attendancesAtStart = attendancesAtStart;
    }

    /**
     * Atribui as presenças no fim da aula
     * @param attendancesAtStart Presenças no fim da aula
     */
    public void setAttendancesAtEnd(UserDB attendancesAtEnd) {
        this.attendancesAtEnd = attendancesAtEnd;
    }

    
}
