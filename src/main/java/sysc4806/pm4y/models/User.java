package sysc4806.pm4y.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {

    @Id
    private String email;
    private String password;
    private String sessionId;

    public User(final String email,final String password)
    {
        this.email = email;
        this.password = password;
    }

    public void setEmail(String email) {
		if(Objects.isNull(email)) {
			throw new IllegalArgumentException("Email Cannot be a null value");
		}
		if(email.isEmpty()) {
			throw new IllegalArgumentException("Email must contain at least 1 character");
		}
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) throws IllegalArgumentException {
        if(Objects.isNull(password)) {
            throw new IllegalArgumentException("Password Cannot be a null value");
        }
        if(password.isEmpty()) {
            throw new IllegalArgumentException("Password must contain at least 1 character");
        }
        this.password = password;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(final String sessionId) {
        if(Objects.isNull(sessionId)) {
            throw new IllegalArgumentException("sessioniD Cannot be a null value");
        }
        if(sessionId.isEmpty()) {
            throw new IllegalArgumentException("sessioniD must contain at least 1 character");
        }
        this.sessionId = sessionId;
    }


}
