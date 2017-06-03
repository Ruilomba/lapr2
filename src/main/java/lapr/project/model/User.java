package lapr.project.model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    public String username;
    String password;
    
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
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }
    
    
}
