/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.util.ArrayList;

/**
 * Registo de Recomendações
 *
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */
public class HealthOrganizationRecommendations {

    private ArrayList<String> recommendationsForIsolation;
    private ArrayList<String> recommendationsForInfected;
    private ArrayList<String> recommendationsForNormal;
    private InputReader reader;

    /**
     * Construtor
     */
    public HealthOrganizationRecommendations() {
        reader = new InputReader();
        this.recommendationsForIsolation = new ArrayList<>();
        this.recommendationsForInfected = new ArrayList<>();
        this.recommendationsForNormal = new ArrayList<>();

    }

    /**
     * Cria nova recomendação e armazena-a no array redimensionando-o
     *
     * @param recommendation
     */
    public void newRecommendationForIsolation(String recommendation) {
        recommendationsForIsolation.add(recommendation);
    }

    public void newRecommendationForInfected(String recommendation) {
        recommendationsForInfected.add(recommendation);
    }

    public void newRecommendationForNormal(String recommendation) {
        recommendationsForNormal.add(recommendation);
    }

    public void newRecommendation(String recommendation) {
        newRecommendationForInfected(recommendation);
        newRecommendationForNormal(recommendation);
        newRecommendationForIsolation(recommendation);
    }

    /**
     * Remove uma recomendação do array
     *
     * @param option opção/indice
     */
    public void removeRecommendationForIsolation(int option) {
        if (option < 0 || option > recommendationsForIsolation.size()) {
            System.out.println("Essa recomendação não existe");
            reader.getText("Prima Enter para continuar");
        } else {
            recommendationsForIsolation.remove(option);
        }
    }

    public void removeRecommendationForNormal(int option) {
        if (option < 0 || option > recommendationsForNormal.size()) {
            System.out.println("Essa recomendação não existe");
            reader.getText("Prima Enter para continuar");
        } else {
            recommendationsForNormal.remove(option);
        }
    }

    public void removeRecommendationForInfected(int option) {
        if (option < 0 || option > recommendationsForInfected.size()) {
            System.out.println("Essa recomendação não existe");
            reader.getText("Prima Enter para continuar");
        } else {
            recommendationsForInfected.remove(option);
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
                if (option < recommendationsForIsolation.size()) {
                    newRecommendation = reader.getText("Recomendação");
                    if(!newRecommendation.equals("#")){
                        recommendationsForIsolation.set(option, newRecommendation);
                        System.out.println("A sua recomendação foi editada.");
                    }
                    else
                        System.out.println("Saindo com sucesso...");
                } else {
                    System.out.println("Essa recomendação não existe");
                }
                break;
            case 2:
                if (option < recommendationsForInfected.size()) {
                    newRecommendation = reader.getText("Recomendação");
                    if(!newRecommendation.equals("#")){
                        recommendationsForInfected.set(option, newRecommendation);
                        System.out.println("A sua recomendação foi editada.");
                    }
                    else
                        System.out.println("Saindo com sucesso...");
                } else {
                    System.out.println("Essa recomendação não existe");
                }

                break;
            case 3:
                if (option < recommendationsForNormal.size()) {
                    newRecommendation = reader.getText("Recomendação");
                    if(!newRecommendation.equals("#")){
                        recommendationsForNormal.set(option, newRecommendation);
                        System.out.println("A sua recomendação foi editada.");
                    }
                    else
                        System.out.println("Saindo com sucesso...");
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
        System.out.println("0 - Sair");
        listRecommendationsInfected();

        System.out.println("Recomendações para em contínuo: ");
        System.out.println("0 - Sair");
        listRecommendationsNormal();

        System.out.println("Recomendações para em Isolamento: ");
        System.out.println("0 - Sair");
        listRecommendationsIsolation();

    }

    /**
     * Lista as recomendações para os usuários infectados
     */
    public void listRecommendationsInfected() {
        for (int i = 0; i < recommendationsForInfected.size(); i++) {
            System.out.println((i + 1) + " - " + recommendationsForInfected.get(i));
        }
    }

    /**
     * Lista as recomendações para os usuários em estado contínuo
     */
    public void listRecommendationsNormal() {
        for (int i = 0; i < recommendationsForNormal.size(); i++) {
            System.out.println((i + 1) + " - " + recommendationsForNormal.get(i));
        }
    }

    /**
     * Lista as recomendações para os usuários em isolamento
     */
    public void listRecommendationsIsolation() {
        for (int i = 0; i < recommendationsForIsolation.size(); i++) {
            System.out.println((i + 1) + " - " + recommendationsForIsolation.get(i));
        }
    }

}
