/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Registo dos Utilizadores
 * @author Lucas Freixieiro e Liliana Santos
 * @version 1.0.0
 */
public class UserDB {

    private User[] users;
    private Id[] infectedIDs;
    
    /**
     * Construtor do UserDB
     * Cria os arrays com tamnaho 0
     */
    public UserDB() {
        users = new User[0];
        infectedIDs = new Id[0];
    }

    /**
     * 
     * @return utilizadores registados
     */
    public User[] getUsers() {
        return users;
    }

    /**
     * Adiciona um utilizador ao array users
     * Para isso é feito o redimensionamento do array
     * Copiando o mesmo para outro e depois copiando de volta para o original
     * @param user Utilizador a ser adicionado
     */
    public void addUser(User user) {
        User[] newUserArray = new User[users.length + 1];
        System.arraycopy(users, 0, newUserArray, 0, users.length);
        int j = users.length + 1;
        users = new User[j];
        System.arraycopy(newUserArray, 0, users, 0, users.length);
        users[users.length - 1] = user;
    }

    /**
     * Remove um utilizador do array users
     * O array é redimensionado
     * @param user utilziador a ser removido
     */
    public void removeUser(User user) {
        int index = getArrayIndex(user);
        User[] newUserArray = new User[users.length - 1];
        System.arraycopy(users, 0, newUserArray, 0, index);
        System.arraycopy(users, index + 1, newUserArray, index, users.length - index - 1);
        users = new User[users.length - 1];
        System.arraycopy(newUserArray, 0, users, 0, newUserArray.length);
    }

    /**
     * Serve para obter um utilizador com um determindado numberID
     * @param numberID número do utilizador a ser procurado
     * @return Utilizador com o numberID igual ao do parametro
     */
    public User getUser(String numberID) {
        for (User user : users) {
            if (user.getUserID().equalsIgnoreCase(numberID)) {
                return user;
            }
        }
        System.out.println("Utilizador inválido");
        return null;
    }
    
    /**
     * Obter posição de um utilizador no array users
     * @param user utilizador a ser procurado
     * @return indice ao qual um determinado utilizador se encontra no array users
     */
    public int getArrayIndex(User user) {
        int index = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i].equals(user)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Obtem o total de utilizadores no array users
     * @return quantidade de utililizadores
     */
    public int getTotalCount() {
        return users.length;
    }

    /**
     * Verifica se o utilizador já se encontra no array
     * @param numberID número do utilziador a ser verificado
     * @return Verdadeiro se o utilizador está no array, false se não está
     */
    public boolean verifyUser(String numberID) {
        for (User user : users) {
            if (user.getUserID().equalsIgnoreCase(numberID)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Define os Ids recebidos para cada utilizador 
     * Utiliza os ids transmitidos para preencher o array dos ids recebidos
     */
    public void setIDs(){
        String ID;
        LocalDate today;
        for(int i=0; i<users.length; i++){
            System.out.println(i);
            ID = UUID.randomUUID().toString();
            today = LocalDate.now();
            System.out.println(users[i].getUserID());
            users[i].setTransmitedIds(ID, today);
            for(int j=0; j<users.length; j++){
                if(i != j){
                    users[j].setReceivedIDs(ID, today);
                }
            }
        }
    }   
    
    /**
     * 
     * @return Ids infetados
     */
    public Id[] getInfectedIDs() {
        return infectedIDs;
    }

    /**
     * Define os ids infetados
     * Redimensiona o array dos id infetados
     * @param ids IDs a serem inseridos na lista
     */
    public void setInfectedIDs(Id[] ids) {
        ids = verifyInfectedIDs(ids);
        if(ids != null){
            int size = infectedIDs.length + ids.length;
            //Criar array auxiliar com o tamanho do antigo mais os novos ids recebidos
            Id[] newIDArray = new Id[size];
            //copiar o array antigo para o array novo
            System.arraycopy(infectedIDs, 0, newIDArray, 0, infectedIDs.length);
            //copiar o array do parametro para o novo array
            System.arraycopy(ids, 0, newIDArray, infectedIDs.length, ids.length);
            infectedIDs = new Id[size];
            //Copiar o novo array para o velho array
            System.arraycopy(newIDArray, 0, infectedIDs, 0, newIDArray.length);
        }
    }
    
    /**
     * Verifica se já se passaram 7 dias desde que o array foi gerado
     * Se sim ele será eliminado
     * @param ids Array de ids a serem verificados
     * @return Array do tipo Id que contém os ids mais atuais
     */
    public Id[] verifyInfectedIDs(Id[] ids){
        LocalDate after;
        if(ids != null){
            for(int i=0; i<ids.length; i++){
                after = ids[i].getDate().plusDays(7);
                if(LocalDate.now().isAfter(after)){
                    ids = removeOldID(i, ids);
                    i--;
                }
            }
            return ids;
        }
        return null;
    }
    
    /**
     * Remove o id do array passado em parametro na posição indicada
     * @param index posição a eliminar
     * @param ids array a ser alterado
     * @return array alterado
     */
    public Id[] removeOldID(int index, Id[] ids){
        Id[] newArray = new Id[ids.length - 1];
        System.arraycopy(ids, 0, newArray, 0, index);
        System.arraycopy(ids, index + 1, newArray, index, ids.length - index - 1);
        return newArray;
    }
    
    /**
    * Limpa o array que contém os ids dos utilizadores infetados
    * Só é acionado após o upload dos ids infetados em cada utilizador
    * (é acionado através da organização)
    */
    public void clearInfectedIDs(){
        infectedIDs = new Id[0];
    }
    
}
