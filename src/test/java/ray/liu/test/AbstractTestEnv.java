package ray.liu.test;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath*:application-context.xml" })
public abstract class AbstractTestEnv {

	
	// nothing to do, just a abstract method for guys who extends this
	public abstract void couldBeIgnore();
}
