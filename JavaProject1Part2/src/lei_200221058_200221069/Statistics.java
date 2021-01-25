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
    public void run() {

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

        if ((infected + isolation + normal > 0)) {
            int percentageOfInfected = infected * 100 / (infected + isolation + normal);
            int percentageOfIsolation = isolation * 100 / (infected + isolation + normal);
            int percentageOfNormal = normal * 100 / (infected + isolation + normal);

            System.out.println("Infectados: " + infected);
            System.out.println("Em isolamento: " + isolation);
            System.out.println("Em contínuo: " + normal);

            System.out.println("Infectados: ");

            for (int i = 0; i < percentageOfInfected; i++) {
                System.out.print("|");
            }
            System.out.print(" " + percentageOfInfected + "%");
            System.out.println("\nEm Isolamento:");

            for (int i = 0; i < percentageOfIsolation; i++) {
                System.out.print("|");
            }
            System.out.print(" " + percentageOfIsolation + "%");
            System.out.println("\nEm Contínuo:");

            for (int i = 0; i < percentageOfNormal; i++) {
                System.out.print("|");
            }
            System.out.print(" " + percentageOfNormal + "%");
            System.out.println("");
        } else {
            System.out.println("Não existem utilizadores");
        }
    }
}
