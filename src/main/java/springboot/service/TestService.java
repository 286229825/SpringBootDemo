package springboot.service;

import springboot.entity.BookType;

public interface TestService {
	public BookType getOneById(Integer id) throws Exception;
	public void addOne(BookType bookType) throws Exception;
}
