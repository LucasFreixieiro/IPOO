/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.util.ArrayList;

/**
 * Área da organização de saúde
 *
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */
public class HealthOrganizationMenu {

    private HealthOrganizationRecommendations recommendation;
    private InputReader reader;
    private Statistics statistics;
    private UserDB userDB;

    /**
     * Construtor
     *
     * @param recommendation Registo de Recomendações
     * @param userDB Registo de Utilizadores
     */
    public HealthOrganizationMenu(HealthOrganizationRecommendations recommendation, UserDB userDB) {
        reader = new InputReader();
        this.recommendation = recommendation;
        statistics = new Statistics(userDB);
        this.userDB = userDB;
    }

    /**
     * Corre o Menu da organização de saúde Aqui é onde é dividido todo o
     * processo da organização
     */
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
                    statistics.run();
                    break;
                }
                case 3: {
                    showAddRecommendationMenu();
                    break;
                }
                case 4: {
                    showEditRecommendationMenu();
                    break;
                }
                case 5: {
                    showRemoveRecommendationMenu();
                    break;
                }
                case 6: {
                    recommendation.listRecommendations();
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

    /**
     * Menu da organização
     */
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

    /**
     * Menu para escolher o estado para que queremos editar/adicionar/remover
     * uma recomendação
     */
    public void chooseState() {
        System.out.println("Insira a sua opção:");
        System.out.println("1 - Em Isolamento");
        System.out.println("2 - Infectado");
        System.out.println("3 - Em Continuo");
    }

    /**
     * Adicionar uma recomendação de acordo com o estado
     */
    public void showAddRecommendationMenu() {
        int option;
        do {
            System.out.println("Escolha para que tipo de utilizadores quer adicionar a sua recomendação:");
            chooseState();
            System.out.println("4 - Para todos os utilizadores.");
            System.out.println("0 - Sair");
            option = reader.getOption("");
            if (option != 0) {
                String recommendations = reader.getText("Recomendação");
                switch (option) {
                    case 1:
                        recommendation.newRecommendationForIsolation(recommendations);
                        System.out.println("A sua recomendação foi adicionada.");
                        break;
                    case 2:
                        recommendation.newRecommendationForInfected(recommendations);
                        System.out.println("A sua recomendação foi adicionada.");
                        break;
                    case 3:
                        recommendation.newRecommendationForNormal(recommendations);
                        System.out.println("A sua recomendação foi adicionada.");
                        break;
                    case 4:
                        recommendation.newRecommendation(recommendations);
                        System.out.println("A sua recomendação foi adicionada.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }
        } while (option != 0);
    }

    /**
     * Remoção de uma recomendação
     */
    public void showRemoveRecommendationMenu() {
        int option;
        int remove;
        do {
            System.out.println("Escolha para que tipo de utilizadores quer remover a sua recomendação:");
            chooseState();
            System.out.println("0 - Sair");
            option = reader.getOption("");
            if (option != 0) {
                switch (option) {
                    case 1:
                        recommendation.listRecommendationsIsolation();
                        remove = reader.getOption("Introduza o número");
                        recommendation.removeRecommendationForIsolation(remove);
                        break;
                    case 2:
                        recommendation.listRecommendationsInfected();
                        remove = reader.getOption("Introduza o número");
                        recommendation.removeRecommendationForInfected(remove);
                        break;
                    case 3:
                        recommendation.listRecommendationsNormal();
                        remove = reader.getOption("Introduza o número");
                        recommendation.removeRecommendationForNormal(remove);
                        break;
                    default:
                        System.out.println("Essa recomendação não existe.");
                        break;
                }
            }
        } while (option != 0);
    }

    /**
     * Edição de uma recomendação
     */
    public void showEditRecommendationMenu() {
        chooseState();
        System.out.println("0 - Sair");
        int state = reader.getOption("");
        switch (state) {
            case 1:
                recommendation.listRecommendationsIsolation();
                break;
            case 2:
                recommendation.listRecommendationsInfected();
                break;
            case 3:
                recommendation.listRecommendationsNormal();
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
        int option = reader.getOption("Introduza o número");
        recommendation.editRecommendation(option, state);
    }

    /**
     * Enviar a lista com os ids infetados para os utilizadores Se se
     * encontrarem estes ids nos ids recebidos o utilizador entrará
     * automáticamente em quarentena
     */
    public void sendList() {
        if (userDB.getTotalCount() != 0) {
            ArrayList<Id> infectedUsers = userDB.getInfectedIDs();
            //infectedUsers = filterByDay(infectedUsers);
            ArrayList<User> user = userDB.getUsers();
            for (Id infectedUser : infectedUsers) {
                for (User user1 : user) {
                    ArrayList<Id> ids = user1.getReceivedIDs();
                    for (int j = 0; j < ids.size(); j++) {
                        if (ids.get(j).getValue().equals(infectedUser.getValue())) {
                            user1.setUserState(UserState.ISOLATION);
                            return;
                        }
                    }
                }
            }
            userDB.clearInfectedIDs();
            System.out.println("A lista foi enviada.");
        } else {
            System.out.println("Não foram encontrados utilizadores.");
        }
    }

}
