package sysc4806.pm4y.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sysc4806.pm4y.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepo extends CrudRepository<User,String>
{
    User findById(String id);
    User findByEmail (String email);
    List<User> findBySessionId(String sessionId);
    List<User> findAll();
}
