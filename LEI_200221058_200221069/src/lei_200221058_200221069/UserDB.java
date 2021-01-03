/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author lukef
 */
public class UserDB {
    private User[] users;

    public UserDB() {
        users = new User[0];
    }
    
    public User[] getUsers() {
        return users;
    }
    
    public void addUser(User user){
        users = ArrayUtils.add(users, user);
    }

    public void removeUser(String numberID){
        for(User user : users){
            if(user.getUserID().equals(numberID)){
                users = ArrayUtils.removeElement(users, user);
                return;
            }
        }
    }
    
    public User getUser(String numberID){
        for(User user : users){
            if(user.getUserID().equalsIgnoreCase(numberID)){
                return user;
            }
        }
        System.out.println("Utilizador inválido");
        return null;
    }
    
}
