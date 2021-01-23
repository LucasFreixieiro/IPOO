/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

/**
 * Registo de Recomendações
 *
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */
public class HealthOrganizationRecommendations {

    private String[] recommendationsForIsolation;
    private String[] recommendationsForInfected;
    private String[] recommendationsForNormal;
    private InputReader reader;

    /**
     * Construtor
     */
    public HealthOrganizationRecommendations() {
        reader = new InputReader();
        this.recommendationsForIsolation = new String[0];
        this.recommendationsForInfected = new String[0];
        this.recommendationsForNormal = new String[0];

    }

    /**
     * Cria nova recomendação para quem se encontra no estado Em Isolamento e
     * armazena-a no array redimensionando-o
     *
     * @param recommendation String com a recomendação a armazenar
     */
    public void newRecommendationForIsolation(String recommendation) {
        String[] newRecommendationArray = new String[recommendationsForIsolation.length + 1];
        System.arraycopy(recommendationsForIsolation, 0, newRecommendationArray, 0, recommendationsForIsolation.length);
        int j = recommendationsForIsolation.length + 1;
        recommendationsForIsolation = new String[j];
        System.arraycopy(newRecommendationArray, 0, recommendationsForIsolation, 0, recommendationsForIsolation.length);
        recommendationsForIsolation[recommendationsForIsolation.length - 1] = recommendation;
    }

    /**
     * Cria nova recomendação para quem se encontra no estado Infectado e
     * armazena-a no array redimensionando-o
     *
     * @param recommendation String com a recomendação a armazenar
     */
    public void newRecommendationForInfected(String recommendation) {
        String[] newRecommendationArray = new String[recommendationsForInfected.length + 1];
        System.arraycopy(recommendationsForInfected, 0, newRecommendationArray, 0, recommendationsForInfected.length);
        int j = recommendationsForInfected.length + 1;
        recommendationsForInfected = new String[j];
        System.arraycopy(newRecommendationArray, 0, recommendationsForInfected, 0, recommendationsForInfected.length);
        recommendationsForInfected[recommendationsForInfected.length - 1] = recommendation;
    }

    /**
     * Cria nova recomendação para quem se encontra em estado Contínuo e
     * armazena-a no array redimensionando-o
     *
     * @param recommendation String com a recomendação a armazenar
     */
    public void newRecommendationForNormal(String recommendation) {
        String[] newRecommendationArray = new String[recommendationsForNormal.length + 1];
        System.arraycopy(recommendationsForNormal, 0, newRecommendationArray, 0, recommendationsForNormal.length);
        int j = recommendationsForNormal.length + 1;
        recommendationsForNormal = new String[j];
        System.arraycopy(newRecommendationArray, 0, recommendationsForNormal, 0, recommendationsForNormal.length);
        recommendationsForNormal[recommendationsForNormal.length - 1] = recommendation;
    }

    /**
     * Cria uma nova recomendação para todos os utilizadores e armazena-a nos
     * três arrays redimensionando-os
     *
     * @param recommendation String com a recomendação a armazenar
     */
    public void newRecommendation(String recommendation) {
        newRecommendationForInfected(recommendation);
        newRecommendationForNormal(recommendation);
        newRecommendationForIsolation(recommendation);
    }

    /**
     * Remove uma recomendação do array dos utilizadores com o estado Em
     * Isolamento
     *
     * @param option opção/indice
     */
    public void removeRecommendationForIsolation(int option) {
        if (option < 0 || option > recommendationsForIsolation.length) {
            System.out.println("Essa recomendação não existe");
            reader.getText("Prima Enter para continuar");
        } else {
            String[] newRecommendationArray = new String[recommendationsForIsolation.length - 1];
            System.arraycopy(recommendationsForIsolation, 0, newRecommendationArray, 0, option);
            System.arraycopy(recommendationsForIsolation, option + 1, newRecommendationArray, option, recommendationsForIsolation.length - option - 1);
            recommendationsForIsolation = new String[recommendationsForIsolation.length - 1];
            System.arraycopy(newRecommendationArray, 0, recommendationsForIsolation, 0, newRecommendationArray.length);
            System.out.println("A sua recomendação foi removida");
        }
    }

