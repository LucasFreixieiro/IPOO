/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.util.UUID;

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
    private String[] transmitIDs;
    //Lista com os ID's recebidos
    private String[] receivedIDs;

    //Construtor
    public User(String userID, UserState userState) {
        this.userID = userID;
        this.userState = userState;
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

    public String[] getTransmitIDs() {
        return transmitIDs;
    }

    public void setTransmitIDs() {
        //this.transmitIDs[numberOfIDs] = UUID.randomUUID().toString();
    }

    public String[] getReceivedIDs() {
        return receivedIDs;
    }

    public void setReceivedIDs() {
        //this.receivedIDs = UUID.randomUUID().toString();
    }
    
}
