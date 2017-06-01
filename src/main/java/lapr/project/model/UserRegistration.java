package lapr.project.model;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class UserRegistration implements Serializable {

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
    
    public List<User> getuserList() {
        return userList;
    }
    
    public void addUserRegistration(User u) {
        if (validateUser(u)) {
            addUser(u);
        }
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
    
    private void addUser(User u) {
        userList.add(u);
    }

}
