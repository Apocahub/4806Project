package main;
import javax.persistence.*;


@Entity
public abstract class User
{

    String email;
    String password;
    String sessioniD;

    @Id
    public String getEmail() {
        return email;
    }
    public User(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSessioniD() {
        return sessioniD;
    }

    public void setSessioniD(String sessioniD) {
        this.sessioniD = sessioniD;
    }


}
