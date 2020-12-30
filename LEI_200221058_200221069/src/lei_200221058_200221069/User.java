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
        if(userID.length()==9){
            this.userID = userID;
            this.userState = userState;
            transmitedIds = new String[0];
            receivedIds = new String[0];
        }
        else
            System.out.println("Tente novamente!\nNúmero de Utilizador inválid (9 caracteres)");
    }
    //Método para obter o id do utilizador
    //@return String com o número do utilizador
    public String getUserID() {
        return userID;
    }

    //Método para atualizar o atributo do número de utilizador
    //Só atribui o novo número caso o parametro passado tenha o tamanho de 9 caracteres
    //@params setUserID
    public void setUserID(String userID) {
        if(userID.length()==9)
            this.userID = userID;
        else
            System.out.println("Tente novamente!\nNúmero de Utilizador inválid (9 caracteres)");
    }
    
    //Método para obter o estado do utilzador
    //@return UserState com o estado do utilziador
    public UserState getUserState() {
        return userState;
    }

    //Método para atualizar o estado do utilizador
    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    //Método para obter os Ids transmitidos
    //@return String[] com o array dos ids transmitidos
    public String[] getTransmitedIds() {
        return transmitedIds;
    }
    
    //Método para obter os ids transmitidos (gerados) em forma de texto
    public void listTransmitedIds() {
        for(String transmitedID : transmitedIds){
            System.out.println(transmitedID);
        }
    }
    
    //Método para atualizar o array que contém os ids transmitidos (gerados).
    public void setTransmitedIds() {
        transmitedIds = ArrayUtils.add(transmitedIds, UUID.randomUUID().toString());
    }
    
    //Método para obter os Ids recebidos durante as aulas
    //@return String[]
    public String[] getReceivedIDs() {
        return receivedIds;
    }
    
    //Método para listar os ids recebidos
    public void listReceivedIds() {
        for(String receivedID : receivedIds){
            System.out.println(receivedID);
        }
    }

    //Método para atualizar o array dos ids recebidos
    //@params String[] ids
    public void setReceivedIDs(String[] ids) {
        receivedIds = ArrayUtils.addAll(receivedIds, ids);
    }
    
}
