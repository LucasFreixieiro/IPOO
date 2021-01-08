/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.time.LocalDate;

/**
 * Classe inicial
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */

public class AppStart {

    /**
     * @param args the command line arguments
     */
    //public static User[] users;
    //UserMenu userMenu;
    //AdministrationMenu administrationMenu;
    public static void main(String[] args) {
        //init instances
        InputReader reader = new InputReader();

        UserDB userDB = new UserDB();
        ClassroomDB classroomDB = new ClassroomDB();
        LessonDB lessonDB = new LessonDB();
        HealthOrganizationRecomendations recomendations = new HealthOrganizationRecomendations();

        UserMenu userMenu = new UserMenu(userDB, recomendations);
        AdministrationMenu adminMenu = new AdministrationMenu(userDB, classroomDB);
        HealthOrganizationMenu healthOrganizationMenu = new HealthOrganizationMenu(recomendations, userDB);
        TeacherMenu teacherMenu = new TeacherMenu(lessonDB, userDB);
        
        //declare internal variables
        int option;

        showMainMenu(); //Demonstra o menu principal
        option = reader.getOption("");
        
        //Enquanto a opção for diferente de 0 o programa continuará a correr
        while (option != 0) {
            //Ponte para os métodos correspondentes às opções
            try{
                switch (option) {
                    case 1:
                        Classroom classroom = classroomDB.getClassroom(reader.getText("Nome da sala"));
                        String numberID = reader.getUserID("Número de Utilizador");
                        if (numberID != null && classroom != null) {
                            teacherMenu.run(numberID, classroom);
                        } else {
                            System.out.println("Dados inválidos");
                        }
                        break;
                    case 2:
                        User user = userDB.getUser(reader.getUserID("Número de Utilizador"));
                        if (user != null) {
                            userMenu.run(user);
                        } else {
                            System.out.println("Dados inválidos");
                        }
                        break;
                    case 3:
                        healthOrganizationMenu.run();
                        break;
                    case 4:
                        adminMenu.run();
                        break;
                    default:
                        System.out.println("Opção não reconhecida");
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Erro inesperado");
            }

            //De forma a que a informação não apareça de seguida
            //ao utilizador é pedido que ele insira um enter para continuar o programa
            reader.getText("Prima Enter para continuar");

            //Demonstração do menu e pedido de nova opção
            showMainMenu();
            option = reader.getOption("");
        }
    }

    /**
     * Menu principal
     */
    public static void showMainMenu() {
        System.out.println("\tSistema de rastreio de contactos em sala de aula");
        System.out.println("\t\tBem-vindo!!!");
        System.out.println("Insira a sua opção:");
        System.out.println("1 - Registo de presenças.");
        System.out.println("2 - Área de utilizador.");
        System.out.println("3 - Área da Autoridade de Saúde.");
        System.out.println("4 - Área de administrador.");
        System.out.println("0 - Sair.");
    }
}
