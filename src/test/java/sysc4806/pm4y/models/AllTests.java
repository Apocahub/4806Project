package sysc4806.pm4y.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        ProfTest.class,
        StudentTest.class,
        UserTest.class,
        ProjectCoordinatorTest.class,
        ProjectTest.class
})

public class AllTests {}