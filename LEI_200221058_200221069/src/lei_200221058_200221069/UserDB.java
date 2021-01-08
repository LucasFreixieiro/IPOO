/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.time.LocalDate;
import java.util.UUID;

/**
 *
 * @author Lucas Freixieiro
 */
public class UserDB {

    private User[] users;
    private Id[] infectedIDs;
            
    public UserDB() {
        users = new User[0];
        infectedIDs = new Id[0];
    }

    public User[] getUsers() {
        return users;
    }

    public void addUser(User user) {
        User[] newUserArray = new User[users.length + 1];
        System.arraycopy(users, 0, newUserArray, 0, users.length);
        int j = users.length + 1;
        users = new User[j];
        System.arraycopy(newUserArray, 0, users, 0, users.length);
        users[users.length - 1] = user;
    }

    public void removeUser(User user) {
        int index = getArrayIndex(user);
        User[] newUserArray = new User[users.length - 1];
        System.arraycopy(users, 0, newUserArray, 0, index);
        System.arraycopy(users, index + 1, newUserArray, index, users.length - index - 1);
        users = new User[users.length - 1];
        System.arraycopy(newUserArray, 0, users, 0, newUserArray.length);
    }

    public User getUser(String numberID) {
        for (User user : users) {
            if (user.getUserID().equalsIgnoreCase(numberID)) {
                return user;
            }
        }
        System.out.println("Utilizador inválido");
        return null;
    }

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

    public int getTotalCount() {
        return users.length;
    }

    public boolean verifyUser(String numberID) {
        for (User user : users) {
            if (user.getUserID().equalsIgnoreCase(numberID)) {
                return true;
            }
        }
        return false;
    }
    
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

    public Id[] getInfectedIDs() {
        return infectedIDs;
    }

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
    
    public Id[] removeOldID(int index, Id[] ids){
        Id[] newArray = new Id[ids.length - 1];
        System.arraycopy(ids, 0, newArray, 0, index);
        System.arraycopy(ids, index + 1, newArray, index, ids.length - index - 1);
        //infectedIDs = new Id[infectedIDs.length - 1];
        //System.arraycopy(newArray, 0, infectedIDs, 0, newArray.length);
        return newArray;
    }
    
}
