package springboot.mapper;

import java.util.List;

import springboot.entity.BookType;

public interface TestMapper {
	
	public BookType getOneById(Integer id) throws Exception;

	public Integer addOne(BookType bookType);
	
	public void updateOne(BookType bookType);

	public void deleteById(Integer id);
	
	public List<BookType> getList(List<Integer> ids);
}
