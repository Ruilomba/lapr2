package lapr.project.model;

import java.io.*;
import java.util.*;
import lapr.project.utils.*;

public class UserRegistration implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String USER_DATA_FILE_PATH = "userData.txt";
    private List<User> userList;

    /**
     * constructor without user list
     */
    public UserRegistration() {
        userList = new ArrayList<>();
    }

    /**
     * constructor with user list
     *
     * @param userList
     */
    public UserRegistration(List<User> userList) {
        this.userList = userList;
    }

    /**
     * sets user list
     *
     * @param userList
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * returns user list
     *
     * @return
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * creates new user object
     *
     * @return
     */
    public User createUser() {
        return new User();
    }

    /**
     * adds user registration to user list
     *
     * @param u
     * @return
     * @throws IOException
     */
    public boolean addUserRegistration(User u) throws IOException {
        if (validateUser(u) && AuthenticationService.registerUser(u)) {
            return addUser(u);
        }
        return false;
    }

    /**
     * updates user registration on user list
     *
     * @param name
     * @param username
     * @param email
     * @param password
     * @return
     * @throws IOException
     */
    public boolean updateUserRegistration(String name, String username, String email, String password) throws IOException {
        User currentUser = AuthenticationService.getAuthenticatedUser();
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
        try {
            if (AuthenticationService.updateUserDataInFile(currentUser)) {
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
                return true;
            }
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * checks if user fields are valid
     * @param u
     * @return 
     */
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

    /**
     * returns user with specified username
     * @param username
     * @return 
     */
    public User getUserWithUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            if (u.getUsername().equalsIgnoreCase(username)) {
                return u;
            }
        }
        return null;
    }

    /**
     * adds new user to user list
     * @param u
     * @return 
     */
    private boolean addUser(User u) {
        return userList.add(u);
    }

}
