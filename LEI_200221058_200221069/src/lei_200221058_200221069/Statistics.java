/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

/**
 *
 * @author Lili
 */
public class Statistics {
    private UserDB users;


    public Statistics(UserDB users) {
        this.users = users;
    }
    
    
    public void Statistics(){
        
        int isolation= 0 ;
        int normal = 0;
        int infected = 0;
        
        for (User user : users.getUsers()) {
            if (null != user.getUserState())
                switch (user.getUserState()) {
                    case INFECTED:
                        infected++;
                        break;
                    case ISOLATION:
                        isolation++;
                        break;
                    case NORMAL:
                        normal++;
                        break;
                    default:
                        break;
                }
        
        }
        
        System.out.println("Infectados: " + infected);
        System.out.println("Em isolamento: " + isolation);
        System.out.println("Em contínuo: " + normal);
    }
    
}