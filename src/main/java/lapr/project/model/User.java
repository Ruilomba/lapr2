package lapr.project.model;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private String email;
    private String username;
    private String password;
    
    public User() {
    }
    
    public User(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setName(String nome) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean validates() {
        // implement if necessary
        return true;
    }

    @Override
    public String toString() {
        return "Nome: " + this.name + "\n" + 
               "Email: " + this.email + "\n" + 
               "UserName: " + this.username;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User u = (User) obj;
        return this.email.equalsIgnoreCase(u.getEmail()) && this.username.equals(u.getUsername());
    }    
}
