package sysc4806.pm4y.models;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepo extends CrudRepository<Project,String>
{
    List<Project> findbyId(Integer id);
    List<Project> findbyname(String projectname);
}
