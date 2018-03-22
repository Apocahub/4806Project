package sysc4806.pm4y.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
    public static final String MODEL_NAME = "user";
    public User() {
    }

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    private String email;
    private String password;
    private String sessionId;

    public User(final String email,final String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }
}
