package springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.entity.BookType;
import springboot.mapper.TestMapper;
import springboot.service.TestService;

@CacheConfig(cacheNames = "bookType")	//这个注解表示：会把当前类的所有方法的数据存到bookType缓存区中。
@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestMapper testMapper;

	@Override
	@Cacheable(key="#p0")	//这个注解表示：每次查询都会去缓存中查，若查不到再去数据库中查，并将结果放入缓存（#p0表示用方法的第一个参数作为缓存的key）供下次使用
	public BookType getOneById(Integer id) throws Exception {
		return testMapper.getOneById(id);
	}

	@Override
	@CacheEvict(key="#p0.id",allEntries=true)  //这个注解表示：每次添加操作之后都会把相应的缓存中的数据也删除（#p0表示用方法的第一个参数作为缓存的key）。allEntries=true表示清空所有数据，目的是防止脏读。
	@Transactional  // 使用此注解为当前方法加上事务管理。若是在当前类上使用此注解，则会为当前类的所有方法加上事务管理。注意是在实现类中而不是在接口中加事务。
	public void addOne(BookType bookType) throws Exception {
		testMapper.addOne(bookType);
	}

	@Override
	@CacheEvict(key="#p0.id",allEntries=true)  //这个注解表示：每次更新操作之后都会把相应的缓存中的数据也删除（#p0表示用方法的第一个参数作为缓存的key）。allEntries=true表示清空所有数据，目的是防止脏读。
	public void updateOne(BookType bookType) throws Exception {
		testMapper.updateOne(bookType);
	}

	@Override
	@CacheEvict(key="#p0",allEntries=true)  //这个注解表示：每次删除操作之后都会把相应的缓存中的数据也删除（#p0表示用方法的第一个参数作为缓存的key）。allEntries=true表示清空所有数据，目的是防止脏读。
	public void deleteOne(Integer id) throws Exception {
		testMapper.deleteById(id);
	}
	
	@Override
	@Cacheable(key="#p0") //这个注解表示：每次都会执行更新数据库的操作，并根据方法的返回值更新缓存（若没有返回值则会将缓存删除）（#p0.id表示用方法的第一个参数的id作为缓存的key）。
	public List<BookType> getList(List<Integer> ids) {
		return testMapper.getList(ids);
	}

}
