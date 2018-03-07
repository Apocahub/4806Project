package sysc4806.pm4y.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sysc4806.pm4y.models.Project;

import java.util.List;

@Repository
public interface ProjectRepo extends CrudRepository<Project,String>
{
    List<Project> findById(long id);
    List<Project> findByProjectName(String projectname);
}
