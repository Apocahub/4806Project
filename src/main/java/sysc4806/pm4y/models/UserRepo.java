package sysc4806.pm4y.models;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,String>
{
    List<User> findbyemail (String email);
    List<User> findbysessionId(String sessionId);
}
