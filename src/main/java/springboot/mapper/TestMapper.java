package springboot.mapper;

import springboot.entity.BookType;

public interface TestMapper {
	public BookType getOneById(Integer id) throws Exception;

	public void addOne(BookType bookType);
}
