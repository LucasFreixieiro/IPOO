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
        String recomendation = "" + recomendations.length + " - ";
        recomendation += reader.getText("Recomendação");
        recomendations = ArrayUtils.add(recomendations, recomendation);
    }
    
    public void removeRecomendation(int option){
        if(option<0 || option>recomendations.length){
            System.out.println("Opção não reconhecida");
        }
        else{
            recomendations = ArrayUtils.remove(recomendations, option);
        }
    }
    
    public void editRecomendation(int option){
        String newRecomendation = "" + recomendations.length + " - ";
        newRecomendation += reader.getText("Recomendação");
        recomendations[option] = newRecomendation;
    }
    
    public void listRecomendations(){
        for(String recomendation : getRecomendations()){
            System.out.println(recomendation);
        }
    }
}
