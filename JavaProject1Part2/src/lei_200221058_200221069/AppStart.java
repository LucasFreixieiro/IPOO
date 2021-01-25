/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

/**
 * Classe inicial
 *
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
        HealthOrganizationRecommendations recommendations = new HealthOrganizationRecommendations();

        UserMenu userMenu = new UserMenu(userDB, recommendations);
        AdministrationMenu adminMenu = new AdministrationMenu(userDB, classroomDB);
        HealthOrganizationMenu healthOrganizationMenu = new HealthOrganizationMenu(recommendations, userDB);
        TeacherMenu teacherMenu = new TeacherMenu(lessonDB, userDB);
        
        User joaoCapinha = new User("000021720", UserState.NORMAL);
        User cedricGrueau = new User("000012619", UserState.NORMAL);
        User paulaMiranda = new User("000003708", UserState.NORMAL);
        User brunoPereira =  new User("000021114", UserState.NORMAL);
        User lilianaSantos = new User("200221058", UserState.NORMAL);
        User lucasFreixieiro = new User("200221069", UserState.NORMAL);
        User joaoCapinha2 = new User("130221070", UserState.NORMAL);
        User joaoCapinha3 = new User("170257012", UserState.NORMAL);
        
        userDB.addUser(joaoCapinha);
        userDB.addUser(cedricGrueau);
        userDB.addUser(paulaMiranda);
        userDB.addUser(brunoPereira);
        userDB.addUser(lilianaSantos);
        userDB.addUser(lucasFreixieiro);
        userDB.addUser(joaoCapinha2);
        userDB.addUser(joaoCapinha3);
        
        recommendations.newRecommendationForInfected("Permaneça em casa.");
        recommendations.newRecommendationForIsolation("Permaneça em casa.");
        recommendations.newRecommendationForInfected("Não receba visitas.");
        recommendations.newRecommendationForIsolation("Não receba visitas.");
        recommendations.newRecommendationForInfected("Monitorize os seus sintomas.");
        recommendations.newRecommendationForIsolation("Monitorize os seus sintomas.");
        recommendations.newRecommendationForIsolation("Se ficar doente, permaneça em casa e ligue para o SNS24 (808 24 24 24)");
        recommendations.newRecommendationForIsolation("Meça a sua temperatura corporal duas vezes ao dia.");
        recommendations.newRecommendation("Lave e desinfecte as mãos com frequência.");
        
        

        //declare internal variables
        int option;

        showMainMenu(); //Demonstra o menu principal
        option = reader.getOption("");

        //Enquanto a opção for diferente de 0 o programa continuará a correr
        while (option != 0) {
            //Ponte para os métodos correspondentes às opções
            try {
                switch (option) {
                    case 1:
                        String classroomName = reader.getText("Nome da sala");
                        if(!classroomName.equals("#")){

                            Classroom classroom = classroomDB.getClassroom(classroomName);
                            
                            while(classroom == null && !classroomName.equals("#")){
                                classroomName = reader.getText("Nome da sala");
                                if(!classroomName.equals("#"))
                                    classroom = classroomDB.getClassroom(classroomName);
                            }

                            if(classroom != null){

                                String numberID = reader.getUserID("Número de Utilizador");      

                                if(!numberID.equals("#")){
                                    
                                    User teacher = userDB.getUser(numberID);
                                    
                                    while(teacher == null && !numberID.equals("#")){
                                        numberID = reader.getUserID("Número de Utilizador"); 
                                        if(!numberID.equals("#"))
                                            teacher = userDB.getUser(numberID);
                                    }

                                    if(teacher != null)
                                        teacherMenu.run(teacher, classroom);
                                    else
                                        exitMessage();
                                }
                                else{
                                    exitMessage();
                                }
                            }
                        }
                        else {
                            exitMessage();
                        }
                        break;
                    case 2:
                        String id = reader.getUserID("Número de Utilizador");
                        if(id.equals("#")){
                            exitMessage();
                        }
                        else{
                            User user = userDB.getUser(id);
                            if (user != null) {
                                userMenu.run(user);
                            } else {
                                System.out.println("Dados inválidos");
                            }
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
            } catch (Exception e) {
                System.out.println("Erro inesperado");
                System.out.println(e);
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

    public static void exitMessage(){
        System.out.println("Saida com sucesso");
    }
}
