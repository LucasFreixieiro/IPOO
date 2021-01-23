/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Informação do utilizador
 *
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */
//Classe que tem como atributos as infos do user
public class User {

    //Identificação do utilizador
    //No caso dos alunos o seu número de aluno
    //No caso dos professores um número mecanográfico, os números dos professores começam com 000
    private String userID;
    //Estado do utilizador (continuo, infetado ou em isolamento)
    private UserState userState;
    //Lista com os IDs gerados
    private ArrayList<Id> transmitedIds;
    //Lista com os ID's recebidos
    private ArrayList<Id> receivedIds;
    private LocalDate changeStateDate;

    /**
     * Construtor
     *
     * @param userID Número de utilizador
     * @param userState Estado do utilizador
     */
    public User(String userID, UserState userState) {
        this.userID = userID;
        this.userState = userState;
        changeStateDate = LocalDate.now();
        transmitedIds = new ArrayList<>();
        receivedIds = new ArrayList<>();
    }

    /**
     * Método para obter o id do utilizador
     *
     * @return número do utilizador
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Método para atualizar o atributo do número de utilizador Só atribui o
     * novo número caso o parametro passado tenha o tamanho de 9 caracteres
     *
     * @param userID número do utilizador
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Método para obter o estado do utilzador
     *
     * @return UserState com o estado do utilizador
     */
    public UserState getUserState() {
        return userState;
    }

    /**
     * Método para atualizar o estado do utilizador
     *
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
     * Altera a data de alteração de estado
     *
     * @param date Data da alteração do estado
     */
    public void setChangeStateDate(LocalDate date) {
        changeStateDate = date;
    }

    /**
     * Método para obter os Ids transmitidos
     *
     * @return array dos ids transmitidos
     */
    public ArrayList<Id> getTransmitedIds() {
        return transmitedIds;
    }

    /**
     * Método para obter os ids transmitidos (gerados) em forma de texto
     */
    public void listTransmitedIds() {
        for (Id transmitedID : transmitedIds) {
            System.out.println(transmitedID);
        }
    }

    /**
     * Método para atualizar o array que contém os ids transmitidos (gerados).
     *
     * @param value Valor do ID
     * @param date Data da criação do ID
     */
    public void setTransmitedIds(String value, LocalDate date) {
        transmitedIds.add(new Id(value, date));
    }

    /**
     * Método para obter os Ids recebidos durante as aulas
     *
     * @return Ids recebidos
     */
    public ArrayList<Id> getReceivedIDs() {
        return receivedIds;
    }

    /**
     * Método para listar os ids recebidos
     */
    public void listReceivedIds() {
        for (Id receivedID : receivedIds) {
            System.out.println(receivedID);
        }
    }

    /**
     * Método para atualizar o array dos ids recebidos
     *
     * @param value Valor do ID
     * @param date Data da criação do ID
     */
    public void setReceivedIDs(String value, LocalDate date) {
        receivedIds.add(new Id(value, date));
    }

    /**
     * Método que permite a remoção de um id transmitido
     *
     * @param index Posição a remover
     */
    public void removeTransmitedID(int index) {
        transmitedIds.remove(index);
    }

    /**
     * Método que permite a remoção de um id recebidos
     *
     * @param index Posição a remover
     */
    public void removeReceivedID(int index) {
        receivedIds.remove(index);
    }

    /**
     * Método para verificar se um utilizador é professor
     *
     * @return true se for professor falso se não for
     */
    public boolean isTeacher() {
        return userID.startsWith("000");
    }

}
