package springboot.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
class GlobalExceptionHandler {
	
	//这里的 error 对应了templates目录下的error.ftl文件
    public static final String DEFAULT_ERROR_VIEW = "error";

    //默认的异常处理。注意：一个异常类只能存在一个方法上，例如：当前方法用了Exception后，这个类中的其他方法的异常类就必须换成其他自定义的。
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        //这里必须使用ModelAndView，而不能使用ModelMap
    	ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
    
    //自定义的异常处理
    //MyPageException为自定义的异常类。注意：一个异常类只能存在一个方法上，例如：当前方法用了MyPageException后，这个类中的其他方法的异常类就必须换成其他自定义的。
    @ExceptionHandler(value = MyPageException.class)
    public ModelAndView customErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        //这里必须使用ModelAndView，而不能使用ModelMap
    	ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }
    
    //返回json数据的异常处理。注意：一个异常类只能存在一个方法上，例如：当前方法用了MyJsonException后，这个类中的其他方法的异常类就必须换成其他自定义的。
    @ExceptionHandler(value = MyJsonException.class)
    public @ResponseBody ExceptionInfo jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    	//ExceptionInfo为自定义的异常信息类
    	ExceptionInfo exceptionInfo=new ExceptionInfo();
    	exceptionInfo.setCode("404");
    	exceptionInfo.setMessage(e.getMessage());
    	exceptionInfo.setUrl(req.getRequestURL().toString());
        return exceptionInfo;
    }

}
