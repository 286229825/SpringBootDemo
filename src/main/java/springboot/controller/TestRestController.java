package springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springboot.entity.BookType;
import springboot.exception.MyJsonException;
import springboot.exception.MyPageException;
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
	
	//@ApiOperation为swagger的注解：tags相同的接口将被归为一类；value表示接口的简单描述；notes表示接口的详细描述；response表示返回的类型，若为返回的是集合，则改为BookType[].class
	//@ApiParam("图书类型ID")为swagger的注解，用来描述参数的信息
	@ApiOperation(value="获取图书类型信息",tags = "CategoryOrganizationResource",notes="根据id获取图书类型信息",response=BookType.class)
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public BookType getOneById(@ApiParam("图书类型ID") @PathVariable("id") Integer id) throws Exception {
		return testService.getOneById(id);
	}
	
	@ApiOperation(value="添加图书信息",tags = "CategoryOrganizationResource",notes="添加一条图书类型记录")
	@RequestMapping(method=RequestMethod.POST)
	public String addOne(BookType bookType) throws Exception {
		if (bookType.getId()==null) {
			throw new MyJsonException("测试一下返回json数据的异常处理哦");
		}
		testService.addOne(bookType);
		return "success";
	}
	
}
