package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.utils.*;

/**
 *
 * @author inesmartins
 */
public class UserDataUpdateController {
    
    public final EventCenter eventCenter;
    
    public UserDataUpdateController(EventCenter center) {
        eventCenter = center;
    }
    
    public boolean updateUserData(String name, String username, String email, String password) {
        UserRegistration userRegistration = eventCenter.getUserRegistration();
        return userRegistration.updateUserRegistration(name, username, email, password);
    }
}
