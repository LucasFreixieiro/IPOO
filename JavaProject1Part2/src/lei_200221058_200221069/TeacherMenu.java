/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.util.ArrayList;

/**
 * Área do professor
 *
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */
public class TeacherMenu {

    private LessonDB lessonDB;
    private UserDB userDB;
    private UserDB attendances;

    private InputReader reader;

    private Lesson lesson;
    private User user;
    private boolean flag;
    private int numberOfLessons;
    private int numberOfStudents;
    private int[][] lessonMap;

    /**
     * Construtor
     *
     * @param lessonDB Registo de lições
     * @param userDB Registo de utilizadores
     */
    public TeacherMenu(LessonDB lessonDB, UserDB userDB) {
        reader = new InputReader();
        this.lessonDB = lessonDB;
        this.userDB = userDB;
        numberOfLessons = 0;
        numberOfStudents = 0;
    }

    /**
     * Método que corre o menu e todas as funções relacionadas com o menu do
     * professor
     *
     * @param user número de utilizador
     * @param classroom Sala de aula
     */
    public void run(User user, Classroom classroom) {
        this.user = user;
        if (user != null && classroom != null && user.isTeacher()) {
            int option;
            lessonMap = classroom.getMap();
            int capacity = classroom.getCapacity();

            attendances = new UserDB();

            showTeacherMenu();

            option = reader.getOption("");
            while (option != 0 || flag) {
                switch (option) {
                    case 1: {
                        setAttendances(lessonMap, capacity);
                        break;
                    }
                    case 2: {
                        if (!flag) {
                            startLesson(classroom);
                        } else {
                            System.out.println("Aula já iniciada");
                        }
                        break;
                    }
                    case 3: {
                        endLesson();
                        break;
                    }
                    case 4: {
                        if (!flag) {
                            listLessons();
                        } else {
                            System.out.println("A aula está a decorrer, logo não pode consultar a lista de aulas.");
                        }
                        break;
                    }
                    case 5: {
                        if (!flag) {
                            listAttendances();
                        } else {
                            System.out.println("A aula está a decorrer, logo não pode consultar a lista de presenças.");
                        }
                        break;
                    }
                    default: {
                        System.out.println("Opção não reconhecida");
                    }
                }
                if (option == 0 && flag) {
                    System.out.println("Não pode sair durante o decorrer de uma aula.");
                }

                //De forma a que a informação não apareça de seguida
                //ao utilizador é pedido que ele insira um enter para continuar o programa
                reader.getText("Prima Enter para continuar");

                //Demonstração do menu e pedido de nova opção
                showTeacherMenu();
                option = reader.getOption("");
            }
        } else if (!user.isTeacher()) {
            System.out.println("Este utilizador não pode aceder ao menu");
        } else if (classroom == null) {
            System.out.println("Não foi seleccionada uma sala.");
        } else {
            System.out.println("Utilizador não existe.");
        }
    }

    /**
     * Menu do Professor
     */
    public void showTeacherMenu() {
        System.out.println("1 - Registar Presenças");
        System.out.println("2 - Iniciar aula");
        System.out.println("3 - Terminar aula");
        System.out.println("4 - Registo de aulas");
        System.out.println("5 - Presenças por aula");
        System.out.println("0 - Sair");
    }

    /**
     * Regista as presenças não podendo ultrapassar a capacidade do parametro
     *
     * @param capacity capacidade da sala de aula
     */
    public void setAttendances(int[][] map, int capacity) {
        int option;

        showAttendanceMenu();
        option = reader.getOption("Opção");

        while (option != 0 && numberOfStudents < capacity) {
            switch (option) {
                case 1: {
                    String numberID = reader.getUserID("Número de Aluno");
                    if(!numberID.equals("#")){
                        User student = userDB.getUser(numberID);
                        if (student != null && (verifyAttendances(student) == false)) {
                            drawMap();
                            String position = reader.getText("Posição do aluno");
                            if(!position.equals("#")){
                                if(setPosition(student, position)){
                                    attendances.addUser(student);
                                    numberOfStudents++;
                                    System.out.println("Foi marcada presença do aluno: " + student.getUserID());
                                }
                                else
                                    System.out.println("Lugar com aluno ou Posição inválida.");
                            }
                            else
                                System.out.println("Saida com sucesso");
                        } else if (verifyAttendances(student) == true) {
                            System.out.println("Já foi marcada presença deste aluno.");
                        } else {
                            System.out.println("Este aluno não existe.");
                        }
                    }
                    
                }
            }
            showAttendanceMenu();
            option = reader.getOption("Opção");
        }
    }

