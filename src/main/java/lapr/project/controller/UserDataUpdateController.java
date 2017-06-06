package lapr.project.controller;

import java.io.IOException;
import lapr.project.model.*;
import lapr.project.utils.*;

/**
 *
 * @author inesmartins
 */
public class UserDataUpdateController {
    
    private final EventCenter eventCenter;
    private final AuthenticationService authentication;

    /**
     * default constructor
     * @param center 
     */
    public UserDataUpdateController(EventCenter center) {
        eventCenter = center;
        authentication = new AuthenticationService();
    }
    
    /**
     * 
     * @return data for authenticated user
     */
    public User getCurrentUserData() {
        return authentication.getAuthenticatedUser();
    }
    
    /**
     * updates data for authenticated user
     * @param name
     * @param username
     * @param email
     * @param password
     * @return 
     */
    public boolean updateUserData(String name, String username, String email, String password) {
        UserRegistration userRegistration = eventCenter.getUserRegistration();
        try {
            return userRegistration.updateUserRegistration(name, username, email, password);            
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
