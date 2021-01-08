/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.util.UUID;
import java.lang.Object;
import java.time.LocalDate;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Informação do utilizador
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
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
    private Id[] transmitedIds;
    //Lista com os ID's recebidos
    private Id[] receivedIds;
    private LocalDate changeStateDate;

    /**
     * Construtor
     * @param userID Número de utilziador
     * @param userState Estado do utilizador
     */
    public User(String userID, UserState userState) {
        this.userID = userID;
        this.userState = userState;
        transmitedIds = new Id[0];
        receivedIds = new Id[0];
    }
    
    /**
     * Método para obter o id do utilizador
     * @return número do utilizador
     */
    public String getUserID() {
        return userID;
    }

    /**
    * Método para atualizar o atributo do número de utilizador
    * Só atribui o novo número caso o parametro passado tenha o tamanho de 9 caracteres
    * @param userID número do utilizador
    */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Método para obter o estado do utilzador
     * @return UserState com o estado do utilziador
     */
    public UserState getUserState() {
        return userState;
    }

    /**
     * Método para atualizar o estado do utilizador
     * @param userState Estado do utilizador
     */
    public void setUserState(UserState userState) {
        this.userState = userState;
        changeStateDate = LocalDate.now();
        
    }

    /**
     * 
     * @return Data da alteração do estado
     */
    public LocalDate getChangeStateDate() {
        return changeStateDate;
    }

    /**
     * Método para obter os Ids transmitidos
     * @return array dos ids transmitidos
     */
    public Id[] getTransmitedIds() {
        return transmitedIds;
    }
    
    /**
     * Método para obter os ids transmitidos (gerados) em forma de texto
     */
    public void listTransmitedIds() {
        for(Id transmitedID : transmitedIds){
            System.out.println(transmitedID);
        }
    }
    
    /**
     * Método para atualizar o array que contém os ids transmitidos (gerados).
     * @param value Valor do ID
     * @param date Data da criação do ID
     */
    public void setTransmitedIds(String value, LocalDate date) {
        int size = transmitedIds.length + 1;
        Id[] newIdArray = new Id[size];
        System.arraycopy(transmitedIds, 0, newIdArray, 0, transmitedIds.length);
        transmitedIds = new Id[size];
        System.arraycopy(newIdArray, 0, transmitedIds, 0, newIdArray.length);
        Id id = new Id(value, date);
        transmitedIds[transmitedIds.length-1] = id;
    }
    
    /**
     * Método para obter os Ids recebidos durante as aulas
     * @return Ids recebidos
     */
    public Id[] getReceivedIDs() {
        return receivedIds;
    }
    
    /**
     * Método para listar os ids recebidos
     */
    public void listReceivedIds() {
        for(Id receivedID : receivedIds){
            System.out.println(receivedID);
        }
    }

    /**
     * Método para atualizar o array dos ids recebidos
     * @param value Valor do ID
     * @param date Data da criação do ID
     */
    public void setReceivedIDs(String value, LocalDate date) {
        int size = receivedIds.length + 1;
        Id[] newIdArray = new Id[size];
        System.arraycopy(receivedIds, 0, newIdArray, 0, receivedIds.length);
        receivedIds = new Id[size];
        System.arraycopy(newIdArray, 0, receivedIds, 0, newIdArray.length);
        Id id = new Id(value, date);
        receivedIds[receivedIds.length-1] = id;
    }
    
    /**
     * Método que permite a remoção de um id transmitido
     * @param index Posição a remover
     */
    public void removeTransmitedID(int index){
        Id[] newArray = new Id[transmitedIds.length - 1];
        System.arraycopy(transmitedIds, 0, newArray, 0, index);
        System.arraycopy(transmitedIds, index + 1, newArray, index, transmitedIds.length - index - 1);
        transmitedIds = new Id[transmitedIds.length - 1];
        System.arraycopy(newArray, 0, transmitedIds, 0, newArray.length);
    }
    
    /**
     * Método que permite a remoção de um id recebidos
     * @param index Posição a remover
     */
    public void removeReceivedID(int index){
        Id[] newArray = new Id[receivedIds.length - 1];
        System.arraycopy(receivedIds, 0, newArray, 0, index);
        System.arraycopy(receivedIds, index + 1, newArray, index, receivedIds.length - index - 1);
        receivedIds = new Id[receivedIds.length - 1];
        System.arraycopy(newArray, 0, receivedIds, 0, newArray.length);
    }
}
