/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Lucas Freixieiro
 */
public class HealthOrganizationRecomendations {
    private String[] recomendations;
    private InputReader reader;

    public HealthOrganizationRecomendations() {
        reader = new InputReader();
        this.recomendations = new String[0];
    }
    
    public String[] getRecomendations() {
        return recomendations;
    }
    
    public void newRecomendation(){
        String recomendation;
        recomendation = reader.getText("Recomendação");
        
        String[] newRecomendationArray = new String[recomendations.length+1];
        System.arraycopy(recomendations, 0, newRecomendationArray, 0, recomendations.length);
        int j = recomendations.length + 1;
        recomendations = new String[j];
        System.arraycopy(newRecomendationArray, 0, recomendations, 0, recomendations.length);
        recomendations[recomendations.length-1] = recomendation;
    }
    
    public void removeRecomendation(int option){
        if(option<0 || option>recomendations.length){
            System.out.println("Opção não reconhecida");
        }
        else{
            String[] newRecomendationArray = new String[recomendations.length-1];
            System.arraycopy(recomendations, 0, newRecomendationArray, 0, option);
            System.arraycopy(recomendations, option + 1, newRecomendationArray, option, recomendations.length - option - 1);
            recomendations = new String[recomendations.length-1];
            System.arraycopy(newRecomendationArray, 0, recomendations, 0, newRecomendationArray.length);
        }
    }
    
    public void editRecomendation(int option){
        String newRecomendation;
        newRecomendation = reader.getText("Recomendação");
        recomendations[option] = newRecomendation;
    }
    
    public void listRecomendations(){
        for(int i=0; i<recomendations.length; i++){
            System.out.println(i + " - " + recomendations[i]);
        }
    }
}
