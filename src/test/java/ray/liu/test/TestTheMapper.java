package ray.liu.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ray.liu.dao.TestMapper;
import ray.liu.service.IgniteService;


public class TestTheMapper extends AbstractTestEnv{

	@Autowired
	IgniteService igniteService;
//	TestService testService;
	@Autowired
	TestMapper testMapper;
	
	private static final Logger log = LoggerFactory.getLogger(TestTheMapper.class);

	@Override
	public void couldBeIgnore() {
		// TODO Auto-generated method stub
		
	}
	
	
//	@Test
	public void orderCredit(){
		System.out.println(testMapper.getTestInfo());
//		System.out.println(testService.getTestString());
		System.out.println("done");
	}
	
	@Test
	public void igniteService() throws InterruptedException{
		log.info("start...");
		long start1 = System.currentTimeMillis();
		igniteService.second();
		long start2 = System.currentTimeMillis();
		log.info("---> 1 --- " + (start2 - start1));
		igniteService.second();
		long start3 = System.currentTimeMillis();
		log.info("---> 2 --- " + (start3 - start2));
		igniteService.second();
		log.info("---> 3 --- " + (System.currentTimeMillis() - start3));
		igniteService.set();
		igniteService.get();
//		igniteService.first();
		log.info("done");
	}

}
