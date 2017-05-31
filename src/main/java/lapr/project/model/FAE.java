package lapr.project.model;

import java.io.Serializable;

public class FAE implements Serializable {
    
    private User user;

    public FAE () {
    }

    /**
     * Object Constructor
     * @param user FAE User
     */
    public FAE (User user) {
        this.user = user;
    }

    
    /**
     * sets user
     * @param u
     */
    public void setUser(User u) {
        this.user = u;
    }
    /**
     * get user
     * @return
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Validates object
     * @return true if valid, false if invalid
     */
    public boolean validateFAE() {
        return true;
    }

    /**
     * Validates if the instance user is the parameter user
     * @param user user to be validated
     * @return true if the users are the same
     */
    public boolean isUser(User user) {
        if (this.user != null) {
            return this.user.equals(user);
        }
        return false;
    }

    @Override
    public String toString() {
        return user != null ? user.toString() : null;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        //return other.isUser(user);
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.user.hashCode();
        return hash;
    }
}