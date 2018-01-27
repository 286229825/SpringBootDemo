package springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.entity.BookType;
import springboot.mapper.TestMapper;
import springboot.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestMapper testMapper;

	@Override
	public BookType getOneById(Integer id) throws Exception {
		return testMapper.getOneById(id);
	}

	@Override
	@Transactional  // 使用此注解为当前方法加上事务管理。若是在当前类上使用此注解，则会为当前类的所有方法加上事务管理。注意是在实现类中而不是在接口中加事务。
	public void addOne(BookType bookType) throws Exception {
		testMapper.addOne(bookType);
	}

}
