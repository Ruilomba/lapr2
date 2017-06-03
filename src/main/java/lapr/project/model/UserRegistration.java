package lapr.project.model;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import lapr.project.utils.AuthenticationService;

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
        if (validateUser(u) && AuthenticationService.registerUser(u.username, u.password)) {
            return addUser(u);
        }
        return false;
    }
    
    public User createUser() {
        return new User();
    }
    
    private  boolean validateUser(User u) {
        return !userList.contains(u);
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
