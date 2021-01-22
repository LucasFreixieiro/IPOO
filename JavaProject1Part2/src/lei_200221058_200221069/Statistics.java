/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

/**
 * Estatísticas Diárias
 *
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */
public class Statistics {

    private UserDB users;

    /**
     * Construtor das Estatisticas
     *
     * @param users Registo de utilizadores
     */
    public Statistics(UserDB users) {
        this.users = users;
    }

    /**
     * Método que corre as estatisticas
     */
    public void Statistics() {

        int isolation = 0;
        int normal = 0;
        int infected = 0;

        for (User user : users.getUsers()) {
            if (null != user.getUserState()) {
                switch (user.getUserState()) {
                    case INFECTED:
                        infected++;
                        break;
                    case ISOLATION:
                        isolation++;
                        break;
                    case NORMAL:
                        normal++;
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println("Infectados: " + infected);
        System.out.println("Em isolamento: " + isolation);
        System.out.println("Em contínuo: " + normal);

        System.out.println("Infectados:");
        for (int i = 0; i < infected; i++) {
            System.out.print("x");
        }
        System.out.println("Em Isolamento:");
        for (int i = 0; i < isolation; i++) {
            System.out.print("x");
        }
        System.out.println("Em Contínuo:");
        for (int i = 0; i < isolation; i++) {
            System.out.print("x");
        }
    }

}
