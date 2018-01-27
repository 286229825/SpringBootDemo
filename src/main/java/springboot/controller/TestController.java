package springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import springboot.entity.BookType;
import springboot.service.TestService;
//@RestController包含了  @Controller和 @ResponseBody两个注解，
//因此若使用@RestController注解则会将当前类的所有方法返回的数据直接转为json数据显示在前端页面中
//因此若是采用restful风格开发则使用 @RestController注解
//而使用@Controller注解，可以返回页面，并可以往页面中添加数据
//当前类使用@Controller注解,返回一个页面,并往页面中添加数据
@Controller  
@RequestMapping("/study_SpringBoot")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/test.do")
	public String test(ModelMap modelMap,HttpSession session) throws Exception{
		testService.addOne(new BookType(null, "德语", 100));
		//一般都是通过 ModelMap向freemarker模版中添加数据，也可以使用ModelAndView
		modelMap.addAttribute("booktype",testService.getOneById(2));
		session.setAttribute("username", "xiaoqiang2");
		//注意这里的文件访问形式，会自动去templates文件夹中找寻freemarker的模版文件（也就是test01.ftl文件）
		return "test01";  
	}
}
