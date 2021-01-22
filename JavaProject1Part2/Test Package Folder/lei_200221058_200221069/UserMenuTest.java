/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lei_200221058_200221069;

import java.time.LocalDate;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lili
 */
public class UserMenuTest {
    
    private User user = new User("200200200", UserState.ISOLATION);
    
    public UserMenuTest() {
    }
    
    /**
     * Test of verifyState method, of class UserMenu. Over 15 days.
     */
    @Test
    public void testVerifyStateOver15() {
        System.out.println("verifyState");
        UserMenu instance = new UserMenu(null,null);
        instance.setUser(user);
        user.setUserState(UserState.ISOLATION);
        user.setChangeStateDate(LocalDate.now().minusDays(16));
        instance.verifyState();
        assertEquals(UserState.NORMAL,user.getUserState());
    }

    /**
     * Test of verifyState method, of class UserMenu. Under 15 days.
     */
    @Test
    public void testVerifyStateUnder15() {
        System.out.println("verifyState");
        UserMenu instance = new UserMenu(null,null);
        instance.setUser(user);
        user.setUserState(UserState.ISOLATION);
        user.setChangeStateDate(LocalDate.now().minusDays(14));
        instance.verifyState();
        assertEquals(UserState.ISOLATION,user.getUserState());
    }
    
}