    /**
     * Remove uma recomendação do array dos utilizadores com o estado Contínuo
     *
     * @param option opção/indice
     */
    public void removeRecommendationForNormal(int option) {
        if (option < 0 || option > recommendationsForNormal.length) {
            System.out.println("Essa recomendação não existe");
            reader.getText("Prima Enter para continuar");
        } else {
            String[] newRecommendationArray = new String[recommendationsForNormal.length - 1];
            System.arraycopy(recommendationsForNormal, 0, newRecommendationArray, 0, option);
            System.arraycopy(recommendationsForNormal, option + 1, newRecommendationArray, option, recommendationsForNormal.length - option - 1);
            recommendationsForNormal = new String[recommendationsForNormal.length - 1];
            System.arraycopy(newRecommendationArray, 0, recommendationsForNormal, 0, newRecommendationArray.length);
            System.out.println("A sua recomendação foi removida");
        }
    }

    /**
     * Remove uma recomendação do array dos utilizadores com o estado Infectado
     *
     * @param option opção/indice
     */
    public void removeRecommendationForInfected(int option) {
        if (option < 0 || option > recommendationsForInfected.length) {
            System.out.println("Essa recomendação não existe");
            reader.getText("Prima Enter para continuar");
        } else {
            String[] newRecommendationArray = new String[recommendationsForInfected.length - 1];
            System.arraycopy(recommendationsForInfected, 0, newRecommendationArray, 0, option);
            System.arraycopy(recommendationsForInfected, option + 1, newRecommendationArray, option, recommendationsForInfected.length - option - 1);
            recommendationsForIsolation = new String[recommendationsForIsolation.length - 1];
            System.arraycopy(newRecommendationArray, 0, recommendationsForIsolation, 0, newRecommendationArray.length);
            System.out.println("A sua recomendação foi removida");
        }
    }

    /**
     * Edita uma recomendação
     *
     * @param option opção/indice da recomendação
     * @param state estado que queremos editar
     */
    public void editRecommendation(int option, int state) {
        String newRecommendation;
        switch (state) {
            case 1:
                if (option < recommendationsForIsolation.length) {
                    newRecommendation = reader.getText("Recomendação");
                    recommendationsForIsolation[option] = newRecommendation;
                    System.out.println("A sua recomendação foi editada.");
                } else {
                    System.out.println("Essa recomendação não existe");
                }
                break;
            case 2:
                if (option < recommendationsForInfected.length) {
                    newRecommendation = reader.getText("Recomendação");
                    recommendationsForInfected[option] = newRecommendation;
                    System.out.println("A sua recomendação foi editada.");
                } else {
                    System.out.println("Essa recomendação não existe");
                }

                break;
            case 3:
                if (option < recommendationsForNormal.length) {
                    newRecommendation = reader.getText("Recomendação");
                    recommendationsForNormal[option] = newRecommendation;
                    System.out.println("A sua recomendação foi editada.");
                } else {
                    System.out.println("Essa recomendação não existe");
                }

                break;
            default:
                System.out.println("Opção não reconhecida");
                break;
        }
    }

    /**
     * Lista as recomendações no formato de texto
     */
    public void listRecommendations() {
        System.out.println("Recomendações para Infectados: ");
        listRecommendationsInfected();

        System.out.println("Recomendações para em contínuo: ");
        listRecommendationsNormal();

        System.out.println("Recomendações para em Isolamento: ");
        listRecommendationsIsolation();

    }

    /**
     * Lista as recomendações para os usuários infectados
     */
    public void listRecommendationsInfected() {
        for (int i = 0; i < recommendationsForInfected.length; i++) {
            System.out.println(i + " - " + recommendationsForInfected[i]);
        }
    }

    /**
     * Lista as recomendações para os usuários em estado contínuo
     */
    public void listRecommendationsNormal() {
        for (int i = 0; i < recommendationsForNormal.length; i++) {
            System.out.println(i + " - " + recommendationsForNormal[i]);
        }
    }

    /**
     * Lista as recomendações para os usuários em isolamento
     */
    public void listRecommendationsIsolation() {
        for (int i = 0; i < recommendationsForIsolation.length; i++) {
            System.out.println(i + " - " + recommendationsForIsolation[i]);
        }
    }

}
