/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.util.UUID;
import java.lang.Object;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author Lucas Freixieiro
 */

//Classe que tem como atributos as infos do user
public class User {
    //Identificação do utilizador
    //No caso dos alunos o seu número de aluno
    //No caso dos professores um número mecanográfico
    private String userID; 
    //Estado do utilizador (continuo, infetado ou em isolamento)
    private UserState userState;
    //Lista com os IDs gerados
    private String[] transmitedIds;
    //Lista com os ID's recebidos
    private String[] receivedIds;

    //Construtor
    public User(String userID, UserState userState) {
        this.userID = userID;
        this.userState = userState;
        transmitedIds = new String[0];
        receivedIds = new String[0];
    }
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public String[] getTransmitedIds() {
        return transmitedIds;
    }
    
    public void listTransmitedIds() {
        for(String transmitedID : transmitedIds){
            System.out.println(transmitedID);
        }
    }

    public void setTransmitedIds() {
        transmitedIds = ArrayUtils.add(transmitedIds, UUID.randomUUID().toString());
    }

    public String[] getReceivedIDs() {
        return receivedIds;
    }
    
    public void listReceivedIds() {
        for(String receivedID : receivedIds){
            System.out.println(receivedID);
        }
    }

    public void setReceivedIDs() {
        //this.receivedIDs = UUID.randomUUID().toString();
    }
    
}
