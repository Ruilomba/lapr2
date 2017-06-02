/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author RuiSL
 */
public class Organizer {
    private User user;
    
    
    public boolean isUser(User u) {
        if (this.user != null) {
            return this.user.equals(u);
        }
        return false;
    }
    
    public User getUser() {
        return user;
    }
    public void setUser(User u){
        this.user=u;
    }
}
