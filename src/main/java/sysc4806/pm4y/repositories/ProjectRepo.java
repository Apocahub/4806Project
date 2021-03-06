package sysc4806.pm4y.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sysc4806.pm4y.models.EngineeringStream;
import sysc4806.pm4y.models.Project;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProjectRepo extends CrudRepository<Project,String>
{
    Project findById(long id);
    List<Project> findByProjectName(String projectName);
    List<Project> findAll();
    List<Project> findProjectsByEngineeringStreamsContaining(EngineeringStream engineeringStream);
    void deleteById(Long id);
}
