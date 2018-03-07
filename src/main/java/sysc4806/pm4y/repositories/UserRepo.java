package sysc4806.pm4y.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sysc4806.pm4y.models.User;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User,String>
{
    List<User> findByEmail (String email);
    List<User> findBySessionId(String sessionId);
}
