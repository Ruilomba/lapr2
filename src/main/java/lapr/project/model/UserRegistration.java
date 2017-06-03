package lapr.project.model;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lapr.project.utils.AuthenticationService;
import lapr.project.utils.DataValidationService;

public class UserRegistration implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<User> userList;
    
    public UserRegistration() {
        userList = new ArrayList<>();
    }
    
    public UserRegistration(List<User> userList) {
        this.userList = userList;
    }
    
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    public List<User> getUserList() {
        return userList;
    }
    
    public boolean addUserRegistration(User u) throws IOException {
        if (validateUser(u) && AuthenticationService.registerUser(u)) {
            return addUser(u);
        }
        return false;
    }
    
    public User createUser() {
        return new User();
    }
    
    private  boolean validateUser(User u) {
        if (DataValidationService.emailIsValid(u.getEmail())) {
            for (User user : userList) {
                if ((user.getUsername().equals(u.getUsername())) || (user.getEmail().equals(u.getEmail()))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public User getUser(String username) {
        for (int i = 0;i < userList.size();i++) {
            User u = userList.get(i);
            if (u.getUsername().equalsIgnoreCase(username)) {
                return u;
            }
        }
        return null;
    }
    
    private boolean addUser(User u) {
        return userList.add(u);
    }

}
