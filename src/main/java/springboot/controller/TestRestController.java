package springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.entity.BookType;
import springboot.service.TestService;
//@RestController包含了  @Controller和 @ResponseBody两个注解，
//因此若使用@RestController注解则会将当前类的所有方法返回的数据直接转为json数据显示在前端页面中
//因此若是采用restful风格开发则使用 @RestController注解
//而使用@Controller注解，可以返回页面，并可以往页面中添加数据
//当前类使用@RestController注解，开发一个restful风格的api
@RestController  
@RequestMapping("/study_SpringBoot")
public class TestRestController {
	
	@Autowired
	private TestService testService;
	
}
