package sysc4806.pm4y;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import sysc4806.pm4y.models.*;
import sysc4806.pm4y.repositories.ProjectRepo;
import sysc4806.pm4y.repositories.UserRepo;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
public class Application {

    private UserRepo userRepo;
    private ProjectRepo projectRepo;

    @Autowired
    public Application(UserRepo userRepo, ProjectRepo projectRepo) {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
        populateUser();
        populateProject();
    }

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void populateUser() {
        User p;
        p = new Student("StudentTest", "p1");
        Project pr = new Project();
        ((Student) p).setProject(pr);
        userRepo.save(p);
        p = new Student("StudentTest2", "p1");
        ((Student) p).setEngineeringStream(EngineeringStream.AEROSPACE);
        userRepo.save(p);
        p = new Prof("ProfTest", "p2");
        userRepo.save(p);
        p = new Prof("ProfTest1", "p2");
        userRepo.save(p);
        p = new ProjectCoordinator("AdminTest", "p3");
        userRepo.save(p);

        User user = userRepo.findByEmail("StudentTest");
        log.info(user.getEmail() + ", " + user.getPassword());

    }

    public void populateProject() {
        Project p;
        User u = userRepo.findByEmail("ProfTest");
        p = new Project("project1", (Prof) u);
        p.setDescription("u smell");
        p.setMaxStudents(3);
        List la = new ArrayList<EngineeringStream>();
        la.add(EngineeringStream.AEROSPACE);
        p.setEngineeringStreams(la);
        projectRepo.save(p);
        u = userRepo.findByEmail("ProfTest1");
        p = new Project("project2",  (Prof) u);
        p.setDescription("u smell no rly");
        p.setMaxStudents(2);
        projectRepo.save(p);

        projectRepo.findProjectsByEngineeringStreamsContaining(EngineeringStream.AEROSPACE).forEach(user -> {
            log.info("working");
        });
    }


}
