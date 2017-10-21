package springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import springboot.entity.BookType;
import springboot.service.TestService;

@Controller  //  @RestController包含了  @Controller和 @ResponseBody两个注解，因此若使用@RestController注解则会将当前类的所有方法返回的数据直接转为json数据显示在前端页面中，所以一般都是用 @Controller注解。
@RequestMapping("/study_SpringBoot")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/test.do")
	public String test(ModelMap modelMap,HttpSession session) throws Exception{
		testService.addOne(new BookType(null, "德语", 100));
		modelMap.addAttribute("booktype",testService.getOneById(2));  //一般都是通过 ModelMap向freemarker模版中添加数据，也可以使用ModelAndView。
		session.setAttribute("username", "xiaoqiang2");
		return "test01";  //会自动去templates文件夹中找寻freemarker的模版文件（也就是有ftl后缀的文件）
	}
}
