package ray.liu.dao;

import ray.liu.bean.TestBean;

@MyBatisRepository
public interface TestMapper {
	TestBean getTestInfo();
}
