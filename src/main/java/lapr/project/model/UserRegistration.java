package lapr.project.model;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
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

    public boolean updateUserRegistration(String name, String username, String email, String password) {
        String currentUserUsername = AuthenticationService.getAuthenticatedUser();
        User currentUser = null;
        for (User u : userList) {
            if (u.getUsername().equals(currentUserUsername)) {
                currentUser = u;
            }
        }
        if (currentUser != null) {
            for (User u : userList) {
                if (!u.equals(currentUser)) {
                    if (username != null && !username.isEmpty()) {
                        if (u.getUsername().equals(username)) {
                            return false;
                        }
                    }
                    if (email != null && !email.isEmpty()) {
                        if (u.getEmail().equals(email)) {
                            return false;
                        }
                    }
                }
            }
            if (name != null && !name.isEmpty()) {
                currentUser.setName(name);
            }
            if (username != null && !username.isEmpty()) {
                currentUser.setUsername(username);
            }
            if (email != null && !email.isEmpty()) {
                currentUser.setEmail(email);
            }
            if (password != null && !password.isEmpty()) {
                currentUser.setPassword(password);
            }
            // TODO: IMPLEMENT
            updateUserDataInFile();
            return true;
        }
        return false;
    }

    private void updateUserDataInFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean validateUser(User u) {
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
        for (int i = 0; i < userList.size(); i++) {
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
