/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

/**
 *
 * @author Lucas Freixieiro
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
        User[] newUserArray = new User[users.length+1];
        System.arraycopy(users, 0, newUserArray, 0, users.length);
        int j = users.length + 1;
        users = new User[j];
        System.arraycopy(newUserArray, 0, users, 0, users.length);
        users[users.length-1] = user;
    }

    public void removeUser(User user){
        int index = getArrayIndex(user);
        User[] newUserArray = new User[users.length-1];
        System.arraycopy(users, 0, newUserArray, 0, index);
        System.arraycopy(users, index + 1, newUserArray, index, users.length - index - 1);
        users = new User[users.length-1];
        System.arraycopy(newUserArray, 0, users, 0, newUserArray.length);
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
    
    public int getArrayIndex(User user) {
        int index=0;
        for(int i=0;i<users.length;i++){
            if(users[i].equals(user)){
                index=i;
                break;
            }
        }
        return index;
    }
    
    public int getTotalCount(){
        return users.length;
    }
    
    public boolean verifyUser(String numberID){
        for(User user : users){
            if(user.getUserID().equalsIgnoreCase(numberID)){
                return true;
            }
        }
        return false;
    }
}