    /**
     * Menu para as presenças
     */
    public void showAttendanceMenu() {
        System.out.println("1 - Marcar presença");
        System.out.println("0 - Sair");
    }

    /**
     * Iniciar aula
     *
     * @param classroom sala de aula
     */
    public void startLesson(Classroom classroom) {
        lesson = new Lesson(numberOfLessons, user, classroom);
        lesson.startLesson(attendances, lessonMap);
        lessonDB.addLesson(lesson);
        flag = true;
        numberOfLessons++;
        System.out.println("Aula iniciada.");
    }

    /**
     * Terminar aula
     */
    public void endLesson() {
        if (flag) {
            lesson.endLesson(attendances, lessonMap);
            flag = false;
            numberOfStudents = 0;
            lessonMap = new int[0][0];
            System.out.println("Aula terminada.");
        } else {
            System.out.println("Não está nenhuma aula a decorrer.");
        }
    }

    /**
     * Listar as presenças Esta opção é feita através de um menu onde serão
     * disponibilizadas as aulas com o seu respetivo número de aula
     */
    public void listAttendances() {
        System.out.println("1 - Ver Aulas");
        System.out.println("0 - Sair");

        int option = reader.getOption("Opção");
        int lesson = 1;
        while (option != 0 && lesson != 0) {
            if (option == 1) {
                listLessons();
                lesson = reader.getOption("Opção");
                if(lesson != 0)
                    lessonDB.listAttendances(lesson - 1);
            }
            System.out.println("1 - Ver Aulas");
            System.out.println("0 - Sair");
            option = reader.getOption("Opção");
        }
    }

    /**
     * Lista as aulas já realizadas
     */
    public void listLessons() {
        lessonDB.listLessons();
    }

    /**
     * Verifica se o aluno que está ser inscrito já foi inscrito
     *
     * @param student Utilizador
     * @return Verdadeiro se já, falso se não
     */
    public boolean verifyAttendances(User student) {
        ArrayList<User> users = attendances.getUsers();
        for (int i = 0; i < numberOfStudents; i++) {
            if (users.get(i).equals(student)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Desenha o mapa da sala comos lugares
     */
    public void drawMap(){
        for(int i=0; i<lessonMap.length; i++){
            for(int j=0;j<lessonMap[i].length; j++){
                //System.out.println(lessonMap[i][j]);
                if(lessonMap[i][j] == 0)
                    System.out.print("|"+ i + "," + j + "| ");
                else
                    System.out.print("|X| ");
            }
            System.out.println("\n");
        }
    }
    
    /**
     * Coloca um aluno numa posição
     * @param student Aluno
     * @param position Mesa em que o aluno se encontra
     * @return Verdadeiro se for definida uma nova posição, Falso se o lugar já está preenchido
     */
    public boolean setPosition(User student, String position){
        String[] options = position.split(",");
        int[] positionMap = new int[2];

        try{
            //Copiar as posições que o utilizador escolheu para um array inteiro estático de 2 posições 
            for(int i=0; i<2; i++){
                positionMap[i] = Integer.parseInt(options[i]);
            }

            if(positionMap[0] < lessonMap.length){
                if(positionMap[1] < lessonMap[positionMap[0]].length){
                    
                    //Verificar a posição
                    if(lessonMap[positionMap[0]][positionMap[1]] == 0){
                        //Atribuir o aluno à posição
                        lessonMap[positionMap[0]][positionMap[1]] = Integer.parseInt(student.getUserID());
                        return true;
                    }
                }  
            }
            return false;
        }
        catch(Exception e){
            return false;
        }
    }
}
