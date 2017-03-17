package ray.liu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ray.liu.bean.TestBean;
import ray.liu.dao.TestMapper;

@Service
public class TestService {

	@Autowired
	TestMapper testMapper;
	
	public String getTestString() {
		TestBean bean = testMapper.getTestInfo();
		return String.valueOf(bean);
	}
}
