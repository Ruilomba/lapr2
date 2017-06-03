package lapr.project.controller;

import java.io.IOException;
import lapr.project.model.*;
import lapr.project.utils.*;

/**
 *
 * @author inesmartins
 */
public class UserLoginController {
    
    public final EventCenter eventCenter;

    public UserLoginController(EventCenter center) {
        eventCenter = center;
    }

    public boolean loginUser(String usernameOrEmail, String password) throws IOException {
        try {
            return AuthenticationService.loginUser(usernameOrEmail, password);            
        }
        catch (IOException e) {
            return false;
        }
    }
}
