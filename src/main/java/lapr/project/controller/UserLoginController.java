package lapr.project.controller;

import java.io.IOException;
import lapr.project.model.*;
import lapr.project.utils.*;

/**
 *
 * @author inesmartins
 */
public class UserLoginController {
    
    private final EventCenter eventCenter;
    private final AuthenticationService authentication;

    public UserLoginController(EventCenter center) {
        eventCenter = center;
        authentication = new AuthenticationService();
    }

    public boolean loginUser(String usernameOrEmail, String password) throws IOException {
        try {
            return authentication.loginUser(usernameOrEmail, password);            
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
