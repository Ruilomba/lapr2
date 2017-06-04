package lapr.project.controller;

import java.io.IOException;
import lapr.project.model.*;
import lapr.project.utils.*;

/**
 *
 * @author inesmartins
 */
public class UserRegistrationController {
    
    private final EventCenter eventCenter;
    
    public UserRegistrationController(EventCenter center) {
        eventCenter = center;
    }
    
    /**
     * registers new user in user registration
     * @param name
     * @param username
     * @param email
     * @param password
     * @return
     * @throws IOException 
     */
    public boolean registerUser(String name, String username, String email, String password) throws IOException {
        UserRegistration userRegistration = eventCenter.getUserRegistration();
        User createdUser = userRegistration.createUser();
        createdUser.setName(name);
        createdUser.setUsername(username);
        createdUser.setEmail(email);
        createdUser.setPassword(password);
        return userRegistration.addUserRegistration(createdUser);
    }
    
    /**
     * saves username of authenticated user
     * @param username 
     */
    public void saveUserCredentials(String username) {
        AuthenticationService.setAuthenticatedUser(username);
    }
    
}
