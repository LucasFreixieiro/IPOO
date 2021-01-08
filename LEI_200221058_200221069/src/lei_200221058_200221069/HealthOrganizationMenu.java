/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.time.LocalDate;

/**
 *
 * @author Lucas Freixieiro
 */
public class HealthOrganizationMenu {

    private HealthOrganizationRecomendations recomendations;
    private InputReader reader;
    private Statistics statistics;
    private UserDB userDB;
    private Id[] infectedUsers;

    public HealthOrganizationMenu(HealthOrganizationRecomendations recomendations, UserDB userDB) {
        reader = new InputReader();
        this.recomendations = recomendations;
        statistics = new Statistics(userDB);
        this.userDB = userDB;
    }

    public void run() {
        int option;
        showHealthOrganizationMenu();

        option = reader.getOption("");
        while (option != 0) {
            switch (option) {
                case 1: {
                    sendList();
                    break;
                }
                case 2: {
                    statistics.Statistics();
                    break;
                }
                case 3: {
                    recomendations.newRecomendation();
                    break;
                }
                case 4: {
                    editRecomendation();
                    break;
                }
                case 5: {
                    removeRecomendation();
                    break;
                }
                case 6: {
                    recomendations.listRecomendations();
                    break;
                }
                default: {
                    System.out.println("Opção não reconhecida");
                    break;
                }
            }

            //De forma a que a informação não apareça de seguida
            //ao utilizador é pedido que ele insira um enter para continuar o programa
            reader.getText("Prima Enter para continuar");

            //Demonstração do menu e pedido de nova opção
            showHealthOrganizationMenu();
            option = reader.getOption("");
        }
    }

    public void showHealthOrganizationMenu() {
        System.out.println("\tSistema de rastreio de contactos em sala de aula");
        System.out.println("\t\tÁrea da organização de Saúde");
        System.out.println("Insira a sua opção:");
        System.out.println("1 - Enviar lista de doentes infetados hoje");
        System.out.println("2 - Ver Estatísticas");
        System.out.println("3 - Nova Recomendação");
        System.out.println("4 - Editar Recomendações");
        System.out.println("5 - Remover Recomendação");
        System.out.println("6 - Listar Recomendações");
        System.out.println("0 - Sair");
    }

    public void removeRecomendation() {
        int option;

        recomendations.listRecomendations();
        option = reader.getOption("Introduza o número");
        recomendations.removeRecomendation(option);
    }

    public void editRecomendation() {
        int option;

        recomendations.listRecomendations();
        option = reader.getOption("Introduza o número");
        recomendations.editRecomendation(option);
    }
    
    public void sendList(){
        if(userDB.getTotalCount() != 0){
            infectedUsers = userDB.getInfectedIDs();
            infectedUsers = filterByDay(infectedUsers);
            User[] user = userDB.getUsers();
            for(int index=0; index<infectedUsers.length; index++){
                for (int i=0; i<user.length; i++){
                    Id[] ids = user[i].getReceivedIDs();
                    for(int j=0; j<ids.length; j++){
                        if(ids[j].getValue().equals(infectedUsers[index].getValue())){
                            user[i].setUserState(UserState.ISOLATION);
                            return;
                        }
                    }
                }
            }
        }
    }
    
    public Id[] filterByDay(Id[] ids){
        if(ids != null){
            LocalDate today = LocalDate.now();
            for(int i=0; i<ids.length; i++){
                if(!(LocalDate.now().equals(today))){
                    ids = removeOldID(i, ids);
                    i--;
                }
            }
            return ids;
        }
        return null;
    }
    public Id[] removeOldID(int index, Id[] ids){
        Id[] newArray = new Id[ids.length - 1];
        System.arraycopy(ids, 0, newArray, 0, index);
        System.arraycopy(ids, index + 1, newArray, index, ids.length - index - 1);
        return newArray;
    }
    
}
