package springboot.service;

import java.util.List;

import springboot.entity.BookType;

public interface TestService {
	
	public BookType getOneById(Integer id) throws Exception;
	
	public void addOne(BookType bookType) throws Exception;
	
	public void updateOne(BookType bookType) throws Exception;
	
	public void deleteOne(Integer id) throws Exception;
	
	public List<BookType> getList(List<Integer> ids);
}
