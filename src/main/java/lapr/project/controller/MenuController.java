package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.utils.*;

/**
 *
 * @author inesmartins
 */
public class MenuController {
    
    private final EventCenter eventCenter;
    private final AuthenticationService authentication;
    
    public MenuController(EventCenter center) {
        eventCenter = center;
        authentication = new AuthenticationService();
    }
    
    public String getAuthenticatedUserName() {
        User authenticatedUser = authentication.getAuthenticatedUser();
        if (authenticatedUser.getName() != null) {
            return authenticatedUser.getName();
        }
        else if (authenticatedUser.getUsername() != null) {
            return authenticatedUser.getUsername();
        }
        else {
            return "Unkown user";
        }
    }
}
