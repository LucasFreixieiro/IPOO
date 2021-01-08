/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

/**
 * Registo de Recomendações
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */
public class HealthOrganizationRecomendations {

    private String[] recomendations;
    private InputReader reader;

    /**
     * Construtor
     */
    public HealthOrganizationRecomendations() {
        reader = new InputReader();
        this.recomendations = new String[0];
    }

    /**
     * 
     * @return Recomendações
     */
    public String[] getRecomendations() {
        return recomendations;
    }

    /**
     * Cria nova recomendação e armazena-a no array redimensionando-o
     */
    public void newRecomendation() {
        String recomendation;
        recomendation = reader.getText("Recomendação");

        String[] newRecomendationArray = new String[recomendations.length + 1];
        System.arraycopy(recomendations, 0, newRecomendationArray, 0, recomendations.length);
        int j = recomendations.length + 1;
        recomendations = new String[j];
        System.arraycopy(newRecomendationArray, 0, recomendations, 0, recomendations.length);
        recomendations[recomendations.length - 1] = recomendation;
    }

    /**
     * Remove uma recomendação do array
     * @param option opção/indice
     */
    public void removeRecomendation(int option) {
        if (option < 0 || option > recomendations.length) {
            System.out.println("Opção não reconhecida");
        } else {
            String[] newRecomendationArray = new String[recomendations.length - 1];
            System.arraycopy(recomendations, 0, newRecomendationArray, 0, option);
            System.arraycopy(recomendations, option + 1, newRecomendationArray, option, recomendations.length - option - 1);
            recomendations = new String[recomendations.length - 1];
            System.arraycopy(newRecomendationArray, 0, recomendations, 0, newRecomendationArray.length);
        }
    }

    /**
     * Edita uma recomendação
     * @param option opção/indice da recomendação
     */
    public void editRecomendation(int option) {
        String newRecomendation;
        newRecomendation = reader.getText("Recomendação");
        recomendations[option] = newRecomendation;
    }

    /**
     * Lista as recomendações no formato de texto
     */
    public void listRecomendations() {
        for (int i = 0; i < recomendations.length; i++) {
            System.out.println(i + " - " + recomendations[i]);
        }
    }
}
