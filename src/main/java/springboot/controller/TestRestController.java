package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.entity.BookType;
import springboot.service.TestService;
//@RestController包含了  @Controller和 @ResponseBody两个注解，
//因此若使用@RestController注解则会将当前类的所有方法返回的数据直接转为json数据显示在前端页面中
//因此若是采用restful风格开发则使用 @RestController注解
//而使用@Controller注解，可以返回页面，并可以往页面中添加数据
//当前类使用@RestController注解，开发一个restful风格的api
@RestController  
@RequestMapping(value="/study_SpringBoot/bookType",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
public class TestRestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public BookType getOneById(@PathVariable("id") Integer id) throws Exception {
		return testService.getOneById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addOne(BookType bookType) throws Exception {
		testService.addOne(bookType);
		return "success";
	}
	
}
