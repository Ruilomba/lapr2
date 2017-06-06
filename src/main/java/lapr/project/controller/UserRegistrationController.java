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
    private final AuthenticationService authentication;
    
    public UserRegistrationController(EventCenter center) {
        eventCenter = center;
        authentication = new AuthenticationService();
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
        if (userRegistration.addUserRegistration(createdUser)) {
            authentication.setAuthenticatedUser(createdUser);
            return true;
        }
        return false;
    }
}
